import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.util.ArrayList;

public class StringBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  IOException {
        long startTime=System.nanoTime();
       ArrayList<String> list = new ArrayList<String>();
        try(
                DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("string.dat",true)));
               
             )
        {
             for(int i=0;i< 10;i++){
            output.writeUTF("Advanced Java ");
        }
        }
            try(
                DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("string.dat")));
               
                    )
            {
               while(true){
                   System.out.print(input.readUTF());
               }
            }
            catch(EOFException ex){
                System.out.println("All data were read");
            }
         
       
         long endTime =System.nanoTime();
         long duration =(endTime - startTime);
         System.out.println(duration);
       
       
    }
   
}

