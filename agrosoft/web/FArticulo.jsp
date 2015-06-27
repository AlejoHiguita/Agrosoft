
<%@page import="Agrosoft.entidades.Articulo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String mensaje = (String) request.getAttribute("mensaje");
String codigo =request.getParameter("txtcodigo");
String nombre =request.getParameter("txtnombre");
String descripcion =request.getParameter("txtdescripcion");
String observacion =request.getParameter("txtobservacin");
String precio =request.getParameter("txtprecio");
String codigo_mascota=request.getParameter("txtcodigo_mascota");
String ed=(String)request.getAttribute("edicion");

List<Articulo>LU=
(List<Articulo>) request.getAttribute("listadoArticulo")!=null?
(List<Articulo>) request.getAttribute("listadoArticulo"):null;
Articulo miarticulo=(Articulo) request.getAttribute("datoArticulo")!=null?
(Articulo) request.getAttribute("datoArticulo"):null;
if(miarticulo!=null){
codigo= miarticulo.getCodigo();
nombre= miarticulo.getNombre();
descripcion=miarticulo.getDescripcion();
observacion = miarticulo.getObservacion();
precio= miarticulo.getPrecio();
codigo_mascota =miarticulo.getCodigo_mascota();
}else{
codigo ="";
nombre ="";
descripcion="";
observacion="";
precio="";
codigo_mascota="";
}

%>
<!DOCTYPE html>
<html>
<head>
<title>Artículos</title>
<link href="css/estilo.css" rel="stylesheet" type=""text/css">
<script type="text/javascript" src="js/validar.js"></script>  

<style type="text/css">
input{border-radius: 4px;}
</style>

</head>


<body>

<div style=" width:110%; top:15%;left: 5%;height:105% ;">
<center>
<i id="titulo2">
<h1>
Artículos
</h1>
</i>
</center>




<form name="Formulario" method="post" id="" action="./ArticuloServlet">


<div style="width: 20%; margin: 0 auto;  height:1px; float:left;">
<jsp:include page="FBotones.jsp" flush="true"/>
</div>

<div style="width:60%; margin: 0 auto;  height: 300px; float:center;">

<fieldset>

<legend align= "center">Información del Aríticulo </legend>

<table border=0 ALIGN=center>



<tr>
<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td></td>
</tr>

<tr>
</tr>
<tr>
</tr>

<tr>
<td>Código<br></td>
<td></b><br>
<input type=text name="txtcodigo" placeholder="  Codigo  * "value="<%=codigo%>"   <%=ed%> onkeypress="return numeros(event)" ><br>
</td>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td>Nombre<br></td>
<td></b><br>
<input type="text" name="txtnombre"placeholder="  Nombre  * " value="<%=nombre%>" onkeypress="return sololetras(event)"><br>
</td>
</tr>

<tr>
</tr>
<tr>
</tr>

<tr>
<td>Descripción<br></td>
<td></b><br>
<input type=text name="txtdescripcion" placeholder="  Descripcion  * "value="<%=descripcion%>"><br>
</td>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td>Observación<br></td>
<td></b><br>
<input type=text name="txtobservacion" placeholder="  Observacion  * "value="<%=observacion%>"><br>
</td>
</tr>

<tr>
</tr>
<tr>
</tr>

<tr>
<td>Precio<br></td>
<td></b><br>
<input type=text name="txtprecio"placeholder="  Precio  * " value="<%=precio%>"onkeypress="return numeros(event)" ><br>
</td>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td></td>
<td></b><br>

<td>Código de mascota<br></td>
<td></b><br>
<input type=text name="txtcodigo_mascota"placeholder="  Codigo Mascota  * " value="<%=codigo_mascota%>"onkeypress="return numeros(event)" ><br>
</td>
</tr>
</table>



<p align=right>
(Todos los campos marcados con (*)son obligatorios)
</p>

</div>
</fieldset>  

<div style="width:100%; margin: 0 auto;  height: 300px; float:right;">
<br>
<br>
<br> 
<center>
<%if (LU != null) {%>
<table border="1" >
<tr>                
<td style="background:orange" >Código</td>
<td style="background:orange">Nombre</td>
<td style="background:orange">Descripción</td>
<td style="background:orange">Observación</td>
<td style="background:orange">Precio</td>
<td style="background:orange">Código de mascota</td>

</tr>
<!--Listar datos en jsp -->
<%for (Articulo us : LU) {%>
<tr>
<td><%=us.getCodigo()%> </td>
<td><%=us.getNombre()%> </td>
<td><%=us.getDescripcion()%> </td>
<td><%=us.getObservacion()%> </td>
<td><%=us.getPrecio()%> </td>
<td><%=us.getCodigo_mascota()%> </td>
<td><a href="./ArticuloServlet?action=buscar&txtcodigo=<%=us.getCodigo()%>"><img height="20" src="imagenes/busca33333333333333333.png" width="20" /></a></td>
</tr>
<%}%>  
</table>
<%}%>
<table><tr><td></td></tr></table>
</center>
</div>
</div>
</form>           
</body>
</html>