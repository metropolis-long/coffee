package com.sky.coffee.service.impl;

import com.sky.coffee.entity.Coffee;
import com.sky.coffee.mapper.CoffeeMapper;
import com.sky.coffee.service.ICoffeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuye
 * @since 2022-09-15
 */
@Service
public class CoffeeServiceImpl extends ServiceImpl<CoffeeMapper, Coffee> implements ICoffeeService {

}
