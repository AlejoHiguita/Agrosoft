
<%@page import="Agrosoft.utilidades.Tiempo"%>
<%@page import="Agrosoft.entidades.Usuario"%>
<%
String fechasistema = Tiempo.getFecha();
String nombre= "";    
String user = "";
nombre = "";
String perfil = "";
String estado = "";
Usuario entUsuario =(Usuario) session.getAttribute("usuario");
if(entUsuario!=null ){

user = entUsuario.getUsuario();
nombre = entUsuario.getNombre();
perfil = entUsuario.getPerfil();
estado = entUsuario.getEstado();
}else{
nombre= "visitante";    
user = "";
nombre = "";
perfil = "";
estado = "";
}
%>

<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="css/styles_1.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="js/script_1.js"></script>
   <title>Menu</title>
</head>
<body>

Perfil iniciado:
<% if(!"0".equals(user)){%>      
<%=nombre%>
<% if(!"Inactivo".equals(estado)){%>      
<% if("Admin".equals(perfil)){%> 
<table>
<tr>
<td>Fecha sistema: </td>
<td><input type="text" name="txtfechasistema"     readonly   maxlength="10" size="10" value="<%=fechasistema%>"   ></td>
</tr>
</table>


<div id='cssmenu'>
<ul>
    <li><a><b><br></b></a></li>
     <li><a><b><br></b></a></li>
     <li><a><b><br></b></a></li>
     <li><a><b><br></b></a></li>
    <li><a  href="./ArticuloServlet?action=mostrar" title="Articulos">Articulos</a></li>
   <li><a href="./UsuarioServlet?action=mostrar"  title="Usuarios">Usuarios</a></li>
   <li><a href="./ClientesServlet?action=mostrar" title="Clientes">Clientes</a></li>
   <li><a href="./VentasServlet?action=mostrar" title="Ventas">Ventas</a></li>
   <li><a href="./ProveedorServlet?action=mostrar" title="Proveedores">Proveedores</a></li>
   <li><a href="./MascotasServlet?action=mostrar" title="Mascota">Mascota</a></li>
   <%}%>
   <li><a href="./UsuarioServlet?action=salir" title="Cerrar sesion">Cerrar Sesion</a></li>
   <%}else{%>

<%}%>
<%}else{%>

<%}%>
<li><a><b><br></b></a></li>
     <li><a><b><br></b></a></li>
      <li><a><b><br></b></a></li>
</ul>
</div>
<br>
<hr>
</body>


