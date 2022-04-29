
import javafx.application.Application;
import static javafx.application.Application.launch;


import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


/**
 *
 * @author LENOVO
 */
public class DisplayClockStopStart extends Application {
    
    @Override
    public void start(Stage primaryStage) {

// Create a clock and a label

ClockPane2 clock = new ClockPane2();

Button BtStart=new Button("Start");//creation bouton start
BtStart.setOnAction(e ->{clock.start();});//ajout de l'action
Button BtStop=new Button("Stop");//creation bouton stop
BtStop.setOnAction(e ->{clock.stop();});// ajout de l'action
// Place clock and label in border pane

BorderPane pane = new BorderPane();
HBox paneBtn = new HBox(2);

paneBtn.setAlignment(Pos.CENTER);
paneBtn.getChildren().addAll(BtStart,BtStop);

pane.setCenter(clock);

pane.setBottom(paneBtn);

//BorderPane.setAlignment(paneBtn, Pos.TOP_CENTER);

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

