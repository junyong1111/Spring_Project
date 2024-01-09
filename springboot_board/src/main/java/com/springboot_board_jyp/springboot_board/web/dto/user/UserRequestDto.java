package com.springboot_board_jyp.springboot_board.web.dto.user;

import com.springboot_board_jyp.springboot_board.domain.user.SiteUser;

import lombok.Builder;
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
    
}
