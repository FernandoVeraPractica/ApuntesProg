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

    public static void main(String[] args) {
        Scanner sc = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            String nombre;
            int edad;
            double estatura;
            fr = new FileReader("Jugadores.txt");
            int contadorEdad = 0;
            int contadorEstatura = 0;
            int sumaEdad = 0;
            double sumaEstatura = 0;

            String datos = br.readLine();

            while (datos != null) {
                
                sc = new Scanner(datos).useLocale(Locale.US);
                
                if (sc.hasNextLine()) {
                    nombre = sc.next();
                    System.out.println(datos);
                }

                if (sc.hasNextInt()) {
                    edad = sc.nextInt();
                    contadorEdad++;
                }

                if (sc.hasNextDouble()) {
                    estatura = sc.nextDouble();
                    contadorEstatura++;
                }
                
                datos = br.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
