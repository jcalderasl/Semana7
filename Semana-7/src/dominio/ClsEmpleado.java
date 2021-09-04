

package dominio;
/**
 *
 * @author PC
 */

public class ClsEmpleado {
    private String nombre;
    private Double datoEne;
    private Double datoFeb;
    private Double datoMar;
 
    public ClsEmpleado( String nombre_emple, Double Enero, Double Febrero, Double Marzo){
        this.nombre=nombre_emple;
        this.datoEne=Enero;
        this.datoFeb=Febrero;
        this.datoMar=Marzo;
       
    }

    public ClsEmpleado(String linea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public String toString(){
        return this.getNombre()+ this.getDatoEne()+this.getDatoFeb()+this.getDatoMar();
        
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the datoEne
     */
    public Double getDatoEne() {
        return datoEne;
    }

    /**
     * @param datoEne the datoEne to set
     */
    public void setDatoEne(Double datoEne) {
        this.datoEne = datoEne;
    }

    /**
     * @return the datoFeb
     */
    public Double getDatoFeb() {
        return datoFeb;
    }

    /**
     * @param datoFeb the datoFeb to set
     */
    public void setDatoFeb(Double datoFeb) {
        this.datoFeb = datoFeb;
    }

    /**
     * @return the datoMar
     */
    public Double getDatoMar() {
        return datoMar;
    }

    /**
     * @param datoMar the datoMar to set
     */
    public void setDatoMar(Double datoMar) {
        this.datoMar = datoMar;
    }

   
}
