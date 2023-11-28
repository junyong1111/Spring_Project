package com.spring_jyp_todo.springbootTodoProject.controller;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes("name")
public class LoginController {

    @GetMapping
    public String get_login(){
        return "hello";
    }
    @PostMapping
    public String get_welcome(@RequestParam(name = "name") String name,
                              @RequestParam(name = "password") String password, ModelMap model){
        model.put("name", name);
        return "welcome";
    }
}
