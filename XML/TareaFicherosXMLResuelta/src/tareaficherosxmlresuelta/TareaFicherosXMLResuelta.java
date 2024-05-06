/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareaficherosxmlresuelta;

/**
 *
 * @author martarobina
 */
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class TareaFicherosXMLResuelta {

    /**
     * @param args the command line arguments
     */
    final static int NUM_MAX_CONTACTOS = 20;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Agenda miAgenda;
        int opc;
        String nombre, tlf;

        try {
            JAXBContext contexto = JAXBContext.newInstance(Agenda.class);
            
            Unmarshaller um = contexto.createUnmarshaller();
            Marshaller m = contexto.createMarshaller();
            
            miAgenda = new Agenda(NUM_MAX_CONTACTOS);
            
            miAgenda.desdeFichero(um);
            
            do {
                opc = menu();
                switch (opc) {
                    case 1:
                        if (miAgenda.agendaLlena() == true) { 
                            System.out.println("La agenda está llena");
                        } else {                   
                            System.out.print("Nombre?: ");
                            nombre = sc.nextLine();
                            System.out.print("Teléfono?: ");
                            tlf = sc.nextLine(); 
                            miAgenda.nuevoContacto(nombre, tlf);
                        }
                        break;

                    case 2:
                        System.out.print("Nombre a buscar?: ");
                        nombre = sc.nextLine();
                        miAgenda.buscaNombre(nombre);
                        break;
                    case 3:
                        miAgenda.muestraTodos(); 
                        break;
                }
            } while (opc != 4);
            
            // Antes de salir volcamos la agenda en el fichero xml
            miAgenda.aFichero(m);            
        } catch (JAXBException ex) {
            System.out.println(ex);
        }
    } 

    static int menu() {
        Scanner sc = new Scanner(System.in);
        int opc;
        System.out.println("1. Nuevo contacto");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Mostrar todos");
        System.out.println("4. Salir");
        do {
            System.out.print("opción?: ");
            opc = sc.nextInt();
        } while (opc <= 0 || opc >= 5);

        return (opc);
    }
    
}
