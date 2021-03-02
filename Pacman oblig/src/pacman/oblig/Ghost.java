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
public class Ghost extends ImageView {
    
    double x;
    double y;
    double height = 20;
    double width = 20;
    
    /*String path;
    FileInputStream stream;
    Image image;
    ImageView view;*/
    
    String path = "src/Bilder/red.gif";
    
    
    public Ghost(double x, double y) throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(path);
        Image image = new Image(stream);
        
        setTranslateX(270);
        setTranslateY(400);
        setFitHeight(20);
        setFitWidth(20);
        setImage(image);
    }
    
}