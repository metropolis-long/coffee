package com.sky.coffee.controller;

import com.sky.coffee.entity.User;
import com.sky.coffee.entity.UserInfo;
import com.sky.coffee.service.IUserService;
import com.sky.coffee.tool.CypherTools;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    public IUserService userService;
    @GetMapping("/info")
    public String hello(HttpSession session) {
        List<UserInfo> one = userService.findUserInfo();
        System.out.println(one.get(0).getUserName());
        return "azzxcffghjkl";
    }
}
