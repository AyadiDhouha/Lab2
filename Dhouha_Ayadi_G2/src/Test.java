import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
public class Test extends Application {
     TextField f1;
     TextField f2 ;
     TextField f3 ;
     ComboBox<String> cbo = new ComboBox<>();
     String ch;
     RandomAccessFile file;
  
     
     private String[] options = {"1111","2222","3333","4444"};
    @Override
    public void start(Stage primaryStage) {
        
        
 Label L1= new Label ("Customer ID :")  ;
 Label L2= new Label ("Balance :")  ;
 Label L3= new Label ("Enter the Amount to withdraw:")  ;
 Label L4= new Label ("Enter the Amount to deposit")  ;
 
 f1 = new TextField();
 f2 = new TextField();
 f3 = new TextField();
 
 cbo.getItems().addAll(FXCollections.observableArrayList(options));
 
 cbo.setValue("------------------------");
 cbo.setOnAction((e) -> {
            
             ch=cbo.getValue();
             if (ch=="1111"){
     f1.setText("2000");
 }
 else if (ch=="2222"){
     f1.setText("3000");
 }
 else if (ch=="3333"){
     f1.setText("4000");
 }
 else if (ch=="4444"){
     f1.setText("5000");
 }
        });
 


 Button B1 = new Button("Withdraw");
 B1.setOnAction((e) -> {
     Account a =new Account(Integer.parseInt(cbo.getValue()), Double.parseDouble(f1.getText()),0);
     a.withdraw(Double.parseDouble(f2.getText()));
     f1.setText(String.valueOf(a.getBalance()));
 });
 Button B2 = new Button("Deposit");
 B2.setOnAction((e) -> {
     Account a =new Account(Integer.parseInt(cbo.getValue()), Double.parseDouble(f1.getText()),0);
     a.deposit(Double.parseDouble(f3.getText()));
     f1.setText(String.valueOf(a.getBalance()));
 });
 Button B3 = new Button("Save");
  B3.setOnAction(e->{try {
        add();
       } catch (IOException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
       }
});
 
BorderPane pane = new BorderPane();
GridPane paneG =new GridPane();

paneG.add(L1, 0, 0,1,1);
paneG.add(cbo, 1, 0,1,1);
paneG.add(L2, 0, 1,1,1);
paneG.add(f1, 1, 1,1,1);
paneG.add(L3, 0, 2,1,1);
paneG.add(f2, 1, 2,1,1);
paneG.add(B1, 3, 2,1,1);
paneG.add(L4, 0, 3,1,1);
paneG.add(f3, 1, 3,1,1);
paneG.add(B2, 3, 3,1,1);
paneG.setHgap(5);
paneG.setVgap(5);
paneG.setPadding(new Insets(15,15,15,15));
pane.setTop(paneG);
pane.setCenter(B3);

// Create a scene and place it in the stage

Scene scene = new Scene(pane, 450, 220);

primaryStage.setTitle("Account UI"); // Set the stage title

primaryStage.setScene(scene); // Place the scene in the stage

primaryStage.show(); }
         private void write(RandomAccessFile inout) throws IOException{
          
          Date date = new Date();

        inout.writeUTF("!date "+(date).toString()+"\n");
        inout.writeUTF("+The Customer "+cbo.getValue()+" has the Balance "+f1.getText()+"\n");
         
    }
  private void add() throws FileNotFoundException, IOException{
     file= new RandomAccessFile("transactions.dat", "rw");
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

