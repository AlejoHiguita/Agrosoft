package Agrosoft.persistencia;


import Agrosoft.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class Daos {

public Daos (){
Daos dao;
}//fin constructor Daos
// Método para listar datos
public List<Usuario>ListaUsuarios(Connection con)
{
List<Usuario> resultado= new ArrayList<Usuario>();
try{
PreparedStatement p=con.prepareStatement(SQLHelpers.getUsuarios() );
ResultSet r =p.executeQuery();
while(r.next()){
Usuario u = new Usuario();
u.setUsuario(r.getString(1));
u.setNombre(r.getString(2));
u.setClave(r.getString(3));
u.setPerfil(r.getString(4));
//u.setEstado(r.getString("perfil")) ó;
u.setEstado(r.getString(5));
resultado.add(u);
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
return  resultado;
}//fin lista 
// Copiamos el método anterior
// y lo modificamos
/* Método para un consultar un registro
 determinado */

/*Copiamos el siguiente método y renombramos*/
public Usuario getUsuario(Connection con,String idusuario)
{
Usuario u= new Usuario();
try{
PreparedStatement p=con.prepareStatement(SQLHelpers.getUsuario(idusuario) );
ResultSet r =p.executeQuery();
while(r.next()){
u.setUsuario(r.getString(1));
u.setNombre(r.getString(2));
u.setClave(r.getString(3));
u.setPerfil(r.getString(4));
//u.setEstado(r.getString("perfil")) ó;
u.setEstado(r.getString(5));
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
return  u;
}//fin buscar

public Usuario getValidarIngreso(Connection con,String user,String pwd)
{
Usuario u= new Usuario();
u.setUsuario("0");
try{
PreparedStatement p=con.prepareStatement(SQLHelpers.getValidarIngreso(user, pwd) );
ResultSet r =p.executeQuery();
while(r.next()){
u.setUsuario(r.getString(1));
u.setNombre(r.getString(2));
u.setClave(r.getString(3));
u.setPerfil(r.getString(4));
//u.setEstado(r.getString("perfil")) ó;
u.setEstado(r.getString(5));
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
return  u;
}//fin buscar

public String guardarUsuario(
        Connection con,
        String usuario,
        String nombre, 
        String clave, 
        String perfil,
        String estado){
String respuesta="";
try {
PreparedStatement p=con.prepareStatement(SQLHelpers.getInsertarUsuario());
p.setString(1,usuario);
p.setString(2,nombre);
p.setString(3,clave);
p.setString(4,perfil);
p.setString(5,estado);
p.execute();
if(p.getUpdateCount()>0){
respuesta="Usuario:"+usuario+"Agregado";
} else{
respuesta+="Error Usuario:"+usuario+"No Agregado";
}       
}catch (Exception e){
respuesta=""+ e.getMessage()+"causa"+e.getCause();
}finally{try{con.close();}catch (Exception e2){}}
return respuesta;
}
}//fin Daos
