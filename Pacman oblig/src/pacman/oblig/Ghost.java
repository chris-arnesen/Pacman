/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

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
        
            setX(x); //translate
            setY(y);
            setFitHeight(10); //height
            setFitWidth(10);   //width
            setImage(image);
        } catch (FileNotFoundException e) {System.out.println("funker ikke");}
    }
    
    public void setPath(String path) {this.path = path;}
    public String getPath() {return path;}
    
    
    protected void chase(pacman player) {
        //pacman.setMovement();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double pacPosX = player.getCenterX();
                double pacPosY = player.getCenterY();

                double ghostX = getX();
                double ghostY = getY();
System.out.println(getX());
                double distanceX = Math.abs(pacPosX - getX());
                double distanceY = Math.abs(pacPosY - getY());
         
                if (distanceX > distanceY) { 
                    if (ghostX > pacPosX) {
                        setX(ghostX - 1);
                    } 
                    else {
                        setX(ghostX + 1);
                    }
                } 
                else {
                    if(ghostY > pacPosY) {
                        setY(ghostY - 1);
                    } 
                    else {
                        setY(ghostY + 1);
                    }
                }
            }
        }.start();
    }
    
    
    
    
}