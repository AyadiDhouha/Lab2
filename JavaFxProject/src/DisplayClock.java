

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
public class DisplayClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {

// Create a clock and a label

ClockPane clock = new ClockPane();

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
