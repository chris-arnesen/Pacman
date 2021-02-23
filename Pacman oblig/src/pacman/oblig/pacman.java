/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author christofferstrandarnesen
 */

public class pacman extends Circle {
    int STR    = 20;
    int width  = STR*28;
    int height = (STR*31)+100;
    
    
        //Pacman figur
    public pacman() {
        int dx = STR/2;
        int dy = STR/2;
        int radius = STR/2;
        this.setRadius(radius);
        this.setCenterX(dx);
        this.setCenterY(dy);
        this.setFill(Color.YELLOW);
    }
}
