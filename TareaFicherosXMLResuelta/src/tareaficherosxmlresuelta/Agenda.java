/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaficherosxmlresuelta;

/**
 *
 * @author martarobina
 */
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "agenda")
@XmlType(propOrder = {"numContactos", "listaContactos"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda {

    @XmlElement(name = "numero_contactos")
    int numContactos;
    @XmlElementWrapper(name = "contactos")
    @XmlElement(name = "contacto")
    Contacto[] listaContactos;

    public Agenda() {
    }

    Agenda(int tam) {
        listaContactos = new Contacto[tam];
        numContactos = 0;
    }

    public void nuevoContacto(String nombre, String tlf) {
        if (numContactos < listaContactos.length) {
            listaContactos[numContactos] = new Contacto(nombre, tlf);
            numContactos++;
        }
    }

    public boolean agendaLlena() {
        return (numContactos == listaContactos.length);
    }

    public void buscaNombre(String nombre) {
        Contacto claveBusqueda = new Contacto(nombre, "");
        for (int i = 0; i < numContactos; i++) {
            if (listaContactos[i].equals(claveBusqueda)) {
                System.out.println(listaContactos[i]);
            }
        }
    }

    public void muestraTodos() {
        Arrays.sort(listaContactos, 0, numContactos);

        for (int i = 0; i < numContactos; i++) {
            System.out.println(listaContactos[i].toString());
        }
    }

    public void desdeFichero(Unmarshaller um) {
        try {
                Agenda agendaAux = (Agenda) um.unmarshal(new FileReader("Agenda.xml"));
                
                int i=0;
                while(!agendaLlena() && i<agendaAux.listaContactos.length){
                    this.listaContactos[i] = agendaAux.listaContactos[i];
                    this.numContactos++;
                    i++;
                }
                
                if (agendaAux.listaContactos.length>20) {
                    System.out.println("Se ignoran algunos contactos del fichero");
                    System.out.println("Agenda.xml demasiado grande");
            }            
        } catch (FileNotFoundException ex){
            System.out.println("Agenda vacia.");
        } catch (JAXBException ex){
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void aFichero(Marshaller m) {
        try {
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(this, new FileWriter("Agenda.xml"));
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
