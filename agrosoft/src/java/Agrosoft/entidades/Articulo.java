/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agrosoft.entidades;



public class Articulo {
String codigo;
String nombre;
String descripcion;
String observacion;
String Precio;
String codigo_mascota;

	    
           
public Articulo () {}

    public Articulo(String codigo, String nombre, String Precio, String descripcion, String observacion, String codigo_mascota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.Precio = Precio;
        this.codigo_mascota = codigo_mascota;
    }

 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
   public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(String codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }
  
    
}//fin de la clase
