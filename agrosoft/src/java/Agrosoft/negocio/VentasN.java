

package Agrosoft.negocio;
import Agrosoft.entidades.Ventas;
import Agrosoft.persistencia.DaosVentas;
import Agrosoft.utilidades.Conexion;
import java.util.List;

/**
 *
 * @author Yuliana Arango
 */
public class VentasN {
DaosVentas dao;    
public VentasN(){
Conexion c= new Conexion();
dao = new DaosVentas();
}// fin constructor
public List<Ventas>listado(){
Conexion c= new Conexion();
return dao.ListaVentas(c.getCon());
}
public Ventas  getVentas(String  N_factura){
Conexion c= new Conexion();
return dao.getVentas (c.getCon(),N_factura);
}// fin getUsuario


//ingresar un dato
public void insertarVentas(Ventas Ven)throws Exception{
String N_factura= Ven.getN_factura();
String Nombre_vendedor= Ven.getN_factura();
String Porcentaje_IVA= Ven.getN_factura();
String N_Documento= Ven.getN_factura();
String mensajeError="";
Conexion c= new Conexion();



if("".equals(N_factura)||null==N_factura){
mensajeError+="<br>Debe ingresar el Numero de factura";
}//fin si
if("".equals(Nombre_vendedor)||null==Nombre_vendedor){
mensajeError+="<br>Debe ingresar Nombre del vendedor";
}//fin si
if("".equals(Porcentaje_IVA)||null==Porcentaje_IVA){
mensajeError+="<br>Debe ingresar la Porcentaje_IVA";
}//fin si
if("".equals(N_Documento)||null==N_Documento){
mensajeError+="<br>Debe ingresar N_Documento";
}//fin si



if (!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
mensajeError=dao.guardarVentas(c.getCon(), N_factura , Nombre_vendedor, Porcentaje_IVA, N_Documento );
if(!"".equals(mensajeError)){
throw new Exception(mensajeError);
}
}//fin metodo insertarUsuario //regresamos a UsuarioServlet


public void ActualizarVentas (Ventas Ven) throws Exception{
String N_factura= Ven.getN_factura();
String Nombre_vendedor= Ven.getNombre_vendedor();
String Porcentaje_IVA= Ven.getPorcentaje_IVA();
String N_Documento= Ven.getN_Documento();
String mensajeError="";
Conexion c=new Conexion();

if("".equals(N_factura)||null==N_factura){
mensajeError+="<br>Debe ingresar el Numero de factura";
}//fin si
if("".equals(Nombre_vendedor)||null==Nombre_vendedor){
mensajeError+="<br>Debe ingresar Nombre del vendedor";
}//fin si
if("".equals(Porcentaje_IVA)||null==Porcentaje_IVA){
mensajeError+="<br>Debe ingresar la Porcentaje_IVA";
}//fin si
if("".equals(N_Documento)||null==N_Documento){
mensajeError+="<br>Debe ingresar N_Documento";
}//fin si

System.out.println(mensajeError);

if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
 
mensajeError=dao.ActualizarVentas (c.getCon(), N_factura, Nombre_vendedor, Porcentaje_IVA, N_Documento);
    if (!"".equals(mensajeError)){
 throw new Exception(mensajeError);
}
   
}


public void eliminarVentas (String N_factura) throws Exception{
  String mensajeError="";
  Conexion c = new Conexion();
  
if("".equals(N_factura)||null==N_factura){
mensajeError+="Debe ingresar el codigo";
}//fin if codigo
   
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}
  
mensajeError=dao.eliminarVentas (c.getCon(), N_factura);
if (!"".equals(mensajeError)){
throw new Exception(mensajeError);   
}
}

}// fin de ventas