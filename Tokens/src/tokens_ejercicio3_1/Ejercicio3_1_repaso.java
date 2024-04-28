
/*
Crea en un documento de texto el archivo de texto Jugadores.txt en la carpeta del proyecto.
Escribe en él los nombres, edades y estaturas de los jugadores del equipo con un jugador en cada línea.

Implementa un programa que lea del fichero los datos, muestre los nombres y calcule la media de las edades y estaturas, mostrándolas por pantalla.
 */
package tokens_ejercicio3_1;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3_1_repaso {

    public static void main(String[] args) {
        Scanner sc = null;
        String nombre;
        int edad;
        int sumaEdad = 0;
        int contador = 0;
        double estatura;
        double sumaEstatura = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader("Jugadores.txt"))) {
            String cad = br.readLine();
            
            while ( cad!= null){
                sc = new Scanner(cad).useLocale(Locale.US);
                
                nombre = sc.next();
                System.out.println(nombre);
                
                edad = sc.nextInt();
                sumaEdad += edad;
                
                estatura = sc.nextDouble();
                sumaEstatura += estatura;
                
                System.out.println(nombre);
                contador++;
                cad = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally{
            System.out.println("La media de las edades son: "+sumaEdad/contador);
            System.out.println("La media de las estaturas son: "+sumaEstatura/contador);
        }
    }

}
