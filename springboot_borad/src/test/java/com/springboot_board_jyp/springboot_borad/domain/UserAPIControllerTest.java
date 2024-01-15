package com.springboot_board_jyp.springboot_borad.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.springboot_board_jyp.springboot_borad.domain.user.SiteUser;
import com.springboot_board_jyp.springboot_borad.service.UserService;

@SpringBootTest
public class UserAPIControllerTest {
    @Autowired
    private UserService uService;
    
    @Autowired
    private AuthenticationManager aManager;

    private String username = "admin";
    private String password = "zxc123";
    private String email = "abc@123.com";

    private String testUsername = "admin";
    private String testPassword = "123";
    
    SiteUser user = SiteUser.builder()
    .username(username)
    .password(password)
    .email(email)
    .build();
    

    @Test
    public void 로그인_테스트(){
        try {
            uService.create(username, username, password);
            System.out.println("회원가입 완료");
        } catch (Exception e) {
            System.out.println("회원가입 실패~!");
            System.out.println(e.getMessage());
        }
        try {
            uService.loadUserByUsername(testUsername);
            UsernamePasswordAuthenticationToken authToke = 
                new UsernamePasswordAuthenticationToken(testUsername, testPassword);
            aManager.authenticate(authToke);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}