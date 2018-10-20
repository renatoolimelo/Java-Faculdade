<%-- 
    Document   : mensagens
    Created on : 03/10/2018, 19:34:29
    Author     : internet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagens</title>
    </head>
    <body>
        <%
            String msg = (String)request.getAttribute("msg");
            out.print(msg);
        %>
    </body>
</html>
