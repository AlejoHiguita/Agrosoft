/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agrosoft.persistencia;
/**
 Esta clase nos va permitir
 * crear métdos  estáticos
 * Los cuales contienen 
 * todas las sentencia sql
 * pertence a la capa de la
 * persistencia, estos métodos
 * generalmente nos van a retornar
 * un String
 * @author Yuliana Arango
 */

/**
 *
 * @author USUARIO
 */
public class SQLHelpersVentas {
public static String getVentas(){
    
    return "SELECT  N_factura , Nombre_vendedor , Porcentaje_IVA , N_Documento " 
            + "from tlbVenta"
            +"order by N_factura";    
   //Ventas Ven=new Ventas();
}
      
public static String getVentas(String N_factura) {
return "SELECT  N_factura , Nombre_vendedor , Porcentaje_IVA , N_Documento "
        + "from tblVenta where N_factura='"+N_factura+"' ";

      
/*Utilizamos '"+user+"' para enviar un
 Parámetro de tipo String
 * en caso de ser un valor numérico es recomendable
 * usar "+vlornumerico +"
 */
        
       
}
   
    public static String getinsertarVentas () {
        
   return"INSERT INTO tblVenta ( N_factura , Nombre_vendedor , Porcentaje_IVA , N_Documento ) values "
       +"(?,?,?,?)";
        }//insertar ventas
    
     public static String getActualizarVentas(){
     return"UPDATE tblVenta set  Nombre_vendedor=? , Porcentaje_IVA=? , N_Documento=? "
             + " where N_factura=? ";
}// actualizar ventas
    
    
    public static String getEliminarVentas (String N_factura ){
return "DELETE from tblVenta "
        + " where N_factura='"+ N_factura +"'";

}// eliminar ventas
    
}


