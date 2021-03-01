/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    //Disse trengs ikke, bruk heller getSTR(), getHeight(), getWidth()
    //int STR    = 20;
    //int width  = STR*28;
    //int height = (STR*31)+100;
    double x, y;
    //double x = 280, y = 470;
    double radius = 5;  //Main.getSTR()/2
        //Pacman figur
    /*public pacman() {
        double x = 280;
        double y = 470;
        double radius = Main.getSTR()/2;
        this.setRadius(radius);
        this.setCenterX(x);
        this.setCenterY(y);
        this.setFill(Color.YELLOW);  
    }*/
    
    public pacman(double x, double y) {
        //this.setRadius(this.radius);
        //this.setCenterX(x);
        //this.setCenterY(y);
        //this.setFill(Color.YELLOW);
        
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadiusX(this.radius);
        this.setRadiusY(this.radius);
        this.setStartAngle(40);
        this.setLength(300);

    this.setStroke(Color.BLACK);
    this.setFill(Color.YELLOW);
    this.setType(ArcType.ROUND);
    

    Timeline gaping = new Timeline();
    gaping.setCycleCount(Timeline.INDEFINITE);
    gaping.setAutoReverse(true);
    KeyValue vinkel = new KeyValue(
      this.startAngleProperty(), 0);
    KeyValue bue = new KeyValue(
      this.lengthProperty(), 360);
    KeyFrame kf = new KeyFrame(
      Duration.millis(200), vinkel, bue);
    gaping.getKeyFrames().add(kf);
    
    
    // Sekvensiell utførelse bevegelser og rotasjoner    
     ParallelTransition animasjon=new ParallelTransition();
    animasjon.getChildren().add(gaping);
    animasjon.play();
    
  
    }
    
    //Set- og get-metoder
    public void setPacmanX(double x) {this.x = x;}
    public void setPacmanY(double y) {this.y = y;}
    
    public double getPacmanX() {return x;}
    public double getPacmanY() {return y;}
    public double getPacmanRadius() {return radius;}
     
    
}
