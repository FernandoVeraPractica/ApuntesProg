/*
Crear con un editor de texto un archivo con un conjunto de números reales, uno por línea.
Abrirlo con un flujo de texto para lectura y leerlo línea a línea.
Convertir las cadenas leídas en números de tipo double por medio de Scanner
y mostrar al final la suma de todos ellos.
 */
package tokens_ejercicio2;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = null;

        try (BufferedReader br = new BufferedReader(new FileReader("Reales.txt"))) {
            double numero;
            double suma = 0;

            String cad = br.readLine();
            while (cad != null) {
                sc = new Scanner(cad).useLocale(Locale.US);

                if (sc.hasNextDouble()) {
                    numero = sc.nextDouble();
                    suma += numero;
                }
                cad = br.readLine();
            }
            System.out.println("Suma: " + suma);

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}

