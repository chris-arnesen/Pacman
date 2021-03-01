/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author jacob
 */
public class topPane extends Pane {
    
    int poeng;
    Text scoreText = getScore();
    Text levelText = getLevel();
    
    public topPane(int poeng) {
        this.poeng = poeng;
        this.setPrefHeight(50);
        this.setStyle("-fx-border-color: black; -fx-background-color: darkblue;");
        this.getChildren().addAll(scoreText, levelText);
    }
    
    public Text getScore() {
            Text text = new Text("Score: " + poeng);
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(10);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
    }
    
    public Text getLevel() {
            Text text = new Text("Level: ");
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(480);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
        }
    
    public void setScore(int poeng) {
        scoreText.setText("Score: " + poeng);
    }
    
    
}
