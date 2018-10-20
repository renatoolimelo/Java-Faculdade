<%-- 
    Document   : calculo
    Created on : 19/09/2018, 19:52:45
    Author     : internet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dias Vividos</title>
    </head>
    <body>
        <%
            String nome = request.getParameter("nomePessoa");
            int idade = Integer.parseInt(request.getParameter("idadePessoa"));
            int dias = idade*365;
            out.println("Você já viveu " + dias + " dias.");
        %>
    </body>
</html>
