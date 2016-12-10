<%-- 
    Document   : resultadoBuscaMeusPedidos
    Created on : 27/11/2016, 13:02:36
    Author     : levymarcelo
--%>

<%@page import="br.edu.ifrs.modelo.bean.PedidosBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrs.modelo.bean.UsuariosBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Meus Pedidos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="Estilos/Estilo.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        
    </head>
    <body>
                <img src="Imagens/Loj-o-Oba-Oba.png" class="img-responsive" style="width:100%" alt="ImageBanner"/>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!--<a class="navbar-brand" href="#">Logo</a>-->
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.html">Home</a></li>
                        <li><a href="#">Institucional</a></li>
                        <li><a href="formProdutos.html">Produtos</a></li>
                        <li><a href="formMeusPedidos.html">Meus Pedidos</a></li>
                        <li><a href="#">Administração</a></li>
                        <li><a href="formFaleConosco.html">Fale Conosco</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sua Conta</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="col-sm-5">
            <div class="panel panel-primary" >
                <div class="panel-heading" align="center">Pesquisar Meus Pedidos</div>
                <div class="panel-body" ><form action="MeusPedidosControl" > <!-- onsubmit="return validarForm();"-->
                        <label class="formulario" for="nome">Nome:</label>
                        <input type="text" name="nome" id="nome" size="29"><br>

                        <label class="formulario" for="data_emissao">Data de emissão:</label>
                        <input type="date" name="data_emissao">

                        <br>
                        <div  class="panel-footer" align="center">
                            <input type="submit" value="Pesquisar">
                            <input type="reset" value="Limpar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-12" align="center">
            <div class="panel panel-primary" align="center">
                <div class="panel-heading" >Meus Pedidos</div>
                <div class="panel-body"><form action="MeusPedidos"> <!-- onsubmit="return validarForm();"-->
                        <table border="1">
                            <tr>
                                <th>Número do pedido</th>
                                <th>Nome do cliente</th>
                                <th>Data de emissão</th>
                                <th>valor total</th>
                                <th>Ações</th>
                            </tr>
                            <%
                            List<UsuariosBean> lista = (ArrayList)request.getAttribute("lista");
                                for (int i=0; i<lista.size(); i++) {
                                    UsuariosBean u = lista.get(i);
                                    
                                    
                            List<PedidosBean> lista2 = (ArrayList)request.getAttribute("lista2");
                                for (int j=0; j<lista2.size(); j++) {
                                    PedidosBean p = lista2.get(j);



                                    %>
                                    <tr>
                                        <td><%= u.getNome()%></td>
                                        <td><%= p.getId()%></td>
                                        <td><%= p.getData_emissao()%></td>
                                        <td><%= p.getValor_total()%></td>
                                        <td>
                                            <a href="MeusPedidosControl?op=EDITAR&id=<%= p.getId()%>">Editar</a>&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                    <%
                                    }
                                    %>
                        </table>
                                    <br><br><br><br><br><br>
                                    </form>
                </div>
            </div>
        </div>
        
        
        
        
    </body>
</html>
