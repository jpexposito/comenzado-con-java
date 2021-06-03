<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Página de Login</title>
    </head>
    <body>
        <h1>Detalles del Usuario</h1>
        <form method ="get" action="acceptuser.jsp">
            Usuario : <input type="text" name="usuario"><br/><br/>
            Contraseña : <input type="password" name ="password"><br/>
                <input type ="submit" value="SUBMIT">    
        </form>
    </body>
</html>

