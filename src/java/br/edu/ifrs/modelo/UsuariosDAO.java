/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.modelo.bean.UsuariosBean;
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
public class UsuariosDAO {
   
    
    public void inserir(UsuariosBean usu) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("insert into usuarios (nome, rg, expedidor, cpf, sexo, endereco_residencial text, email, telefone_residencial, telefone_profissional, telefone_celular, perfil, username, senha, situacao, observacoes text) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, usu.getNome());
        pstmt.setString(2, usu.getRg());
        pstmt.setString(3, usu.getOrgexp());
        pstmt.setString(4, usu.getCpf());
        pstmt.setString(5, usu.getSexo());
        pstmt.setString(6, usu.getEndereco());
        pstmt.setString(7, usu.getEmail());
        pstmt.setString(8, usu.getTelres());
        pstmt.setString(9, usu.getTelcom());
        pstmt.setString(10, usu.getTelcel());
        pstmt.setString(11, usu.getPerfil());
        pstmt.setString(12, usu.getUsername());
        pstmt.setString(13, usu.getSenha());
        pstmt.setString(14, usu.getSituacao());
        pstmt.setString(15, usu.getObservacao());

        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public void atualizar(UsuariosBean usu) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("update usuarios set nome = ?, rg = ?, expedidor = ?, cpf = ?, sexo = ?, endereco = ?, email = ?, telefone_residencial = ?, telefone_profissional = ?, telefone_celular = ?, perfil = ?, username = ?, senha = ?, situacao = ? , observacoes text = ? where cpf = ?");
        pstmt.setString(1, usu.getNome());
        pstmt.setString(2, usu.getRg());
        pstmt.setString(3, usu.getOrgexp());
        pstmt.setString(4, usu.getCpf());
        pstmt.setString(5, usu.getSexo());
        pstmt.setString(6, usu.getEndereco());
        pstmt.setString(7, usu.getEmail());
        pstmt.setString(8, usu.getTelres());
        pstmt.setString(9, usu.getTelcom());
        pstmt.setString(10, usu.getTelcel());
        pstmt.setString(11, usu.getPerfil());
        pstmt.setString(12, usu.getUsername());
        pstmt.setString(13, usu.getSenha());
        pstmt.setString(14, usu.getSituacao());
        pstmt.setString(15, usu.getObservacao());
        pstmt.setString(16, usu.getCpf());

        pstmt.execute();

        pstmt.close();
        con.close();
    }

    public List<UsuariosBean> buscar(UsuariosBean usua) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("select * from usuarios where nome like ? and perfil like ?");
        pstmt.setString(1, "%"+usua.getNome()+"%");
        pstmt.setString(2, "%"+usua.getPerfil()+"%");
        
        ResultSet rs = pstmt.executeQuery();
        List<UsuariosBean> lista = new ArrayList<UsuariosBean>();
        while (rs.next() == true) {
            UsuariosBean usu = new UsuariosBean();
            usu.setNome(rs.getString("nome"));
            usu.setCpf(rs.getString("cpf"));
            usu.setEmail(rs.getString("email"));
            usu.setPerfil(rs.getString("perfil"));
            usu.setSituacao(rs.getString("situacao"));
            
            lista.add(usu);
        }

        rs.close();
        pstmt.close();
        con.close();
        
        return lista;
    }

    public void deletar(UsuariosBean usu) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("delete from usuarios where cpf = ?");
        pstmt.setString(1, usu.getCpf());
        
        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public UsuariosBean buscarPorCpf(UsuariosBean usua) throws Exception {
        Connection con = Conexao.abrir();
        
        PreparedStatement pstmt = con.prepareStatement("select * from usuarios where cpf = ?");
        pstmt.setString(1, usua.getCpf());
        
        ResultSet rs = pstmt.executeQuery();
        UsuariosBean usu = new UsuariosBean();
        
        if (rs.next() == true) {
            
            usu.setNome(rs.getString("nome"));
            usu.setCpf(rs.getString("cpf"));
            usu.setEmail(rs.getString("email"));
            usu.setPerfil(rs.getString("perfil"));
            usu.setSituacao(rs.getString("situacao"));
        }

        rs.close();
        pstmt.close();
        con.close();
        
        return usu;
    }
}


