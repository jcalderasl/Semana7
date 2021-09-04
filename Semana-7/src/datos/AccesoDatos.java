
package datos;

import dominio.ClsEmpleado;
import dominio.mdEmpleado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;


public interface AccesoDatos  {
  
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<ClsEmpleado> listar(String nombreArchivo) throws LecturaDatosEx;
    void escribir(ClsEmpleado pelicula, String nombreArchivo,boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo,String buscar) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
   
}

