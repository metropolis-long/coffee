package com.sky.coffee.mapper;

import com.sky.coffee.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.coffee.entity.UserInfo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhuye
 * @since 2022-08-03
 */
public interface UserMapper extends BaseMapper<User> {
    List<UserInfo> findUserInfo();
}
