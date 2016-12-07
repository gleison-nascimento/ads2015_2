<%-- 
    Document   : resultadoBusca_categoria
    Created on : Dec 1, 2016, 6:59:38 PM
    Author     : anderson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrs.modelo.bean.CategoriasBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <h1>Resultado da Busca</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Situação</th>
            </tr>
            <%
                List<CategoriasBean> lista = (ArrayList)request.getAttribute("lista");
                for (int i=0; i<lista.size(); i++) {
                    CategoriasBean c = lista.get(i);
            %>
                    <tr>
                        <td><%= c.getNome()%></td>
                        <td><%= c.getDescricao()%></td>
                        <td><%= c.getSituacao()%></td>
                        <td>
                            <a href="CategoriasControl?op=EDITAR&id=<%= c.getId()%>">Editar</a>&nbsp;&nbsp;
                            <a href="CategoriasControl?op=EXCLUIR&id=<%= c.getId()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                }
            %>
        </table>
        <a href="formBuscaCategorias.html">Voltar</a>
    </body>
</html>
