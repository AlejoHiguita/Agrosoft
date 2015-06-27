
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
 * @author USER
 */
public class SQLHelpers {
public static String getUsuarios(){
return "SELECT usuario, nombre, "
        + "clave,perfil, estado "
        + " from tblusuario "
        + " order by usuario  ";
}   
public static String getUsuario(String user){
System.out.print(user +"dddddddddddddddd");
    return "SELECT usuario, nombre, "
        + "clave,perfil, estado"
        + " from tblusuario where usuario ='"+user+"' "
        + " order by usuario  ";
/*Utilizamos '"+user+"' para enviar un
 Parámetro de tipo String
 * en caso de ser un valor numérico es recomendable
 * usar "+vlornumerico +"
 */

}// fin buscar usuario

public static String getValidarIngreso(String user,
        String pwd
        ){
return "SELECT usuario, nombre, "
        + "clave,perfil, estado"
        + " from tblusuario "
        + " where usuario ='"+user+"'  and clave ='"+pwd + "'   "
        + " order by usuario  ";
}

    static String getUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public static String getInsertarUsuario() {
    return"INSERT INTO tblusuario(usuario, nombre,clave, perfil,estado) values "
        + "(?,?,?,?,?)";
    }//fin getInsertarUsuario
    
     public static String getActualizarUsuario(){
return"UPDATE tblusuario set nombre=?,clave=?, perfil=?,estado=?  "
        + " usuario=?";

}//fin getActualizarUsuario
//regresamos al daos

    static String getProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}// fin def de la clase
