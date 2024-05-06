/*

 */
package tokens_ejercicio3_2;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/*
Crea en un documento de texto el archivo de texto Jugadores.txt en la carpeta del proyecto.
Escribe en él los nombres, edades y estaturas de los jugadores del equipo con un jugador en cada línea.

Implementa un programa que lea del fichero los datos, muestre los nombres y calcule la media de las edades y estaturas, mostrándolas por pantalla.
 */
public class Ejercicio3_2_repaso {

    public static void main(String[] args) {

        Scanner sc = null;
        String nombre;
        int edad;
        int sumaEdad = 0;
        double estatura;
        double sumaEstatura = 0;
        int contador = 0;
        try {
            sc = new Scanner(new FileReader("Jugadores.txt")).useLocale(Locale.US);

            while (sc.hasNext()) {
                nombre = sc.next();
                System.out.println(nombre);

                edad = sc.nextInt();
                sumaEdad+=edad;
                
                estatura = sc.nextDouble();
                sumaEstatura += estatura;
                
                contador++;
            }
                System.out.println("La media de edades es: "+ (sumaEdad/contador));
                System.out.println("La media de estaturas es: "+ (sumaEstatura/contador));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
