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
    //Disse trengs ikke, bruk heller getSTR(), getHeight(), getWidth()
    //int STR    = 20;
    //int width  = STR*28;
    //int height = (STR*31)+100;
    
    int x, y;
        //Pacman figur
    public pacman() {
        double x = 280;
        double y = 470;
        double radius = Main.getSTR()/2;
        this.setRadius(radius);
        this.setCenterX(x);
        this.setCenterY(y);
        this.setFill(Color.YELLOW);  
    }
    
    //public pacman() {}
    
}
