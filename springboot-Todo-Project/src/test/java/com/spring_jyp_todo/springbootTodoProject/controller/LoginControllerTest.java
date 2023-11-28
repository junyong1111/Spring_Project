package com.spring_jyp_todo.springbootTodoProject.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = LoginController.class)

public class LoginControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void name() {

    }

    @Test
    public void hlleo_return() throws Exception{
        mvc.perform(get("/hello")).andExpect(status().isOk());
    }
}
