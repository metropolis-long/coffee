package com.sky.coffee.controller;

import com.sky.coffee.entity.User;
import com.sky.coffee.entity.UserInfo;
import com.sky.coffee.msg.ResultBody;
import com.sky.coffee.msg.ResultCodeMsg;
import com.sky.coffee.service.ICacheService;
import com.sky.coffee.service.IUserService;
import com.sky.coffee.tool.CypherTools;
import com.sky.coffee.tool.NullUtil;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    public IUserService userService;

    @Resource
    private ICacheService cacheService;
    @GetMapping("/info")
    public String hello(HttpSession session,@CookieValue("cf_token") String sessionId) {
        UserInfo userInfo = (UserInfo) session.getAttribute(sessionId);
        return userInfo.getUserName();
    }

    /**
     * 登录
     *
     * @param request
     * @param response
     * @param loginName
     * @param pwd
     * @return
     */
    @RequestMapping(value = {"/login"}, produces = {"application/json;charset=UTF-8"})
    public Object login(HttpServletRequest request, HttpServletResponse response,
                        HttpSession session, String loginName, String pwd) {

        if (NullUtil.isNull(loginName) || NullUtil.isNull(pwd)) {
            return new ResultBody(ResultCodeMsg.PARAM_IS_BLANK.getCode(), ResultCodeMsg.PARAM_IS_BLANK.getMsg());
        }
        String cookie = cacheService.getCookie(request);
        System.out.println(cookie);
        ResultBody data = userService.login(loginName, pwd);
        User info = (User) data.getData();
        if (data.getCode() == 200) {
            String key = UUID.randomUUID().toString();
//            Cookie cookie = new Cookie("token", key);
////            cookie.setDomain("coffee.zhuyelong.cn");
////            cookie.setPath("/");
//            response.addCookie(cookie);
            List<UserInfo> list = userService.findUserInfo(info.getUid());
            String sesssionId= session.getId();
            System.out.println("session;;;;;;"+sesssionId);
            session.setAttribute(key,list.get(0));
        }
        return data;
    }
}
