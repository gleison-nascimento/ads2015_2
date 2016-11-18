/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.modelo.bean.CategoriasBean;
import br.edu.ifrs.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class CategoriasDAO {
    
    public void inserir(CategoriasBean c) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("insert into categorias (nome, descricao text, situacao) values (?, ?, ?)");
        pstmt.setString(1, c.getNome());
        pstmt.setString(2, c.getDescricao());
        pstmt.setString(3, c.getSituacao());

        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public void atualizar(CategoriasBean c) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("update categorias set nome = ?, descricao text = ?, situacao = ? where id = ?");
        pstmt.setString(1, c.getNome());
        pstmt.setString(2, c.getDescricao());
        pstmt.setString(3, c.getSituacao());
        pstmt.setInt(4, c.getId());

        pstmt.execute();

        pstmt.close();
        con.close();
    }

    public List<CategoriasBean> buscar(CategoriasBean categ) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("select * from categorias where nome like ? and situacao like ?");
        pstmt.setString(1, "%"+categ.getNome()+"%");
        pstmt.setString(2, "%"+categ.getSituacao()+"%");
        
        ResultSet rs = pstmt.executeQuery();
        List<CategoriasBean> lista = new ArrayList<CategoriasBean>();
        while (rs.next() == true) {
            CategoriasBean c = new CategoriasBean();
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            c.setSituacao(rs.getString("situacao"));
           
            
            lista.add(c);
        }

        rs.close();
        pstmt.close();
        con.close();
        
        return lista;
    }

    public void deletar(CategoriasBean c) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("delete from categorias where id = ?");
        pstmt.setInt(1, c.getId());
        
        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public CategoriasBean buscarPorId(CategoriasBean categ) throws Exception {
        Connection con = Conexao.abrir();
        
        PreparedStatement pstmt = con.prepareStatement("select * from categorias where id = ?");
        pstmt.setInt(1, categ.getId());
        
        ResultSet rs = pstmt.executeQuery();
        CategoriasBean c = new CategoriasBean();
        
        if (rs.next() == true) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            c.setSituacao(rs.getString("situacao"));
        }

        rs.close();
        pstmt.close();
        con.close();
        
        return c;
    }
}
