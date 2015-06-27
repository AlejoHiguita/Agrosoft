
package Agrosoft.negocio;
import Agrosoft.entidades.Proveedor;
import Agrosoft.persistencia.DaosProveedor;
import Agrosoft.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

public class ProveedorN {
DaosProveedor dao;    
public ProveedorN(){
dao = new DaosProveedor();
}// fin constructor
public List<Proveedor>listado(){
Conexion c= new Conexion();
return dao.ListaProveedor(c.getCon());
}
public Proveedor  getProveedor(String Identificacion){
Conexion c= new Conexion();
return dao.getProveedor(c.getCon(),Identificacion);
}// fin getProveedor

//Insertar un dato
public void insertarProveedor(Proveedor  pro) throws Exception{
String Identificacion=pro.getIdentificacion();
String Nombre=pro.getNombre();
String Direccion=pro.getDireccion();
String Celular=pro.getCelular();
String Telefono_fijo=pro.getTelefono_fijo();
String Correro_electronico=pro.getCorrero_electronico();
String Nombre_contacto=pro.getNombre_contacto();
String Telefono_contacto=pro.getTelefono_contacto();
String mensajeError="";
Conexion c=new Conexion();
if("".equals(Identificacion)||null==Identificacion){
mensajeError+="<br>Debe ingresar el usuario";
}
if("".equals(Nombre)||null==Nombre){
mensajeError+="<br>Debe ingresar el Nombre";
}
if("".equals(Direccion)||null==Direccion){
mensajeError+="<br>Debe ingresar la Direccion";
}
if("".equals(Celular)||null==Celular){
mensajeError+="<br>Debe ingresar el Celular";
}
if("".equals(Telefono_fijo)||null==Telefono_fijo){
mensajeError+="<br>Debe ingresar el Telefono Fijo";
}
if("".equals(Correro_electronico)||null==Correro_electronico){
//mensajeError+="<br>Debe ingresar el usuario";
    }
if("".equals(Nombre_contacto)||null==Nombre_contacto){
mensajeError+="<br>Debe ingresar el Nombre del contacto";
}
System.out.println(mensajeError);
if("".equals(Telefono_contacto)||null==Telefono_contacto){
mensajeError+="<br>Debe ingresar el Telefono del contacto";
}

if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
 if(dao.getValidarSiExisteProveedor(c.getCon(), Identificacion)){
     mensajeError="El usuario ya esta registrado..";
     throw new Exception(mensajeError);
 }
mensajeError=dao.guardarProveedor(c.getCon(), Identificacion, Nombre, Direccion,  Celular, Telefono_fijo, Correro_electronico, Nombre_contacto, Telefono_contacto);
    if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
   
}// fin metodo regresamos al Usuarioservlet

public void actualizarProveedor(Proveedor  pro) throws Exception{
String Identificacion=pro.getIdentificacion();
String Nombre=pro.getNombre();
String Direccion=pro.getDireccion();
String Celular=pro.getCelular();
String Telefono_fijo=pro.getTelefono_fijo();
String Correro_electronico=pro.getCorrero_electronico();
String Nombre_contacto=pro.getNombre_contacto();
String Telefono_contacto=pro.getTelefono_contacto();
String mensajeError="";
Conexion c=new Conexion();
if("".equals(Identificacion)||null==Identificacion){
mensajeError+="<br>Debe ingresar el usuario";
}
if("".equals(Nombre)||null==Nombre){
mensajeError+="<br>Debe ingresar el Nombre";
}
if("".equals(Direccion)||null==Direccion){
mensajeError+="<br>Debe ingresar la Direccion";
}
if("".equals(Celular)||null==Celular){
mensajeError+="<br>Debe ingresar el Celular";
}
if("".equals(Telefono_fijo)||null==Telefono_fijo){
mensajeError+="<br>Debe ingresar el Telefono Fijo";
}
if("".equals(Correro_electronico)||null==Correro_electronico){
//mensajeError+="<br>Debe ingresar el usuario";
    }
if("".equals(Nombre_contacto)||null==Nombre_contacto){
mensajeError+="<br>Debe ingresar el Nombre del contacto";
}
System.out.println(mensajeError);
if("".equals(Telefono_contacto)||null==Telefono_contacto){
mensajeError+="<br>Debe ingresar el Telefono del contacto";
}

if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
 
mensajeError=dao.actualizarProveedor(c.getCon(), Identificacion, Nombre, Direccion,  Celular, Telefono_fijo, Correro_electronico, Nombre_contacto, Telefono_contacto);
    if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
   
}


}// fin de ProveedorN