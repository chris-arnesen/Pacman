/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jacob
 */
public class topPane extends Pane {
    
    public topPane() {
        this.setPrefHeight(50);
        this.setStyle("-fx-border-color: black; -fx-background-color: darkblue;");
        this.getChildren().addAll(getScore(), getLevel());
    }
    
    public Text getScore() {
            Text text = new Text("Score: ");
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(10);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
    }
    
    public Text getLevel() {
            Text text = new Text("Level: ");
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(410);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
        }
    
}
