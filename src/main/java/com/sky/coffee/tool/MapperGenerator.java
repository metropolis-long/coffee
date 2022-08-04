package com.sky.coffee.tool;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MapperGenerator {
    public static void genertor(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/coffee?serverTimezone=UTC&useSSL=true",
                        "root", "123456")
                .globalConfig(builder -> {
                    builder.author("zhuye") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride()
                            .outputDir("D:\\workspace\\java\\coffee\\src\\generator");// 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.skip.coffee") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\workspace\\java\\coffee\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().logicDeleteColumnName("deleted");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }

    public static void main(String[] args) {
        genertor();
    }
}
