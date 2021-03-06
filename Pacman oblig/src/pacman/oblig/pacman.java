package pacman.oblig;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

/**
 *
 * @author christofferstrandarnesen
 */
public class pacman extends Arc {
    
    double x, y;
    double radius = Main.getSTR()/2.5;
    
    /**
     *
     * @param x
     * @param y
     */
    public pacman(double x, double y) {
        
        this.x = x;
        this.y = y;
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadiusX(this.radius);
        this.setRadiusY(this.radius);
        this.setStartAngle(40);
        this.setLength(300);

    this.setStroke(Color.BLACK);
    this.setFill(Color.YELLOW);
    this.setType(ArcType.ROUND);
    

    Timeline åpne = new Timeline();
    åpne.setCycleCount(Timeline.INDEFINITE);
    åpne.setAutoReverse(true);
    KeyValue kv1 = new KeyValue(
      this.startAngleProperty(), 0);
    KeyValue kv2 = new KeyValue(
      this.lengthProperty(), 360);
    KeyFrame kf = new KeyFrame(
      Duration.millis(200), kv1, kv2);
    åpne.getKeyFrames().add(kf);
    
    
     
    ParallelTransition pacman=new ParallelTransition();
    pacman.getChildren().add(åpne);
    pacman.play();
    
  
    }
    
    /**
     *
     * @param x
     */
    public void setPacmanX(double x) {this.x = x;}

    /**
     *
     * @param y
     */
    public void setPacmanY(double y) {this.y = y;}
    
    /**
     *
     * @return
     */
    public double getPacmanX() {return x;}

    /**
     *
     * @return
     */
    public double getPacmanY() {return y;}

    /**
     *
     * @return
     */
    public double getPacmanRadius() {return radius;}
     
    
}
