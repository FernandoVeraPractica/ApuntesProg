/*
Crear un fichero desde el FIleWriter con dos cadenas iguales. 

La primera la añade carácter a carácter y la segunda en una cadena.

 */
package writers;

import java.io.*;


public class Ejercicio1 {

    public static void main(String[] args) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
            
            fw = new FileWriter("Hola.txt");
            bw = new BufferedWriter(fw);
            fr = new FileReader("Hola.txt");
            br = new BufferedReader(fr);
            
            String cad = "Hola que tal como estas.";
            
            for (int i= 0; i<cad.length(); i++){
                bw.write(cad.charAt(i));
            }
            
            bw.newLine();
            
            bw.write("Hola que tal como estas.");
            
            bw.flush();
            
            String texto = br.readLine();
            
            while (texto != null){
                System.out.println(texto);
                texto = br.readLine();
            }
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(bw != null){
                
                try{
                    bw.close();

                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            
            if(br != null){
                try{
                    br.close();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        
        
    }
    
}
