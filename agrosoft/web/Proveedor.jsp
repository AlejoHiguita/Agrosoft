<%@page import="Agrosoft.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="Agrosoft.entidades.Proveedor"%>
<%@page import ="Agrosoft.utilidades.Tiempo"%>
<%@page import ="java.util.List"%>

<%
Usuario entUsuario =(Usuario) session.getAttribute("usuario");
String user = entUsuario.getUsuario();
String Identificacion =request.getParameter("txtIdentificacion");
String Nombre =request.getParameter("txtNombre");   
String Direccion =request.getParameter("txtDireccion");   
String Celular =request.getParameter("txtCelular");
String Telefono_fijo =request.getParameter("txtTe_fijo"); 
String Correro_electronico =request.getParameter("txtCorrero_electronico"); 
String Nombre_contacto =request.getParameter("txtNombre_contacto"); 
String Telefono_contacto =request.getParameter("txtTelefono_contacto"); 
String men=(String)request.getAttribute("mensaje") !=null?(String)request.getAttribute("mensaje") :null;    
List<Proveedor>LU=
(List<Proveedor>) request.getAttribute("listadoProveedor")!=null?
(List<Proveedor>) request.getAttribute("listadoProveedor"):null;
Proveedor miproveedor=
(Proveedor) request.getAttribute("datoProveedor")!=null?
(Proveedor) request.getAttribute("datoProveedor"):null;
if(miproveedor!=null){
Identificacion=miproveedor.getIdentificacion();
Nombre= miproveedor.getNombre();
Direccion= miproveedor.getDireccion();
Celular= miproveedor.getCelular();
Telefono_fijo= miproveedor.getTelefono_fijo();
Correro_electronico=miproveedor.getCorrero_electronico();
Nombre_contacto=miproveedor.getNombre_contacto();
Telefono_contacto=miproveedor.getTelefono_contacto();
}else{
Identificacion="";
Nombre ="";
Direccion="";
Celular="";
Telefono_fijo="";
Correro_electronico="";
Nombre_contacto="";
Telefono_contacto="";
}
String ed =(String) request.getAttribute("edicion")!=null ?(String)request.getAttribute("edicion"):""; 
String fechasistema = Tiempo.getFecha();


%>

<html>


<head>
<title>Proveedor</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<!--traer un script externo--->
<script type="text/javascript" src="js/validar.js"></script>
<style type="text/css">
input{border-radius: 3px;}
select{boreder-radius:3px;}

</style>
</head>
<body>

<i id="titulo2">
<center>
<h1 >
Proveedor
</h1>
</center>
</i>

<form  name="frmproveedor" method="POST"  action="./ProveedorServlet" >
<hr>
<div style="width: 20%; margin: 0 auto;  height:1px; float:left;">
<jsp:include page="FBotones.jsp" flush="true"/>
</div>



<div style="width:60%; margin: 1 auto;  height: 300px; float:center;">

<fieldset>

<legend align= "center">Información del Proveedor  </legend>    

<table>         
<tr>
<td><label for="Identificacion"> Identificación:</label></td>
<td> <input  placeholder="  Identificacion *"type="text" name="txtIdentificacion" onkeypress="return numeros(event)" value="<%=Identificacion%>"> </td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td> <label for="Nombre"> Nombre:</label></td>
<td> <input  placeholder="  Nombre *" type="text" name="txtNombre" onkeypress="return sololetras(event)" value="<%=Nombre%>" ></td> 
<br>
</tr>
<tr>
<td><label for="Direccion"> Dirección:</label></td>
<td> <input  placeholder="  Direccion *" type="text" name="txtDireccion" value="<%=Direccion%>" > </td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><label for="Celular"> Celular:</label></td>
<td>  <input type="text" placeholder="  Celular *" name="txtCelular" onkeypress="return numeros(event)" value="<%=Celular%>"> </td> 
<br>
</tr>
<tr>
<td><label for="Telefono_fijo"> Teléfono Fijo:</label></td>
<td> <input type="text" name="txtTe_fijo"  placeholder="  Telefono fijo *"onkeypress="return numeros(event)" value="<%=Telefono_fijo%>"></td> 
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><label for="Correro_electronico"> Correo Electrónico:</label></td>
<td> <input type="text" name="txtCorrero_electronico"  placeholder="  Correo Electronico *"value="<%=Correro_electronico%>"></td>
</tr>
<tr>
<td><label for="Nombre_contacto"> Nombre Contacto:</label></td>
<td>  <input type="text" name="txtNombre_contacto"  placeholder="  Nombre Contacto *"onkeypress="return sololetras(event)" value="<%=Nombre_contacto%>"> </td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><label for="Telefono_contacto"> Teléfono Contacto:</label></td>
<td> <input type="text" name="txtTelefono_contacto"  placeholder="  Telefono Contacto *" onkeypress="return numeros(event)" value="<%=Telefono_contacto%>"></td>
</table>
</center>

<p align=right>
(Todos los campos son obligatorios)
<p>

</fieldset>  
</div>
<br>




<%if(LU!=null){%>
<table border="1">
<tr>
<td>Identificación</td>
<td>Nombre</td>
<td>Dirección</td>
<td>Celular:</td>
<td>Teléfono Fijo:</td>
<td>Correo Electrónico:</td>
<td>Nombre Contacto:</td>
<td>Teléfono Contacto:</td>
</tr>
<!--Listar datos en jsp -->
<%for(Proveedor us:LU){ %>
<tr>
<td><%=us.getIdentificacion()%> </td>
<td><%=us.getNombre()%> </td>
<td><%=us.getDireccion() %> </td>
<td><%=us.getCelular()  %> </td>
<td><%=us.getTelefono_fijo()  %> </td>
<td><%=us.getCorrero_electronico()  %> </td>
<td><%=us.getNombre_contacto()  %> </td>
<td><%=us.getTelefono_contacto()  %> </td>
<td><a href="./ProveedorServlet?action=buscar&txtIdentificacion=<%=us.getIdentificacion()%>"><img height="20" src="imagenes/busca33333333333333333.png" width="20" /></a></td>    
</tr>
<%}%>  
</table>
<%}%>
<table><tr><td><%=men  %></td></tr></table>


</form>



</body>
</html>