package Agrosoft.persistencia;


import Agrosoft.entidades.HistorialMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaosHistorialMedico{

public DaosHistorialMedico (){
}//fin constructor Daos
// Método para listar datos

public List<HistorialMedico>ListaHistorialMedico(Connection con)
{
List<HistorialMedico> resultado= new ArrayList<HistorialMedico>();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersHistorialMedico.getHistorialMedico() );
ResultSet r =p.executeQuery();
while(r.next()){
HistorialMedico a = new HistorialMedico();
a.setcodigo_historial(r.getString(1));
a.setcodigo_mascota(r.getString(2));
a.setfecha_creacion(r.getString(3));
a.setgenero(r.getString(4));
a.setpeso(r.getString(5));
a.setfecha_nacimiento(r.getString(6));
a.settipo_procedimiento(r.getString(7));
a.setdoctor(r.getString(8));
a.setnombre(r.getString(9));
a.setdosis(r.getString(10));
a.setobservacion(r.getString(11));
resultado.add(a);
}// fin mientras

}//inicia un bloque de control de excepciones
catch (Exception e)
{
 System.out.print("error  "+  e.getMessage());

}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexión
con.close();//cerrar la conexión
}//fin try
catch(Exception cl)
{} 
}//fin finally
return  resultado;
}//fin lista 
// Copiamos el método anterior
// y lo modificamos
/* Método para un consultar un registro
 determinado */

/*Copiamos el siguiente método y renombramos*/

public List<HistorialMedico>ListaHistorialMedicoPorMascota(Connection con, String codigo_mascota)
{
List<HistorialMedico> resultado= new ArrayList<HistorialMedico>();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersHistorialMedico.getHistorialMedicoPorMascota(codigo_mascota));
ResultSet r =p.executeQuery();
while(r.next()){
HistorialMedico a = new HistorialMedico();
a.setcodigo_historial(r.getString(1));
a.setcodigo_mascota(r.getString(2));
a.setfecha_creacion(r.getString(3));
a.setgenero(r.getString(4));
a.setpeso(r.getString(5));
a.setfecha_nacimiento(r.getString(6));
a.settipo_procedimiento(r.getString(7));
a.setdoctor(r.getString(8));
a.setnombre(r.getString(9));
a.setdosis(r.getString(10));
a.setobservacion(r.getString(11));
resultado.add(a);
}// fin mientras

}//inicia un bloque de control de excepciones
catch (Exception e)
{
 System.out.print("error  "+  e.getMessage());

}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexión
con.close();//cerrar la conexión
}//fin try
catch(Exception cl)
{} 
}//fin finally
return  resultado;
}//fin lista 


public HistorialMedico getHistorialMedico(Connection con,String idcodigo_historial)
{
HistorialMedico a= new HistorialMedico();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersHistorialMedico.getHistorialMedico(idcodigo_historial) );
ResultSet r =p.executeQuery();
while(r.next()){
a.setcodigo_historial(r.getString(1));
a.setcodigo_mascota(r.getString(2));
a.setfecha_creacion(r.getString(3));
a.setgenero(r.getString(4));
a.setpeso(r.getString(5));
a.setfecha_nacimiento(r.getString(6));
a.settipo_procedimiento(r.getString(7));
a.setdoctor(r.getString(8));
a.setnombre(r.getString(9));
a.setdosis(r.getString(10));
a.setobservacion(r.getString(11));

}// fin mientras
}//inicia un bloque de control de excepciones
catch (Exception e)
{}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexión
con.close();//cerrar la conexión
}//fin try
catch(Exception cl)
{} 
}//fin finally
return a;
}//fin buscar



