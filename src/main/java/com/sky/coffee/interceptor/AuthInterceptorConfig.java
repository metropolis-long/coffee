package com.sky.coffee.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * 拦截器配置
 * @author zhuye
 */
@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 添加拦截规则
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/authentication/**")
                .excludePathPatterns("/stat/warReport/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/api/user/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns(
                        Arrays.asList("/swagger**/**",
                                "/doc.html**/**",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/v3/**",
                                "/error",
                                "/favicon.ico",
                                "/coffee/home"
                        )
                );
    }

    @Bean
    LoginAuthInterceptor getInterceptor() {
        return new LoginAuthInterceptor();
    }
}
