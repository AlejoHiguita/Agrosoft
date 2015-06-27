/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agrosoft.negocio;
import Agrosoft.entidades.Clientes;
import Agrosoft.persistencia.DaosClientes;
import Agrosoft.utilidades.Conexion;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ClientesN {
DaosClientes dao;
public ClientesN(){
Conexion c= new Conexion();
dao=new DaosClientes();
}//fin constructor

public List<Clientes>Listado(){
Conexion c= new Conexion();      
return dao.ListaClientes(c.getCon());
}
public Clientes getClientes (String N_documento){
Conexion c;
 c = new Conexion();   
return dao.getClientes(c.getCon(),N_documento);
}

//insertar un  dato
public void insertarClientes(Clientes cl) throws Exception{
String N_docu= cl.getN_documento();
String Primer_nombre= cl.getPrimer_nombre();
String Segundo_nombre= cl.getSegundo_nombre();
String Apellidos= cl.getApellidos();
String Tel_fijo= cl.getTel_fijo();
String Tel_cel= cl.getTel_cel();
String Direccion= cl.getDireccion();
String Municipio= cl.getMunicipio();
String Correo_elec= cl.getCorreo_elec();
String mensajeError="";
Conexion c= new Conexion();


if ("".equals(N_docu)||null==N_docu){
mensajeError+="<br>Debe ingresar la identificacion";
}
if ("".equals(Primer_nombre)||null==Primer_nombre){
mensajeError+="<br>Debe ingresar el primer nombre";
}
if ("".equals(Segundo_nombre)||null==Segundo_nombre){
mensajeError+="<br>Debe ingresar el segundo nombre";
}
if ("".equals(Apellidos)||null==Apellidos){
mensajeError+="<br>Debe ingresar los apellidos";
}
if ("".equals(Tel_fijo)||null==Tel_fijo){
mensajeError+="<br>Debe ingresar el telefono fijo ";
}
if ("".equals(Tel_cel)||null==Tel_cel){
mensajeError+="<br>Debe ingresar el telefono celular";
}
if ("".equals(Direccion)||null==Direccion){
mensajeError+="<br>Debe ingresar la direccion";
}
if ("".equals(Municipio)||null==Municipio){
mensajeError+="<br>Debe ingresar el municipio";
}
if ("".equals(Correo_elec)||null==Correo_elec){
mensajeError+="<br>Debe ingresar correo electronico";
}
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
mensajeError=dao.guardarClientes (c.getCon(), N_docu, Primer_nombre, Segundo_nombre, Apellidos, Tel_fijo, Tel_cel, Direccion, Municipio, Correo_elec);
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
}//fin metodo insertarUsuario //regresamos a UsuarioServlet


public void ActualizarClientes(Clientes cli) throws Exception{
String N_documento=cli.getN_documento();
String Primer_nombre=cli.getPrimer_nombre();
String Segundo_nombre=cli.getSegundo_nombre();
String Apellidos=cli.getApellidos();
String Tel_fijo=cli.getTel_fijo();
String Tel_cel=cli.getTel_cel();
String Direccion=cli.getDireccion();
String Municipio=cli.getMunicipio();
String Correo_elec=cli.getCorreo_elec();
String mensajeError="";
Conexion c=new Conexion();

if("".equals(N_documento)||null==N_documento){
mensajeError+="<br>Debe ingresar el numero de documento ";
}
if("".equals(Primer_nombre)||null==Primer_nombre){
mensajeError+="<br>Debe ingresar el Nombre";
}
if("".equals(Segundo_nombre)||null==Segundo_nombre){
mensajeError+="<br>Debe ingresar el Nombre";
}
if("".equals(Apellidos)||null==Apellidos){
mensajeError+="<br>Debe ingresar el Celular";
}
if("".equals(Tel_fijo)||null==Tel_fijo){
mensajeError+="<br>Debe ingresar el Telefono Fijo";
}
if("".equals(Tel_fijo)||null==Tel_fijo){
mensajeError+="<br>Debe ingresar el Telefono Fijo";
}
if("".equals(Tel_cel)||null==Tel_cel){
//mensajeError+="<br>Debe ingresar el usuario";
    }
if("".equals(Municipio)||null==Municipio){
mensajeError+="<br>Debe ingresar el Nombre del contacto";
}
if("".equals(Correo_elec)||null==Correo_elec){
mensajeError+="<br>Debe ingresar el Telefono del contacto";
}
System.out.println(mensajeError);

if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
 
mensajeError=dao.ActualizarClientes(c.getCon(), N_documento, Primer_nombre, Segundo_nombre, Apellidos, Tel_fijo, Tel_cel, Direccion, Municipio, Correo_elec);
    if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
   
}

public void eliminarClientes(String N_documento) throws Exception{
  String mensajeError="";
  Conexion c = new Conexion();
  
if("".equals( N_documento)||null== N_documento){
mensajeError+="Debe ingresar el codigo";
}//fin if codigo
   
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}
  
mensajeError=dao.eliminarClientes(c.getCon(),  N_documento);
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}
}// fin de cliente
}