
package Agrosoft.entidades;

/**
 * Esta clase nos va permitir
 * crear metodos los cuales 
 * van a definir y les dara valor a
 * variables que van a ser llamadas en otros 
 * archivos que las procesen.
 * 
 * @version 2.2 01/07/2015
 * @author Alejandro H
 */

public class Articulo {
String codigo;
String nombre;
String descripcion;
String observacion;
String Precio;
String codigo_mascota;

 /* Se definieron variables
  de tipo String*/
	    
/* Metodo vacio*/
public Articulo () {}

/**
 * Este metodo resive parametros
 * @param codigo
 * @param nombre
 * @param Precio
 * @param descripcion
 * @param observacion
 * @param codigo_mascota 
 */
    public Articulo(String codigo, String nombre, String Precio, String descripcion, String observacion, String codigo_mascota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.Precio = Precio;
        this.codigo_mascota = codigo_mascota;
    }
 
/**
 * Este metodo retorna la variable Codigo
 * @return Codigo
 */
    public String getCodigo() {
        return codigo;
    }
 /**
  * Este metodo resive el parametro Codigo
  * @param codigo 
  */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
  
 /**
  * Este metodo retorna la variable nombre
  * @return nombre
  */
    public String getNombre() {
        return nombre;
    }
 
/**
 * Este metodo resive un parametro nombre
 * @param nombre 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * Este metodo retorna la variable descripcion
 * @return descripcion
 */
    public String getDescripcion() {
        return descripcion;
    }

/**
 * Este metodo resive el parametro  descripcion
 * @param descripcion 
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Este metodo retorna la variable descripcion
     * @return descripcion
     */
    public String getObservacion() {
        return observacion;
    }
  
/**
 * Este metodo resive un parametro obsevacion
 * @param observacion 
 */
  public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
   
  /**
   * Este metodo retorna precio
   * @return precio
   */
   public String getPrecio() {
        return Precio;
    }
   
   
/**
 * Este metodo resive el parametro precio
 * @param Precio 
 */
    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
  
/**
 * Este metodo retorna codigo_mascota
 * @return codigo_mascota
 */
    public String getCodigo_mascota() {
        return codigo_mascota;
    }
   
/**
 * Este metodo resive un parametro codigo_mascota
 * @param codigo_mascota 
 */
    public void setCodigo_mascota(String codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }  
    
}//fin de la clase
