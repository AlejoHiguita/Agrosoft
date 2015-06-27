
package Agrosoft.negocio;


import Agrosoft.persistencia.Daos;
import Agrosoft.utilidades.Conexion;
import Agrosoft.entidades.Usuario;
import java.util.List;

public class UsuarioN {
Daos dao;    
public UsuarioN(){
dao = new Daos();
}// fin constructor
public List<Usuario>listado(){
Conexion c= new Conexion();
return dao.ListaUsuarios(c.getCon());
}
public Usuario  getUsuario(String user){
Conexion c= new Conexion();
return dao.getUsuario(c.getCon(),user);
}// fin getUsuario

public Usuario  getValidarIngreso(String user,String pwd){
Conexion c= new Conexion();
return dao.getValidarIngreso(c.getCon(),user,pwd);
}
//ingresar un dato
public void insertarUsuario(Usuario user)throws Exception{
String us=user.getUsuario();
String nombre=user.getUsuario();
String clave=user.getUsuario();
String perfil=user.getUsuario();
String estado=user.getUsuario();
String mensajeError="";
Conexion c=new Conexion();
if("".equals(us)||null==us){
mensajeError+="<br>Debe ingresar el usuario";
}//fin si
if("".equals(nombre)||null==nombre){
mensajeError+="<br>Debe ingresar el nombre";
}//fin si
if("".equals(clave)||null==clave){
mensajeError+="<br>Debe ingresar la clave";
}//fin si
if("".equals(perfil)||null==perfil){
mensajeError+="<br>Debe ingresar el perfil";
}//fin si
if("".equals(estado)||null==estado){
//mensajeError+="<br>Debe ingresar el estado";
estado="Activo";
}//fin si
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
mensajeError=dao.guardarUsuario(c.getCon(),us, nombre, clave, perfil, estado);

if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
}//fin metodo insertarUsuario //regresamos a UsuarioServlet
}// fin de UsuarioN
