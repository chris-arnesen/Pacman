/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Path: "src/Bilder/red.gif"
 * @author christofferstrandarnesen
 */
public class Blinky extends Ghost {
    
    double height;
    double width;
     
    public Blinky(double x, double y, String path) {
        super(x,y,path);
    }
    
}
