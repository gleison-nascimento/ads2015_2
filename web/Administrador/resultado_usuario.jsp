<%-- 
    Document   : resultado_usuario
    Created on : Dec 1, 2016, 10:30:57 PM
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
                <a href="formBuscaUsuario.html">Voltar</a>
        <%
            } else {
        %>
                <p style="color:red">Ops. <%= request.getAttribute("erro")%></p>
                <a href="formUsuario.jsp?op=<%= request.getParameter("op")%>">Voltar</a>
        <%
            }
        %>
        
    </body>
</html>
