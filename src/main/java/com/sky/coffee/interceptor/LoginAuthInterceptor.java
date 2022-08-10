package com.sky.coffee.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sky.coffee.entity.UserInfo;
import com.sky.coffee.service.ICacheService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginAuthInterceptor implements HandlerInterceptor {

    @Resource
    ICacheService cacheService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        UserInfo user = cacheService.getUserInfo(request);
        if (null == user) {
            resultMsg(response);
            return false;
        }
        return true;
    }

    /**
     * 响应信息
     *
     * @param response 返回信息
     */
    private void resultMsg(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out;
        try {
            JSONObject res = new JSONObject();
            res.put("code", 403);
            res.put("message", "token登录已过期，请重新登录");
            out = response.getWriter();
            out.append(res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

