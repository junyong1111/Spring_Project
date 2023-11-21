package com.gaming.gamingapp.game;

public class GameRunner {
    GamingConsole game;
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run(){
        System.out.println("GAME RUN :"  + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
