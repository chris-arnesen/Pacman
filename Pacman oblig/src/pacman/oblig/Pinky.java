package pacman.oblig;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

//Path: "src/Bilder/YMXv.gif"

/**
 *
 * @author christofferstrandarnesen
 */

public class Pinky extends Ghost {
    
    double height;
    double width;
    double random = 1;

    /**
     *
     * @param x
     * @param y
     * @param path
     */
    public Pinky(double x, double y, String path) {
        super(x,y,path);
    }
    
    /**
     *
     * @param player
     * @param ghost
     */
    public void hunt(pacman player, Ghost ghost) {
        Timeline tl = new Timeline();
        KeyFrame kf = new KeyFrame(Duration.millis(30),
                (evt) -> {
                if (random == 1) {        //Opp
                    if ( isCollisionGhost(this) ) {
                        random = (int)(Math.random()*4)+1;
                        setY(getY()+5);
                    } else 
                        setY(getY()-1);
                } else if (random == 2) { //Høyre
                    if ( isCollisionGhost(this) ) {
                        random = (int)(Math.random()*4)+1;
                        setX(getX()-5);
                    } else
                        setX(getX()+1);
                } else if (random == 3) { //Ned
                    if ( isCollisionGhost(this) ) {
                        random = (int)(Math.random()*4)+1;
                        setY(getY()-5);
                    } else
                        setY(getY()+1);
                } else {                  //Venstre
                    if ( isCollisionGhost(this) ) {
                        random = (int)(Math.random()*4)+1;
                        setX(getX()+5);
                    } else
                        setX(getX()-1);
                }
            });
        tl.getKeyFrames().add(kf);
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    } 
    
    /**
     *
     * @param ghost
     * @return
     */
    public boolean isCollisionGhost(Ghost ghost) {
        ArrayList<Rectangle> sperringer = centerPane.getSperringer();
        for (Rectangle r : sperringer) {
            if (ghost.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
}
