/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.utils;

/**
 *
 * @author anderson
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class conexao {
     public static Connection abrir() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja", "root", "connect");

        return con;
    }
}
