/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controles;

import br.edu.ifrs.modelo.ProdutosDAO;
import br.edu.ifrs.modelo.bean.ProdutosBean;
import java.io.IOException;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */

@WebServlet(name = "ProdutosControl", urlPatterns = {"/ProdutosControl"})
public class ProdutosControl {
    
      /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
            
        if (op.equals("INSERIR")) {
            inserir(request, response);
        } else {
            if (op.equals("PESQUISAR")) {
                buscar(request, response);
            } else {
                if (op.equals("EXCLUIR")) {
                    excluir(request, response);
                } else {
                    if (op.equals("EDITAR")) {
                        editar(request, response);
                    } else {
                        if (op.equals("ATUALIZAR")) {
                            atualizar(request, response);
                        }
                    }
                }
            }
        }
    }
    
     protected void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            ProdutosBean p = new ProdutosBean();
            request.getSession().setAttribute("prod", p);
            
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao_detalhada"));
            p.setUnidade_Venda(request.getParameter("unidade_venda"));
            p.setPreco_Unitario(Float.parseFloat(request.getParameter("preco_unitario")));
            p.setParcelamento_Pagamento(request.getParameter("parcelamento_pagamento"));
            p.setCondicoes_Entrega(request.getParameter("condicoes_entrega"));
            p.setFoto(request.getParameter("foto"));
            p.setQuantidade_Estoque(Float.parseFloat(request.getParameter("quantidade_estoque")));
            p.setId_Categoria(Integer.parseInt(request.getParameter("id_categoria")));
            p.setSituacao(request.getParameter("situacao"));
            p.setObservacoes(request.getParameter("observacoes"));
            
            ProdutosDAO pdao= new ProdutosDAO();
            pdao.inserir(p);
            
            request.setAttribute("msg", "Produto cadastrado com sucesso!!!");
            request.getSession().removeAttribute("prod");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("prod_resultado.jsp");
        dispatcher.forward(request, response);
    }
     
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            ProdutosBean p = new ProdutosBean();
            p.setNome((request.getParameter("nome") == null ? "":request.getParameter("nome")));
            p.setId_Categoria(Integer.parseInt(request.getParameter("id_categoria")));
           /*testa o Id  */
            ProdutosDAO pdao = new ProdutosDAO();
            List<ProdutosBean> lista = pdao.buscar(p);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultadoBusca.jsp");
        dispatcher.forward(request, response);
    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            ProdutosBean p = new ProdutosBean();
            p.setId(Integer.parseInt(request.getParameter("id")));
            
            ProdutosDAO pdao = new ProdutosDAO();
            pdao.deletar(p);
            
            buscar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            ProdutosBean p = new ProdutosBean();
            p.setId(Integer.parseInt(request.getParameter("id")));
            
            ProdutosDAO pdao = new ProdutosDAO();
            ProdutosBean prod = pdao.buscarPorNomeECategoria(p);
            
            request.getSession().setAttribute("prod", prod);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("formProdutos.jsp");
        dispatcher.forward(request, response);
    }
    
     protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            ProdutosBean p = new ProdutosBean();
            request.getSession().setAttribute("prod", p);
            
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setDescricao(request.getParameter("descricao_detalhada"));
            p.setUnidade_Venda(request.getParameter("unidade_venda"));
            p.setPreco_Unitario(Float.parseFloat(request.getParameter("preco_unitario")));
            p.setParcelamento_Pagamento(request.getParameter("parcelamento_pagamento"));
            p.setCondicoes_Entrega(request.getParameter("condicoes_entrega"));
            p.setFoto(request.getParameter("foto"));
            p.setQuantidade_Estoque(Float.parseFloat(request.getParameter("quantidade_estoque")));
            p.setId_Categoria(Integer.parseInt(request.getParameter("id_categoria")));
            p.setSituacao(request.getParameter("situacao"));
            p.setObservacoes(request.getParameter("observacoes"));
            
            
            ProdutosDAO pdao = new ProdutosDAO();
            pdao.atualizar(p);
            
            request.setAttribute("msg", "Produto atualizado com sucesso!!!");
            request.getSession().removeAttribute("prod");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);
    }
    
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
