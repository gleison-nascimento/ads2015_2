/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DTI
 */
public class Conexao {
    public static Connection abrir() throws Exception {
        //Abrir uma conexão com o banco de dados;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "connect");

        return con;
    }
}
