import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class RacingCar extends Application{
    @Override
    public void start(Stage primaryStage) {
    CarPane car= new CarPane();
    car.setOnMousePressed(e->{
            car.Pause();
            
        });
        car.setOnMouseReleased(e->{
            car.Start();
            
        });
        car.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.UP){
                car.Increase();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                car.Decrease();
            }
			
	});
    Scene scene = new Scene(car, 500, 150);
        primaryStage.setTitle("CarLab2");
        primaryStage.setScene(scene);
        primaryStage.show();
        car.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