public String guardarHistorialMedico(
Connection con,
String codigo_historial,
String codigo_mascota,
String fecha_creacion,
String genero,
String peso ,
String fecha_nacimiento,
String tipo_procedimiento,
String doctor,
String nombre,
String dosis,
String observacion){
String respuesta="";
try {
PreparedStatement p=con.prepareStatement(SQLHelpersHistorialMedico.getInsertarHistorialMedico());
p.setString(1,codigo_historial);
p.setString(2,codigo_mascota);
p.setString(3,fecha_creacion);
p.setString(4,genero);
p.setString(5,peso);
p.setString(6,fecha_nacimiento);
p.setString(7,tipo_procedimiento);
p.setString(8,doctor);
p.setString(9,nombre);
p.setString(10,dosis);
p.setString(11,observacion);
p.execute();
respuesta = "Historial Médico agregado";
if(p.getUpdateCount()>0){
respuesta="Historial Médico:"+codigo_historial+"Agregado";
} else{
respuesta+="Error Historial Médico:"+codigo_historial+"No Agregado";
}       
}catch (Exception e){
respuesta=""+ e.getMessage()+"causa"+e.getCause();
}finally{try{con.close();}catch (Exception e2){}}
return respuesta;
}
public String eliminarHistorialMedico(  Connection con, String codigo_historial){
String respuesta="";
try{
    //"UPDATE tblArticulo set nombre=?,precio_compra=?,precio_venta=?,cantidad=?,max_stock=?,min_stock=?  "
    //     where codigo=?;
//PreparedStatement es una clase para preparar un espacio donde se realizará una acción
PreparedStatement p = con.prepareStatement(SQLHelpersHistorialMedico.getEliminarHistorialMedico(codigo_historial));
p.execute();

if(p.getUpdateCount()>0){
    respuesta="Historial Médico:"+ codigo_historial +"Eliminado con éxito!";
}else{
    respuesta="Error Historial Médico :"+ codigo_historial +"No eliminado";
}//fin else/if
}catch(Exception e){
    respuesta+=" " + e.getMessage() + "Causa" + e.getCause();
}finally{try{con.close();}catch(Exception e2){} }//fin finally (finally es para cerrar conexión a la BD)
    
return respuesta;
}//fin eliminarProducto
public String getConsecutivo(Connection con)
{
String a=  "0000000001";
try{
PreparedStatement p=con.prepareStatement(SQLHelpersHistorialMedico.getConsecutivoHistorialMedico() );
ResultSet r =p.executeQuery();
while(r.next()){
a=r.getString(1);
}// fin mientras
}//inicia un bloque de control de excepciones
catch (Exception e)
{}
finally{//finalizar el control de un bloque try
try{//controlar al cerrar la conexión
con.close();//cerrar la conexión
}//fin try
catch(Exception cl)
{} 
}//fin finally
return a;
}//fin buscar


public String actualizarHIstorialMedico(
        Connection con,
      String codigo_historial,
      String codigo_mascota,
      String fecha_creacion,
      String genero,
      String peso ,
      String fecha_nacimiento,
      String tipo_procedimiento,
      String doctor,
      String nombre,
      String dosis,
      String observacion ){
      String respuesta="";
try{
   //UPDATE tblArticulo set nombre=?,descripcion=?, observacion=?,precio=?, codigo_mascota=? "
   //     + "   where codigo=?";

//PreparedStatement es una clase para preparar un espacio donde se realizará una acción
PreparedStatement p = con.prepareStatement(SQLHelpersHistorialMedico.getActualizarHistorialMedico());
p.setString(11,codigo_historial);
p.setString(1,codigo_mascota);
p.setString(2,fecha_creacion);
p.setString(3,genero);
p.setString(4,peso);
p.setString(5,fecha_nacimiento);
p.setString(6,tipo_procedimiento);
p.setString(7,doctor);
p.setString(8,nombre);
p.setString(9,dosis);
p.setString(10,observacion);
p.execute();
if(p.getUpdateCount()>0){
    respuesta="Historial Médico :"+ codigo_historial +"Agregado con éxito!";
}else{
    respuesta="Error HIstorail Médico :"+ codigo_historial +"No agregado";
}//fin else/if
}catch(Exception e){
    respuesta+=" " + e.getMessage() + "Causa" + e.getCause();
}finally{try{con.close();}catch(Exception e2){} }//fin finally (finally es para cerrar conexión a la BD)
    
return respuesta;
}//fin actualizarProducto

}
