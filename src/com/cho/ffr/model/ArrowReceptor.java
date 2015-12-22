package com.cho.ffr.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

import com.cho.ffr.loader.ArrowReceptorLoader;

public class ArrowReceptor {
    
    private Animation[] animations;
    private SpriteSheet spriteSheet;
    private int animationInterval;
    private int angle;
    private boolean isPressed;
    
    public ArrowReceptor(SpriteSheet spriteSheet, int animationInterval, int angle) {
        this.spriteSheet = spriteSheet;
        this.angle = angle;
        this.animationInterval = animationInterval;
    }

    public void init() {
        ArrowReceptorLoader arrowReceptorLoader = new ArrowReceptorLoader(spriteSheet, animationInterval, angle);
        animations = arrowReceptorLoader.load();
    }

    public void render(Graphics graphics) {
        graphics.drawAnimation(animations[0], 0, 0);
        if (isPressed) {
            graphics.drawAnimation(animations[1], 0, 0);
        }
    }
}
