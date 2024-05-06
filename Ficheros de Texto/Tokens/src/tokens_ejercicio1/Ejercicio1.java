/*
Pide por teclado el nombre, la estatura y la edad de un deportista.
Introduce los datos en una sola linea y léelos con un objeto Scanner.
Muestra el resultado por pantalla.
 */
package tokens_ejercicio1;

import java.util.Scanner;


public class Ejercicio1 {
    
    public static void main(String[] args) {
        String nombre;
        double estatura;
        int edad;
        Scanner sc = new Scanner (System.in);

        
        System.out.println("Introduce el nombre, la estatura y la edad de un deportista separado por espacios.");
        
        nombre = sc.next();
        estatura = sc.nextDouble();
        edad = sc.nextInt();
        
        System.out.println("Nombre: "+nombre);
        System.out.println("Estatura: "+ estatura);
        System.out.println("Edad: "+edad);
        
    }
        
    
    
}
