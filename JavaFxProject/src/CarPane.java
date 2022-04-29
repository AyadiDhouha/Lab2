import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class CarPane extends Pane {
    protected double x ;
    protected double y ;
    private void paintCar(){
        getChildren().clear();
       //Dessiner les roues
       Circle circle1 = new Circle(x+15, y-5,5);
       circle1.setFill(Color.BLACK);
       circle1.setStroke(Color.BLACK);
       Circle circle2 = new Circle(x+35, y-5,5);
       circle2.setFill(Color.BLACK);
       circle2.setStroke(Color.BLACK);
       //Dessiner rectangle
       Rectangle rectangle = new Rectangle(x,y-20,50,10);
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.BLACK);
       //Dessiner polygon
       Polygon polygon = new Polygon();
       polygon.getPoints().addAll(new Double[]{x+10,y-20,x+20,y-30,x+30,y-30,x+40,y-20});
       getChildren().addAll(circle1,circle2,rectangle,polygon); 
  
    }
}
