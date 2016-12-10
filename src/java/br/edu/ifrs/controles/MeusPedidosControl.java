/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controles;

import br.edu.ifrs.modelo.UsuariosDAO;
import br.edu.ifrs.modelo.bean.PedidosBean;
import br.edu.ifrs.modelo.bean.UsuariosBean;
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
 * @author 10070142
 */
@WebServlet(name = "MeusPedidosControl", urlPatterns = {"/MeusPedidosControl"})
public class MeusPedidosControl extends HttpServlet {

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
            //inserir(request, response);
        } else {
            if (op.equals("PESQUISAR")) {
                buscar(request, response);
            } else {
                if (op.equals("EXCLUIR")) {
                    //excluir(request, response);
                } else {
                    if (op.equals("EDITAR")) {
                        //editar(request, response);
                    } else {
                        if (op.equals("ATUALIZAR")) {
                            //atualizar(request, response);
                        }
                    }
                }
            }
        }
    }

    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            UsuariosBean usu = new UsuariosBean();
            PedidosBean pe = new PedidosBean();
            usu.setNome((request.getParameter("nome") == null ? "":request.getParameter("nome")));
            pe.setData_emissao((request.getParameter("data_emissao") == null ? "":request.getParameter("data_emissao")));
              
            UsuariosDAO usuario = new UsuariosDAO();
            List<UsuariosBean> lista = usuario.buscar(usu);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultadoBuscaMeusPedidos.jsp");
        dispatcher.forward(request, response);
    }

   
    /*protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        try {
            UsuariosBean usu = new UsuariosBean();
            usu.setCpf(request.getParameter("cpf"));
            
            UsuariosDAO usuario = new UsuariosDAO();
            UsuariosBean usua = usuario.buscarPorCpf(usu);
            
            request.getSession().setAttribute("usua", usu);
        } catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("formAddusuario.jsp");
        dispatcher.forward(request, response);
    }*/
    


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
