/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agrosoft.entidades;

/**
 *
 * @author USUARIO
 */
public class Clientes {
    
 String N_documento;
 String Primer_nombre;
 String Segundo_nombre;
 String Apellidos;
 String Tel_fijo;
 String Tel_cel;
 String Direccion;
 String Municipio;
 String Correo_elec;
 
 
public Clientes() {}

public Clientes (String N_documento,String Primer_nombre, String Segundo_nombre, String Apellidos,String Tel_fijo, String Tel_cel, String Direccion, String Municipio, String Correo_elec ) {
  
    
  this.N_documento = N_documento;
  this.Primer_nombre = Primer_nombre;
  this.Segundo_nombre = Segundo_nombre;
  this.Apellidos = Apellidos;
  this.Tel_fijo = Tel_fijo;
  this.Tel_cel = Tel_cel;
  this.Direccion = Direccion;
  this.Municipio = Municipio;
  this.Correo_elec = Correo_elec;
  
  
  
    }


    public String getN_documento() {
    return N_documento;
    }

    public void setN_documento(String N_documento) {
        this.N_documento = N_documento;
    }

    public String getPrimer_nombre() {
    return Primer_nombre;
    }

    public void setPrimer_Nombre(String Primer_nombre) {
    this.Primer_nombre = Primer_nombre;
    }

    public String getSegundo_nombre() {
    return Segundo_nombre;
    }

    public void setSegundo_nombre(String Segundo_nombre) {
    this.Segundo_nombre = Segundo_nombre;
    }

    public String getApellidos() {
    return Apellidos;
    }

    public void setApellidos(String Apellidos) {
    this.Apellidos = Apellidos;
    }

     public String getTel_fijo() {
    return Tel_fijo ;
    }

    public void setTel_fijo(String Tel_fijo) {
        this.Tel_fijo = Tel_fijo;
    }
    
      public String getTel_cel() {
    return Tel_cel ;
    }

    public void setTel_cel(String Tel_cel) {
        this.Tel_cel = Tel_cel;
    }
    
    public String getDireccion() {
    return Direccion ;
    }

    public void setDireccion(String Direccion) {
        this.Direccion =Direccion;
    }
    
    public String getMunicipio() {
    return Municipio ;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio =Municipio;
    }
    
    public String getCorreo_elec() {
    return Correo_elec ;
    }

    public void setCorreo_elec(String Correo_elec) {
        this.Correo_elec =Correo_elec;
    }

}//
    

