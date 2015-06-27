package Agrosoft.servlet;

import Agrosoft.entidades.Mascotas;
import Agrosoft.entidades.Usuario;
import Agrosoft.negocio.MascotasN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MascotasServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String Codigo =request.getParameter("txtCodigo");
String Nombre =request.getParameter("txtNombre");   
String Genero =request.getParameter("txtGenero");   
String Peso =request.getParameter("txtPeso");
String Fecha_de_nacimiento =request.getParameter("txtFecha_de_nacimiento"); 
String Costo =request.getParameter("txtCosto");   
String modulo ="Mascotas.jsp";
String pagina="./FPrincipal.jsp";
request.setAttribute("targetModulo",modulo );

String men="";
MascotasN un = new  MascotasN();  
request.setAttribute("mensaje", null);
request.setAttribute("listadoMascotas", null);
request.setAttribute("datoMascotas", null);
request.setAttribute("edicion", ""); 


if("grabar".equals(request.getParameter("action"))){
try{
// a quÃ­ el codigo a controlar
men="";
/*Insertar un dato
recuperando los datos a travÃ©z de su constructor
* Es este caso Usuario(param1,param2,param3,param4,param5);
*/
un.insertarMascota(new Mascotas(Codigo,Nombre,Genero,Peso,Fecha_de_nacimiento,Costo));
Mascotas entMas= new Mascotas();
entMas.setCodigo("");
entMas.setNombre("");
entMas.setGenero("");
entMas.setPeso("");
entMas.setFecha_de_nacimiento("");
entMas.setCosto(""); 
request.setAttribute("datoMascotas",entMas);
request.setAttribute("listadoMascotas", un.listado());
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
request.setAttribute("listadoMascotas", un.listado());
request.setAttribute("mensaje", men);

} catch( Exception e){
// controlar la exepcion
Logger.getLogger(Agrosoft.servlet.MascotasServlet.class.getName()).log(Level.SEVERE,null,e);
request.setAttribute("mensaje", e.getMessage());

} // fin exception
}// fin Mostrar todos ---> Regresamos a Proveedor.jsp
// botón buscar


if("buscar".equals(request.getParameter("action"))){
try{
men="Buscar a Mascota: "+Codigo  ;
request.setAttribute("listadoMascotas", null);
request.setAttribute("datoMascotas", un.getMascota(Codigo ));
request.setAttribute("edicion","readonly");
request.setAttribute("mensaje", men);
} catch( Exception e){
Logger.getLogger(Agrosoft.servlet.MascotasServlet.class.getName()).log(Level.SEVERE,null,e);
men= ""+ e.getMessage();
} // fin exception
}// fin Buscar 

if("nuevo".equals(request.getParameter("action"))){
try{
Mascotas entMas = new Mascotas();
entMas.setCodigo(""); 
entMas.setNombre("");   
entMas.setGenero(""); 
entMas.setPeso("");
entMas.setFecha_de_nacimiento("");
entMas.setCosto("");
request.setAttribute("datoMascotas",entMas);
request.setAttribute("edicion","");
request.setAttribute("listadoMascotas", null);


} catch( Exception e){
Logger.getLogger(MascotasServlet.class.getName()).log(Level.SEVERE,null,e);
men= ""+ e.getMessage();
} // fin exception
}// fin Buscar 

if("modificar".equals(request.getParameter("action"))){
try{
un.actualizarMascota(new Mascotas(Codigo,Nombre,Genero,Peso,Fecha_de_nacimiento,Costo));
Mascotas entMas= new Mascotas();
entMas.setCodigo("");
entMas.setNombre("");
entMas.setGenero("");
entMas.setPeso("");
entMas.setFecha_de_nacimiento("");
entMas.setCosto(""); 
request.setAttribute("datoMascotas",entMas);
request.setAttribute("listadoMascotas", un.listado());
men="Datos modificados";


} catch(Exception e){
//controlar la excepción
Logger.getLogger(MascotasServlet.class.getName()).log(Level.SEVERE,null,e);
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
