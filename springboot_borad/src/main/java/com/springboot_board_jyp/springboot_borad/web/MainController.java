package com.springboot_board_jyp.springboot_borad.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_board_jyp.springboot_borad.service.UserService;
import com.springboot_board_jyp.springboot_borad.web.dto.user.UserLoginDto;
import com.springboot_board_jyp.springboot_borad.web.dto.user.UserRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService uService;

    @PostMapping("/user/signup")
    public String signup(@RequestBody UserRequestDto uRequestDto){
        try{
            uService.create(uRequestDto.getUsername(), uRequestDto.getEmail(), uRequestDto.getPassword());
            return "회원가입 완료";
        }
        catch(DataIntegrityViolationException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }    

    @PostMapping("/user/login")
    public void signin(@RequestBody UserLoginDto userLoginDto){
        uService.loadUserByUsername(userLoginDto.getUsername());
    } 




}
