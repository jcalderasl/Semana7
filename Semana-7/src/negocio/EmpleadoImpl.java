
package negocio;
/**
 *
 * @author PC
 */
import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import dominio.ClsEmpleado;
import dominio.mdEmpleado;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;


public class EmpleadoImpl implements InteEmpleado {
     private final AccesoDatos datos;
    
     mdEmpleado ele;
    Scanner t = new Scanner(System.in);
    Scanner t2 = new Scanner(System.in);
    public List<mdEmpleado> Todos = new ArrayList<mdEmpleado>();//declaramos una lista de tipo Md que se llama todos
  
    public EmpleadoImpl(){
        this.datos = new AccesoDatosImpl(); 
    }
    @Override
    public void agregarEmpleado(String nombreEmpleado,Double Enero1,Double Febrero1,Double Marzo1, String nombreArchivo) {
       ClsEmpleado pelicula = new ClsEmpleado(nombreEmpleado, Enero1,Febrero1,Marzo1);
        boolean anexar = false;
        try { 
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula,nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    
  
    
}
    @Override
    public void  listarEmpleado(  String nombreArchivo) {
        
         try {
            List<ClsEmpleado> peliculas = datos.listar(nombreArchivo);
            
        
            for(ClsEmpleado pelicula : peliculas){
                System.out.println("Pelicula: "+pelicula);
                
                Spliterator<ClsEmpleado>lectura= peliculas.spliterator().trySplit();
               
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
        
    }
    
    @Override
    public void buscarEmpleado(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
           
            resultado = datos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar la peli");
            ex.printStackTrace();
        }
         System.out.println("Resultado Busqueda:"+resultado);
    
    }
  
           
   

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }

    }
    
    
}
