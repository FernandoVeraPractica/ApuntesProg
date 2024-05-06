/*
Pedir un entero n por consola y a continuacion pedir n numeros double que iremos insertando en una tabla. Guardar la tabla en un archivo binario.
 */
package binarios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Binarios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n;
        double num;
        double[] tabla;
        double[] t = {1, 9.8, 8.3, 10.8};
        double[] t2 = {9.09, 19.23, 7.43};

        System.out.println("Introduce la cantidad de números que quieres añadir a la tabla.");
        n = sc.nextInt();
        tabla = new double[n];

        for (int i = 0; i < tabla.length; i++) {
            System.out.println("Introduce un número. Se guardará en la posición de la tabla correspondiente.");
            num = sc.nextDouble();
            tabla[i] = num;
        }

        try (FileOutputStream fileout = new FileOutputStream("tabla.bin"); ObjectOutputStream objectout = new ObjectOutputStream(fileout)) {

            objectout.writeObject(tabla);
            objectout.writeObject(t);
            objectout.writeObject(t2);
            System.out.println("Tablas guardada correctamente en el archivo tabla.bin");

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo especificado.");
        } catch (IOException ex) {
            ex.getMessage();
        }

        try (ObjectInputStream objectin = new ObjectInputStream(new FileInputStream("tabla.bin"))) {
            
            while(true){
                double[] tablaleida = (double[]) objectin.readObject();
                System.out.println(Arrays.toString(tablaleida));
            }
            

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Binarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            System.out.println("Se ha llegado al final del documento");
        } catch (IOException ex) {
            Logger.getLogger(Binarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
