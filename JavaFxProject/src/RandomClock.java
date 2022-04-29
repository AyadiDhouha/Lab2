import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ahmed
 */
public class RandomClock extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock1 = new ClockPane((int) ((Math.random()*(12))), (int) ((Math.random()*(31))) ,0);
        clock1.setsecondHandVisible(false);
  
        String timeString = clock1.getHour() + ":" + clock1.getMinute();

        Label lblCurrentTime = new Label(timeString);
        
        BorderPane pane = new BorderPane();       
        
        pane.setCenter(clock1);
        
        pane.setBottom(lblCurrentTime);
        
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
        
        Scene scene = new Scene(pane, 600, 300);

        primaryStage.setTitle("DisplayClock"); // Set the stage title

        primaryStage.setScene(scene); // Place the scene in the stage
        
        primaryStage.show();
           }

    public static void main(String[] args) {
        launch(args);
    }
    
}