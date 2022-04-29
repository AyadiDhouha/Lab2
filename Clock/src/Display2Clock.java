
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Display2Clock extends Application{
    @Override
    public void start(Stage primaryStage) {
    ClockPane clock1 = new ClockPane(4,20,45);
    clock1.setWidth(150);
    clock1.setHeight(250);
    ClockPane clock2 = new ClockPane(22,46,15);
    clock2.setWidth(150);
    clock2.setHeight(250);
    HBox pane = new HBox(2);
    pane.getChildren().addAll(clock1,clock2);
    pane.setAlignment(Pos.CENTER);
    Scene scene = new Scene(pane, 500, 250);
    primaryStage.setTitle("DisplayClock"); 
    primaryStage.setScene(scene);
    primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
