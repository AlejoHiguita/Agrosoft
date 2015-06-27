/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agrosoft.persistencia;

/**
 *
 * @author USUARIO
 */
public class SQLHelpersClientes {
public static String getClientes(){
    
    
    return " SELECT  N_documento,Primer_nombre, "
            + " Segundo_nombre, Apellidos, Tel_fijo, Tel_cel, Direccion, Municipio, Correo_elec "
            + " from tblclientes "
            +" order by N_documento ";   
}
    
    
public static String getClientes(String N_documento){
return " SELECT N_documento, Primer_nombre, "
        +" Segundo_nombre, Apellidos, Tel_fijo, Tel_cel, Direccion, Municipio, Correo_elec "
        + " from tblclientes where N_documento='"+N_documento+ "' ";

      
/*Utilizamos '"+user+"' para enviar un
 Parámetro de tipo String
 * en caso de ser un valor numérico es recomendable
 * usar "+vlornumerico +"
 */
        
        

}
    /**
     *
     * @return
     */
    public static String getinsertarClientes () {
        
   return"INSERT INTO tblclientes(N_documento, Primer_nombre, Segundo_nombre, Apellidos,Tel_fijo, Tel_cel, Direccion, Municipio, Correo_elec ) values "
       +"( ?,?,?,?,?,?,?,?,? )";
        }
   
    
    public static String getActualizarClientes(){
    
    return "UPDATE tblclientes set Primer_nombre=?,Segundo_nombre=?,Apellidos=?,Tel_fijo=?,Tel_cel=?,Direccion=?,Municipio=?,Correo_elec=? "
            + " where N_documento=?";
}
    
    public static String getEliminarClientes(String N_documento ){
return "DELETE from tblClientes "
        + " where N_documento='"+ N_documento +"'";
}
    
}

 