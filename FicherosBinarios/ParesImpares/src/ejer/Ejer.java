/*
Implementar un programa que solicite al usuario 10 numeros enteros y los vaya guardando en el fichero "datos.dat".
Después debe guardar los números pares en el fichero "pares.dat" y los impares en "impares.dat"
 */
package ejer;

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


public class Ejer {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numEntero;
        int m   ;
        
        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("datos.dat"))){
            
            for(int i=0; i<10; i++){
                System.out.println("Introduce un número entero.");
                numEntero = sc.nextInt();
                objOut.writeInt(numEntero);
            }
              
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el documento");
        } catch (IOException ex) {
            System.out.println("Error de lectura / escritura");;
        }
        
        try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("datos.dat"));
                ObjectOutputStream objOutPares = new ObjectOutputStream(new FileOutputStream("pares.dat"));
                ObjectOutputStream objOutImpares = new ObjectOutputStream(new FileOutputStream("impares.dat"))){
            System.out.println("Leyendo el archivos datos.dat.");
            
            while (true){
                m = objIn.readInt();
                
                if(m % 2 == 0){
                    objOutPares.writeInt(m);
                }else{
                    objOutImpares.writeInt(m);
                }
                
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch(EOFException ex){
            System.out.println("Se ha llegado al final del documento.");
        } 
        catch (IOException ex) {
            System.out.println("Error de lectura / escritura");
        }
 
        
        try(ObjectInputStream objInPares = new ObjectInputStream(new FileInputStream("pares.dat"));
                ){
            System.out.println("Números pares: ");
            while(true){ 
                System.out.println(objInPares.readInt());
            }
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (EOFException ex){
            System.out.println("Se ha llegado al final del documento.");
        } 
        catch (IOException ex) {
            System.out.println("Error de lectura / escritura");
        }
        
        
        try(ObjectInputStream objInImpares = new ObjectInputStream(new FileInputStream("impares.dat"))){
            System.out.println("Números impares: ");
            while (true){ 
                System.out.println(objInImpares.readInt());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (EOFException ex){
            System.out.println("Se ha llegado al final del documento.");
        } 
        catch (IOException ex) {
            System.out.println("Error de lectura / escritura");
        }
        
        
    }
    
}
