/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author christofferstrandarnesen
 */
public class PacmanOblig extends Application {
    
    
    BorderPane bPane;
    Pane top = getTop();
    Pane bottom = getBottom();
    Text score = getScore();
    Text level = getLevel();
    
    
    @Override
    public void start(Stage primaryStage) {
      
        
        //Borderpane
        BorderPane bPane = new BorderPane();
        bPane.setTop(top);
        bPane.setBottom(bottom);
        
        top.getChildren().add(score);
        top.getChildren().add(level);
        
        Scene scene = new Scene(bPane, 500, 500);
        
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       
    }
    
    
        //Pane top
        public Pane getTop() {
        Pane pane = new Pane();
        pane.setPrefHeight(50);
        pane.setStyle("-fx-border-color: black; -fx-background-color: darkblue;");
        return pane;
    }
        
        //Pane bottom
        public Pane getBottom() {
        Pane pane = new Pane();
        pane.setPrefHeight(50);
        pane.setStyle("-fx-border-color: black; -fx-background-color: darkblue;");
        return pane;
    }
        
        //Score counter
        public Text getScore() {
            Text text = new Text("Score: ");
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(10);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
        }
        
        //Level counter
        public Text getLevel() {
            Text text = new Text("Level: ");
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(410);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
        }
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}