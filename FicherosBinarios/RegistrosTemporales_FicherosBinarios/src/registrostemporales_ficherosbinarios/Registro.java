/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrostemporales_ficherosbinarios;

/**
 *
 * @author martarobina
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

class Registro implements Serializable {

    double temperatura;
    LocalDateTime fechaYHora;

    Registro(double temperatura) {
        this.temperatura = temperatura;
        fechaYHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'hh:mm:ss.SSSS");
        return "Registro{" + "temperatura=" + temperatura
                + ", fechaYHora=" + fechaYHora.format(f) + "}\n";
    }
    
}
