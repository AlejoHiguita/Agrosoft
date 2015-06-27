<%@page import="Agrosoft.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="Agrosoft.entidades.Mascotas"%>
<%@page import ="Agrosoft.utilidades.Tiempo"%>
<%@page import ="java.util.List"%>

<%
Usuario entUsuario =(Usuario) session.getAttribute("usuario");
String user = entUsuario.getUsuario();
String Codigo =request.getParameter("txtCodigo");
String Nombre =request.getParameter("txtNombre");   
String Genero =request.getParameter("txtGenero");   
String Peso =request.getParameter("txtPeso");
String Fecha_de_nacimiento =request.getParameter("txtFecha_de_nacimiento"); 
String Costo =request.getParameter("txtCosto");  
String men=(String)request.getAttribute("mensaje") !=null?(String)request.getAttribute("mensaje") :null;    
List<Mascotas>LM=
(List<Mascotas>) request.getAttribute("listadoMascotas")!=null?
(List<Mascotas>) request.getAttribute("listadoMascotas"):null;
Mascotas mimascota=
(Mascotas) request.getAttribute("datoMascotas")!=null?
(Mascotas) request.getAttribute("datoMascotas"):null;
 if(mimascota!=null){
 Codigo=mimascota.getCodigo();
 Nombre= mimascota.getNombre();
 Genero= mimascota.getGenero();
 Peso= mimascota.getPeso();
 Fecha_de_nacimiento= mimascota.getFecha_de_nacimiento();
 Costo=mimascota.getCosto();
  }else{
 Codigo="";
 Nombre ="";
 Genero="";
 Peso="";
 Fecha_de_nacimiento="";
 Costo="";
 }
 String ed =(String) request.getAttribute("edicion")!=null ?(String)request.getAttribute("edicion"):""; 
 String fechasistema = Tiempo.getFecha();


%>

<html>
<head>
<title> Mascotas </title>
  <link rel="stylesheet" type="text/css" href="estilo.css">
   <!--traer un script externo--->
   <script type="text/javascript" src="jsp/validar.js"></script>
</head>
<body>

<div style="width:100%; margin: 1 auto;  height: 300px; float:center;">
   
<center>
    <i id="titulo2">
    <h1>
    Mascotas 
    </h1>
</i>
</center>

<hr>
<form  name="frmmascotas" method="POST"  action="./MascotasServlet" >
       <div style="width: 20%; margin: 0 auto;  height:1px; float:left;">
       <jsp:include page="FBotones.jsp" flush="true"/>
   </div>
   <fieldset>
    
 <legend align= "center"><i>Información de la Mascota </i> </legend>
<center>
<table border="0">
<tr><center>
<td><label for="Codigo"> Código:</label></td>
<td><input type="text" name="txtCodigo" onkeypress="return numeros(event)" value="<%=Codigo%>"></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><label for="Nombre"> Nombre:</label></td>
<td><input type="text" name="txtNombre" onkeypress="return sololetras(event)" value="<%=Nombre%>"></td>
<br>
</tr>


<tr>
<td><label for="Genero"> Género:</label></td>
<td><input type="text" name="txtGenero" onkeypress="return sololetras(event)" value="<%=Genero%>"></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><label for="Peso"> Peso:</label></td>
<td><input type="text" name="txtPeso" onkeypress="return numeros(event)" value="<%=Peso%>"></td>
<br>
</tr>

<tr>
<td><label for="Fecha_de_nacimiento">Fecha de nacimiento:</label></td>
<td><input type="text" name="txtFecha_de_nacimiento" onkeypress="return numeros(event)" value="<%=Fecha_de_nacimiento%>"></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><label for="Costo">Costo:</label></td>
<td><input type="text" name="txtCosto" onkeypress="return numeros(event)" value="<%=Costo%>"></td>
<br>
</tr>

</table></center>

<br>
<p align=right>
(Todos los campos son obligatorios)
</p>
  
     </fieldset>  
</di> 

<br>

<center>
 <%if(LM!=null){%>
            <table border="1">
                <tr>
                    <td>Codigo:</td>
                    <td>Nombre:</td>
                    <td>Genero:</td>
                    <td>Peso:</td>
                    <td>Fecha de nacimiento:</td>
                    <td>Costo:</td>
                </tr>
                <!--Listar datos en jsp -->
             <%for(Mascotas us:LM){ %>
             <tr>
             <td><%=us.getCodigo()%> </td>
             <td><%=us.getNombre()%> </td>
             <td><%=us.getGenero() %> </td>
             <td><%=us.getPeso()  %> </td>
             <td><%=us.getFecha_de_nacimiento()  %> </td>
             <td><%=us.getCosto()  %> </td>
             <td><a href="./MascotasServlet?action=buscar&txtCodigo=<%=us.getCodigo()%>"><img height="20" src="imagenes/busca33333333333333333.png" width="20" /></a></td>    
             </tr>
             <%}%>  
            </table>
            <%}%>
            <table><tr><td><%=men  %></td></tr></table>



            </center>
 </form>
 
</div>
           
</body>

</html>

