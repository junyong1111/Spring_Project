package com.springboot_board_jyp.springboot_borad.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value="/")
    public String root(){
        return "redirect:/question/list";
    }

    @GetMapping(value="/question/list")
    public String questions_lists(){
        return "question_list";
    }
}
