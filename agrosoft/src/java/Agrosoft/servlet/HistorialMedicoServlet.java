package Agrosoft.servlet;

import Agrosoft.entidades.Articulo;
import Agrosoft.entidades.HistorialMedico;
import Agrosoft.negocio.HistorialMedicoN;
import Agrosoft.negocio.MascotasN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistorialMedicoServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String codigo_historial =request.getParameter("txtcodigo_historial");
String codigo_mascota=request.getParameter("txtcodigo_mascota");
String fecha_creacion =request.getParameter("txtfecha_creacion");
String genero =request.getParameter("cboGenero");
String peso =request.getParameter("txtpeso");
String fecha_nacimiento =request.getParameter("txtfecha_nacimiento");
String tipo_procedimiento=request.getParameter("cbotipo_procedimiento");
String doctor=request.getParameter("txtdoctor");
String nombre=request.getParameter("txtnombre");
String dosis=request.getParameter("txtdosis");
String observacion=request.getParameter("txtobservacion");
String modulo ="./FHistorialMedico.jsp";
String pagina="./FPrincipal.jsp";
String men="";
HistorialMedicoN un = new  HistorialMedicoN();
MascotasN mn=new MascotasN();

request.setAttribute("mensaje", null);
request.setAttribute("listadoHistorialMedico", null);
request.setAttribute("datoHistorialMedico", null);
request.setAttribute("datoMascotas", null);
request.setAttribute("edicion", ""); 
request.setAttribute("targetModulo", modulo);


// para mostrar todos(boton Mostrar)
if("mostrar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Listado de datos "   ;
request.setAttribute("listadoHistorialMedico", un.listado());
request.setAttribute("mensaje", men);

} catch( Exception e){
// controlar la exepcion
Logger.getLogger(HistorialMedicoServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a FUsuario.jsp



if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar HistorialMedico : ";
request.setAttribute("listadoHistorialMedico", null);
request.setAttribute("datoHistorialMedico", un.getHistorialMedico(codigo_historial));
request.setAttribute("mensaje", men);
request.setAttribute("edicion", "readonly"); 
} catch( Exception e){
Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception
}// fin Buscar ---> 

if("buscarmascota".equals(request.getParameter("action"))){
try{
codigo_mascota=codigo_mascota.replace(" ", "");
request.setAttribute("datoMascotas", mn.getMascota(codigo_mascota));
request.setAttribute("edicion", "readonly"); 
men+=" codigo "+codigo_mascota;
} catch( Exception e){
Logger.getLogger(HistorialMedicoServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception

try{


request.setAttribute("datoHistorialMedico",null);
request.setAttribute("listadoHistorialMedico",un.listadoPorMascota(codigo_mascota));
request.setAttribute("edicion", "readonly"); 
} catch( Exception e){
Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception







}// fin Buscar ---> 

if("grabar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Datos recibidos";
// HistorialMedico (String codigo_historial,String codigo_mascota, String fecha_creacion, String genero,String peso ,String fecha_nacimiento, String tipo_procedimiento, String doctor,String nombre, String dosis, 
///String observacion) {



un.guardarHistorialMedico(new HistorialMedico(codigo_historial,codigo_mascota, fecha_creacion, genero, peso, fecha_nacimiento, tipo_procedimiento, doctor, nombre,dosis, observacion));
men+=tipo_procedimiento;
HistorialMedico entHistorialMedico= new HistorialMedico();
entHistorialMedico.getcodigo_historial();
entHistorialMedico.getcodigo_mascota();
entHistorialMedico.getfecha_creacion();
entHistorialMedico.getgenero();
entHistorialMedico.getpeso();
entHistorialMedico.getfecha_nacimiento();
entHistorialMedico.gettipo_procedimiento();
entHistorialMedico.getdoctor();
entHistorialMedico.getnombre();
entHistorialMedico.getdosis();
entHistorialMedico.getobservacion();
request.setAttribute("datoHistorialMedico",entHistorialMedico);   
request.setAttribute("listadoHistorialMedico", un.listado());
} catch( Exception e){
men+=""+e.getMessage();
/*INsertar un dato
* recuperando los datos a traves de su constructor
* es este caso Articulo(param1, param2, param3, param4, param5);
*/

} // fin exception

}// fin  guardar
if("bloquear".equals(request.getParameter("action"))){
try{
// aquí el código a controlar

/*Insertar un dato
* recuperando los datos a través de su constructor
* Es este caso Usuario(param1,param2,param3,param4,param5);
*   request.setAttribute("listadoProductos", un.listado());
*/

un.eliminarHistrorialMedico(codigo_historial);
request.setAttribute("listadoArticulo", un.listado());
}catch (Exception e){
men+=""+ e.getMessage(); 

}//fin exception 
}//fin eliminar
if("nuevo".equals(request.getParameter("action"))){
try{
HistorialMedico entHistorialMedico= new HistorialMedico();
entHistorialMedico.setcodigo_historial(un.getConsecutivo());
entHistorialMedico.setcodigo_mascota("");
entHistorialMedico.setfecha_creacion("");
entHistorialMedico.setgenero("");
entHistorialMedico.setpeso("");
entHistorialMedico.setfecha_nacimiento("");
entHistorialMedico.settipo_procedimiento("");
entHistorialMedico.setdoctor("");
entHistorialMedico.setnombre("");
entHistorialMedico.setdosis("");
entHistorialMedico.setobservacion("");
request.setAttribute("datoHistorialMedico",entHistorialMedico);
request.setAttribute("edicion","");
request.setAttribute("listadoHIstorialMedico", null);
request.setAttribute("edicion", "readonly"); 


} catch( Exception e){
Logger.getLogger(HistorialMedicoServlet.class.getName()).log(Level.SEVERE,null,e);
men= ""+ e.getMessage();
} // fin exception
}// fin nuevo---> Regresamos a FArticulo.jsp

if("modificar".equals(request.getParameter("action"))){
try{
// aquí el código a controlar
men="";
/*  public Articulo(String codigo, String nombre, String Precio, String descripcion, String observacion, String codigo_mascota) {

*/
un.actualizarHistorialMedico(new HistorialMedico(codigo_historial,codigo_mascota,fecha_creacion,genero,peso ,fecha_nacimiento,tipo_procedimiento,doctor,nombre,dosis, 
observacion));
request.setAttribute("edicion", ""); 

}catch (Exception e){
men+=""+ e.getMessage(); 

}//fin exception 
}//fin modificar



request.setAttribute("mensaje", men);

// despachar la petición
request.getRequestDispatcher(pagina).forward(request, response);
}// fin procesar petición

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
* Handles the HTTP
* <code>GET</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Handles the HTTP
* <code>POST</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/

public String getServletInfo() {
return "Short description";
}// </editor-fold>
}

