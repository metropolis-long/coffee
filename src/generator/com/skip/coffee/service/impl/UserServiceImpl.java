package com.skip.coffee.service.impl;

import com.skip.coffee.entity.User;
import com.skip.coffee.mapper.UserMapper;
import com.skip.coffee.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper sampleMapper;
}
