package com.example.pc.config.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加jwt拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                // 拦截所有请求，通过判断是否有 @JwtToken 注解 决定是否需要登录
                .addPathPatterns("/**")
                // 排除不需要登录的接口
                .excludePathPatterns("/api/pc/login");
    }

    /**
     * jwt拦截器
     *
     * @return
     */
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }
}
