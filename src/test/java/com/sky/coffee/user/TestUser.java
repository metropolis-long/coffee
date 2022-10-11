package com.sky.coffee.user;

import com.sky.coffee.app.CoffeeApplication;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@SpringBootTest(classes = CoffeeApplication.class)
@AutoConfigureMockMvc
public class TestUser {

    @Resource
    private MockMvc mockMvc;

    @Test
    void loginTest() throws Exception {
        String expect = "{\"code\":200,\"msg\":\"成功\",\"data\":{\"uid\":28,\"loginName\":\"1\",\"pwd\":null,\"mobile\":\"12345678911\",\"email\":null,\"salt\":\"gdUtuQfO\",\"deleted\":null,\"created\":\"2022-08-11T12:25:57\",\"modified\":\"2022-08-11T12:25:57\"},\"adds\":{}}";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/login")
                        .param("loginName","1")
                        .param("pwd","123456"))
                .andExpect(MockMvcResultMatchers.content()
                        .json(expect))
                        .andDo(MockMvcResultHandlers.print());
    }
}





