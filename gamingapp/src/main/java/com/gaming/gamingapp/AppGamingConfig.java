package com.gaming.gamingapp;

import com.gaming.gamingapp.game.GameRunner;
import com.gaming.gamingapp.game.GamingConsole;
import com.gaming.gamingapp.game.PackmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppGamingConfig {
    @Bean
    public GamingConsole game(){
        return new PackmanGame();
    }

    @Bean
    public GameRunner gameRunner(){
        return new GameRunner(game());
    }

}
