package com.sky.coffee.service.impl;

import com.sky.coffee.entity.User;
import com.sky.coffee.mapper.UserMapper;
import com.sky.coffee.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    public boolean addUser(User user){
        int ok = userMapper.insert(user);
        return ok != 0;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
