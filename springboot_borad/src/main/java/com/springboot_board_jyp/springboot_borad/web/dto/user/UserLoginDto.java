package com.springboot_board_jyp.springboot_borad.web.dto.user;

import groovy.transform.builder.Builder;
import lombok.Getter;

@Getter
public class UserLoginDto {
    private String username;
    private String password;
    
    @Builder
    public UserLoginDto(String usernmae, String password){
        this.username = usernmae;
        this.password = password;
    }
}
