/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaficherostextoagenda;

/**
 *
 * @author marta
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="agenda")
@XmlType(propOrder={"listaContactos", "numContactos"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda {
    
    @XmlElementWrapper(name="contactos")
    @XmlElement(name="contacto")
    private Contacto[] listaContactos;
    
    @XmlElement(name="numeroContactos")
    private int numContactos;   // Número de contactos introducidos

    Agenda(){
        
    }
    
    Agenda(int tam) {
        listaContactos = new Contacto[tam]; // Agenda vacía
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
        Arrays.sort(listaContactos, 0, numContactos);   // Ordena por orden natural desde el elemento 0 
        // hasta el elemento numContactos sin incluirlo
        for (int i = 0; i < numContactos; i++) {
            System.out.println(listaContactos[i].toString());
        }
    }

    public void desdeFichero() {    // Lectura del fichero con la agenda guardada en la anterior ejecución
        try {
            JAXBContext contexto = JAXBContext.newInstance(Agenda.class);
            Unmarshaller um = contexto.createUnmarshaller();
            
            Agenda agendaAux = (Agenda) um.unmarshal(new FileReader("Agenda.xml"));
            
            int i=0;
                while(!agendaLlena() && i<agendaAux.listaContactos.length){
                    this.listaContactos[i] = agendaAux.listaContactos[i];
                    this.numContactos++;
                    i++;
                }
            
            
            if (agendaLlena()) {   // Esto pasa si hay más de 20 líneas en el ficher
                System.out.println("Se ignoran algunos contactos del fichero");
                System.out.println("agenda.txt demasiado grande");
            }

        }catch (JAXBException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void aFichero() {
        try {
            JAXBContext contexto = JAXBContext.newInstance(Agenda.class);
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(this, new FileWriter("Agenda.xml"));
            
        } catch (EOFException eof) {
            System.out.println("Error de fichero.");
        } catch (IOException fnf) {
            System.out.println("Fichero no encontrado.");
        } catch (JAXBException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
