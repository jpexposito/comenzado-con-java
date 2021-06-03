<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Pagina validacion Dni</title>
    </head>
    <body>
        <h1>Verificador dni</h1>
        <jsp:useBean id="validarDni" class="es.ejemplos.jpexposito.ValidarDni"/>
        <jsp:setProperty name="validarDni" property="dni"/>
          
        <p>Dni a validar: <jsp:getProperty name="validarDni" property="dni"/></p>

        <% if(validarDni.validar()) {%>
            El DNI es correcto<br/>
        <%} else {%>
            Error!! El DNI es incorrecto<br/>
        <%} %>
    </body>
</html>