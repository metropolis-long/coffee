package com.sky.coffee.lambda;

import com.sky.coffee.entity.Coffee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestLambda {
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
}
