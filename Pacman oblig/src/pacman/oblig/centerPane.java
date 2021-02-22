/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jacob
 */
public class centerPane extends Pane {
    
    int width = 500;
    int STR;
    
    
    public centerPane(int STR) {
        this.STR = STR;
        this.setPrefHeight(STR*31);
        this.setStyle("-fx-border-color: black; -fx-background-color: white;");
        getMap();
    }
    
    //Metode som leser inn kartet(banen)
    public Scanner getMap() {
             Scanner leser = null;
             int pointerX = 0, pointerY = 0;
             
        try{
          File fil = new File("pacman-kart.txt");
            leser = new Scanner(fil);
            while ( leser.hasNextLine() ) {
                String linje = leser.nextLine();
                for (int i = 0; i < linje.length(); i++ ) {
                    char c = linje.charAt(i);
                    if ( c == 'x' ) {
                        Rectangle s = new Rectangle(pointerX, pointerY, STR,STR);
                        this.getChildren().add(s);
                        pointerX+=STR;
                    } else if(c == '-'){
                        Circle s = new Circle(pointerX+(STR/2),pointerY+(STR/2),2);
                        this.getChildren().add(s);
                        pointerX+=STR;
                    } else
                        pointerX+=STR;
                        
                        
                } //Slutt på for-løkke
                pointerY+=STR;
                pointerX=0;
            } //Slutt på while-løkke
            leser.close();
            
        } catch (FileNotFoundException e) //Slutt på "try" fortsetter med "catch"
        { 
        System.out.println("fant ikke fil");}
        
        return leser;
        } 
    
}
