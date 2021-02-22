/* barmen
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
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

/**
 *
 * @author christofferstrandarnesen
 */
public class PacmanOblig extends Application implements KeyListener {
    
    //Deklarasjoner
    int STR    = 20;
    int width  = STR*28;
    int height = (STR*31)+100;
    
    
    
<<<<<<< Updated upstream
    //Diverse bokser
    BorderPane bPane;
    topPane top = new topPane();
    bottomPane bottom = new bottomPane();
    centerPane center = new centerPane(STR);
=======
    Circle pacman = getPacman(); 
    
    int pointerX = 0, pointerY = 0;
>>>>>>> Stashed changes
    
    
    @Override
    public void start(Stage primaryStage) {
      
        //Borderpane
        BorderPane bPane = new BorderPane();
        bPane.setTop(top);
        bPane.setBottom(bottom);
        bPane.setCenter(center);
        
<<<<<<< Updated upstream
=======
        top.getChildren().add(score);
        top.getChildren().add(level);
        center.getChildren().add(pacman);
>>>>>>> Stashed changes
        
        Scene scene = new Scene(bPane, width, height);
        
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Ikke gjort om til en metode enda, må lage en center-box som denne kan
        // putte "banen" inn i
        
        TranslateTransition transition = new TranslateTransition(); /*
        transition.setToX(700);
        transition.setToY(700);*/
        transition.setNode(pacman);
        //transition.play();
        
       scene.setOnKeyPressed(e -> {
    switch (e.getCode()) {
    case UP:
        transition.setToY(0);
        transition.play();
        break;
    case LEFT:
         transition.setToX(-50);
         transition.play();
        break;
    case DOWN:
        transition.setToY(500);
        transition.play();
        break;
    case RIGHT:
        transition.setToX(550);
        transition.play();
        break;
    }
});
        
       
    }
<<<<<<< Updated upstream
=======
    
        //Pacman figur
    public Circle getPacman() {
        int dx = 50;
        int dy = 50;
        int radius = 100;
        Circle pacman = new Circle(radius, dx, dy);
        pacman.setFill(Color.YELLOW);
        
        return pacman;
    }
    
    
        //Pane top
        public Pane getTop() {
        Pane pane = new Pane();
        pane.setPrefHeight(50);
        pane.setStyle("-fx-border-color: black; -fx-background-color: darkblue;");
        return pane;
    }
>>>>>>> Stashed changes
        
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
