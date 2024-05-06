/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaficherosxmlresuelta;

/**
 *
 * @author martarobina
 */
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "contacto")
@XmlType(propOrder = {"nombre", "tlf"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Contacto implements Comparable{
    //@XmlElement(name = "nombre")
    String nombre;
    @XmlElement(name = "telefono")
    String tlf;

    public Contacto() {
    }

    Contacto(String nombre, String tlf) { // constructor
        this.nombre = nombre;
        this.tlf = tlf;
    }

    /*public String formatoFichero() {
        return (nombre + ";" + tlf);
    }*/

    /*Dos contactos son iguales si sus nombres son iguales*/
    @Override
    public boolean equals(Object otro) {
        Contacto otroContacto = (Contacto) otro;
        return this.nombre.equals(otroContacto.nombre);
    }

    @Override
    public String toString() {
        String aux;
        aux = "Nombre: " + nombre + "\tTeléfono: " + tlf;
        return (aux);
    }

    @Override
    public int compareTo(Object otro) {
        return this.nombre.compareTo(((Contacto) otro).nombre);
    }
}
