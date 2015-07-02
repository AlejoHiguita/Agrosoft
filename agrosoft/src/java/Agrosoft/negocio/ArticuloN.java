package Agrosoft.negocio;


import Agrosoft.entidades.Articulo;
import Agrosoft.persistencia.DaosArticulo;
import Agrosoft.utilidades.Conexion;
import java.util.List;

/**
* 
*
* @version 2.2 01/07/2015
* @author Alejandro H.
**/

public class ArticuloN {
DaosArticulo dao;  
Conexion c= new Conexion();
public ArticuloN(){

dao = new DaosArticulo();
}// fin constructor
public List<Articulo>listado(){

return dao.ListaArticulo(c.getCon());
}
public Articulo  getArticulo(String codigo){
return dao.getArticulo(c.getCon(),codigo);
}// fin getProducto
public String getConsecutivo(){
return dao.getConsecutivo(c.getCon());
}// fin getProducto

  
public void guardarArticulo(Articulo en)throws Exception{
String codi= en.getCodigo();
String nombre= en.getNombre();
String descripcion=en.getDescripcion();
String observacion=en.getObservacion();
String precio=en.getPrecio();
String codigo_mascota=en.getCodigo_mascota();
String mensajeError="";
Conexion c=new Conexion();
if("".equals(codi)||null==codi){
mensajeError+="<br>Debe ingresar el codigo";
}//fin si
if("".equals(nombre)||null==nombre){
mensajeError+="<br>Debe ingresar el nombre";
}//fin si
if("".equals(descripcion)||null==descripcion){
mensajeError+="<br>Debe ingresar la descripción";
}//fin si
if("".equals(observacion)||null==observacion){
mensajeError+="<br>Debe ingresar el observacion";
}//fin si
if("".equals(precio)||null==precio){
mensajeError+="<br>Debe ingresar el precio";
}//fin si
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
mensajeError=dao.guardarArticulo(c.getCon(),codi, nombre, descripcion, observacion, precio, codigo_mascota);
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
 if(dao.getValidarSiExisteArticulo(c.getCon(), codi)){
     mensajeError="El usuario ya esta¡ registrado..";
     throw new Exception(mensajeError);
 }
}//fin metodo insertarUsuario //regresamos a ArticuloServlet

public void actualizarArticulo(Articulo en) throws Exception{
String codi= en.getCodigo();
String nombre= en.getNombre();
String descripcion=en.getDescripcion();
String observacion=en.getObservacion();
String precio=en.getPrecio();
String codigo_mascota=en.getCodigo_mascota();
String mensajeError="";
  Conexion c = new Conexion();

if("".equals(codi)||null==codi){
mensajeError+="Debe ingresar el codigo";
}//fin si
if("".equals(nombre)||null==nombre){
mensajeError+="Debe ingresar el nombre";
}//fin si
if("".equals(descripcion)||null==descripcion){
mensajeError+="Debe ingresar la descripción";
}//fin si
if("".equals(observacion)||null==observacion){
mensajeError+="Debe ingresar el observacion";
}//fin si
if("".equals(precio)||null==precio){
mensajeError+="Debe ingresar el precio";
}//fin si
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
 mensajeError=dao.actualizarArticulo(c.getCon(),codi, nombre, descripcion, observacion, precio, codigo_mascota);
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
} 
      
  }// fin método modificarProducto regresamos al ---->CompraServlet

public void eliminarArticulo(String codigo) throws Exception{
  String mensajeError="";
  Conexion c = new Conexion();
  
if("".equals(codigo)||null==codigo){
mensajeError+="Debe ingresar el codigo";
}//fin if codigo
   
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}
  
mensajeError=dao.eliminarArticulo(c.getCon(), codigo);
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}

}//fin método eliminarProducto
    
}// fin de Articulo