
package Agrosoft.servlet;

import Agrosoft.entidades.Proveedor;
import Agrosoft.entidades.Usuario;
import Agrosoft.negocio.ProveedorN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProveedorServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String Identificacion =request.getParameter("txtIdentificacion");
String Nombre =request.getParameter("txtNombre");   
String Direccion =request.getParameter("txtDireccion");   
String Celular =request.getParameter("txtCelular");
String Telefono_fijo =request.getParameter("txtTe_fijo"); 
String Correro_electronico =request.getParameter("txtCorrero_electronico"); 
String Nombre_contacto =request.getParameter("txtNombre_contacto"); 
String Telefono_contacto =request.getParameter("txtTelefono_contacto");  
String modulo ="Proveedor.jsp";
String pagina="./FPrincipal.jsp";
request.setAttribute("targetModulo",modulo );

String men="";
ProveedorN un = new  ProveedorN();  
request.setAttribute("mensaje", null);
request.setAttribute("listadoProveedor", null);
request.setAttribute("datoProveedor", null);
request.setAttribute("edicion", ""); 


if("grabar".equals(request.getParameter("action"))){
try{
// a quÃ­ el codigo a controlar
men="";
/*Insertar un dato
recuperando los datos a travÃ©z de su constructor
* Es este caso Usuario(param1,param2,param3,param4,param5);
*/
un.insertarProveedor(new Proveedor(Identificacion,Nombre,Direccion,Celular,Telefono_fijo,Correro_electronico,Nombre_contacto,Telefono_contacto));
Proveedor entPro= new Proveedor();
entPro.setIdentificacion("");
entPro.setNombre("");
entPro.setDireccion("");
entPro.setTelefono_fijo("");
entPro.setCorrero_electronico("");
entPro.setNombre_contacto(""); 
entPro.setTelefono_contacto ("");
request.setAttribute("datoProveedor",entPro);
request.setAttribute("listadoProveedor", un.listado());
//request.setAttribute("mensaje", null);
} catch( Exception e){
men+=""+ e.getMessage();
// controlar la excecion

} // fin exception
}// fi  guardar
// para mostrar todos(boton Mostrar)
if("mostrar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Listado de datos "   ;
request.setAttribute("listadoProveedor", un.listado());
request.setAttribute("mensaje", men);

} catch( Exception e){
// controlar la exepcion
Logger.getLogger(Agrosoft.servlet.ProveedorServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a Proveedor.jsp
// botón buscar


if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar a Proveedor : "+Identificacion   ;
request.setAttribute("listadoProveedor", null);
request.setAttribute("datoProveedor", un.getProveedor(Identificacion ));
request.setAttribute("edicion","readonly");
request.setAttribute("mensaje", men);
} catch( Exception e){
Logger.getLogger(Agrosoft.servlet.ProveedorServlet.class.getName()).log(Level.SEVERE,null,e);
men= ""+ e.getMessage();
} // fin exception
}// fin Buscar 

if("nuevo".equals(request.getParameter("action"))){
try{
Proveedor entPro = new Proveedor();
entPro.setIdentificacion(""); 
entPro.setNombre("");   
entPro.setDireccion(""); 
entPro.setCelular("");
entPro.setTelefono_fijo("");
entPro.setCorrero_electronico("");
entPro.setNombre_contacto(""); 
entPro.setTelefono_contacto ("");
request.setAttribute("datoProveedor",entPro);
request.setAttribute("edicion","");
request.setAttribute("listadoProveedor", null);


} catch( Exception e){
Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE,null,e);
men= ""+ e.getMessage();
} // fin exception
}// fin Buscar 

if("modificar".equals(request.getParameter("action"))){
try{
un.actualizarProveedor(new Proveedor(Identificacion,Nombre,Direccion,Celular,Telefono_fijo,Correro_electronico,Nombre_contacto,Telefono_contacto));
Proveedor entPro= new Proveedor();
entPro.setIdentificacion("");
entPro.setNombre("");
entPro.setDireccion("");
entPro.setTelefono_fijo("");
entPro.setCorrero_electronico("");
entPro.setNombre_contacto(""); 
entPro.setTelefono_contacto ("");
request.setAttribute("datoProveedor",entPro);
request.setAttribute("listadoProveedor", un.listado());
men="Datos modificados";


} catch(Exception e){
//controlar la excepción
Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE,null,e);
}//fin excepcion

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
@Override
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
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>
}

