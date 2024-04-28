/*
Escribe un texto en un archivo de texto línea a línea leídas del teclado hasta que introduzca la cadena "fin".
 */
package writers;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        Scanner sc = null;
        
        try{
            fw = new FileWriter("Ejercicio1.txt");
            bw = new BufferedWriter(fw);
            sc = new Scanner(System.in);
            
            System.out.println("Introduce las palabras que se almacenarán en el archivo: ");
            String cad = sc.next();
            
            while(!cad.equalsIgnoreCase("fin")){
                bw.write(cad);
                bw.newLine();
                cad = sc.next();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
