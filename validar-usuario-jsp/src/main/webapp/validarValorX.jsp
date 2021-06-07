<%@ page errorPage = "showError.jsp" %>
<html>
   <head>
      <title>Error Handling Example</title>
   </head>
   
   <body>
      <%
         int x = 1;
         if (x == 1) {
            throw new RuntimeException("Error condition!!!");
         }
      %>
   </body>
</html>