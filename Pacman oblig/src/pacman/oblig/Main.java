/* barmen
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.animation.Animation;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    int poeng = 0;
    
    static ArrayList<Rectangle> sperringer = centerPane.getSperringer();
    static ArrayList<Circle> dotter = centerPane.getDotter();
    
    //Diverse bokser
    BorderPane bPane;
    topPane top = new topPane(poeng);
    bottomPane bottom = new bottomPane();
    centerPane center = new centerPane();
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
      
        //Borderpane
        BorderPane bPane = new BorderPane();
        bPane.setTop(top);
        bPane.setBottom(bottom);
        bPane.setCenter(center);
        
        //pacman player = new pacman();
        pacman player = centerPane.getPlayer();
        center.getChildren().add(player);
        
        pacman liv1 = new pacman(30, 25);
        bottom.getChildren().add(liv1);
        
        pacman liv2 = new pacman(60, 25);
        bottom.getChildren().add(liv2);
        
        pacman liv3 = new pacman(90, 25);
        bottom.getChildren().add(liv3);
        
        String path = "src/Bilder/ghost2-kopi.gif";
        FileInputStream stream = new FileInputStream(path);
        Image image = new Image(stream);
        ImageView view = new ImageView(image);
        view.setTranslateX(10);
        view.setTranslateY(100);
        view.setFitHeight(20);
        view.setFitWidth(20);
        
        
       //Ghost clyde = new Ghost();
        
        center.getChildren().add(view);
        
        
        
        
        Scene scene = new Scene(bPane, width, height);
        
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
        
     
     //Her kommer animasjon
       Timeline opp = new Timeline();
       Timeline venstre = new Timeline();
       Timeline ned = new Timeline();
       Timeline høyre = new Timeline();
       
       final int speed = 30;
       
       // KeyFrames // KeyFrames // KeyFrames // KeyFrames //
       KeyFrame oppkf = new KeyFrame(Duration.millis(speed),
       (evt) -> {
           player.setCenterY(player.getCenterY()-5);
           if (isCollision(player)) {
               opp.pause();
               player.setCenterY(player.getCenterY()+5);
           }
           if (dø(player)) {
               poeng++;
               top.setScore(poeng);
               }
           
       });
       opp.getKeyFrames().add(oppkf);
       opp.setCycleCount(Animation.INDEFINITE);
       
       KeyFrame venstrekf = new KeyFrame(Duration.millis(speed),
       (evt) -> {
           player.setCenterX(player.getCenterX()-5);
            if (isCollision(player)) {
                venstre.pause();
                player.setCenterX(player.getCenterX()+5);
            }
            if (dø(player)) {
               poeng++;
               top.setScore(poeng);
               }
       });
       venstre.getKeyFrames().add(venstrekf);
       venstre.setCycleCount(Animation.INDEFINITE);
       
       KeyFrame nedkf = new KeyFrame(Duration.millis(speed),
       (evt) -> {
           player.setCenterY(player.getCenterY()+5);
            if (isCollision(player)) {
                ned.pause();
                player.setCenterY(player.getCenterY()-5);
            }
            if (dø(player)) {
               poeng++;
               top.setScore(poeng);
               }
       });
       ned.getKeyFrames().add(nedkf);
       ned.setCycleCount(Animation.INDEFINITE);
       
       KeyFrame høyrekf = new KeyFrame(Duration.millis(speed),
       (evt) -> {
           player.setCenterX(player.getCenterX()+5);
               if (isCollision(player)) {
                   høyre.pause();
                   player.setCenterX(player.getCenterX()-5);
               }
               if (dø(player)) {
               poeng++;
               top.setScore(poeng);
               }
               
       });
       høyre.getKeyFrames().add(høyrekf);
       høyre.setCycleCount(Animation.INDEFINITE);
       
       player.setTranslateX(280);
       player.setTranslateY(470);
      
       
   scene.setOnKeyPressed(e -> {        
    switch (e.getCode()) {
        
    case UP:
        opp.play();
        venstre.stop();
        ned.stop();
        høyre.stop();
        player.setRotate(270);
        break;
    case LEFT:
        venstre.play();
        opp.stop();
        ned.stop();
        høyre.stop();
        player.setRotate(180);
        break;
    case DOWN:
        ned.play();
        opp.stop();
        venstre.stop();
        høyre.stop();
        player.setRotate(90);
        break;
    case RIGHT:
        høyre.play();
        opp.stop();
        venstre.stop();
        ned.stop();
        player.setRotate(0);
        break;
   case SPACE:
        ned.stop();
        break;
    }
    
});
   opp.stop();
   ned.stop();
   venstre.stop();
   høyre.stop();
     
   
   
  

    
       
        
       
    }
    
    // Skriv metoder her
    // Legg til boundingBox/eller vanlig box, la den gå "før" pacman, dersom DEN boksen treffer, sett koordinatene dens lik
    // pacman sine, og isCollision == true
    public boolean isCollision(pacman player) {
        for (Rectangle r : sperringer) {
            if (player.getBoundsInParent().intersects(r.getBoundsInParent())) {
                r.setFill(Color.RED);
                return true;
            }
        }
    return false;
    }
    
    /*
    public void pickUpPoint(pacman player) {
        for (Circle c : dotter) {
            if ( player.getBoundsInParent().intersects(c.getBoundsInParent()) &&
                                                   c.getFill() != Color.BLACK) {
                c.setFill(Color.BLACK);
                //Oppdater score
                poeng++;
                System.out.println(poeng);
                top.oppdaterPoeng(poeng);
            }
        }
    }*/
    
    public boolean dø(pacman player) {
        for (Circle c : dotter) {
            if ( player.getBoundsInParent().intersects(c.getBoundsInParent()) ) {
                center.getChildren().remove(c);
                dotter.remove(c);
                return true;
            }
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
