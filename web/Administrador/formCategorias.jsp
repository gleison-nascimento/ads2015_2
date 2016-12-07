<%--
    Document   : formCategorias
    Created on : Dec 1, 2016, 6:29:05 PM
    Author     : anderson
--%>
<%@page import="br.edu.ifrs.modelo.bean.CategoriasBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <title>Categorias</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="validacoes.js" type="text/javascript"></script>
        <link href="Estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Categorias</h1>
        <hr>
        <div id="quadro">
            <%
                CategoriasBean categ = (request.getSession().getAttribute("categ") == null ? new CategoriasBean():(CategoriasBean)request.getSession().getAttribute("categ"));
            %>
            <form action="CategoriasControl">
            <%
                if (request.getParameter("op") != null && 
                    (request.getParameter("op").equals("EDITAR") || 
                    request.getParameter("op").equals("ATUALIZAR"))) { %>
                   <input type="hidden" name="op" value="ATUALIZAR">
                   <input type="hidden" name="id" value="<%= categ.getId()%>">
            <%
                } else { %>
                    <input type="hidden" name="op" value="INSERIR">
            <% 
                } %>
                
                <label for="nome">Nome da Categoria:</label>
                <input type="text" name="nome" id="nome" size="50" maxlength="200" value="<%= categ.getNome()%>"><br>

                <label for="descricao">Descrição:</label>
                <input type="text" name="descricao" id="descricao" size="100" maxlength="200" value="<%= categ.getDescricao()%>"><br>
                
                
                <label for="time">Situação:</label>
                <select name="situacao" id="situacao">
                    <option value="A" <%= (categ.getSituacao().equals("A") ? "selected":"")%>>Ativo</option>
                    <option value="I" <%= (categ.getSituacao().equals("I") ? "selected":"")%>>Inativo</option>
                </select><br>

                

                

                <input type="submit" value="Salvar">
                <input type="reset" value="Limpar">
            </form>
        </div>
    </body>
</html>