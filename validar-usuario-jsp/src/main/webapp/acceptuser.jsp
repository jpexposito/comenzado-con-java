<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Pagina de verificacion de usuario</title>
    </head>
    <body>
        <h1>Verificacion Usuario</h1>

        <jsp:useBean id="validarUsuario" class="es.ejemplos.jpexposito.ValidarUsuario"/>
        
        <jsp:setProperty name="validarUsuario" property="usuario"/>
        <jsp:setProperty name="validarUsuario" property="password"/>
          
        
        Información del usuario<br/>
        <p>Username : <jsp:getProperty name="validarUsuario" property="usuario"/></p>
        <p>Password : <jsp:getProperty name="validarUsuario" property="password"/></p>
          
        <%if(validarUsuario.validate()){%>
            Ok! El usuario es valido<br/>
        <%}else{%>
            Error! El usuario es Invalido<br/>
        <%}%>  
    </body>
</html>