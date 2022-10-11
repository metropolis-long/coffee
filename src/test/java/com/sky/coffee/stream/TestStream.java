package com.sky.coffee.stream;


import com.sky.coffee.app.CoffeeApplication;
import com.sky.coffee.entity.Coffee;
import com.sky.coffee.mapper.CoffeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest(classes = CoffeeApplication.class)
public class TestStream {

    @Autowired
    private CoffeeMapper coffeeMapper;


    @Test
    void forEachStream(){
        List<Coffee> coffees = coffeeMapper.selectList(null);
        Stream<Coffee> stream = coffees.stream();

        stream.forEach(coffee->{
            System.out.println(coffee.getCoffeeName());
        });

//        try {
//            stream.forEach(coffee->{
//                System.out.println(coffee.getCoffeeName());
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
