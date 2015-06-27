
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
public class SQLHelpersHistorialMedico {
public static String getHistorialMedico(){
return "SELECT codigo_historial,codigo_mascota,fecha_creacion,genero,peso ,fecha_nacimiento,tipo_procedimiento,doctor, nombre,dosis, observacion "
        + " from tblhistorialmedico "
        + " order by codigo_historial  ";

}   
public static String getHistorialMedico(String codigo_historial){
return "SELECT codigo_historial,codigo_mascota,fecha_creacion,genero,peso ,fecha_nacimiento,tipo_procedimiento,doctor, nombre,dosis,observacion  "
        + " from tblhistorialmedico where codigo_historial='"+codigo_historial+"' ";
       
/*Utilizamos '"+user+"' para enviar un
 Parámetro de tipo String
 * en caso de ser un valor numérico es recomendable
 * usar "+vlornumerico +"
 */

}// fin buscar producto

public static String getHistorialMedicoPorMascota(String codigo_mascota){
return "SELECT codigo_historial,codigo_mascota,fecha_creacion,genero,peso ,fecha_nacimiento,tipo_procedimiento,doctor, nombre,dosis,observacion  "
        + " from tblhistorialmedico where codigo_mascota='"+codigo_mascota+"' ";
       
/*Utilizamos '"+user+"' para enviar un
 Parámetro de tipo String
 * en caso de ser un valor numérico es recomendable
 * usar "+vlornumerico +"
 */

}// fin buscar producto


    public static String getInsertarHistorialMedico() {
    return"INSERT INTO tblhistorialmedico(codigo_historial,codigo_mascota, fecha_creacion, genero, peso, fecha_nacimiento, tipo_procedimiento, doctor, nombre,dosis, observacion) values "
        + "(?,?,?,?,?,?,?,?,?,?,?)";
    }//fin getInsertarArticulo
    
    public static String getEliminarHistorialMedico(String codigo_historial ){
return "DELETE from tblhistorialmedico "
        + " where codigo_historial='"+ codigo_historial +"'";
}
         public static String getActualizarHistorialMedico(){
     return"UPDATE tblhistorialmedico set codigo_mascota=?, fecha_creacion=?, genero=?, peso=?, fecha_nacimiento=?, tipo_procedimiento=?, doctor=?, nombre=?,dosis=?, observacion=? "
        + "   where codigo_historial=?";

}//fin getActualizarUsuario
    public static String getConsecutivoHistorialMedico(){
       return "SELECT Lpad( max( cast( codigo_historial AS varchar(10) ) ) +1, 10, '0' )FROM tblhistorialmedico "; 
	}
}