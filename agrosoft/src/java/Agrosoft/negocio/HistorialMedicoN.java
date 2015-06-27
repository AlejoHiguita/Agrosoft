package Agrosoft.negocio;


import Agrosoft.entidades.HistorialMedico;
import Agrosoft.persistencia.DaosHistorialMedico;
import Agrosoft.utilidades.Conexion;
import java.util.List;

public class HistorialMedicoN {
DaosHistorialMedico dao;    
public HistorialMedicoN (){
Conexion c= new Conexion();
dao = new DaosHistorialMedico();
}// fin constructor
public List<HistorialMedico>listado(){
Conexion c= new Conexion();
return dao.ListaHistorialMedico(c.getCon());
}
public List<HistorialMedico>listadoPorMascota(String codigo_mascota){
Conexion c= new Conexion();
return dao.ListaHistorialMedicoPorMascota(c.getCon(), codigo_mascota);
}
public HistorialMedico  getHistorialMedico(String codigo_historial){
Conexion c;
    c = new Conexion();
return dao.getHistorialMedico(c.getCon(),codigo_historial);
}// fin
public String getConsecutivo(){
Conexion c= new Conexion();
return dao.getConsecutivo(c.getCon());
}// fin getProducto

public void guardarHistorialMedico(HistorialMedico en)throws Exception{
String codigo_historial=en.getcodigo_historial(); 
String codigo_mascota=en.getcodigo_mascota(); 
String fecha_creacion=en.getfecha_creacion();
String genero=en.getgenero();
String peso=en.getpeso() ;
String fecha_nacimiento=en.getfecha_nacimiento(); 
String tipo_procedimiento=en.gettipo_procedimiento(); 
String doctor=en.getdoctor();
String nombre=en.getnombre(); 
String dosis=en.getdosis(); 
String observacion=en.getobservacion(); 	    
String mensajeError="";
Conexion c=new Conexion();
if("".equals(codigo_historial)||null==codigo_historial){
mensajeError+="<br>Debe ingresar el codigo";
}//fin si
if("".equals(codigo_mascota)||null==codigo_mascota){
mensajeError+="<br>Debe ingresar el codigo de la mascota";
}//fin si
if("".equals(fecha_creacion)||null==fecha_creacion){
mensajeError+="<br>Debe ingresar la fecha de creacion";
}//fin 

if("".equals(genero)||null==genero){
mensajeError+="<br>Debe ingresar el genero";
}//fin si

if("".equals(peso)||null==peso){
mensajeError+="<br>Debe ingresar el peso";
}//fin si
if("".equals(fecha_nacimiento)||null==fecha_nacimiento){
mensajeError+="<br>Debe ingresar la fecha de nacimiento";
}//fin si
if("".equals(tipo_procedimiento)||null==tipo_procedimiento){
mensajeError+="<br>Debe ingresar el tipo de procedimiento";
}//fin si
if("".equals(doctor)||null==doctor){
mensajeError+="<br>Debe ingresar el doctor";
}//fin si
if("".equals(nombre)||null==nombre){
mensajeError+="<br>Debe ingresar el nombre";
}//fin si
if("".equals(dosis)||null==dosis){
mensajeError+="<br>Debe ingresar la dosis";
}//fin si
if("".equals(observacion)||null==observacion){
mensajeError+="<br>Debe ingresar la observacion";
}//fin si
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
mensajeError=dao.guardarHistorialMedico(c.getCon(),codigo_historial,codigo_mascota,fecha_creacion,genero,peso ,fecha_nacimiento,tipo_procedimiento,doctor,nombre,dosis, 
observacion);
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
}//fin metodo insertarUsuario //regresamos a ArticuloServlet

public void eliminarHistrorialMedico(String codigo_historial) throws Exception{
  String mensajeError="";
  Conexion c = new Conexion();
  
if("".equals(codigo_historial)||null==codigo_historial){
mensajeError+="Debe ingresar el codigo";
}//fin if codigo
   
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}
  
mensajeError=dao.eliminarHistorialMedico(c.getCon(), codigo_historial);
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}

}//fin método eliminarProducto
public void actualizarHistorialMedico(HistorialMedico en) throws Exception{
String codigo_historial=en.getcodigo_historial(); 
String codigo_mascota=en.getcodigo_mascota(); 
String fecha_creacion=en.getfecha_creacion();
String genero=en.getgenero();
String peso=en.getpeso() ;
String fecha_nacimiento=en.getfecha_nacimiento(); 
String tipo_procedimiento=en.gettipo_procedimiento(); 
String doctor=en.getdoctor();
String nombre=en.getnombre(); 
String dosis=en.getdosis(); 
String observacion=en.getobservacion(); 
String mensajeError="";
  Conexion c = new Conexion();
if("".equals(codigo_historial)||null==codigo_historial){
mensajeError+="<br>Debe ingresar el codigo";
}//fin si
if("".equals(codigo_mascota)||null==codigo_mascota){
mensajeError+="<br>Debe ingresar el codigo de la mascota";
}//fin si
if("".equals(fecha_creacion)||null==fecha_creacion){
mensajeError+="<br>Debe ingresar la fecha de creacion";
}//fin 

if("".equals(genero)||null==genero){
mensajeError+="<br>Debe ingresar el genero";
}//fin si

if("".equals(peso)||null==peso){
mensajeError+="<br>Debe ingresar el peso";
}//fin si
if("".equals(fecha_nacimiento)||null==fecha_nacimiento){
mensajeError+="<br>Debe ingresar la fecha de nacimiento";
}//fin si
if("".equals(tipo_procedimiento)||null==tipo_procedimiento){
mensajeError+="<br>Debe ingresar el tipo de procedimiento";
}//fin si
if("".equals(doctor)||null==doctor){
mensajeError+="<br>Debe ingresar el doctor";
}//fin si
if("".equals(nombre)||null==nombre){
mensajeError+="<br>Debe ingresar el nombre";
}//fin si
if("".equals(dosis)||null==dosis){
mensajeError+="<br>Debe ingresar la dosis";
}//fin si
if("".equals(observacion)||null==observacion){
mensajeError+="<br>Debe ingresar la observacion";
}//fin si
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
 mensajeError=dao.actualizarHIstorialMedico(c.getCon(),codigo_historial,codigo_mascota,fecha_creacion,genero,peso ,fecha_nacimiento,tipo_procedimiento,doctor,nombre,dosis, 
observacion);
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
} 
      
  }// fin método modificarProducto regresamos al ---->CompraServlet
}