
package Agrosoft.negocio;
import Agrosoft.entidades.Mascotas;
import Agrosoft.persistencia.DaosMascota;
import Agrosoft.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

public class MascotasN {
DaosMascota dao;    
public MascotasN(){
dao = new DaosMascota();
}// fin constructor
public List<Mascotas>listado(){
Conexion c= new Conexion();
return dao.ListaMascota(c.getCon());
}
public Mascotas getMascota(String Codigo){
Conexion c= new Conexion();
return dao.getMascota(c.getCon(),Codigo);
}// fin getProveedor

//Insertar un dato
public void insertarMascota(Mascotas mas) throws Exception{
String Codigo=mas.getCodigo();
String Nombre=mas.getNombre();
String Genero=mas.getGenero();
String Peso=mas.getPeso();
String Fecha_de_nacimiento=mas.getFecha_de_nacimiento();
String Costo=mas.getCosto();
String mensajeError="";
Conexion c=new Conexion();
if("".equals(Codigo)||null==Codigo){
mensajeError+="<br>Debe ingresar el Codigo";
}
if("".equals(Nombre)||null==Nombre){
mensajeError+="<br>Debe ingresar el Nombre";
}
if("".equals(Genero)||null==Genero){
mensajeError+="<br>Debe ingresar la Genero";
}
if("".equals(Peso)||null==Peso){
mensajeError+="<br>Debe ingresar el Peso";
}
if("".equals(Fecha_de_nacimiento)||null==Fecha_de_nacimiento){
mensajeError+="<br>Debe ingresar la fecha de nacimiento";
}

if("".equals(Costo)||null==Costo){
mensajeError+="<br>Debe ingresar el Costo";
}
System.out.println(mensajeError);

if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
 if(dao.getValidarSiExisteMascotas(c.getCon(), Codigo)){
     mensajeError="El usuario ya esta registrado..";
     throw new Exception(mensajeError);
 }
 
mensajeError=dao.guardarMascotas(c.getCon(), Codigo, Nombre, Genero, Peso, Fecha_de_nacimiento, Costo);
    if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
   
}// fin metodo regresamos al Usuarioservlet

public void actualizarMascota(Mascotas  mas) throws Exception{
String Codigo=mas.getCodigo();
String Nombre=mas.getNombre();
String Genero=mas.getGenero();
String Peso=mas.getPeso();
String Fecha_de_nacimiento=mas.getFecha_de_nacimiento();
String Costo=mas.getCosto();
String mensajeError="";
Conexion c=new Conexion();
if("".equals(Codigo)||null==Codigo){
mensajeError+="<br>Debe ingresar el Codigo";
}
if("".equals(Nombre)||null==Nombre){
mensajeError+="<br>Debe ingresar el Nombre";
}
if("".equals(Genero)||null==Genero){
mensajeError+="<br>Debe ingresar la Genero";
}
if("".equals(Peso)||null==Peso){
mensajeError+="<br>Debe ingresar el Peso";
}
if("".equals(Fecha_de_nacimiento)||null==Fecha_de_nacimiento){
mensajeError+="<br>Debe ingresar la fecha de nacimiento";
}

if("".equals(Costo)||null==Costo){
mensajeError+="<br>Debe ingresar el Costo";
}

if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
 
mensajeError=dao.actualizarMascotas(c.getCon(), Codigo, Nombre, Genero,  Peso, Fecha_de_nacimiento, Costo);
    if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
   
}


}// fin 