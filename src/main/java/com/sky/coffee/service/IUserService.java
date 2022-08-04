package com.sky.coffee.service;

import com.sky.coffee.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
