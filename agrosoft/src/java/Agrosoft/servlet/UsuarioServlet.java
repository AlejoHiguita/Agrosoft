package Agrosoft.servlet;

import Agrosoft.entidades.Usuario;
import Agrosoft.negocio.UsuarioN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UsuarioServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String user =request.getParameter("txtusuario");
String nombre =request.getParameter("txtnombre");   
String clave =request.getParameter("txtclave");   
String perfil =request.getParameter("cboperfil");
String estado =request.getParameter("cboestado"); 
String modulo ="FUsuario.jsp";
String pagina="./FPrincipal.jsp";
request.setAttribute("targetModulo", modulo);
String men="";
UsuarioN un = new  UsuarioN();  
request.setAttribute("mensaje", null);
request.setAttribute("listadoUsuarios", null);
request.setAttribute("datoUsuario", null);

if("salir".equals(request.getParameter("action"))){
request.getSession().invalidate();
request.setAttribute("targetModulo","./FloginBox.jsp");
request.getRequestDispatcher("./index.jsp").forward(request, response);
}



if("grabar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="";
un.insertarUsuario(new Usuario(user, nombre, clave, perfil, estado));
//request.setAttribute("mensaje", null);
} catch( Exception e){
men+=""+e.getMessage();
/*Insertar un dato
* recuperando los datos a traves de su constructor
* es este caso Usuario(param1, param2, param3, param4, param5);
*/

} // fin exception
}// fi  guardar
// para mostrar todos(boton Mostrar)

if("mostrar".equals(request.getParameter("action"))){
try{
// a quí el codigo a controlar
men="Listado de datos "   ;
request.setAttribute("listadoUsuarios", un.listado());
request.setAttribute("mensaje", men);

} catch( Exception e){
// controlar la exepcion
Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a FUsuario.jsp
// botón buscar


if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar a usuario : "+user   ;
request.setAttribute("listadoUsuarios", null);
request.setAttribute("datoUsuario", un.getUsuario(user));
request.setAttribute("mensaje", men);
} catch( Exception e){
Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());
} // fin exception
}// fin Buscar ---> Regresamos a FUsuario.jsp


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
