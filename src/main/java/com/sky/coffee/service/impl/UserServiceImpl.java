package com.sky.coffee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.sky.coffee.component.redis.RedisService;
import com.sky.coffee.entity.User;
import com.sky.coffee.entity.UserInfo;
import com.sky.coffee.mapper.UserMapper;
import com.sky.coffee.msg.ResultBody;
import com.sky.coffee.msg.ResultCodeMsg;
import com.sky.coffee.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.coffee.tool.CypherTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private RedisService redisService;
    public boolean addUser(User user){
        int ok = userMapper.insert(user);
        return ok != 0;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public List<UserInfo> findUserInfo(Integer id) {
        return userMapper.findUserInfo(id);
    }

    @Override
    public ResultBody login(String loginName, String pwd) {
        User info = findOne(loginName);
        if (info == null) {
            return new ResultBody(ResultCodeMsg.NO_USER.getCode(), ResultCodeMsg.NO_USER.getMsg());
        }
        if (!info.getPwd().equals(CypherTools.shaEncode(pwd,info.getSalt()))) {
            return new ResultBody(ResultCodeMsg.LOGIN_PWD_ERR.getCode(), ResultCodeMsg.LOGIN_PWD_ERR.getMsg());
        }
        pwd = null;
        info.setPwd(null);
        ResultBody resultBody = new ResultBody(ResultCodeMsg.OK.getCode(),ResultCodeMsg.OK.getMsg());
        resultBody.setData(info);
        return resultBody;
    }

    @Override
    public User findOne(String loginName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getLoginName,loginName);
        User info = userMapper.selectOne(queryWrapper);
        return info;
    }
}
