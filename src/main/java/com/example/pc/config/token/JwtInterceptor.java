package com.example.pc.config.token;

import com.example.pc.exception.Errors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * jwt拦截器
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        // 从 Authorization 请求头中取出 token
        String token = httpServletRequest.getHeader("Authorization");

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(com.example.pc.config.token.JwtToken.class)) {
            com.example.pc.config.token.JwtToken jwtToken = method.getAnnotation(com.example.pc.config.token.JwtToken.class);
            if (jwtToken.required()) {
                // 执行认证
                if (token == null) {
                    //改变response的状态码
                    httpServletResponse.setStatus(401);

                    throw new Errors( 401,"无token，请重新登录");
                }
                // 验证 token
                com.example.pc.config.token.JwtUtil.checkSign(token);
            }
        }
        return true;
    }
}
