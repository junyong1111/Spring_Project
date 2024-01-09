package com.springboot_board_jyp.springboot_board.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot_board_jyp.springboot_board.domain.user.SiteUser;
import com.springboot_board_jyp.springboot_board.domain.user.SiteUserRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final SiteUserRepository uRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password){
        SiteUser user = SiteUser.builder()
        .username(username)
        .email(email)
        .password(passwordEncoder.encode(password))
        .build();
        uRepository.save(user);
        return user;
    }
}
