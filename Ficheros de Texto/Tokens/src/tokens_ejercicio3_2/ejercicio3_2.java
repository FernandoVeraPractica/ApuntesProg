package tokens_ejercicio3_2;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/*
Crea en un documento de texto el archivo de texto Jugadores.txt en la carpeta del proyecto.
Escribe en él los nombres, edades y estaturas de los jugadores del equipo con un jugador en cada línea.

Implementa un programa que lea del fichero los datos, muestre los nombres y calcule la media de las edades y estaturas, mostrándolas por pantalla.
 */
public class ejercicio3_2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = null;
        FileReader fr = null;
        String nombre;
        int edad;
        double estatura;
        int contadorEdad = 0;
        int contadorEstatura = 0;
        int sumatorioEdad = 0;
        double sumatorioEstatura = 0;

        try {
            fr = new FileReader("Jugadores.txt");
            sc = new Scanner(fr).useLocale(Locale.US);

            while (sc.hasNext()) {
                if (sc.hasNext()) {
                    nombre = sc.next();
                    System.out.println(nombre);
                }

                if (sc.hasNextInt()) {
                    edad = sc.nextInt();
                    sumatorioEdad += edad;
                    contadorEdad++;
                }

                if (sc.hasNextDouble()) {
                    estatura = sc.nextDouble();
                    sumatorioEstatura += estatura;
                    contadorEstatura++;
                }
            }
            System.out.println("Media de edad: " + (sumatorioEdad / contadorEdad));
            System.out.println("Media de estatura: " + (sumatorioEstatura / contadorEstatura));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
