/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author LENOVO
 */
public class DisplayClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {

// Create a clock and a label

clockPane clock = new clockPane();

String timeString = clock.getHour() + ":" + clock.getMinute()+ ":" + clock.getSecond();

Label lblCurrentTime = new Label(timeString);

// Place clock and label in border pane

BorderPane pane = new BorderPane();

pane.setCenter(clock);

pane.setBottom(lblCurrentTime);

BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

// Create a scene and place it in the stage

Scene scene = new Scene(pane, 250, 250);

primaryStage.setTitle("DisplayClock"); // Set the stage title

primaryStage.setScene(scene); // Place the scene in the stage

primaryStage.show(); }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
