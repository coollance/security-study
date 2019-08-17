package com.coolance.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @ClassName UserControllerTest
 * @Description 测试类
 * @Author Coolance
 * @Version
 * @Date 2019/8/17 8:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception {
        String result = mockMvc.perform(get("/user").contentType(APPLICATION_JSON_UTF8)
                .param("username", "coolance")
                .param("age", "18")
                .param("ageTo", "60")
                .param("xxx", "yyy")
                .param("size", "15")
                .param("page", "3")
                .param("sort", "age,desc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result = mockMvc.perform(get("/user/1").contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("coolance"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(result);
    }

    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(get("/user/a").contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        System.out.println(date.getTime());
        String content = "{\"username\":\"coolance\",\"password\":null,\"birthday\":" + date.getTime() + "}";
        String result = mockMvc.perform(post("/user").contentType(APPLICATION_JSON_UTF8).content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(result);
    }
}
