package com.sky.coffee.controller;

import com.sky.coffee.entity.User;
import com.sky.coffee.service.IUserService;
import com.sky.coffee.tool.CypherTools;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/coffee")
public class IndexHome {
    @Resource
    public IUserService userService;
    @GetMapping("/home")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, HttpSession session) {
        User user = userService.findOne(name);
        if (user != null){
            return String.format("Hello %s!", name);
        }
        new User();
        user.setLoginName(name);
        String salt = CypherTools.generateShortUUID();
        user.setSalt(salt);
        user.setMobile("12345678911");
        user.setPwd(CypherTools.shaEncode("123456",salt));
        userService.addUser(user);
        int uid = user.getUid();
        System.out.println(uid);
        User one = userService.findUserById(uid);
        session.setAttribute(one.getMobile(),one.getLoginName());
        return String.format("Hello %s!", one.getMobile());
    }
}
