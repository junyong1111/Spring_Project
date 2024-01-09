package com.springboot_board_jyp.springboot_borad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaAuditing
@SpringBootApplication
public class SpringbootBoradApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBoradApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
            .allowedMethods("*")
            .allowedOrigins("http://localhost:3000");
            }
        };
}

}
