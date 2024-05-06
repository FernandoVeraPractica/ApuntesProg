/*
Guardar en una tabla tipo Socios los diferentes socios.
Guardar la tabla en el archivo socios.dat.
Recuperar la tabla.
 */
package ejercicios.ejer1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        Socio[] listaSocios = new Socio[3];
        
        Socio s1 = new Socio("11111111X", "Pepe Luis");
        Socio s2 = new Socio("22222222X", "Antonia");
        Socio s3 = new Socio("33333333X", "Luisa");
        
        listaSocios[0] = s1;
        listaSocios[1] = s2;
        listaSocios[2] = s3;
        
        try(ObjectOutputStream objectout = new ObjectOutputStream(new FileOutputStream("socios.dat"));
                ObjectInputStream objectin = new ObjectInputStream(new FileInputStream("socios.dat"))){
            
            objectout.writeObject(listaSocios);
            
            while (true){
                Socio[] listaLeida = (Socio[]) objectin.readObject();
                System.out.println(Arrays.deepToString(listaLeida));
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado.");
        } catch (EOFException ex) {
            System.out.println("Se ha llegado al final del documento.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
