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
 *
 * @author christofferstrandarnesen
 */
public abstract class Ghost extends ImageView {
    
    double x;
    double y;
    double height = 20;
    double width = 20;
    
    /*String path;
    FileInputStream stream;
    Image image;
    ImageView view;*/
    
    String path;//"src/Bilder/red.gif";
    
    
    public Ghost(double x, double y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
        try {
            FileInputStream stream = new FileInputStream(getPath()); //path
            Image image = new Image(stream);
        
            setTranslateX(x);
            setTranslateY(y);
            setFitHeight(height);
            setFitWidth(width);
            setImage(image);
        } catch (FileNotFoundException e) {System.out.println("funker ikke");}
    }
    
    public void setPath(String path) {this.path = path;}
    public String getPath() {return path;}
}