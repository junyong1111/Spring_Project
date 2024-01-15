package com.springboot_board_jyp.springboot_borad.web;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final AuthenticationManager aManager;

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
    public String signin(@RequestBody UserLoginDto userLoginDto){
        try {
            UsernamePasswordAuthenticationToken authToke = 
                new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword());
            aManager.authenticate(authToke);
            return "로그인 성공";
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }
        
    } 




}
