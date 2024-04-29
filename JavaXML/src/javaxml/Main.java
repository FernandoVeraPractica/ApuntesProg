
package javaxml;

import java.io.*;
import java.util.logging.*;
import javax.xml.bind.*;


public class Main {


    public static void main(String[] args) {
        try{
            JAXBContext contexto = JAXBContext.newInstance(Socio.class);
            Unmarshaller um = contexto.createUnmarshaller();
            
            Socio s = (Socio) um.unmarshal(new FileReader("socio1.xml"));
            System.out.println(s);
            
            Marshaller m = contexto.createMarshaller();
            Socio s1 = new Socio(1, "Karim Benzema", "Calle Alta", "12-12-2024");
            
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(s1, new FileWriter("socio1.xml"));
            
            
            
        }catch(JAXBException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
