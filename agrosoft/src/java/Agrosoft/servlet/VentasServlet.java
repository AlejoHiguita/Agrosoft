
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package Agrosoft.servlet;


import Agrosoft.entidades.Ventas;
import Agrosoft.negocio.VentasN;
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
public class VentasServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();


String N_factura =request.getParameter("txtN_factura");
String Nombre_vendedor =request.getParameter ("txtNombre_vendedor");
String Porcentaje_IVA =request.getParameter ("txtPorcentaje_IVA");
String N_Documento =request.getParameter("txtN_Documento");  
String modulo="FVentas.jsp";
String pagina="./FPrincipal.jsp";
request.setAttribute("targetModulo",modulo);
String men="";
VentasN un= new VentasN();
request.setAttribute("mensaje",null);
request.setAttribute("listadoVentas", null);
request.setAttribute("datoVentas", null);


if("mostrar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Listado de datos "   ;
request.setAttribute("listadoVentas", un.listado());
} catch( Exception e){
// controlar la exepcion
Logger.getLogger(VentasServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a FUsuario.jsp
// botón buscar


if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar Venta : ";
request.setAttribute("listadoVentas", null);
request.setAttribute("datoVentas", un.getVentas(N_factura));
request.setAttribute("mensaje", men);
} catch( Exception e){
Logger.getLogger(VentasServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception
}// fin Buscar ---> Regresamos a FUsuario.jsp

if("grabar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="";
un.insertarVentas(new Ventas (N_factura,Nombre_vendedor,Porcentaje_IVA, N_Documento ));
//request.setAttribute("mensaje", null);
} catch( Exception e){
men+=""+e.getMessage();
/*INsertar un dato
* recuperando los datos a traves de su constructor
* es este caso Usuario(param1, param2, param3, param4, param5);
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

un.eliminarVentas(N_factura);
request.setAttribute("listadoVentas", un.listado());
}catch (Exception e){
men+=""+ e.getMessage(); 

}//fin exception 
}//fin eliminar


if("modificar".equals(request.getParameter("action"))){
try{
un.ActualizarVentas (new Ventas (N_factura,Nombre_vendedor,Porcentaje_IVA,N_Documento ));
Ventas entVen= new Ventas();
entVen.setN_factura("");
entVen.setNombre_vendedor("");
entVen.setPorcentaje_IVA("");
entVen.setN_Documento("");
request.setAttribute("datoVenta",entVen);
request.setAttribute("listadoVentas", un.listado());
men="Datos modificados";                            
} catch(Exception e){
men=""+e.getMessage();
//controlar la excepción
Logger.getLogger(VentasServlet.class.getName()).log(Level.SEVERE,null,e);
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
