/*
Escribe un texto en un archivo de texto línea a línea leídas del teclado hasta que introduzca la cadena "fin".
 */

package Repaso;

import java.util.Scanner;
import java.io.*;


public class Ejercicio2_repaso {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("ej2repaso.txt"))){
            String cad;
            System.out.println("Introduce frases que se introducirán en un archivo. Para terminar escriba \"fin\"");
            cad = sc.nextLine();
            while (!cad.equalsIgnoreCase("fin")){
                bw.write(cad);
                bw.newLine();
                cad = sc.nextLine();
            }
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        
    }
 
}
