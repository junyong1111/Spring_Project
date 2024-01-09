package com.springboot_board_jyp.springboot_board.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_board_jyp.springboot_board.service.UserService;
import com.springboot_board_jyp.springboot_board.web.dto.user.UserRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService uService;
    @GetMapping(value = "/user/signup")
    public String get_signup(){
        return "signup page";
    }
    @PostMapping(value = "/user/signup")
    public String userSignup(@RequestBody UserRequestDto uRequestDto){
        System.out.println("Testing....");
        System.out.println(uRequestDto);
        System.out.println("Testing....");
        try {
            uService.create(uRequestDto.getUsername(), uRequestDto.getEmail(), uRequestDto.getPassword());   
            return "등록이 정상적으로 완료 되었습니다.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
