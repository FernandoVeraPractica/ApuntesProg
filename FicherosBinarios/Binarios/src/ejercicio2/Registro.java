
package ejercicio2;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Registro implements Serializable{
    private double temperatura;
    private LocalDateTime fechaCreacion;
    
    public Registro(double temp){
        this.temperatura = temp;
        this.fechaCreacion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Temperatura: "+this.temperatura+
                " | Fecha creación: "+this.fechaCreacion + "\n";
    }
    
    
    
}
