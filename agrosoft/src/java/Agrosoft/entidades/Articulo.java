
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
/**
 * Se definieron variables
 * de tipo String.
 */
	    
           
public Articulo () {}
/**
 * Metodo vacio
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
 * Este metodo recive las variables ya definidas
 * dentro de la clase y les da un valor a estas.
 */
 

    public String getCodigo() {
        return codigo;
    }
 /**
 * Este metodo retorna 
 * la variable codigo.
 */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
 /**
 * Este metodo le da valor a
 * la variable codigo.
 */

    public String getNombre() {
        return nombre;
    }
 /**
 * Este metodo retorna 
 * la variable nombre.
 */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 /**
 * Este metodo le da valor a
 * la variable nombre.
 */
    public String getDescripcion() {
        return descripcion;
    }
    /**
 * Este metodo retorna
 * la variable descripcion.
 */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
 * Este metodo le da valor a
 * la variable descripcion.
 */
    public String getObservacion() {
        return observacion;
    }
    /**
 * Este metodo retorna
 * la variable observacion.
 */

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    /**
 * Este metodo le da valor a
 * la variable observacion.
 */
   public String getPrecio() {
        return Precio;
    }
   /**
 * Este metodo retorna
 * la variable precio.
 */

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }
    /**
 * Este metodo le da valor a
 * la variable precio.
 */

    public String getCodigo_mascota() {
        return codigo_mascota;
    }
    /**
 * Este metodo retorna
 * la variable codigo_mascota.
 */

    public void setCodigo_mascota(String codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }
    /**
 * Este metodo le da valor a
 * la variable codigo_mascota.
 */
  
    
}//fin de la clase
