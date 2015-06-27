<%
String mensajeError = (String) request.getAttribute("mensajeError");

String clave =request.getParameter("txtclave");
String usuario = request.getParameter("txtusuario") == null ? "" : request.getParameter("txtusuario");
//String usuario = request.getParameter("usuario");
%>

<head>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>

<script LANGUAGE= "javascript" TYPE="text/javascript" src="./scripts/validar.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Inicio de sesión</title>

  <link rel="stylesheet" href="css/reset.css">

    
        <link rel="stylesheet" href="css/style.css">
        
</head>

<body>
    
<form id="fondoformulario" name ="xForm" method="POST" action="./Autenticacion" Onsubmit= "return valida_envia();"/>
 
<center>
 <div class="wrap">
		<div class="avatar">
      <img src="imagenes/gato.jpg">
		</div>
		<input name="txtusuario" type="text" placeholder="Usuario" class="texto" value="<%=usuario%>" required>
		<div class="bar">
			<i></i>
		</div>
		<input name="txtclave" type="password" class="texto" placeholder="Clave" required>
                <br>
		<button name="action" value="ingresar">Ingresar</button>
                <br>
                <%if (mensajeError != null) {%>
                <%=mensajeError%>   
                <%}%>
	</div>
</center> 
  </body>
    
</form>



