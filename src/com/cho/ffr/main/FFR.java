package com.cho.ffr.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.cho.ffr.loader.ArrowReceptorLoader;

public class FFR extends BasicGame {

    private static final String ARROW_RECEPTOR_SPRITE_SHEET = "res/arrow_receptor/arrow_receptor_sheet.png";
    private GameContainer gameContainer;
    private Animation[] arrowReceptorAnimations = new Animation[8];
    private boolean arrowPressed;

    public FFR(String gameName) {
        super(gameName);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        SpriteSheet arrowsReceptorSpriteSheet = new SpriteSheet(ARROW_RECEPTOR_SPRITE_SHEET, 143, 140);
        ArrowReceptorLoader arrowReceptorLoader = new ArrowReceptorLoader(arrowsReceptorSpriteSheet, 30);
        arrowReceptorAnimations = arrowReceptorLoader.load();
    }

    @Override
    public void update(GameContainer contain, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer contain, Graphics g) throws SlickException {
        g.drawAnimation(arrowReceptorAnimations, 300, 300);
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
        case Input.KEY_UP:
            arrowPressed = true;
            break;
        case Input.KEY_LEFT:
            arrowPressed = true;
            break;
        case Input.KEY_DOWN:
            arrowPressed = true;
            break;
        case Input.KEY_RIGHT:
            arrowPressed = true;
            break;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        arrowPressed = false;
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
