<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Pagina de verificacion de usuario</title>
    </head>
    <body>
        <h1>Verificando el usuario</h1>
        <%-- Include the ValidateUser.java class whose method 
             boolean validate(String, String) we will be using
        --%>
        <%-- Create and instantiate a bean and assign an id to 
             uniquely identify the action element throughout the jsp
        --%>
        <jsp:useBean id="validarUsuario" class="es.ejemplos.jpexposito.ValidarUsuario"/>
          >
        <jsp:setProperty name="validarUsuario" property="usuario"/>
        <jsp:setProperty name="validarUsuario" property="password"/>
          
        <%-- Display the form data --%>
        The Details Entered Are as Under<br/>
        <p>Username : <jsp:getProperty name="validarUsuario" property="usuario"/></p>
        <p>Password : <jsp:getProperty name="validarUsuario" property="password"/></p>
          
        <%-- Validate the user using the validate() of 
             ValidateUser.java class
        --%>
        <%if(validarUsuario.validate("GeeksforGeeks", "GfG")){%>
            Ok!,El usuario es valido<br/>
        <%}else{%>
            Error!,El usuario es Invalido<br/>
        <%}%>  
    </body>
</html>