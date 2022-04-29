
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;


import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


/**
 *
 * @author LENOVO
 */
public class LoanCalculator extends Application {
        TextField f1;
        TextField f2 ;
        TextField f3 ;
        TextField f4 ;
        TextField f5;
        TextField f6;
        private String[] options = {"Monthly Interest Rate","Monthly Payment","Total Payment"};
        public loan l=new loan();
        public String ch;
        RandomAccessFile file;
    
    @Override
    public void start(Stage primaryStage) {
        Label AnnualInterestRate = new Label("AnnualInterestRate");
        Label NumberofYears = new Label("Number of Years");
        Label LoanAmount = new Label("LoanAmount");
        Label ChooseaCalculation = new Label("Choose a Calculation");
        Label MonthlyIntrestRate = new Label("MonthlyIntrestRate");
        Label MonthlyPayment = new Label("MonthlyPayment");
        Label TotalPayment = new Label("TotalPayment");
        
        f1 = new TextField();
        
        f2 = new TextField();
        
        f3 = new TextField();
        
        f4 = new TextField();
        
        f5 = new TextField();
        
        f6 = new TextField();
        
        ComboBox<String> cbo = new ComboBox<>(FXCollections.observableArrayList(options));
        
        cbo.setValue("--------");
        cbo.setOnAction((e) -> {
            
             ch=cbo.getSelectionModel().getSelectedItem();
        });
       
        Button B1 = new Button("Calculate");
        B1.setOnAction((e) -> {
           
            if (ch == "Monthly Interest Rate"){
                f4.setText(String.valueOf(l.getMonthlyInterestRate()));
            }
            else if (ch =="Monthly Payment"){
                f5.setText(String.valueOf(l.getMonthlyPayment()));
            }
            else {
                f6.setText(String.valueOf(l.getTotalPayment()));
            }
            try {
                add();
            } catch (IOException ex) {
                Logger.getLogger(LoanCalculator.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        





BorderPane pane = new BorderPane();
HBox paneH = new HBox(8);
GridPane paneG1 = new GridPane();
GridPane paneG2 = new GridPane();

paneG1.add(AnnualInterestRate, 0, 0,1,1);
paneG1.add(f1, 1, 0,1,1);
paneG1.add(NumberofYears, 0, 1,1,1);
paneG1.add(f2, 1, 1,1,1);
paneG1.add(LoanAmount, 0, 2,1,1);
paneG1.add(f3, 1, 2,1,1);


paneH.getChildren().addAll(ChooseaCalculation,cbo,B1);

paneG2.add(MonthlyIntrestRate, 0, 0,1,1);
paneG2.add(f4, 1, 0,1,1);
paneG2.add(MonthlyPayment, 0, 1,1,1);
paneG2.add(f5, 1, 1,1,1);
paneG2.add(TotalPayment, 0, 2,1,1);
paneG2.add(f6, 1, 2,1,1);
//BorderPane.setAlignment(paneBtn, Pos.TOP_CENTER);

pane.setTop(paneG1);

pane.setBottom(paneG2);
paneH.setPadding(new Insets(15,15,15,0));
pane.setCenter(paneH);

// Create a scene and place it in the stage

Scene scene = new Scene(pane, 450, 220);

primaryStage.setTitle("LoanCalculator"); // Set the stage title

primaryStage.setScene(scene); // Place the scene in the stage

primaryStage.show(); }
    
    
     private void write(RandomAccessFile inout) throws IOException{
        inout.writeUTF(LocalDateTime.now().toString()+"\n");
        inout.writeUTF("For the input "+f1.getText()+" "+f2.getText()+" "+f3.getText()+"\n");
        
        inout.writeUTF("The monthly interest Rate is "+f4.getText()+"\n");
        inout.writeUTF("The Monthly Payment is "+f5.getText()+"\n");
        inout.writeUTF("The Total Payment is "+f6.getText()+"\n");

         
    }
 private void add() throws FileNotFoundException, IOException{
     file= new RandomAccessFile("calculations.dat", "rw");
     file.seek(file.length());
     write(file);
   
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}

