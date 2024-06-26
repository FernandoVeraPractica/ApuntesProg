/*
Por motivos puramente estadísticos, se desea llevar constancia del número de llamadas recibidas cada día en una oficina.
Para ello, al terminar cada jornada laboral, se guarda dicho número al final de un archivo binario.
Implementa una aplicación con un menú que nos permita añadir el número correspondiente cada día y ver la lista completa en cualquier momento.
 */

package ejercicio3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static void añadirNumeroLlamadas(int n) {
        
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("registroLlamadas.dat"))){
<<<<<<< HEAD
            objOut.writeInt((Integer.valueOf(n)));
=======
            objOut.writeInt(n);
>>>>>>> fb2f4d8ee80676a5faa7a8ac6a99d8261da089f2
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de escritura.");
        }
    }
    
    
<<<<<<< HEAD
    static void consultarNumeroLlamadas(ObjectInputStream objIn) {
=======
    static void consultarNumeroLlamadas() {
>>>>>>> fb2f4d8ee80676a5faa7a8ac6a99d8261da089f2
         
         try{
             objIn = new ObjectInputStream(new FileInputStream("registroLlamadas.dat"));
             while (true){
                 int numLlamadaLeido = objIn.readInt();
                 System.out.println("Número de llamadas: "+numLlamadaLeido);
             }   
        } catch (FileNotFoundException ex) {
             System.out.println("Archivo no encontrado.");
        } catch (EOFException ex){
             System.out.println("Se ha alzancado el final del documento.");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             if (objIn != null){
                 try{
                     objIn.close();
                 }catch(IOException ex){
                     System.out.println("Error al cerrar el lector.");
                 }
             }
         }
     }
 

    static int menu() {
        Scanner sc = new Scanner(System.in);
        ObjectInputStream objIn = null;
        int opcion;
        int salir = 0;
        int numeroLlamadas;

        System.out.println("Elija una opción: ");

        System.out.println("1. Añadir número de llamadas.");
        System.out.println("2. Consultar número de llamadas.");
        System.out.println("3. Salir del menú.");

        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Introduzca el número de llamadas de esta jornada: ");
                numeroLlamadas = sc.nextInt();
                añadirNumeroLlamadas(numeroLlamadas);
                break;

            case 2:
<<<<<<< HEAD
                consultarNumeroLlamadas(objIn);
=======
                consultarNumeroLlamadas();
>>>>>>> fb2f4d8ee80676a5faa7a8ac6a99d8261da089f2
                break;
                
            case 3:
                salir = 1;
                break;
        }
        
        return salir;
    }

    public static void main(String[] args) {
        int salir = 0;
        
        
        while (salir==0){
            salir = menu();
        }
        
    }
}