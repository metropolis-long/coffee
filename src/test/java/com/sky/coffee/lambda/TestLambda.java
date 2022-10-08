package com.sky.coffee.lambda;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sky.coffee.app.CoffeeApplication;
import com.sky.coffee.entity.Coffee;
import com.sky.coffee.entity.User;
import com.sky.coffee.mapper.CoffeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootTest(classes = CoffeeApplication.class)
public class TestLambda {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
//        Integer x = null;
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x-> x*2;
        Function<Integer,Integer> h = f.compose(g);
        int res = h.apply(2);
        System.out.println(res);
        Supplier<Coffee> supplier = Coffee::new;
        Coffee coffee = supplier.get();
        coffee.setCoffeeName("sssssssss");
        CoffeeName name = (Coffee cf) -> {
            System.out.println(cf.getCoffeeName());
            return cf.getCoffeeName();
        };
        String name2 = name.seeName(coffee);
        List<String> str = Arrays.asList("2","a","A","1");
        str.sort(String::compareToIgnoreCase);
        str.forEach(s -> {
            System.out.println(s);
        });
    }
    interface CoffeeName{
        String seeName(Coffee coffee);
    }

    @Test
    void getData(){
        System.out.println("ddddddddd");
        Coffee coffee = coffeeMapper.selectById(1);
        System.out.println(coffee.getCoffeeName());
    }
    @Test
    void insertData(){
        Integer id = null;
        QueryWrapper<Coffee> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("cid").last("limit 1");
        Coffee coffee1 = coffeeMapper.selectOne(queryWrapper);
        if (coffee1 == null)
            id = 1;
        else
            id = coffee1.getCid()+1;
        for (int i =id; i<id+10; i++ ) {
            Coffee  coffee =new Coffee();
            coffee.setCid(i);
            coffee.setCoffeeName(i+""+i);
            coffee.setPrice(new BigDecimal(i*i));
            coffee.setUpDate(LocalDateTime.now());
            coffeeMapper.insert(coffee);
        }
        System.out.println("finish insert 10 record coffee data.");
    }
    @Test
    void seeData(){
        List<Coffee> list =coffeeMapper.selectList(null);
        list.stream().forEach(coffee -> {
            System.out.println(coffee.getCoffeeName().toString());
        });
    }
}
