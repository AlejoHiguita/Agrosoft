
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
public class SQLHelpersArticulo {
public static String getArticulo(){
return "SELECT codigo, nombre, "
        + " descripcion, observacion, precio, codigo_mascota "
        + " from tblArticulo "
        + " order by codigo  ";
}   
public static String getArticulo(String Codigo){
return "SELECT codigo, nombre, "
        + " descripcion, observacion, precio, codigo_mascota "
        + " from tblArticulo where codigo='"+Codigo+"' ";
       
/*Utilizamos '"+user+"' para enviar un
 Parámetro de tipo String
 * en caso de ser un valor numérico es recomendable
 * usar "+vlornumerico +"
 */

}// fin buscar producto

    public static String getInsertarArticulo() {
    return"INSERT INTO tblArticulo(codigo, nombre,descripcion, observacion,precio,codigo_mascota) values "
        + "(?,?,?,?,?,?)";
    }//fin getInsertarArticulo

     public static String getActualizarArticulo(){
     return"UPDATE tblArticulo set nombre=?,descripcion=?, observacion=?,precio=?, codigo_mascota=? "
        + "   where codigo=?";

}//fin getActualizarUsuario

public static String getEliminarArticulo(String codigo ){
return "DELETE from tblArticulo "
        + " where codigo='"+ codigo +"'";
}
public static String getConsecutivoArticulo(){
       return "SELECT Lpad( max( cast( codigo AS varchar(6) ) ) +1, 10, '0' )FROM tblArticulo "; 
	}
}// fin de de la clase

