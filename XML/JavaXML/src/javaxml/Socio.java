package javaxml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "socio")
@XmlType(propOrder = {"identificacion", "nomb", "dir", "fec"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Socio {
    
    @XmlAttribute(name = "id")
    private int identificacion;
    
    @XmlElement(name = "nombre")
    private String nomb;
    
    @XmlElement(name = "direccion")
    public String dir;
    
    @XmlElement(name = "alta")
    private String fec;

    public Socio(int identificacion, String nomb, String dir, String fec) {
        
        
        this.identificacion = identificacion;
        
        
        this.nomb = nomb;
        
        
        this.dir = dir;
        
        
        this.fec = fec;
    }

    public Socio(){
        
    }
    
    @Override
    public String toString() {
        return "id: "+this.identificacion+
                "\n"+"Nombre: "+this.nomb+
                "\n"+"Dirección: "+this.dir+
                "\n"+"Fecha: "+ this.fec;
    }
    
    
}
