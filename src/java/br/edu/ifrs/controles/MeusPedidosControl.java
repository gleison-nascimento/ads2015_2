/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controles;

import java.io.IOException;
import java.io.PrintWriter;
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
//        response.setContentType("text/html;charset=UTF-8");
        try {
            String nroPedido = request.getParameter("nroPedido");
            String status = request.getParameter("status");
            int qtdItens = Integer.parseInt(request.getParameter("qtdItens"));
            String enderecoEnvio = request.getParameter("enderecoEnvio");
            date data = request.getParameter("data");
            float valorTotal = Float.parseFloat(request.getParameter("valorTotal"));
            
            Pedidos Pid = new Pedidos();
            Pid.setNroPedido(nroPedido);
            Pid.setStatus(status);
            Pid.setQtdItens(qtdItens);
            Pid.setData(data);
            Pid.setValorTotal(valorTotal);
            Pid.inserir();
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
        } 
//        RequestDispatcher dispatcher = request.getRequestDispatcher("resultadoPedidos.jsp");
//        dispatcher.forward(request, response);
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
