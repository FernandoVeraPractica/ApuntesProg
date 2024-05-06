
package writers;

import java.io.*;
import java.util.Scanner;

/*
Crea un fichero que sea la copia de otro fichero que el usuario escribe su nombre.
El fichero tendrá el formato copia_de_"fichero".txt
 */
public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el archivo. Se copiará en el mismo directorio.");
        String cad = sc.nextLine();
        
        try(BufferedReader br = new BufferedReader(new FileReader(cad));
                BufferedWriter bw = new BufferedWriter(new FileWriter("copia_de_"+cad))){
            String copiar = br.readLine();
            while(copiar!= null){
                bw.write(copiar);
                bw.newLine();
                copiar = br.readLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}
