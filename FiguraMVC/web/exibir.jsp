<%-- 
    Document   : exibir
    Created on : 26/09/2018, 19:25:03
    Author     : internet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <%
           Float r = (Float)request.getAttribute("resultado");
           out.print("Resultado: " + r.floatValue());
        %>
    </body>
</html>
