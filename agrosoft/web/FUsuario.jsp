<%@page import="java.util.List"%>
<%@page import="Agrosoft.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    
String men=request.getAttribute("mensaje");
String user =request.getParameter("txtusuario");
String nombre =request.getParameter("txtnombre");   
String clave =request.getParameter("txtclave");   
String perfil =request.getParameter("cboperfil");
String estado =request.getParameter("cboestado"); 
        
List<Usuario>LU=
(List<Usuario>) request.getAttribute("listadoUsuarios")!=null?
(List<Usuario>) request.getAttribute("listadoUsuarios"):null;
Usuario miusuario=
(Usuario) request.getAttribute("datoUsuario")!=null?
(Usuario) request.getAttribute("datoUsuario"):null;
 if(miusuario!=null){
 nombre= miusuario.getNombre();
 clave= miusuario.getClave();
 perfil= miusuario.getPerfil();
 estado= miusuario.getEstado();
 user=miusuario.getUsuario();
  }else{
 nombre ="";
 clave="";
 estado ="";
 perfil="";
 
 }



%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración de Usuarios del sistema</title>
        <!---  traer un script externo-->
        <script type="text/javascript" src="js/validar.js">
        </script>
    </head>
    <body>
       
        <form  name="frmusuario" method="POST"  action="./UsuarioServlet" >
            <table border="1">
                    <tr>
                        <td>Usuario(*)</td>                                            <!--Al presionar tecla ---->   
                        <td><input type="text" name="txtusuario" maxlength="10" size="10"  value="<%=user%>" ></td>
                        <td>Nombre(*)</td>                                            <!--Al presionar tecla ---->   
                        
                        <td><input type="text" name="txtnombre" maxlength="20" size="10" onkeypress="return sololetras(event)" value="<%=nombre%>"> </td>

                    </tr>
                    <tr>
                        <td>Clave(*)</td>
                        <td><input type="text" name="txtclave" size="10" maxlength="5" value="<%=clave%>">  </td>
                        <td>Perfil(*)</td>
                        <td><select name="cboperfil">
                                <option value="">Seleccione</option>    
                                <option value="Admin">Administrador</option>    
                                <option value="Vendedor">Vendedor</option>    
                                <option value="Gerente">Gerente</option>    
                                <option value="Invitado">Invitado</option>    
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <td><select name="cboestado">
                                <option value="">Seleccione</option>      
                                <option value="Activo">Activo</option>
                                <option value="Inactivo">Inactivo</option>
                            </select>
                        </td>
                        <td></td>
                        <td></td>
                    </tr>
            </table>
                        <jsp:include page="FBotones.jsp" flush="true"/>    
           
            </form> 
         <%if(LU!=null){%>
            <table border="1">
                <tr>
                    <td>Usuario</td>
                    <td>Nombre</td>
                    <td>Clave</td>
                    <td>Perfil</td>
                    <td>Estado</td>
                </tr>
                <!--Listar datos en jsp -->
             <%for(Usuario us:LU){ %>
             <tr>
             <td><%=us.getUsuario()%> </td>
             <td><%=us.getNombre()%> </td>
             <td><%=us.getClave() %> </td>
             <td><%=us.getPerfil()  %> </td>
             <td><%=us.getEstado()  %> </td>
                 
             </tr>
             <%}%>  
            </table>
            <%}%>
            <table><tr><td></td></tr></table>
    </body>
</html>
                             