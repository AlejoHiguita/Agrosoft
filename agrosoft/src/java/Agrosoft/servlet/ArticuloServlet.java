package Agrosoft.servlet;

import Agrosoft.entidades.Articulo;
import Agrosoft.negocio.ArticuloN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticuloServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String codigo =request.getParameter("txtcodigo");
String nombre =request.getParameter("txtnombre");
String descripcion =request.getParameter("txtdescripcion");
String observacion =request.getParameter("txtobservacion");
String precio =request.getParameter("txtprecio");
String codigo_mascota=request.getParameter("txtcodigo_mascota");
String modulo ="./FArticulo.jsp";
String pagina="./FPrincipal.jsp";
String men="";
ArticuloN un = new  ArticuloN();
request.setAttribute("mensaje", null);
request.setAttribute("listadoArticulo", null);
request.setAttribute("datoArticulo", null);
request.setAttribute("edicion", ""); 
request.setAttribute("targetModulo", modulo);
Articulo entArticulo=new Articulo();

// para mostrar todos(boton Mostrar)
if("mostrar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Listado de datos "   ;
request.setAttribute("listadoArticulo", un.listado());
request.setAttribute("mensaje", men);

} catch( Exception e){
// controlar la exepcion
Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a FUsuario.jsp
// botón buscar


if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar Articulo : ";
request.setAttribute("listadoArticulo", null);
request.setAttribute("datoArticulo", un.getArticulo(codigo));
request.setAttribute("mensaje", men);
request.setAttribute("edicion", "readonly"); 
} catch( Exception e){
Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception
}// fin Buscar ---> Regresamos a FUsuario.jsp

if("grabar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
//
men="Datos recibidos";
un.guardarArticulo(new Articulo(codigo, nombre, precio,  descripcion, observacion,codigo_mascota));
entArticulo.setCodigo("");
entArticulo.setNombre("");
entArticulo.setDescripcion("");
entArticulo.setObservacion("");
entArticulo.setPrecio("");
entArticulo.setCodigo_mascota("");
request.setAttribute("datoArticulo",entArticulo);     
request.setAttribute("listadoArticulo", un.listado());
} catch( Exception e){
men+=""+e.getMessage();
/*INsertar un dato
* recuperando los datos a traves de su constructor
* es este caso Articulo(param1, param2, param3, param4, param5);
*/

} // fin exception
}// fin  guardar

if("nuevo".equals(request.getParameter("action"))){
try{

entArticulo.setCodigo(un.getConsecutivo());
entArticulo.setNombre("");
entArticulo.setDescripcion("");
entArticulo.setObservacion("");
entArticulo.setPrecio("");
entArticulo.setCodigo_mascota("");
request.setAttribute("datoArticulo",entArticulo);
request.setAttribute("edicion","");
request.setAttribute("listadoArticulo", null);
request.setAttribute("edicion", "readonly"); 


} catch( Exception e){
Logger.getLogger(ArticuloServlet.class.getName()).log(Level.SEVERE,null,e);
men= ""+ e.getMessage();
} // fin exception
}// fin nuevo---> Regresamos a FArticulo.jsp

if("modificar".equals(request.getParameter("action"))){
try{
// aquí el código a controlar
men="";
/*  public Articulo(String codigo, String nombre, String Precio, String descripcion, String observacion, String codigo_mascota) {

*/
un.actualizarArticulo(new Articulo(codigo, nombre, precio, descripcion, observacion, codigo_mascota));
request.setAttribute("edicion", ""); 

}catch (Exception e){
men+=""+ e.getMessage(); 

}//fin exception 
}//fin modificar

if("bloquear".equals(request.getParameter("action"))){
try{
// aquí el código a controlar

/*Insertar un dato
* recuperando los datos a través de su constructor
* Es este caso Usuario(param1,param2,param3,param4,param5);
*   request.setAttribute("listadoProductos", un.listado());
*/

un.eliminarArticulo(codigo);
request.setAttribute("listadoArticulo", un.listado());
}catch (Exception e){
men+=""+ e.getMessage(); 

}//fin exception 
}//fin eliminar


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
