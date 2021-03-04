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
    
    AnimationTimer timer;
    
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
    
<<<<<<< HEAD
    //Note To Self: Dersom den er lengre vekk på x-koordinat, så skal den bare gø høyre eller venstre
    //Blir dette feil?
    protected void chase(pacman player, Ghost ghost) {
        //pacman.setMovement();
        
        new AnimationTimer() {
=======
    
    protected void chasePacman(pacman player) {
        //pacman.setMovement();

        timer = new AnimationTimer() {
            @Override
>>>>>>> 429304caaba002e3e9023a8401cd6d4b9bb88bf7
            public void handle(long currentNanoTime) {
                
                double ghostX = getX();
                double ghostY = getY();
<<<<<<< HEAD
                
                double distanceX = Math.abs(pacPosX - getX());
                double distanceY = Math.abs(pacPosY - getY());
                
                
                if (distanceX > distanceY) { 
                    if (ghostX > pacPosX) {
                        if (!collideLeftInc(ghost))
                            setX(ghostX - 1);                      //left
                        else if (!collideUpInc(ghost))
                            setY(ghostY-1);
                        else if (!collideDownInc(ghost))
                            setY(ghostY+1);
                        else
                            setX(ghostX+1);
                    } 
                    else {
                        if (!collideRightInc(ghost))
                            setX(ghostX + 1);                      //right
                        else if (!collideUpInc(ghost))
                            setY(ghostY-1);
                        else if (!collideDownInc(ghost))
                            setY(ghostY+1);
                        else
                            setX(ghostX-1);
                    }
                } 
                else {
                    if(ghostY > pacPosY) {
                        if (!collideUpInc(ghost))
                            setY(ghostY - 1);                      //up
                        else if (!collideRightInc(ghost))
                            setX(ghostX + 1);
                        else if (!collideLeftInc(ghost))
                            setX(ghostX - 1);
                        else
                            setY(ghostY+1);
                    } 
                    else {
                        if (!collideDownInc(ghost)) {
                            setY(ghostY + 1);                      //down
                            System.out.println("ned");
                        }
                            else if (!collideRightInc(ghost)) {
                            setX(ghostX + 1);
                            System.out.println("høyre");
                            }
                        else if (!collideLeftInc(ghost))
                            setX(ghostX - 1);
                        else {
                            setY(ghostY - 1);
                            System.out.println("opp");
                        }                  
                        }
=======
               
                double pacmanX = player.getCenterX();
                double pacmanY = player.getCenterY();
                
                
                double dX = Math.abs(pacmanX - getX());
                double dY = Math.abs(pacmanY - getY());

         
                if (dX > dY) { 
                    if (ghostX < pacmanX) {
                        setX(ghostX + 1);
                    } 
                    else {
                        setX(ghostX - 1);
                    }
                } 
                else {
                    if(ghostY < pacmanY) {
                        setY(ghostY + 1);
                    } 
                    else {
                        setY(ghostY - 1);
                    }
>>>>>>> 429304caaba002e3e9023a8401cd6d4b9bb88bf7
                }
            }
        };timer.start();
    }
    
    public boolean collideRightInc(Ghost ghost) {
        Ghost tempGhost = ghost;
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempGhost.setX(ghost.getX()+5);
        for (Rectangle r : sperringer) {
            if (tempGhost.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean collideDownInc(Ghost ghost) {
        Ghost tempGhost = ghost;
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempGhost.setY(ghost.getY()+5);
        for (Rectangle r : sperringer) {
            if (tempGhost.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean collideLeftInc(Ghost ghost) {
        Ghost tempGhost = ghost;
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempGhost.setX(ghost.getX()-5);
        for (Rectangle r : sperringer) {
            if (tempGhost.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean collideUpInc(Ghost ghost) {
        Ghost tempGhost = ghost;
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempGhost.setY(ghost.getY()-5);
        for (Rectangle r : sperringer) {
            if (tempGhost.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    
}