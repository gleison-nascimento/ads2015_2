<%--
    Document   : formUsuarios
    Created on : Dec 1, 2016, 7:50:50 PM
    Author     : anderson
--%>

<%@page import="br.edu.ifrs.modelo.bean.UsuariosBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <title>Usuários</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="validacoes.js" type="text/javascript"></script>
        <link href="Estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Usuários</h1>
        <hr>
        <div id="quadro">
            <%
                UsuariosBean usua = (request.getSession().getAttribute("usua") == null ? new UsuariosBean():(UsuariosBean)request.getSession().getAttribute("usua"));
            %>
            <form action="UsuariosControl">
            <%
                if (request.getParameter("op") != null && 
                    (request.getParameter("op").equals("EDITAR") || 
                    request.getParameter("op").equals("ATUALIZAR"))) { 
            %>
                   <input type="hidden" name="op" value="ATUALIZAR">
                   <input type="hidden" name="cpf" value="<%= usua.getCpf()%>">
            <%
                } else { 
            %>
                    <input type="hidden" name="op" value="INSERIR">
            <% 
                } %>
                
                <label for="nome">Nome do Usuário:</label>
                <input type="text" name="nome" id="nome" size="50" maxlength="200" value="<%= usua.getNome()%>"><br>
                <label for="rg">RG :</label>
                <input type="text" name="rg" id="rg" size="60" maxlength="200" value="<%= usua.getRg()%>"><br>
                <label for="cpf">CPF* :</label>
                <input type="text" name="cpf" id="cpf" size="60" value="<%= usua.getCpf()%>"><br>
                <label for="sexo">Sexo* :</label>
                            <input type="checkbox" name="sexo" id="sexo" value="<%= (usua.getSexo().equals("M")%>" />
                            <label>Masculino </label>
                            <input type="checkbox" name="sexo" id="sexo" value="<%= (usua.getSexo().equals("F")%>" />
                            <label>Feminino </label><br>
                <label for="endereco">Endereco Residencial* :</label>
                <input type="text" name="endereco" id="endereco" size="60" maxlength="200"  value="<%= usua.getEndereco()%>"><br>
                <label for="email">Email* :</label>
                <input type="text" name="email" id="email" size="60" maxlength="200"  value="<%= usua.getEmail()%>"><br>
                <label for="telres">Telefone Residencial :</label>
                <input type="text" name="telres" id="telres" size="60" maxlength="200"  value="<%= usua.getTelres()%>"><br>
                <label for="telcom">Telefone Comercial :</label>
                <input type="text" name="telcom" id="telcom" size="60" maxlength="200"  value="<%= usua.getTelcom()%>"><br>                          
                <label for="telcel">Telefone Celular :</label>
                <input type="text" name="telcel" id="telcel" size="60" maxlength="200"  value="<%= usua.getTelcel()%>"><br>  
                <label for="perfil">Perfil :</label>
                            <input type="checkbox" name="perfil" id="perfil" value="<%= (usua.getPerfil().equals("A")%>" disabled="disabled"/>
                            <label>Administrador </label>
                            <input type="checkbox" name="perfil" id="id" value="<%= (usua.getPerfil().equals("C")%>" checked="checked" disabled="disabled"/>
                            <label>Cliente </label><br>  
                <label for="username">Username :</label>
                <input type="text" name="username" id="username" size="60" maxlength="200"  value="<%= usua.getUsername()%>"><br>
                <label for="senha">Senha* (oito digitos) :</label>
                <input type="text" name="senha" id="senha" size="60" 
                <label for="senha1">Confirma Senha* (oito digitos) :</label>
                <input type="text" name="senha1" id="senha1" size="60"/>
                <%
                

                %>
                  <input type="text" name="senha" id="senha" size="60" value="<%= usua.getSenha()%>"><br>
            <%
               
                    
           
                } %>
                <label for="situacao">Situação* :</label>
                <select name="situacao" id="situacao">
                    <option value="A" <%= (usua.getSituacao().equals("A") ? "selected":"")%>>Ativo</option>
                    <option value="I" <%= (usua.getSituacao().equals("I") ? "selected":"")%>>Inativo</option>
                </select><br>
                <label for="observacao">Observações:</label>
                <textarea name="observacao" id="observacao" rows="4" cols="50" value="<%= usua.getObservacao()%>"></textarea><br>
                <label>* Campos Obrigatorios</label>
                

                <input type="submit" value="Salvar">
                <input type="reset" value="Limpar">
            </form>
        </div>
    </body>
</html>


                            
                           
                            
                            
                            
                                                
                           
                           
                                                  
                            
                          