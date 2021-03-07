package pacman.oblig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
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


public class Main extends Application {
    
    static int STR    = 20;
    static int width  = STR*28;
    static int height = (STR*31)+100;
    
    int alleLivIndeks = 2;
    
    int poeng = 0;
    double random = Math.random();
    
    static ArrayList<Rectangle> sperringer = centerPane.getSperringer();
    static ArrayList<Circle> dotter = centerPane.getDotter();
    static ArrayList<pacman> alleLiv = new ArrayList<>();
    //Diverse bokser
    BorderPane bPane;
    topPane top = new topPane(poeng);
    bottomPane bottom = new bottomPane();
    centerPane center = new centerPane();
    Label GameOver = new Label("Game Over...");
    
    
    pacman player;
    Ghost pinky;
    Ghost inky;
    Ghost clyde;
    Ghost blinky;
    
    Timeline opp = new Timeline();
    Timeline venstre = new Timeline();
    Timeline ned = new Timeline();
    Timeline høyre = new Timeline();
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException {
        
        
      
      
        //Borderpane
        BorderPane bPane = new BorderPane();
        bPane.setTop(top);
        bPane.setBottom(bottom);
        bPane.setCenter(center);
        
      
      
        
        // Legger til tre stk liv i ArrayListen: alleLiv
        int livX = 30, livY = 25;
        
        for (int i = 0; i <= alleLivIndeks; i++) { 
            pacman liv = new pacman(livX,livY);
            alleLiv.add(liv);
            bottom.getChildren().add(liv);
            livX+=30;
        }
        
        player = centerPane.getPlayer();
        center.getChildren().add(player);
        
        
        pinky = center.getPinky();
        blinky = center.getBlinky();
        inky = center.getInky();
        clyde = center.getClyde();
        center.getChildren().addAll(pinky, blinky, inky, clyde);
        
        inky.hunt(player, inky);
        blinky.hunt(player, blinky);
        clyde.hunt(player, clyde);
        pinky.hunt(player, pinky);
        Scene scene = new Scene(bPane, width, height);
        
        primaryStage.setTitle("Pacman");
        primaryStage.setScene(scene);
        primaryStage.show();
    //Her kommer animasjon for spøkelsene
               
    
     //Her kommer animasjon
       
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
             hitByGhost(player);
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
              hitByGhost(player);
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
              hitByGhost(player);
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
               hitByGhost(player);
       });
       høyre.getKeyFrames().add(høyrekf);
       høyre.setCycleCount(Animation.INDEFINITE);
       
       
      // Slutt på KeyFrames // Slutt på KeyFrames // Slutt på KeyFrames
      // Slutt på KeyFrames // Slutt på KeyFrames // Slutt på KeyFrames
       
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
   
  
     
   
   
  
    
       
        System.out.println("Pacman - X: " + player.getCenterX() + " Y: " + player.getCenterY());
        System.out.println("Clyde - X: " + clyde.getX() + " Y: " + clyde.getY());
       
    }
    
    // Skriv metoder her
    public boolean isCollision(pacman player) {
        for (Rectangle r : sperringer) {
            if (player.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public void hitByGhost(pacman player) {
        if (player.getBoundsInParent().intersects(clyde.getBoundsInParent()) ||
            player.getBoundsInParent().intersects(blinky.getBoundsInParent()) ||
            player.getBoundsInParent().intersects(inky.getBoundsInParent()) ||
            player.getBoundsInParent().intersects(pinky.getBoundsInParent())) {
               bottom.getChildren().remove(alleLiv.get(alleLivIndeks));
                   alleLivIndeks--;
                   opp.stop();
                   høyre.stop();
                   ned.stop();
                   venstre.stop();
                   
                   player.setCenterX(player.getPacmanX());
                   player.setCenterY(player.getPacmanY());
                   pinky.setX(pinky.getGhostX());
                   pinky.setY(pinky.getGhostY());
                   inky.setX(inky.getGhostX());
                   inky.setY(inky.getGhostY());
                   blinky.setX(blinky.getGhostX());
                   blinky.setY(blinky.getGhostY());
                   clyde.setX(clyde.getGhostX());
                   clyde.setY(clyde.getGhostY());
                   gameOver();
        }
    }
    
    public boolean isCollisionGhost(Ghost ghost) {
        ArrayList<Rectangle> sperringer = center.getSperringer();
        for (Rectangle r : sperringer) {
            if (ghost.getBoundsInParent().intersects(r.getBoundsInParent()))
                return true;
        }
    return false;
    }
    
    public boolean almostCollision(Ghost ghost) {
        Ghost tempGhost = ghost;
        tempGhost.setX(ghost.getX()+3);
        for (Rectangle r : sperringer) {
            if (tempGhost.getBoundsInParent().intersects(r.getBoundsInParent()) )
                return true;
        }
    return false;
    }
    
    
    
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
    public boolean gameOver() {
         if(alleLivIndeks == -1) {
             
             GameOver.setStyle("-fx-text-fill:YELLOW; -fx-font-size: 40;");
             GameOver.setPrefSize(500,500);
             GameOver.setTranslateX(170);
             GameOver.setTranslateY(100);
                   System.out.println("Game over");
                   center.getChildren().add(GameOver);
                   center.getChildren().remove(player);
                   center.getChildren().remove(clyde);
                   center.getChildren().remove(blinky);
                   center.getChildren().remove(pinky);
                   center.getChildren().remove(inky);
          }
        return true;
    }
    
    
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

