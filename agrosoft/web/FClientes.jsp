
<%@page import="Agrosoft.utilidades.Tiempo"%>
<%@page import="java.util.List"%>
<%@page import="Agrosoft.entidades.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

String N_documento = request.getParameter("txtN_documento");
String Primer_nombre = request.getParameter("txtPrimer_nombre");
String Segundo_nombre = request.getParameter("txtSegundo_nombre");
String Apellidos = request.getParameter("txtApellidos");
String Tel_fijo = request.getParameter("txtTel_fijo");
String Tel_cel = request.getParameter("txtTel_cel");
String Direccion = request.getParameter("txtDireccion");
String Municipio = request.getParameter("cboMunicipio");
String Correo_elec = request.getParameter("txtCorreo_elec");

String mensaje = (String) request.getAttribute("mensaje");
String fechasistema = Tiempo.getFecha();

List<Clientes> LU =
(List<Clientes>) request.getAttribute("listadoClientes") != null
? (List<Clientes>) request.getAttribute("listadoClientes") : null;
Clientes miClientes =
(Clientes) request.getAttribute("datoClientes") != null
? (Clientes) request.getAttribute("datoClientes") : null;
if (miClientes != null) {
Primer_nombre = miClientes.getPrimer_nombre();
Segundo_nombre = miClientes.getSegundo_nombre();
Apellidos = miClientes.getApellidos();
N_documento = miClientes.getN_documento();
Tel_fijo = miClientes.getTel_fijo();
Tel_cel = miClientes.getTel_cel();
Direccion = miClientes.getDireccion();
Municipio = miClientes.getMunicipio();
Correo_elec = miClientes.getCorreo_elec();
N_documento = miClientes.getN_documento();
} else {
N_documento = "";
Primer_nombre = "";
Segundo_nombre = "";
Apellidos = "";
Tel_fijo = "";
Tel_cel = "";
Direccion = "";
Municipio = "";
Correo_elec = "";

}

%>


<HEAD>
<TITLE> Clientes  </TITLE> 
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<script type="text/javascript" src="js/validar.js"></script>   
<style type="text/css">

th{color:black;font-family: Arial;font-size: 100%;}
input{border-radius:3px;}
select{border-radius: 3px;}
</style>
</head>


<BODY>

<form name="frmcliente" method="POST"  action="./ClientesServlet" >
<center>
<i id="titulo2">
<h1>
Clientes
</h1>
</i>
</center>

<div style="width: 20%; margin: 0 auto;  height:1px; float:left;">
<jsp:include page="FBotones.jsp" flush="true"/>
</div>




<div style="width:50%; margin: 0 auto;  height: 300px; float:center;">
<FIELDSET>

<legend align="center"font-family="Arial"> Información de los clientes</legend>

<table ID="tableform">
<tr><th colspan="5">(Todos los campos marcados con * son obligatorios)

</TH></TR>
<tr>    </tr>
<tr>    </tr>
<tr>    </tr>




<TH> * Número de documento  </th><th>  <INPUT placeholder="  Numero de Documento * "Type="text"  value="<%=N_documento%>" name="txtN_documento"> </th>
<TH> * Primer nombre </TH><TH> <INPUT placeholder="  Primer nombre  * " Type="text" value="<%=Primer_nombre%>" name="txtPrimer_nombre">  </TH>  
</tr>
<TR><TH> Segundo nombre </TH><TH> <INPUT placeholder="  Segundo nombre  * " Type="text" value="<%=Segundo_nombre%>" name="txtSegundo_nombre"></TH> 
<TH>  * Apellidos  </th><TH> <INPUT placeholder="  Apellidos  * "Type="text" value="<%=Apellidos%>" name="txtApellidos"></TH> 
</TR>
<TR><TH>  * Teléfono fijo </th><th>  <INPUT placeholder="  Telefomo  * "Type="text" value="<%=Tel_fijo%>" name="txtTel_fijo"> </th>
<TH>  Teléfono celular </th><th> <INPUT placeholder="  Telefono Celular  * "Type="text" value="<%=Tel_cel%>"  name="txtTel_cel"></TH></tr>
<tr><TH>  * Dirección  </th><th>  
<INPUT placeholder="  Direccion  * " Type="text" value="<%=Direccion%>" name="txtDireccion"></th> 
<TH>  * Municipio </th>


<th> <select Type="cbo"   name="cboMunicipio"> 
<option value="<%=Municipio != null ? Municipio : ""%>"> </option> 
<option value="Medellin"> Municipio *</option> 
<option value="Medellin"> Medellin </option> 
<option value="Andes">Andes</option>
<option value="Armenia">Armenia</option> 
<option value="Barbosa">Barbosa</option> 
<option value="Bello">Bello</option> 
<option value="Otro"  >Otro</option>  
</select>   <TD ALIGN=CENTER> </TD> 
</tr>
<tr><th>   Correo electrónico </tH>
<th> <INPUT placeholder="  Correo Electronico  * " Type="text" value="<%=Correo_elec%>"  name="txtCorreo_elec"  </TH> 
</tr> 
</table> 
</FIELDSET>

</div>
<br>
<br>
<br>  
<br>


<%if (LU != null) {%>
<table border="1" ID="tableform">
<tr>
<td style="background:orange">N_documento</td>
<td style="background:orange">Primer_nombre</td>
<td style="background:orange">Segundo_nombre</td>
<td style="background:orange">Apellidos</td>
<td style="background:orange">Tel_fijo</td>
<td style="background:orange">Tel_cel</td>
<td style="background:orange">Direccion</td>
<td style="background:orange">Municipio</td>
<td style="background:orange">Correo_elec</td>
</tr>

<!--Listar datos en jsp -->
<%for (Clientes cli : LU) {%>
<tr>
<td><%=cli.getN_documento()%> </td>
<td><%=cli.getPrimer_nombre()%> </td>
<td><%=cli.getSegundo_nombre()%> </td>
<td><%=cli.getApellidos()%> </td>
<td><%=cli.getTel_fijo()%> </td>
<td><%=cli.getTel_cel()%> </td>
<td><%=cli.getDireccion()%> </td>
<td><%=cli.getMunicipio()%> </td>
<td><%=cli.getCorreo_elec()%> </td>
<td><a href="./ClientesServlet?action=buscar&txtcodigo=<%=cli.getN_documento()%>"><img height="20" src="imagenes/busca33333333333333333.png" width="20" /></a></td>



</tr>
<%}%>  
</table>
<%}%>
<table><tr><td></td></tr></table>




<%=mensaje%>

</p>




</FORM>
</body>
</html>