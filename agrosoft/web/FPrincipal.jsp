<%
String targetModulo = request.getAttribute("targetModulo") == null ? "FUsuario.jsp":(String)request.getAttribute("targetModulo");

%>
  <link rel="stylesheet" type="text/css" href="css/estilo.css"/>    
  <body>
      
      <nav>
  <jsp:include page="FMenu.jsp" flush="true"></jsp:include>
      </nav>
      
       <section id="contenido">
          <jsp:include page="<%=targetModulo%>" flush="true"></jsp:include>   
       </section>

    
</html>

  </body>