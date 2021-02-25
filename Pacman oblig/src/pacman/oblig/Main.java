/* barmen
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author christofferstrandarnesen
 */
public class Main extends Application {
    
    //Deklarasjoner
    static int STR    = 20;
    static int width  = STR*28;
    static int height = (STR*31)+100;
    
    static ArrayList<Rectangle> sperringer = centerPane.getSperringer();
    
    //Diverse bokser
    BorderPane bPane;
    topPane top = new topPane();
    bottomPane bottom = new bottomPane();
    centerPane center = new centerPane();
    
    
    @Override
    public void start(Stage primaryStage) {
      
        //Borderpane
        BorderPane bPane = new BorderPane();
        bPane.setTop(top);
        bPane.setBottom(bottom);
        bPane.setCenter(center);
        
        //pacman player = new pacman();
        pacman player = centerPane.getPlayer();
        center.getChildren().add(player);
        
        
        
       
        
        
        Scene scene = new Scene(bPane, width, height);
        
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
     
     
       Timeline opp = new Timeline();
       Timeline venstre = new Timeline();
       Timeline ned = new Timeline();
       Timeline høyre = new Timeline();
       
       player.setTranslateX(280);
       player.setTranslateY(470);
      
       
   scene.setOnKeyPressed(e -> {        
    switch (e.getCode()) {
        
    case UP:
        KeyValue kv1 = new KeyValue(player.translateYProperty(),STR+STR/2);
        KeyFrame kf1 = new KeyFrame(Duration.millis(1000), kv1);
        opp.getKeyFrames().add(kf1); 
        System.out.println(player.getTranslateX() + "," + player.getTranslateY());
        opp.play();
        player.setRotate(270);
        break;
    case LEFT:
        KeyValue kv2 = new KeyValue(player.translateXProperty(),STR+STR/2);
        KeyFrame kf2 = new KeyFrame(Duration.millis(1000), kv2);
        venstre.getKeyFrames().add(kf2); 
        System.out.println(player.getTranslateX() + "," + player.getTranslateY());
        venstre.play();
        player.setRotate(180);
        
        break;
    case DOWN:
        KeyValue kv3 = new KeyValue(player.translateYProperty(),height-STR*7+STR/2);
        KeyFrame kf3 = new KeyFrame(Duration.millis(1000), kv3);
        ned.getKeyFrames().add(kf3); 
        System.out.println(player.getTranslateX() + "," + player.getTranslateY());
        ned.play();
        player.setRotate(90);
        break;
    case RIGHT:
        KeyValue kv4 = new KeyValue(player.translateXProperty(),width-STR-STR/2);
        KeyFrame kf4 = new KeyFrame(Duration.millis(1000), kv4);
        høyre.getKeyFrames().add(kf4);
        System.out.println(player.getTranslateX() + "," + player.getTranslateY());
        høyre.play();
        player.setRotate(0);
        break;
   case SPACE:
        ned.stop();
         System.out.println(player.getTranslateX() + "," + player.getTranslateY());
        break;
    }
    
 

    
});
       
   
   
  


       
        
       
    }
    
    // Skriv metoder her
    public boolean isCollision(pacman player) {
        for (Rectangle r : sperringer) {
            if (player.intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    //Get-metoder for forskjellige størrelser
    public static double getWidth()  {return width;}
    public static double getSTR()    {return STR;}
    public static double getHeight() {return height;}
    
   
       
        
       
    
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
