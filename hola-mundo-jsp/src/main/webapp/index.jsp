
<%@page import="java.util.*"%>
<%! String cadena="Bienvenidos a JSP"; %>
<%! String cadenaHora="¿Que hora es?:"; %>
<html>
 <body>
 <h2> HOY HEMOS DADO UN PASO </h2>
 <p>
   <%= cadena %>
</p>
 <br> 
 <p>
<%= cadenaHora %> <% out.println(new Date()); %>
</p>
</body>
</html> 
