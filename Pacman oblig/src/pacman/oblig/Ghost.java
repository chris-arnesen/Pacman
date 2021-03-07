package pacman.oblig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public abstract class Ghost extends ImageView {
    
    double x;
    double y;
    double height = 12;
    double width = 12;
    AnimationTimer timer;
    
    
    String path;//"src/Bilder/red.gif";
    
    public double getGhostX() {return x;}
    public double getGhostY() {return y;}
    
    
    public Ghost(double x, double y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
        try {
            FileInputStream stream = new FileInputStream(getPath()); 
            Image image = new Image(stream);
        
            setX(x);
            setY(y);
            setFitHeight(height); 
            setFitWidth(width);   
            setImage(image);
        } catch (FileNotFoundException e) {System.out.println("funker ikke");}
    }
    
    public void setPath(String path) {this.path = path;}
    public String getPath() {return path;}
    
    
    protected void hunt(pacman player, Ghost ghost) { 
        timer = new AnimationTimer() {
            public void handle(long currentNanoTime) {
                double pacmanX = player.getCenterX();
                double pacmanY = player.getCenterY();

                double ghostX = getX();
                double ghostY = getY();
                
                double dX = Math.abs(pacmanX - getX());
                double dY = Math.abs(pacmanY - getY());
                
                
                if (dX > dY) { 
                    if (ghostX > pacmanX) {
                        if (!collideLeftInc(ghost)){
                            setX(getX() - 1);                      
                        }    else if (!collideUpInc(ghost))
                            setY(getY()-1);
                        else if (!collideDownInc(ghost))
                            setY(getY()+1);
                        else
                            setX(getX()+1);
                    } 
                    else {
                        if (!collideRightInc(ghost))
                            setX(getX() + 1);                      
                        else if (!collideUpInc(ghost))
                            setY(getY()-1);
                        else if (!collideDownInc(ghost))
                            setY(getY()+1);
                        else
                            setX(getX()-1);
                    }
                } 
                else {
                    if(ghostY > pacmanY) {
                        if (!collideUpInc(ghost))
                            setY(getY() - 1);                      
                        else if (!collideRightInc(ghost))
                            setX(getX() + 1);
                        else if (!collideLeftInc(ghost))
                            setX(getX() - 1);
                        else
                            setY(getY()+1);
                    } 
                    else {
                        if (!collideDownInc(ghost)) {
                            setY(getY() + 1);                      
                        }
                            else if (!collideRightInc(ghost)) {
                            setX(getX() + 1);
                            }
                        else if (!collideLeftInc(ghost))
                            setX(getX() - 1);
                        else {
                            setY(getY() - 1);
                        }                  
                    }
                }
            }
        };timer.start();
    }
    
    public boolean collideRightInc(Ghost ghost) {
        Rectangle tempBox = new Rectangle(0,0,10,10);
        tempBox.setX(ghost.getX());
        tempBox.setY(ghost.getY());
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempBox.setX(ghost.getX()+5);
        for (Rectangle r : sperringer) {
            if (tempBox.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean collideDownInc(Ghost ghost) {
        Rectangle tempBox = new Rectangle(0,0,10,10);
        tempBox.setX(ghost.getX());
        tempBox.setY(ghost.getY());
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempBox.setY(ghost.getY()+5);
        for (Rectangle r : sperringer) {
            if (tempBox.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean collideLeftInc(Ghost ghost) {
        Rectangle tempBox = new Rectangle(0,0,10,10);
        tempBox.setX(ghost.getX());
        tempBox.setY(ghost.getY());
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempBox.setX(ghost.getX()-5);
        for (Rectangle r : sperringer) {
            if (tempBox.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean collideUpInc(Ghost ghost) {
        Rectangle tempBox = new Rectangle(0,0,10,10);
        tempBox.setX(ghost.getX());
        tempBox.setY(ghost.getY());
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        tempBox.setY(ghost.getY()-5);
        for (Rectangle r : sperringer) {
            if (tempBox.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    
    
    
}