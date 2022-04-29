
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
public class Integers {
    
    
    
    
    public static void  main (String [] args) throws FileNotFoundException{
        ArrayList<String> list = new ArrayList<String>();
        File file=new File("Integers.txt");
        if (file.exists()){
        Scanner scanner= new Scanner(file);
        while (scanner.hasNext()){
            list.add(scanner.nextLine());
            //pour afficher 
            //String data =scanner.nextLine();
            //System.out.println(data);
        }
        }
     
    PrintWriter output = new PrintWriter(file);
    for (int i=0;i<150;i++){
    int rand = (int)(Math.random()*100);
    list.add(String.valueOf(rand)+" ");       
    }
    for (int i=0; i<150;i++){
        output.print(list.get(i));
    }
    
    output.close();
            

    }
    
}
