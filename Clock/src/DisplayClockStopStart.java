

import java.awt.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author LENOVO
 */
public class DisplayClockStopStart extends Application {
    
    @Override
    public void start(Stage primaryStage) {

// Create a clock and a label

ClockPane2 clock = new ClockPane2();


EventHandler<ActionEvent> eventHandler = e ->{  
    clock.setCurrentTime();
    };


    Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(1000),eventHandler)
    );

Button BtStart=new Button("Start");
BtStart.setOnAction(e ->{animation.play()});
Button BtStop=new Button("Stop");
BtStop.setOnAction(e ->{animation.pause()});
// Place clock and label in border pane

BorderPane pane = new BorderPane();
HBox paneBtn = new HBox(2);
paneBtn.getChildren().addAll(BtStart,BtStop);

pane.setCenter(clock);

pane.setBottom(paneBtn);

BorderPane.setAlignment(paneBtn, Pos.TOP_CENTER);

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
