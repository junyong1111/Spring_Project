package com.spring_jyp_todo.springbootTodoProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static  org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager createUserdetailManage(){

        UserDetails userDetails1 = createNewUser("Park", "dummy");
        UserDetails userDetails2 = createNewUser("jun", "dummydummy");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                    = input -> passwordEncoder().encode(input);

        // 고정된 값 생성
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( // 모든 요청 승인
                auth -> auth.anyRequest().authenticated()
        );
        http.formLogin(withDefaults()); // 승인되지 않은 요청은 로그인
        http.csrf().disable(); // crsf 비활성화
        http.headers().frameOptions().disable(); // 애플리케이션 프레임 비활성화
        return http.build();
    }
}
