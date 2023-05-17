package com.example.pc.service.utils;

import com.example.pc.config.token.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class HttptokenId {
    //获取token中的用户id
    public  Integer tokenId() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("Authorization");
            Map<String, Object> user = JwtUtil.DecodedJWT(token);
            return (Integer) user.get("UserId");
        }
        return null;
    }
}
