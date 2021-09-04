
package negocio;
/**
 *
 * @author PC
 */
import dominio.mdEmpleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static pelisplus.ClsPrincipal.Enero;
import static pelisplus.ClsPrincipal.Febrero;
import static pelisplus.ClsPrincipal.Marzo;
import static pelisplus.ClsPrincipal.nombre;


public class ClsComisiones {
    private static final InteEmpleado catalogoPeli =   new EmpleadoImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String nombreArchivo = "C:\\Users\\PC\\Videos\\archivoTest.txt";
   //obtiene la entrada de datos
    Scanner t = new Scanner(System.in);
    public List<mdEmpleado> Todos = new ArrayList<mdEmpleado>();     //declaramos una lista de tipo Md que se llama todos           
    Scanner t2 = new Scanner(System.in);
    
    public mdEmpleado Ingreso_informacion(){
        mdEmpleado vende = new mdEmpleado();
         
        System.out.println("Ingrese Nombre");
        nombre = scanner.nextLine();
        vende.nombre = nombre;
        
        System.out.println("Ingrese Enero");
        Enero= scanner.nextInt();
        vende.enero = Enero;     
         
        System.out.println("Ingrese Febrero");
        Febrero= scanner.nextInt();
        vende.febrero = Febrero; 
        
        System.out.println("Ingrese Marzo");
        Marzo= scanner.nextInt();
        vende.marzo = Marzo;
        
        Todos.add(vende);
        catalogoPeli.agregarEmpleado(nombre,Enero,Febrero,Marzo, nombreArchivo);
         return vende;
    }
    
      public void desplegarDato(){
        for(mdEmpleado ele: Todos){
            System.out.println("Nombre = "+ele.nombre);
            System.out.println("Enero = "+ele.enero);
            System.out.println("Febrero = "+ele.febrero);
            System.out.println("Marzo = "+ele.marzo);
            
        }           
        
    }
     public void sumaEnero(){
        
        double Total = 0.00;
        double Promedio=0.00;
            for(mdEmpleado obje : Todos){ 
            Total += obje.enero;
            
            }
         
            System.out.println("La suma de Enero es = " + Total);
     }
    
     public void sumaFebrero(){
        double Total = 0.00;
        double Promedio=0.00;
            for(mdEmpleado obje : Todos){ 
            Total += obje.febrero;    
            }
           
            System.out.println("La suma de Febrero es = " + Total);
     }
      public void sumaMarzo(){
        double Total = 0.00;
        double Promedio=0.00;
            for(mdEmpleado obje : Todos){ 
            Total += obje.marzo;    
            }
           
            System.out.println("La suma de Marzo es = " + Total);
     }
    

       public void promedioEnero(){//metodo para sacar promedio de cada mes
        double Total1 = 0.00;
        double Promedio = 0.00;
            for(mdEmpleado obje : Todos){
            Total1 += obje.enero;
            Promedio += obje.enero/Todos.size();                               //coleccion generica, si se desea saber
            }                                                                    //cuantos elementos hay
            System.out.println("El promedio de Enero es: "+Promedio);
     }
     public void promedioFebrero(){
       
        double Total1 = 0.00;
        double Promedio = 0.00;
            for(mdEmpleado obje : Todos){
            Total1 += obje.febrero;
            Promedio += obje.febrero/Todos.size();    
            }
            System.out.println("El promedio de Marzo es: "+Promedio); 
     }
     public void promedioMarzo(){
       
         double Total1 = 0.00;
            double Promedio = 0.00;
            for(mdEmpleado obje : Todos){
            Total1 += obje.marzo;
            Promedio += obje.marzo/Todos.size();    
            }
            System.out.println("El promedio de marzo es: "+Promedio);
     }
     
    public void menu(){
        String opc = "";
        do{
            System.out.println("1- Ingreso de Informacion"
           
                              +"\n2- Ver Informacion"
                              +"\n3- Suma de cada mes"
                              +"\n4- Promedio de cada mes");
            opc = t.nextLine();//llamamos a la opcion
            switch(opc){
                case "1": Ingreso_informacion();
                break;
                case "2": desplegarDato();
                break;    
                case "3": sumaEnero();
                          sumaFebrero();
                          sumaMarzo();
                break;
                case "4": promedioEnero();
                          promedioFebrero();
                          promedioMarzo();
                break;}
        }while(!opc.equals("5"));//el equals se usa para comparar dos objetos
    }

   
}
