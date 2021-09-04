
package datos;

import dominio.ClsEmpleado;
import dominio.mdEmpleado;
import excepciones.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class AccesoDatosImpl implements AccesoDatos{
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    @Override
    public List<ClsEmpleado> listar(String nombreArchivo) throws LecturaDatosEx {
          List<ClsEmpleado> peliculas = new ArrayList();
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                ClsEmpleado pelicula = new ClsEmpleado(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }   
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
        return peliculas;
    }
    
    
    @Override
    public void escribir(ClsEmpleado pelicula, String nombreArchivo,boolean anexar) throws EscrituraDatosEx{
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    
    @Override
    public String buscar(String nombreArchivo,String buscar){
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=0;
            linea = entrada.readLine();
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Pelicula: "+ linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }   entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

public void crear(String nombreArchivo){
    PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
          ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
}
   
@Override
public void borrar(String nombreArchivo) throws AccesoDatosEx{
    File archivo = new File(nombreArchivo);
    archivo.delete();
    System.out.println("Se ha borrado el archivo");
}
    }
