package com.cho.ffr.main;

import java.util.ArrayList;
import java.util.List;
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

import com.cho.ffr.model.ArrowReceptor;
import com.cho.ffr.model.ArrowReceptorPanel;

public class FFR extends BasicGame {

    private static final String ARROW_RECEPTOR_SPRITE_SHEET = "res/arrow_receptor/arrow_receptor_sheet.png";
    
    private GameContainer gameContainer;
    private boolean arrowPressed;
    private ArrowReceptorPanel arrowReceptorPanel;
    public FFR(String gameName) {
        super(gameName);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.gameContainer = gameContainer;
        SpriteSheet arrowsReceptorSpriteSheet = new SpriteSheet(ARROW_RECEPTOR_SPRITE_SHEET, 143, 140);
        List<ArrowReceptor> arrowReceptors = new ArrayList<ArrowReceptor>();
        arrowReceptors.add(new ArrowReceptor(arrowsReceptorSpriteSheet, 30, 270, 300, 300)); //left
        arrowReceptors.add(new ArrowReceptor(arrowsReceptorSpriteSheet, 30, 180, 400, 300)); //down
        arrowReceptors.add(new ArrowReceptor(arrowsReceptorSpriteSheet, 30, 0, 500, 300));   //up
        arrowReceptors.add(new ArrowReceptor(arrowsReceptorSpriteSheet, 30, 90, 600, 300));  //right
        arrowReceptorPanel = new ArrowReceptorPanel(arrowReceptors);
        arrowReceptorPanel.init();
    }

    @Override
    public void render(GameContainer contain, Graphics graphics) throws SlickException {
        arrowReceptorPanel.render(graphics);
    }

    @Override
    public void update(GameContainer contain, int delta) throws SlickException {

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
