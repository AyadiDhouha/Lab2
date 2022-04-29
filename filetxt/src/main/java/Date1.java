
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class Date1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  IOException, ClassNotFoundException {
        try(
                ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("date.dat")));
               
             )
        {
             
           output.writeUTF("ALI ");
           output.writeDouble((float)17.0);
           output.writeObject(new java.util.Date() ); 
            
        
        }
            try(
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("date.dat")));
               
                    )
            {
               while(true){
               
                   String name=input.readUTF();
                   double score = input.readDouble();
                   java.util.Date date=(java.util.Date)(input.readObject());
                   System.out.println(name +" "+ score+" "+date);
               }
            }
            catch(EOFException ex){
                System.out.println("All data were read");
            }
         
        // TODO code application logic here
    }
    
}
