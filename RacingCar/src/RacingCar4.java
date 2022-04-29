
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class RacingCar4 extends Application {
	HBox paneForSpeed = new HBox(4);
	VBox paneForCars = new VBox(4);
	protected ObservableList<Node> textFields = paneForSpeed.getChildren();
	protected ObservableList<Node> cars = paneForCars.getChildren();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		

		paneForSpeed.setAlignment(Pos.CENTER);

		// Place labels and text fields in a pane
		for (int i = 0; i < 4; i++) {
			paneForSpeed.getChildren().addAll(
				new Label("Car " + (i + 1) + ":"), new TextField());
		}

		// Set specified properties for each text field in a list
		for (int i = 1; i < textFields.size(); i+= 2) {
			((TextField)textFields.get(i)).setPrefColumnCount(2);
		}

		// Place nodes in a pane for cars
		for (int i = 0; i < 4; i++) {
			paneForCars.getChildren().add(new CarPane());
		}

		// Set specified properties for each element in a list
		for (Node car: cars) {
			((CarPane)car).setStyle("-fx-border-color: black");
		}

		// Create and register handlers
		for (int i = 1; i < textFields.size(); i += 2) {
			((TextField)textFields.get(i)).setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.ENTER) {
					setSpeed();
				}
			});

		}
		
		// Create a border pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForSpeed);
		pane.setCenter(paneForCars);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 800, 500);
		primaryStage.setTitle("RacingCar"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/** Set specified rate for a CarPane list */
	private void setSpeed() {
		for (int i = 1, j = 0; i < textFields.size(); i += 2, j++) {
			if (((TextField)textFields.get(i)).getText().length() > 0) {
				((CarPane)cars.get(j)).SetSpeed(
					Double.parseDouble(((TextField)textFields.get(i)).getText()));
				((CarPane)cars.get(j)).Start();
			}
			else {
				((CarPane)cars.get(j)).Pause();
			}
		}
	}
        public static void main(String[] args) {
        launch(args);
    }
}