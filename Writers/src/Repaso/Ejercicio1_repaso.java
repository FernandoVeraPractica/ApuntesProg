/*
Crear un fichero desde el FileWriter con dos cadenas iguales. 

La primera la añade carácter a carácter y la segunda en una cadena.

 */
package Repaso;

import java.io.*;

public class Ejercicio1_repaso {

    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Hola.txt")); BufferedReader br = new BufferedReader(new FileReader("Hola.txt"))) {

            String cad = "Hola que tal estas";

            for (int i = 0; i < cad.length(); i++) {
                bw.write(cad.charAt(i));
            }
            bw.newLine();
            bw.write(cad);

            bw.flush();
            
            String leer = br.readLine();
            
            while (leer != null){
                System.out.println(leer);
                leer = br.readLine();
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
