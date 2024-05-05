/*
Implementar un programa que registra la evolución temporal de la temperatura en una ciudad.
La aplicación mostrará un menú que permite añadir nuevos registros de temperatura y mostrar el resultado de todos los registros históricos.
Cada registro constará de la temperatura en grados centígrados introducida por teclado y la fecha y hora, que se leerá en el sistema en el 
momento de la creación del registro.
 */
package ejercicio2;

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

public class Main {

    static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona una opción: \n 1.Crear nuevo registro de temperatura. \n 2. Ver todos los registros almacenados \n 3. Salir");
        int opcion;
        opcion = sc.nextInt();
        return opcion;
    }

    static void leerArchivo() {
        try (ObjectInputStream objin = new ObjectInputStream(new FileInputStream("registros.dat"))) {
            while (true) {
                Registro[] listaRegistrosLeida = (Registro[]) objin.readObject();
                ListaRegistro.setListaRegistros(listaRegistrosLeida);
                System.out.println(Arrays.deepToString(ListaRegistro.getListaRegistros()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontado");
        } catch (EOFException ex) {
            System.out.println("Se ha alcanzado el final del documento.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de lectura.");
        }
    }

    static void escribirArchivo() {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("registros.dat"))) {
            objOut.writeObject(ListaRegistro.getListaRegistros());
        } catch (IOException ex) {
            System.out.println("Error de escritura.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int opc = 0;

        opc = menu();

        while (opc != 3) {
            switch (opc) {
                case 1:
                    System.out.println("Introduzca la temperatura que quiere registrar.");
                    double temp;
                    temp = sc.nextDouble();
                    ListaRegistro.añadirRegistro(new Registro(temp));
                    escribirArchivo();
                    System.out.println("-------------------------");
                    break;

                case 2:
                    leerArchivo();
                    if (ListaRegistro.getListaRegistros().length == 0) {
                        System.out.println("No hay registros almacenados.");
                    }
                    System.out.println("-------------------------");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    System.out.println("-------------------------");
                    break;

            }
            opc = menu();

        }
    }
}
