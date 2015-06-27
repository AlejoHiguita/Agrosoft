
<%@page import="Agrosoft.entidades.Mascotas"%>
<%@page import="Agrosoft.entidades.HistorialMedico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        String mensaje = (String) request.getAttribute("mensaje");
        String codigo_historial =request.getParameter("txtcodigo_historial");
        String codigo_mascota=request.getParameter("txtcodigo_mascota");
        String fecha_creacion =request.getParameter("txtfecha_creacion");
        String genero =request.getParameter("txtgenero");
        String peso =request.getParameter("txtpeso");
        String fecha_nacimiento =request.getParameter("txtfecha_nacimiento");
        String tipo_procedimiento=request.getParameter("cbotipo_procedimiento");
        String doctor=request.getParameter("txtdoctor");
        String nombre=request.getParameter("txtnombre");
        String dosis=request.getParameter("txtdosis");
        String observacion=request.getParameter("txtobservacion");
        String ed=(String)request.getAttribute("edicion");
        //Datos de mascota
        String Codigo =request.getParameter("txtCodigo");
        String Nombre =request.getParameter("txtNombre");   
        String Genero =request.getParameter("cboGenero");   
        String Peso =request.getParameter("txtPeso");
        String Fecha_de_nacimiento =request.getParameter("txtFecha_de_nacimiento"); 
        String Costo =request.getParameter("txtCosto");  
         
 List<HistorialMedico>LU=
(List<HistorialMedico>) request.getAttribute("listadoHistorialMedico")!=null?
(List<HistorialMedico>) request.getAttribute("listadoHistorialMedico"):null;
 HistorialMedico miHistorialMedico=(HistorialMedico) request.getAttribute("datoHistorialMedico")!=null?
(HistorialMedico) request.getAttribute("datoHistorialMedico"):null;
 if(miHistorialMedico!=null){
codigo_historial= miHistorialMedico.getcodigo_historial();
codigo_mascota= miHistorialMedico.getcodigo_mascota();
fecha_creacion= miHistorialMedico.getfecha_creacion();
genero =miHistorialMedico.getgenero ();
peso= miHistorialMedico.getpeso();
fecha_nacimiento=miHistorialMedico.getfecha_nacimiento();
tipo_procedimiento=miHistorialMedico.gettipo_procedimiento();
doctor=miHistorialMedico.getdoctor();
nombre=miHistorialMedico.getnombre();
dosis=miHistorialMedico.getdosis();
observacion = miHistorialMedico.getobservacion();

  }
 
 
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
  }
 
 


%>

<!DOCTYPE html>
<html>
<head>
<title>Historial Médico</title>
<script type="text/javascript" src="js/validar.js"></script> 

<link href="css/estilo.css" rel="stylesheet" type="text/css"> 

 <link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" href="css/style.css">
<script>
$(function() {
$( "#datepicker" ).datepicker();
});
</script>


</head>




<body>


  
   <center>
    <i id="titulo2">
    <h1>
       Historial Médico
    </h1>
    </i>
</center>
 <hr>

 <form name="Formulario" method="post" id="" action="./HistorialMedicoServlet">
        
   <div style="background:white; width:100%; margin: 5 auto;">
   <div style="width: 20%; margin: 0 auto;  height:1px; float:left;">
       <jsp:include page="FBotones.jsp" flush="true"/>
       <%=mensaje %>
   </div>
   <div style="width:50%; margin: 0 auto;  height: 300px; float:center;">
    
       <fieldset>
    
 <legend align= "center"><i>Información del Historial Médico</i> </legend>
    
<table border=0 ALIGN=center>

 <tr>
 </tr>
 
 <tr>
 </tr>
   
<tr>
        <td>Código de historia</td>
	<td>
	<input type=text name="txtcodigo_historial" onkeypress="return numeros(event)" value="<%=codigo_historial!=null?codigo_historial:"" %>" <%=ed%> >
	</td>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>
            
        <td>Código de mascota</td>
	<td>
	<input type="text" name="txtcodigo_mascota" value="<%=codigo_mascota%>" onkeypress="return numeros(event)" >
       <button style=' width:15px; height:15px; background:E9F764; border-radius:10px' type="submit"  name="action" value="buscarmascota">
