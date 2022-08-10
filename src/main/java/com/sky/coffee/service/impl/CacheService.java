package com.sky.coffee.service.impl;

import com.sky.coffee.component.redis.RedisService;
import com.sky.coffee.dto.UserInfoDTO;
import com.sky.coffee.entity.UserInfo;
import com.sky.coffee.service.ICacheService;
import com.sky.coffee.tool.NullUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CacheService
 * @Description TODO
 * @Author metropolis-long
 * @Date 2020/10/18 19:27
 * @VERSION 1.0.0
 */
@Service(value = "cacheService")
public class CacheService implements ICacheService {

    @Resource
    private RedisService redisService;
    /**
     * 获取缓存登录信息.
     * @param request
     * @return
     */
    @Override
    public UserInfo getUserInfo(HttpServletRequest request) {
        String key= getCookie(request);
        UserInfo info=(UserInfo)redisService.get(key);
        return info;
    }

    /**
     * 设置登录会话缓存.
     * @param request
     * @param info
     * @return cookie
     */
    @Override
    public void setLoginUserInfo(String key,HttpServletRequest request,UserInfo info) {
        redisService.set(key,info,60*60*24);
    }

    @Override
    public void outLogin(String sessionId) {
        redisService.del(sessionId);

    }
    @Override
    public void setLoginUserInfo(HttpServletRequest request, UserInfoDTO info) {
        redisService.set(getCookie(request),info,60*60*24);
    }
    /**
     * 获取JSESSIONID.
     * @param request
     * @return
     */
    private String getCookie(final HttpServletRequest request){
        final Cookie[] cookies =request.getCookies();
        if (NullUtil.isNull(cookies)){
            return "";
        }
        for (Cookie cookie:cookies){
            System.out.println(cookie.getName()+":::"+cookie.getValue());
            if ("JSESSIONID".equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return "";
    }
}
