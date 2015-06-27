/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package Agrosoft.servlet;

import Agrosoft.entidades.Clientes;
import Agrosoft.negocio.ClientesN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
*
* @author Usuario
*/
public class ClientesServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();

String N_documento =request.getParameter ("txtN_documento");
String Primer_nombre =request.getParameter("txtPrimer_nombre");
String Segundo_nombre =request.getParameter ("txtSegundo_nombre");
String Apellidos =request.getParameter ("txtApellidos");
String Tel_fijo =request.getParameter ("txtTel_fijo");
String Tel_cel =request.getParameter ("txtTel_cel");
String Direccion =request.getParameter ("txtDireccion");
String Municipio =request.getParameter ("cboMunicipio");
String Correo_elec =request.getParameter ("txtCorreo_elec");
String modulo="FClientes.jsp";
String pagina="./FPrincipal.jsp";
String men="";
ClientesN un= new ClientesN();
request.setAttribute("mensaje",null);
request.setAttribute("listadoClientes", null);
request.setAttribute("datoClientes", null);
request.setAttribute("targetModulo",modulo );  

if("mostrar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Listado de datos "   ;
request.setAttribute("listadoClientes", un.Listado());


} catch( Exception e){
// controlar la exepcion
Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a FUsuario.jsp



// botón buscar
if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar Cliente : ";
request.setAttribute("listadoClientes", null);
request.setAttribute("datoClientes", un.getClientes(N_documento));
request.setAttribute("mensaje", men);
} catch( Exception e){
Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception
}// fin Buscar ---> Regresamos a FUsuario.jsp





if("grabar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="";
un.insertarClientes(new Clientes(N_documento,Primer_nombre, Segundo_nombre,Apellidos,Tel_fijo,Tel_cel,Direccion, Municipio, Correo_elec));
//request.setAttribute("mensaje", null);
} catch( Exception e){
men+=""+e.getMessage();
/*INsertar un dato
* recuperando los datos a traves de su constructor
* es este caso Usuario(param1, param2, param3, param4, param5);
*/

} // fin exception
}// fin  guardar


if("modificar".equals(request.getParameter("action"))){
try{
un.ActualizarClientes(new Clientes (N_documento,Primer_nombre,Segundo_nombre,Apellidos,Tel_fijo,Tel_cel,Direccion,Municipio,Correo_elec));
Clientes entCli= new Clientes();
entCli.setN_documento("");
entCli.setPrimer_Nombre("");
entCli.setSegundo_nombre("");
entCli.setApellidos("");
entCli.setTel_fijo("");
entCli.setTel_cel("");
entCli.setDireccion(""); 
entCli.setMunicipio("");
entCli.setCorreo_elec("");
request.setAttribute("datoClientes",entCli);
request.setAttribute("listadoClientes", un.Listado());
men="Datos modificados";


} catch(Exception e){
men=""+e.getMessage();
//controlar la excepción
Logger.getLogger(ClientesServlet.class.getName()).log(Level.SEVERE,null,e);
}//fin excepcion

}//fin modificar

if("bloquear".equals(request.getParameter("action"))){
try{
// aquí el código a controlar

/*Insertar un dato
* recuperando los datos a través de su constructor
* Es este caso Usuario(param1,param2,param3,param4,param5);
*   request.setAttribute("listadoProductos", un.listado());
*/

un.eliminarClientes(N_documento);
request.setAttribute("listadoClientes", un.Listado());
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


