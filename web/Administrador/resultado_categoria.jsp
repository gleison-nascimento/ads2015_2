<%-- 
    Document   : resultado_categoria
    Created on : Dec 1, 2016, 6:56:47 PM
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <hr>
        <%
            if (request.getAttribute("erro") == null) {
        %>
                <p style="color:blue"><%= request.getAttribute("msg")%></p>
                <a href="formBuscaCategoria.html">Voltar</a>
        <%
            } else {
        %>
                <p style="color:red">Ops. <%= request.getAttribute("erro")%></p>
                <a href="formCategoria.jsp?op=<%= request.getParameter("op")%>">Voltar</a>
        <%
            }
        %>
        
    </body>
</html>
