import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author LENOVO
 */
public class DisplayClockRandom extends Application {
    
    @Override
    public void start(Stage primaryStage) {

// Create a clock and a label

ClockPane2 clock = new ClockPane2( (int)((Math.random()*(12))), (int) ((Math.random()*(31))) ,0);

clock.setsecondHandVisible(false);

String timeString = clock.getHour() + ":" + clock.getMinute();

Label lblCurrentTime = new Label(timeString);

// Place clock and label in border pane

BorderPane pane2 = new BorderPane();

pane2.setCenter(clock);

pane2.setBottom(lblCurrentTime);

BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

// Create a scene and place it in the stage

Scene scene = new Scene(pane2, 250, 250);

primaryStage.setTitle("DisplayClockRandom"); // Set the stage title

primaryStage.setScene(scene); // Place the scene in the stage

primaryStage.show(); }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}