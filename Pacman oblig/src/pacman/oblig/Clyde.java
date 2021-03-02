/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.oblig;



/**
 * path: "src/Bilder/ghost2-kopi.gif"
 * @author christofferstrandarnesen
 */
public class Clyde extends Ghost {
    
    String path = "src/Bilder/ghost2-kopi.gif"; //funker ikke atm
    double height = 100;
    double width = 100;
    
    public Clyde(double x, double y, String path) {
        super(x,y,path);
    }
    
}
