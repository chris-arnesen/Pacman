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
public class Clyde {
    
   public static ImageView getClyde() throws FileNotFoundException {
        String path = "src/Bilder/ghost2-kopi.gif";
        
        FileInputStream stream = new FileInputStream(path);
        Image image = new Image(stream);
        ImageView view = new ImageView(image);
        view.setTranslateX(10);
        view.setTranslateY(100);
        view.setFitHeight(20);
        view.setFitWidth(20);
        return view;
    }
   
   
}