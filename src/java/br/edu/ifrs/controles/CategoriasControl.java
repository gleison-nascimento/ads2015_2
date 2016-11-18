/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controles;

import br.edu.ifrs.modelo.CategoriasDAO;
import br.edu.ifrs.modelo.bean.CategoriasBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anderson
 */
@WebServlet(name = "CategoriasControl", urlPatterns = {"/CategoriasControl"})
public class CategoriasControl extends HttpServlet {

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
         String op = request.getParameter("DEFINIR UM PARAMETRO PADRÃO ATRAVÉS DO FORMADCCATEGORIA");
            
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
            CategoriasBean c = new CategoriasBean();
            request.getSession().setAttribute("categ", c);
            
            
            c.setNome(request.getParameter("nome"));
            c.setDescricao(request.getParameter("descricao"));
            c.setSituacao(request.getParameter("situacao"));
            
            
            CategoriasDAO categoria = new CategoriasDAO();
            categoria.inserir(c);
            
            request.setAttribute("msg", "Nova categoria cadastrada no sistema");
            request.getSession().removeAttribute("categ");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado_categoria.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            CategoriasBean c = new CategoriasBean();
            c.setNome((request.getParameter("nome") == null ? "":request.getParameter("nome")));
            c.setDescricao((request.getParameter("descricao") == null ? "":request.getParameter("descricao")));
            
            CategoriasDAO categoria = new CategoriasDAO();
            List<CategoriasBean> lista = categoria.buscar(c);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultadoBusca_categoria.jsp");
        dispatcher.forward(request, response);
    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            CategoriasBean c = new CategoriasBean();
            c.setId(Integer.parseInt(request.getParameter("id")));
            
            CategoriasDAO categoria = new CategoriasDAO();
            categoria.deletar(c);
            
            buscar(request, response);
           
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado_categoria.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            CategoriasBean c = new CategoriasBean();
            c.setId(Integer.parseInt(request.getParameter("id")));
            
            CategoriasDAO categoria = new CategoriasDAO();
            CategoriasBean categ = categoria.buscarPorId(c);
            
            request.getSession().setAttribute("categ", c);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("formAddcategoria.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            CategoriasBean c = new CategoriasBean();
            request.getSession().setAttribute("categ", c);
            
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setNome(request.getParameter("nome"));
            c.setDescricao(request.getParameter("descricao"));
            c.setSituacao(request.getParameter("situacao"));
            

            CategoriasDAO categoria = new CategoriasDAO();
            categoria.atualizar(c);
            
            request.setAttribute("msg", "Categoria atualizada com sucesso!!!");
            request.getSession().removeAttribute("categ");
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado_categoria.jsp");
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
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
