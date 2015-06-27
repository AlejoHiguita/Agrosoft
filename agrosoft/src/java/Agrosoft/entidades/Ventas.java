/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agrosoft.entidades;

/**
 *
 * @author USUARIO
 */
public class Ventas {
    
 String N_factura;
 String Nombre_vendedor;
 String Porcentaje_IVA;
 String N_Documento;

 
 

public Ventas () {}

public Ventas (String N_factura, String Nombre_vendedor, String Porcentaje_IVA, String N_Documento ) {
  this.N_factura = N_factura;
  this.Nombre_vendedor = Nombre_vendedor;
  this.Porcentaje_IVA = Porcentaje_IVA;
  this.N_Documento = N_Documento;

  
 
 
  
    }

    public String getN_factura() {
    return N_factura;
    }

    public void setN_factura(String N_factura) {
    this.N_factura = N_factura;
    }


    public String getNombre_vendedor() {
    return Nombre_vendedor;
    }

    public void setNombre_vendedor(String Nombre_vendedor) {
    this.Nombre_vendedor = Nombre_vendedor;
    }

    public String getPorcentaje_IVA() {
    return Porcentaje_IVA;
    }

    public void setPorcentaje_IVA (String Porcentaje_IVA) {
        this.Porcentaje_IVA = Porcentaje_IVA;
    }

    public String getN_Documento() {
       return N_Documento;
    }
 
    public void setN_Documento  (String N_Documento) {
        this.N_Documento = N_Documento;
    }
    
   
     
 
          
}
    