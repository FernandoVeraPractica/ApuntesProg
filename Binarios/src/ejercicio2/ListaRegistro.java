
package ejercicio2;

import ejercicio2.Registro;
import java.io.Serializable;
import java.util.Arrays;

public class ListaRegistro implements Serializable{
    static private Registro[] listaRegistros = new Registro[0];
    
    public ListaRegistro(){
        
    }
    
    static public void añadirRegistro(Registro reg){
        listaRegistros = Arrays.copyOf(listaRegistros, listaRegistros.length+1);
        listaRegistros[listaRegistros.length-1] = reg;
    }

    public static void setListaRegistros(Registro[] listaRegistros) {
        ListaRegistro.listaRegistros = listaRegistros;
    }
    
    static public void listar(){
        System.out.println(Arrays.deepToString(listaRegistros));
    }

    public static Registro[] getListaRegistros() {
        return listaRegistros;
    }
    
    
}