</button>  

        </td>

</tr>

 <tr>
 </tr>
 <tr>
 </tr>

<tr>
            <td>Fecha de creación<br></td>
	<td></b><br>
	<input type="text" name="txtfecha_creacion" id="datepicker" value="<%=fecha_creacion%>"><br>
	</td>
        


        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>
      <td>Género</td>
        <td>
	<select name="cboGenero">
		<option value="Macho">Macho</option>
		<option value="Hembra">Hembra</option>
	</select>
	</td>

</tr>

<tr>
</tr>
<tr>
</tr>

<tr>
                 <td>Fecha de nacimiento</td>
	<td> <input type="text" name="txtfecha_nacimiento"value="<%=fecha_nacimiento!=null?fecha_nacimiento:""%>">
	</td>


        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>
        <td>Peso</td>
        <td> <input type=text name="txtpeso"  value="<%=peso%>">
	</td>
      
</tr>
<tr>  
    <td>Nombre<br></td>
	<td></b><br>
            <input type=text name="txtnombre" value="<%=nombre%>" onkeypress="return sololetras(event)" value="<%=nombre%>" ><br>
	</td>
     

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>
            
      <td>Tipo de procedimiento</td>
        <td>
	<select name="cbotipo_procedimiento" )>
		<option value="Vacuna">Vacuna</option>
		<option value="Desparacitacion">Desparacitación</option>
                <Option value="Otro">Otro</option>
	</select>
	</td>
       
</tr>

<tr>
         <td>Doctor<br></td>
	<td></b><br>
	<input type=text name="txtdoctor" value="<%=doctor%>"><br>
	</td>
        

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>
            
        <td>Observación<br></td>
	<td></b><BR>
	<textarea rows="3" name="txtobservacion" >
<%=observacion%>

        </textarea>
	</td>

</tr>
<tr>
             
        <td>dosis<br></td>
	<td></b><BR>
	<INPUT type=text name="txtdosis"value="<%=dosis%>"><br>
	</td>
        
        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>

        <td></td>
	<td></b><br>
            
        <td><br></td>
	

</tr>

</table>

       <p align=right >
(Todos los campos son obligatorios)
</p>

             </fieldset>  
</div>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
       
        
        
        <center>
            

     <%if(LU!=null){%>
            <table border="1" >
                <tr>                
                    <td style="background:orange" >Código de Historia</td>
                    <td style="background:orange" >Código de Mascota</td>
                    <td style="background:orange">Fecha de Creación</td>
                    <td style="background:orange">Género</td>
                    <td style="background:orange">peso</td>
                    <td style="background:orange">Fecha de Nacimiento</td>
                    <td style="background:orange">Tipo de Procedimiento</td>
                    <td style="background:orange">Doctor</td>
                    <td style="background:orange">Nombre</td>
                    <td style="background:orange">Dosis</td>
                    <td style="background:orange">Observación</td>
 
                    
                </tr>
                <!--Listar datos en jsp -->
             <%for(HistorialMedico us:LU){ %>
             <tr>
             <td><%=us.getcodigo_historial()%> </td>
             <td><%=us.getcodigo_mascota()%> </td>
             <td><%=us.getfecha_creacion()%> </td>
             <td><%=us.getgenero()%> </td>
             <td><%=us.getpeso()%> </td>
             <td><%=us.getfecha_nacimiento()%> </td>
             <td><%=us.gettipo_procedimiento()%> </td>
             <td><%=us.getdoctor()%> </td>
             <td><%=us.getnombre()%> </td>
             <td><%=us.getdosis()%> </td>
             <td><%=us.getobservacion()%> </td>
             <td><a href="./HistorialMedicoServlet?action=buscar&txtcodigo_historial=<%=us.getcodigo_historial()%>"><img height="20" src="imagenes/busca33333333333333333.png" width="20" /></a></td>
             </tr>
             <%}%>  
            </table>
             <%}%>
            <table><tr><td></td></tr></table>
 </div>
            </center>
</form>           
</body>
</html>