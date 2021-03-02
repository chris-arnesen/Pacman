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
    
        String path = "src/Bilder/ghost2.gif";
        FileInputStream stream = new FileInputStream(path);
        Image image = new Image(stream);
        ImageView view = new ImageView(image);
    
    public Ghost() throws FileNotFoundException {
        
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setFitHeight(20);
        this.setFitWidth(20);
    } 
    
    public String getPath(String path) {
        return path;
    }
    
    public FileInputStream getStream() {
        
    }
    


}