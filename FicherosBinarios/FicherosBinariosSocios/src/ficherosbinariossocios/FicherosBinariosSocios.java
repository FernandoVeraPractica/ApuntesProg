/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficherosbinariossocios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 *
 * @author martarobina
 */
public class FicherosBinariosSocios {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        Socio[] tablaSocios = new Socio[4];

        tablaSocios[0] = new Socio("1", "pepe");
        tablaSocios[1] = new Socio("11", "ana");
        tablaSocios[2] = new Socio("7", "pepa");
        tablaSocios[3] = new Socio("23", "cris");

        System.out.println("Tabla a serializar:");
        System.out.println(Arrays.deepToString(tablaSocios));

        try (ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("socios.dat"))) {
            salida.writeObject(tablaSocios);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream("socios.dat"))) {
            tablaSocios = (Socio[]) entrada.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        System.out.println("Tabla deserializada");
        System.out.println(Arrays.deepToString(tablaSocios));
    }

}
