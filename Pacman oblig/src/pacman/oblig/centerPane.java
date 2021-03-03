/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.BoundingBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jacob
 */
public class centerPane extends Pane {
    
    
    static ArrayList<Rectangle> sperringer = new ArrayList<>(); //Skal inneholde alle firkanter/"sperringer" 
    static ArrayList<Circle> dotter = new ArrayList<>(); //Skal inneholde alle prikkene på kartet
    static pacman player; 
    static Blinky blinky;
    static Pinky pinky;
    static Inky inky;
    static Clyde clyde;
    
    public centerPane() {
        this.setPrefHeight(Main.getSTR()*31);
        this.setStyle("-fx-border-color: black; -fx-background-color: black;");
        getMap();
        
    }
    BoundingBox bb;
    
    //Metode som leser inn kartet(banen)
    public Scanner getMap() {
             Scanner leser = null;
             int pointerX = 0, pointerY = 0;
             double STR = Main.getSTR();
             
        try{
          //sperringer = new ArrayList<>();  
          File fil = new File("pacman-kart.txt");
            leser = new Scanner(fil);
            while ( leser.hasNextLine() ) {
                String linje = leser.nextLine();
                for (int i = 0; i < linje.length(); i++ ) {
                    char c = linje.charAt(i);
                    switch (c) {
                        case 'x':
                            {
                                Rectangle s = new Rectangle(pointerX, pointerY, STR,STR);
                                s.setFill(BLUE);
                                sperringer.add(s); // Legger til firkant i arraylisten "sperringer"
                                this.getChildren().add(s); // Legger til firkanten på centerPanet
                                
                                pointerX+=STR;
                                break;
                            }
                        case '-':
                            {
                                Circle s = new Circle(pointerX+(STR/2),pointerY+(STR/2),2, YELLOW);
                                dotter.add(s);
                                this.getChildren().add(s);
                                pointerX+=STR;
                                break;
                            }
                        case 'o':      
                            {
                                Circle s = new Circle(pointerX+(STR/2), pointerY+(STR/2), 5, YELLOW);
                                this.getChildren().add(s);
                                pointerX+=STR;
                                break;
                            }
                        case 'p':
                            //Her kommer pacman
                            player = new pacman(pointerX+(STR/2), pointerY+(STR/2)); //pointerX+STR, pointerY+(STR/2)
                            pointerX+=STR;
                            break;
                        case '1':
                            clyde = new Clyde(pointerX+(STR/2), pointerY, "src/Bilder/ghost2-kopi.gif"); //pointerX+(STR/2), pointerY,
                            pointerX+=STR;
                            break;
                        case '2':
                            inky = new Inky(pointerX+(STR/2), pointerY, "src/Bilder/200w.gif");
                            pointerX+=STR;
                            break;
                        case '3':
                            pinky = new Pinky(pointerX+(STR/2),pointerY, "src/Bilder/YMXv.gif");
                            pointerX+=STR;
                            break;
                        case '4':
                            blinky = new Blinky(pointerX+(STR/2), pointerY, "src/Bilder/red.gif");
                            pointerX+=STR;
                            break;
                        default:
                            pointerX+=STR;
                            break;
                    }
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
    
    //Get-metode for arraylisten over alle sperringer
    public static ArrayList<Rectangle> getSperringer() {return sperringer;} 
    public static ArrayList<Circle> getDotter() {return dotter;}
    
    public static pacman getPlayer() {return player;}
    
    public static Blinky getBlinky() {return blinky;}
    public static Pinky getPinky() {return pinky;}
    public static Inky getInky() {return inky;}
    public static Clyde getClyde() {return clyde;}
    
    
    
}
