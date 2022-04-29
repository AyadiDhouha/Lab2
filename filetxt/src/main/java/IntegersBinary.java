import java.io.*;
import java.util.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class IntegersBinary {
    
    
    
    
    public static void  main (String [] args) throws FileNotFoundException,IOException{
        ArrayList<Integer> list = new ArrayList<Integer>();
       
        try (
        FileOutputStream output = new FileOutputStream("Integers.dat",true); 
        )
        {
            for (int i=0;i<150;i++){
    int rand = (int)(Math.random()*100);
    list.add(rand);       
    }
    for (int i=0; i<150;i++){
        output.write(list.get(i));
    }
    
    output.close();
            
        }    
            
            
    }
}

