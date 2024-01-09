package com.springboot_board_jyp.springboot_borad.web.dto.user;

import com.springboot_board_jyp.springboot_borad.domain.user.SiteUser;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String username;
    private String email;
    private String password;

    @Builder
    public UserRequestDto(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public SiteUser toEntity(){
        return SiteUser.builder()
        .email(email)
        .username(username)
        .password(password)
        .build();
    }
    
}
