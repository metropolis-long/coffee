package com.sky.coffee.service;

import com.sky.coffee.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.coffee.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
public interface IUserService extends IService<User> {
    boolean addUser(User user);
    User findUserById(Integer id);
    List<UserInfo> findUserInfo();
}
