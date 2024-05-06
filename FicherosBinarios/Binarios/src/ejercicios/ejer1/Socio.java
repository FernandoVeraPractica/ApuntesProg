
package ejercicios.ejer1;

import java.io.Serializable;


public class Socio implements Serializable{
    String DNI;
    String nombre;

    public Socio(String dni, String nombre) {
        this.DNI = dni;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Socio{" + "DNI=" + DNI + ", nombre=" + nombre + '}';
    }
    
    
    
}
