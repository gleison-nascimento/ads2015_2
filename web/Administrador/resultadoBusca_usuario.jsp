<%-- 
    Document   : resultadoBusca_usuario
    Created on : Dec 1, 2016, 10:33:10 PM
    Author     : anderson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrs.modelo.bean.UsuariosBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        <h1>Resultado da Busca</h1>
        <hr>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Cpf</th>
                <th>Email</th>
                <th>Perfil</th>
                <th>Situação</th>
            </tr>
            <%
                List<UsuariosBean> lista = (ArrayList)request.getAttribute("lista");
                for (int i=0; i<lista.size(); i++) {
                    UsuariosBean usu = lista.get(i);
            %>
                    <tr>
                        <td><%= usu.getNome()%></td>
                        <td><%= usu.getCpf()%></td>
                        <td><%= usu.getEmail()%></td>
                        <td><%= usu.getPerfil()%></td>
                        <td><%= usu.getSituacao()%></td>
                        <td>
                            <a href="CategoriasControl?op=EDITAR&id=<%= usu.getCpf()%>">Editar</a>&nbsp;&nbsp;
                            <a href="CategoriasControl?op=EXCLUIR&id=<%= usu.getCpf()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                }
            %>
        </table>
        <a href="formBuscaUsuario.html">Voltar</a>
    </body>
</html>