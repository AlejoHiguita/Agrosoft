package Agrosoft.persistencia;


import Agrosoft.entidades.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaosArticulo {

public DaosArticulo (){
}//fin constructor Daos
// Método para listar datos

public List<Articulo>ListaArticulo(Connection con)
{
List<Articulo> resultado= new ArrayList<Articulo>();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersArticulo.getArticulo() );
ResultSet r =p.executeQuery();
while(r.next()){
Articulo a = new Articulo();
a.setCodigo(r.getString(1));
a.setNombre(r.getString(2));
a.setDescripcion(r.getString(3));
a.setObservacion(r.getString(4));
a.setPrecio(r.getString(5));
a.setCodigo_mascota(r.getString(6));
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
public Articulo getArticulo(Connection con,String idcodigo)
{
Articulo a= new Articulo();
try{
PreparedStatement p=con.prepareStatement(SQLHelpersArticulo.getArticulo(idcodigo) );
ResultSet r =p.executeQuery();
while(r.next()){
a.setCodigo(r.getString(1));
a.setNombre(r.getString(2));
a.setDescripcion(r.getString(3));
a.setObservacion(r.getString(4));
a.setPrecio(r.getString(5));
a.setCodigo_mascota(r.getString(6));
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


public String getConsecutivo(Connection con)
{
String a=  "0000000001";
try{
PreparedStatement p=con.prepareStatement(SQLHelpersArticulo.getConsecutivoArticulo() );
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

public boolean getValidarSiExisteArticulo(Connection con,String idcodigo)
{
boolean a= false;
try{
PreparedStatement p=con.prepareStatement(SQLHelpersArticulo.getArticulo(idcodigo) );
ResultSet r =p.executeQuery();
while(r.next()){
a=true;
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
}//validarSiexiste

public String guardarArticulo(
        Connection con,
        String codigo,
        String nombre, 
        String descripcion,
        String observacion,
        String precio,
        String codigo_mascota ){
String respuesta="";
try {
PreparedStatement p=con.prepareStatement(SQLHelpersArticulo.getInsertarArticulo());
p.setString(1,codigo);
p.setString(2,nombre);
p.setString(3,descripcion);
p.setString(4,observacion);
p.setString(5,precio);
p.setString(6,codigo_mascota);
p.execute();
respuesta = "Artículo agregado";
if(p.getUpdateCount()>0){
respuesta="Articulo:"+codigo+"Agregado";
} else{
respuesta+="Error Articulo:"+codigo+"No Agregado";
}       
}catch (Exception e){
respuesta=""+ e.getMessage()+"causa"+e.getCause();
}finally{try{con.close();}catch (Exception e2){}}
return respuesta;
}



public String actualizarArticulo(
        Connection con,
        String codigo,
        String nombre, 
        String descripcion,
        String observacion,
        String precio,
        String codigo_mascota ){
String respuesta="";
try{
   //UPDATE tblArticulo set nombre=?,descripcion=?, observacion=?,precio=?, codigo_mascota=? "
   //     + "   where codigo=?";

//PreparedStatement es una clase para preparar un espacio donde se realizará una acción
PreparedStatement p = con.prepareStatement(SQLHelpersArticulo.getActualizarArticulo());
p.setString(6,codigo);
p.setString(1,nombre);
p.setString(2,descripcion);
p.setString(3,observacion);
p.setString(4,precio);
p.setString(5,codigo_mascota);
p.execute();
if(p.getUpdateCount()>0){
    respuesta="Articulo :"+ codigo +"Agregado con éxito!";
}else{
    respuesta="Error Articulo :"+ codigo +"No agregado";
}//fin else/if
}catch(Exception e){
    respuesta+=" " + e.getMessage() + "Causa" + e.getCause();
}finally{try{con.close();}catch(Exception e2){} }//fin finally (finally es para cerrar conexión a la BD)
    
return respuesta;
}//fin actualizarProducto


public String eliminarArticulo(  Connection con, String codigo){
String respuesta="";
try{
    //"UPDATE tblArticulo set nombre=?,precio_compra=?,precio_venta=?,cantidad=?,max_stock=?,min_stock=?  "
    //     where codigo=?;
//PreparedStatement es una clase para preparar un espacio donde se realizará una acción
PreparedStatement p = con.prepareStatement(SQLHelpersArticulo.getEliminarArticulo(codigo));
p.execute();

if(p.getUpdateCount()>0){
    respuesta="Articulo :"+ codigo +"Eliminado con éxito!";
}else{
    respuesta="Error Articulo :"+ codigo +"No eliminado";
}//fin else/if
}catch(Exception e){
    respuesta+=" " + e.getMessage() + "Causa" + e.getCause();
}finally{try{con.close();}catch(Exception e2){} }//fin finally (finally es para cerrar conexión a la BD)
    
return respuesta;
}//fin eliminarProducto

}//fin Daos
