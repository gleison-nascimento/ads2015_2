/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author 10070142
 */
public class Pedidos {
    private String nroPedido;
    private String status;
    private int qtdItens;
    private String data;
    private float valorTotal;

    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void inserir() throws Exception {
        //Abrir uma conexão com o banco de dados;
        Class.forName("com.mysql.jdbc.Driver");
                                                                 //IP da Máquina:Porta do Banco/Nome do Banco de Dados, usuário (root), senha 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prog3", "root", "connect");

        PreparedStatement pstmt = con.prepareStatement("Select into Pedidos (nroPedido, status, qtdItens, data, valorTotal) values (?, ?, ?, ?, ?)");
        pstmt.setString(1, nroPedido);
        pstmt.setString(2, status);
        pstmt.setInt(3, qtdItens);
        pstmt.setString(4, data);
        pstmt.setFloat(5, valorTotal);

        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
}