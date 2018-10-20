<%-- 
    Document   : lista
    Created on : 03/10/2018, 19:34:15
    Author     : internet
--%>

<%@page import="modelo.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="solid">
            <tr><td>ID</td><td>Nome</td><td>Cargo</td><td>Salário</td></tr>
            <%
                List<Funcionario> lista = (List) request.getAttribute("resultado");
                for(Funcionario f:lista){
                    out.print("<tr>");
                    out.print("<td>" + f.getId() + "</td>");
                    out.print("<td>" + f.getNome() + "</td>");
                    out.print("<td>" + f.getCargo() + "</td>");
                    out.print("<td>" + f.getSalario() + "</td>");
                    out.print("</tr>");
                }
            %>
        </table>
    </body>
</html>
