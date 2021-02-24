/* barmen
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
        
        pacman player = new pacman();
        center.getChildren().add(player);
        
       
        
        
        Scene scene = new Scene(bPane, width, height);
        
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
     
       Timeline opp = new Timeline();
       Timeline venstre = new Timeline();
       Timeline ned = new Timeline();
       Timeline høyre = new Timeline();
     

      
       
   scene.setOnKeyPressed(e -> {        
    switch (e.getCode()) {
        
    case UP:
        KeyValue kv1 = new KeyValue(player.translateYProperty(),-height+STR*14);
        KeyFrame kf1 = new KeyFrame(Duration.millis(1000), kv1);
        opp.getKeyFrames().add(kf1); 
        opp.play();
        break;
    case LEFT:
        KeyValue kv2 = new KeyValue(player.translateXProperty(),-width/2+STR+STR/2);
        KeyFrame kf2 = new KeyFrame(Duration.millis(1000), kv2);
        venstre.getKeyFrames().add(kf2); 
        venstre.play();
        break;
    case DOWN:
        KeyValue kv3 = new KeyValue(player.translateYProperty(),height-STR*30);
        KeyFrame kf3 = new KeyFrame(Duration.millis(1000), kv3);
        ned.getKeyFrames().add(kf3); 
        ned.play();
        break;
    case RIGHT:
        KeyValue kv4 = new KeyValue(player.translateXProperty(),width/2-STR-STR/2);
        KeyFrame kf4 = new KeyFrame(Duration.millis(1000), kv4);
        høyre.getKeyFrames().add(kf4); 
        høyre.play();
        break;
        case SPACE:
        
        ned.stop();
         System.out.println(player.getLayoutX() + "," + player.getLayoutY());
        break;
    }
 

    
});
       
   
   
  


       
        
       
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
