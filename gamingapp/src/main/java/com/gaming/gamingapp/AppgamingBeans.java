package com.gaming.gamingapp;


import com.gaming.gamingapp.game.GameRunner;
import com.gaming.gamingapp.game.GamingConsole;
import com.gaming.gamingapp.game.MarioGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppgamingBeans {
    public static void main(String[] args){

        try(var context = new AnnotationConfigApplicationContext(AppGamingConfig.class)){
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
