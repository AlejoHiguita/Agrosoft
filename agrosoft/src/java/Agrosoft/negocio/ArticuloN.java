package Agrosoft.negocio;


import Agrosoft.entidades.Articulo;
import Agrosoft.persistencia.DaosArticulo;
import Agrosoft.utilidades.Conexion;
import java.util.List;

/**
 * Esta clase nos va permitir
 * crear metodos los cuales van a
 * conectarse con la base de datos, 
 * con el daos y van a permitir insertar,
 * eliminar y modificar los datos.
 * 
 * @version 2.2 01/07/2015
 * @author Alejandro H
 */

public class ArticuloN {
DaosArticulo dao;  
Conexion c= new Conexion();
public ArticuloN(){
dao = new DaosArticulo();
}// fin constructor

public List<Articulo>listado(){

return dao.ListaArticulo(c.getCon());
}
/**
 * /**
 * Este metodo recibe un parametro 
 *
 * @param codigo
 * @return lo que obtiene de getArticulo
 */
public Articulo  getArticulo(String codigo){
return dao.getArticulo(c.getCon(),codigo);
}// fin getProducto

/**
 * Este es un metodo vacio
 * @return retorna lo que obtiene de getConsecutivo.
 */
public String getConsecutivo(){
return dao.getConsecutivo(c.getCon());
}// fin getProducto

  
/**
 * /**
 * Este metodo permite guardar un articulo 
 * contiene parametros
 * se conecta con la base de datos, 
 * y muestra mensajes de error.
 *
 * @param en
 * @throws Exception 
 */
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
}//fin metodo insertarArticulo //regresamos a ArticuloServlet


/**
 * Este metodo permite actualizar un articulo  
 * define variables y les da un valor,
 * se conecta con la base de datos, 
 * y muestra mensajes de error.
 * @param en
 * @throws Exception 
 */

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

/**
 *  Este metodo permite eliminar un articulo 
 * resive una variable codigo,
 * define variables y les da un valor,
 * se conecta con la base de datos, 
 * y muestra mensajes de error.
 * @param codigo
 * @throws Exception 
 */

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

}//fin método eliminarArticulo
    
}// fin de Articulo