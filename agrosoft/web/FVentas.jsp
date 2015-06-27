
<%@page import="Agrosoft.entidades.Ventas"%>
<%@page import="Agrosoft.utilidades.Tiempo"%>
<%@page import="java.util.List"%>
<%@page import="Agrosoft.entidades.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 
String N_factura =request.getParameter("txtN_factura");     
String Nombre_vendedor =request.getParameter("txtNombre_vendedor");   
String Porcentaje_IVA =request.getParameter("txtPorcentaje_IVA");
String N_Documento =request.getParameter("txtN_Documento");   
String mensaje = (String)request.getAttribute ("mensaje");
String fechasistema = Tiempo.getFecha();

List<Ventas>LV=
(List<Ventas>) request.getAttribute("listadoVentas")!=null?
(List<Ventas>) request.getAttribute("listadoVentas"):null;
Ventas miVentas=
(Ventas) request.getAttribute("datoVentas")!=null?
(Ventas) request.getAttribute("datoVentas"):null;
 
if(miVentas!=null){
 N_factura= miVentas.getN_factura();
 Nombre_vendedor = miVentas.getNombre_vendedor();
 Porcentaje_IVA = miVentas.getPorcentaje_IVA();
 N_Documento= miVentas.getN_Documento();
 

  }else{
 N_factura="";
 Nombre_vendedor="";
 Porcentaje_IVA ="";
 N_Documento="";
 
 }

 
%>

<html>


<HEAD>
<TITLE> Ventas  </TITLE> 
</head>

    <link rel="stylesheet" type="text/css" href="css/estilo.css">
    
<script type="text/javascript" src="js/validar.js"></script>   
</head>
    <h1 id="titulo">
        Ventas
</h1>


   <form name="formularioVentas" method="POST" action="./VentasServlet" >
       <hr>
  <div style="width: 20%; margin: 0 auto;  height:1px; float:left;">
       <jsp:include page="FBotones.jsp" flush="true"/>
   </div>
      <div style="width:70%; margin: 0 auto;  height: 300px; float:center;">
 <FIELDSET>
            
            <legend aling="center"> <i> Informacion de ventas </i> </legend>
        <table ID="tableform">
<TR>

 <TH> # de factura  </tH>
<TH> <INPUT Type="text" value="<%=N_factura%>" name="txtN_factura"> <br> </TH>

<th> Fecha <input type="text" name="txtfechasistema"  </th>

<th> Porcentaje IVA </th>
<TH> <INPUT Type="text" value="<%=Porcentaje_IVA %>" name="txtPorcentaje_IVA"> <BR> </TH>

             
</TR>

<TR>
<TH> Nombre  </th>
<TH> <INPUT Type="text" value=" name="txtPrimer_nombre"> <BR> </TH> 

<TH> Identificacion   </TH>
<TH> <INPUT Type="text" value="<%= N_Documento %>" name="txtN_Documento"> <BR> </TH> 
</TR>


<tr>
<TH>  Apellidos </th>
<th>  <INPUT Type="text" value=" name="txtApellidos"> <BR> </th>


<TH>  Telefono fijo </label> </th>
<th> <INPUT Type="text" value="  name="txtTel_fijo"> <BR> </TH>
</tr>

<tr>
<br>
<TH> Direccion </th>
<TH> <INPUT Type="text" value="  name="txtDireccion"> <BR> </TH>

<TH>  Vendedor </tH>
<TH> <INPUT Type="text" value="<%= Nombre_vendedor %>" name="txtNombre_vendedor"> <BR> </TH>
</th>
</tr> 

</table>

</FIELDSET>
      </div>

       
       


<%if(LV!=null){%>
            <table border="1" ID="tableform">
                <tr>
                    <td></td>
                    <td>Numero de factura</td>
                    <td>Nombre del vendedor</td>
                    <td>Porcentaje IVA</td>
                    <td>Identificacion</td>
                    <td>Primer nombre</td>
                    <td>Apellidos</td>
                    <td>Telefono fijo</td>
                    <td>Direccion</td>
                </tr>
              
                <!--Listar datos en jsp -->
             <%for(Ventas Ven:LV){ %>
             <tr>
             <td><%=Ven.getN_factura()%> </td>
             <td><%=Ven.getNombre_vendedor()%> </td>
             <td><%=Ven.getPorcentaje_IVA()%> </td>
             <td><%=Ven.getN_Documento()%> </td>
            
             
             
             </tr>
             <%}%>  
            </table>
            <%}%>
            <table><tr><td></td></tr></table>
            

 

<%=mensaje%>



<br>
<br>

</form>
</body>
</html>