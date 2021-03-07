package pacman.oblig;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author christofferstrandarnesen
 */
public class topPane extends Pane {
    
    int poeng;
    Text scoreText = getScore();
    Text levelText = getLevel();
    
    /**
     *
     * @param poeng
     */
    public topPane(int poeng) {
        this.poeng = poeng;
        this.setPrefHeight(50);
        this.setStyle("-fx-border-color: black; -fx-background-color: darkblue;");
        this.getChildren().addAll(scoreText, levelText);
    }
    
    /**
     *
     * @return
     */
    public Text getScore() {
            Text text = new Text("Score: " + poeng);
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(10);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
    }
    
    /**
     *
     * @return
     */
    public Text getLevel() {
            Text text = new Text("Level: ");
        text.setFont(Font.font("Arial", 20));
               text.setLayoutX(480);
               text.setLayoutY(30);
               text.setFill(Color.WHITE);
        return text;
        }
    
    /**
     *
     * @param poeng
     */
    public void setScore(int poeng) {
        scoreText.setText("Score: " + poeng);
    }
    
    
}
