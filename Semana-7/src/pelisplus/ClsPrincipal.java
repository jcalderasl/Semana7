
package pelisplus;
/**
 *
 * @author PC
 */

import java.util.Scanner;
import negocio.EmpleadoImpl;
import negocio.ClsComisiones;
import negocio.InteEmpleado;


public class ClsPrincipal {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\PC\\Videos\\archivoTest.txt";
    private static final InteEmpleado catalogoPeli =   new EmpleadoImpl();

      public static String nombre;
       public static double Enero;
       public static double Febrero;
       public static double Marzo;
    
    
    /**
     * @param args the command line arguments11
     */
    public static void main(String[] args) {
  
     while (opcion != 0) {//
            try {
                System.out.println("Elige opcion:\n1.- Borrar Archivo"
                        + "\n2.- Ingresar al menu de empleados\n"
                        
                        + "0.- Salir");
                

                opcion = Integer.parseInt(scanner.nextLine());

               
                switch (opcion) {
                    case 1:
                        catalogoPeli.iniciarArchivo(nombreArchivo);
                        break;
                    case 2: 
                     
                        ClsComisiones comi =  new ClsComisiones();              
                              comi.menu();
                        catalogoPeli.listarEmpleado( nombreArchivo);
                        
                        break;
                                
                    
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
          }
       
        }

   
    
}
