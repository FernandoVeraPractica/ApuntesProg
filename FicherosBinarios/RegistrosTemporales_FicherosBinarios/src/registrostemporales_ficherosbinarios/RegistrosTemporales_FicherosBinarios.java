/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrostemporales_ficherosbinarios;

/**
 *
 * @author martarobina
 */
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrosTemporales_FicherosBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObjectInputStream flujoEntrada = null;
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temperaturas.dat"))) {
            int opcion;

            do {
                System.out.println("1.Nuevo registro");
                System.out.println("2.Mostrar historial de registros");
                System.out.println("3.Salir");
                System.out.print("\nIntroducir opción: ");
                opcion = new Scanner(System.in).nextInt();
                switch (opcion) {
                    case 1:
                        System.out.print("Introducir temperatura: ");
                        double temperatura = new Scanner(System.in)
                                .useLocale(Locale.US).nextDouble();
                        Registro nuevo = new Registro(temperatura);

                        out.writeObject(nuevo);

                        break;
                    case 2:
                        try {
                            // Se debe crear el flujo de entrada aquí, en lugar de hacer apertura con recursos, 
                            // porque, si no, intentaría leer siempre a continuación de lo último leído, 
                            // y nosotros queremos que lea desde el principio del archivo cada vez que entre aquí
                            flujoEntrada = new ObjectInputStream(new FileInputStream("temperaturas.dat"));
                            while (true) {
                                Registro regLeido;

                                regLeido = (Registro) flujoEntrada.readObject();
                                System.out.println(regLeido.toString());

                            }
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(RegistrosTemporales_FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (EOFException e) {
                            System.out.println("No hay más registros");
                        }
                        break;
                }

            } while (opcion != 3);
        } catch (IOException ex) {
            //System.out.println("No hay registros");
            System.out.println(ex);
        } finally {

            try {
                if (flujoEntrada != null) {
                    flujoEntrada.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(RegistrosTemporales_FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
