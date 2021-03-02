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
 * Path: "src/Bilder/200w.gif"
 * @author christofferstrandarnesen
 */
public class Inky extends Ghost {
    
    double height;
    double width;
     
    public Inky(double x, double y, String path) {
        super(x,y,path);
    }
    
}
