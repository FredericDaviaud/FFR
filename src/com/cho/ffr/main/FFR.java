package com.cho.ffr.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class FFR extends BasicGame {
    
    private GameContainer gameContainer;

    public FFR(String gameName) {
        super(gameName);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
    }

    @Override
    public void update(GameContainer contain, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer contain, Graphics g) throws SlickException {
        
    }
    
    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            gameContainer.exit();
        }
    }

    public static void main(String[] args) {
        try {
            new AppGameContainer(new FFR("FFR"), 1280, 720, false).start();
        } catch (SlickException ex) {
            Logger.getLogger(FFR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
