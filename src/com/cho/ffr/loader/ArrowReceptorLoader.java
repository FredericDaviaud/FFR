package com.cho.ffr.loader;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class ArrowReceptorLoader {
    
    private Animation[] arrowReceptorAnimation = new Animation[2];
    private SpriteSheet spriteSheet;
    private int interval;
    private int angle;

    public ArrowReceptorLoader(SpriteSheet spriteSheet, int interval, int angle) {
        this.spriteSheet = spriteSheet;
        this.interval = interval;
        this.angle = angle;
    }
    
    /**
     * Load and return the arrow receptor animation
     * @return
     */
    public Animation[] load() {
        int count = spriteSheet.getHorizontalCount();
       
        arrowReceptorAnimation[0] = loadAnimation(0, 1);
        arrowReceptorAnimation[1] = loadAnimation(1, count);
        
        return arrowReceptorAnimation;
    }
    
    /**
     * Load an arrow receptor animation
     * @param start x start index
     * @param end x end index
     * @param rotate rotate angle
     * @return the animation
     */
    private Animation loadAnimation(int start, int end) {
        Animation animation = new Animation();
        for (int i = start; i < end; i++) {
            Image sprite = spriteSheet.getSprite(i, 0);
            sprite.rotate(angle);
            animation.addFrame(sprite, interval);
        }
        return animation;
    }
}
