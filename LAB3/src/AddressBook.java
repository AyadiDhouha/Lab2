import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AddressBook extends Application{
        TextField f1;
        TextField f2 ;
        TextField f3 ;
        TextField f4 ;
        TextField f5;
        RandomAccessFile file;
        int count;

        Button B1 = new Button("Add");
        Button B2 = new Button("First");
        Button B3 = new Button("Next");
        Button B4 = new Button("Previous");
        Button B5= new Button("Last");
        Button B6 = new Button("Update ");


    @Override
    public void start (Stage primaryStage) throws FileNotFoundException, IOException , ClassNotFoundException{
        Label Name = new Label("Name");
        Label Street = new Label ("Sreet");
        Label City = new Label ("City");
        Label State = new Label ("State");
        Label Zip = new Label ("Zip");

        f1 = new TextField();
        f1.setPrefColumnCount(23);
        f2 = new TextField();
        f2.setPrefColumnCount(23);
        f3 = new TextField();
        f3.setPrefColumnCount(8);
        f4 = new TextField();
        f4.setPrefColumnCount(2);
        f5 = new TextField();
        f5.setPrefColumnCount(4);
       
        Button B1 = new Button("Add");
        B1.setOnAction(e->{try {
            add();
            } catch (IOException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        Button B2 = new Button("First");
            B2.setOnAction(e->{try {
                first();
            } catch (IOException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        Button B3 = new Button("Next");
        B3.setOnAction(e->{try {
                next();
            } catch (IOException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        Button B4 = new Button("Previous");
        B4.setOnAction(e->{try {
                previous();
            } catch (IOException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        Button B5= new Button("Last");
                B5.setOnAction(e->{try {
                last();
            } catch (IOException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
});
        Button B6 = new Button("Update");
                B6.setOnAction(e->{try {
                update();
            } catch (IOException ex) {
                Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
            }
});
       
        HBox pane1 =  new HBox(10);
        pane1.getChildren().addAll(Name,f1);
        pane1.setAlignment(Pos.CENTER);
       
        HBox pane2 =  new HBox(10);
        pane2.getChildren().addAll(Street,f2);
        pane2.setAlignment(Pos.CENTER);
       
        HBox pane3 =  new HBox(3);
        pane3.getChildren().addAll(City,f3,State,f4,Zip,f5);
        pane3.setAlignment(Pos.CENTER);
               
       
        HBox pane4 = new HBox(8);
        pane4.getChildren().addAll(B1,B2,B3,B4,B5,B6);
        pane4.setAlignment(Pos.CENTER);
     
       
        VBox box = new VBox(15);
         box.getChildren().addAll(pane1,pane2,pane3,pane4);
       
       
        Scene scene = new Scene(box);
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(scene);
        primaryStage.show();
   
    }
 private void write(RandomAccessFile inout) throws IOException{
        inout.write(FixerTaille(f1.getText().getBytes(),32));
        inout.write(FixerTaille(f2.getText().getBytes(),32));
        inout.write(FixerTaille(f3.getText().getBytes(),20));
        inout.write(FixerTaille(f4.getText().getBytes(),5));
        inout.write(FixerTaille(f5.getText().getBytes(),2));

         
    }
  private void read(RandomAccessFile inout) throws IOException{
        int pos;
        byte[] name = new byte[32];
        pos=inout.read(name);
        this.f1.setText(new String(name));
        byte[] street = new byte[32];
        pos+=inout.read(street);
        this.f2.setText(new String(street));
        byte[] city = new byte[20];
        pos+=inout.read(city);
        this.f3.setText(new String(city));
        byte[] state = new byte[2];
        pos+=inout.read(state);
        this.f4.setText(new String(state));
        byte[] zip = new byte[5];
        pos+=inout.read(zip);
        this.f5.setText(new String(zip));
    }



private void add() throws FileNotFoundException, IOException{
     file= new RandomAccessFile("test.dat", "rw");
     file.seek(file.length());
     write(file);
   
}

private void first() throws FileNotFoundException, IOException{
         file= new RandomAccessFile("test.dat", "rw");
         file.seek(0);
         read(file);
}


private void next() throws FileNotFoundException, IOException{
    RandomAccessFile inout = new RandomAccessFile("test.dat", "rw");
          
      
            if (count * 91 < inout.length()) {
                        inout.seek(count * 91);
                        read(inout);
                        count++;
                 }
            }

private void previous() throws FileNotFoundException, IOException {
		
			RandomAccessFile inout = new RandomAccessFile("test.dat", "rw");
		
			if (count > 1) 
				count--;
			else
				count = 1;
			inout.seek((count * 91) - 91);
			read(inout);
			
		}
private void last() throws FileNotFoundException, IOException {
		
			RandomAccessFile inout = new RandomAccessFile("test.dat", "rw");
		
			count = ((int)inout.length()) / 91;
			inout.seek((count * 91) - 91);
			read(inout);
			System.out.println("Reading address #" + count);
		}
		
   private void update() throws FileNotFoundException, IOException  {
                        RandomAccessFile inout = new RandomAccessFile("test.dat", "rw");
		 	inout.seek(count * 91 - 91);
		 	write(inout);
		
	}		
	
private byte[] FixerTaille(byte[] x, int n){
    byte[] b = new byte[n];
for (int i = 0; i < x.length; i++) {
b[i] = x[i];
}
    return b;
}

 
 
    public static void main(String[] args) {
        Application.launch(args);
    }
    }

