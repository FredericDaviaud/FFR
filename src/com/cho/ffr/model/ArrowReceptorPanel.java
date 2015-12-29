package com.cho.ffr.model;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;

public class ArrowReceptorPanel {
    
    private List<ArrowReceptor> arrowReceptors = new ArrayList<ArrowReceptor>();
    
    public ArrowReceptorPanel(List<ArrowReceptor> arrowReceptors) {
        this.arrowReceptors = arrowReceptors;
    }
    
    public void init() {
        for (ArrowReceptor arrowReceptor : arrowReceptors) {
            arrowReceptor.init();
        }
    }
    
    public void render(Graphics graphics) {
        for (ArrowReceptor arrowReceptor : arrowReceptors) {
            arrowReceptor.render(graphics);
        }
    }
    
    public void update() {
        for (ArrowReceptor arrowReceptor : arrowReceptors) {
            arrowReceptor.update();
        }
    }
} 
