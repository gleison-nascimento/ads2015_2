/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.modelo.bean.PedidosBean;
import br.edu.ifrs.modelo.bean.UsuariosBean;
import br.edu.ifrs.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author levymarcelo
 */
public class PedidosDAO {

    /*public List<UsuariosBean> buscarPorNome(UsuariosBean usu) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("select * from usuarios where nome like ?");
        pstmt.setString(1, "%" + usu.getNome() + "%");

        ResultSet rs = pstmt.executeQuery();
        List<UsuariosBean> lista = new ArrayList<UsuariosBean>();
        while (rs.next() == true) {
            UsuariosBean u = new UsuariosBean();
            u.setNome(rs.getString("nome"));
            
            lista.add(u);
        }
        rs.close();
        pstmt.close();
        con.close();
        
        return lista;
    }*/
    

    public List<PedidosBean> buscar(PedidosBean ped) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("select * from pedidos where data_emissao  like ?");
        pstmt.setString(1, "%" + ped.getData_emissao() + "%");

        ResultSet rs = pstmt.executeQuery();
        List<PedidosBean> lista = new ArrayList<PedidosBean>();
        while (rs.next() == true) {
            PedidosBean p = new PedidosBean();
            p.setId(rs.getInt("id"));
            p.setData_emissao(rs.getString("data_emissao"));
            p.setValor_total(rs.getDouble("valor_total"));
            
            lista.add(p);
        }

        rs.close();
        pstmt.close();
        con.close();

        return lista;
    }

    /*public JogadoresBean buscarPorId(JogadoresBean jog) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("select * from jogadores where id = ?");
        pstmt.setInt(1, jog.getId());

        ResultSet rs = pstmt.executeQuery();
        JogadoresBean j = new JogadoresBean();

        if (rs.next() == true) {
            j.setId(rs.getInt("id"));
            j.setNome(rs.getString("nome"));
            j.setTime(rs.getString("time_futebol"));
            j.setAltura(rs.getFloat("altura"));
            j.setPeso(rs.getFloat("peso"));
            j.setIdade(rs.getInt("idade"));
        }

        rs.close();
        pstmt.close();
        con.close();

        return j;
    }*/


    /*public void inserir(JogadoresBean j) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("insert into jogadores (nome, time_futebol, altura, peso, idade) values (?, ?, ?, ?, ?)");
        pstmt.setString(1, j.getNome());
        pstmt.setString(2, j.getTime());
        pstmt.setFloat(3, j.getAltura());
        pstmt.setFloat(4, j.getPeso());
        pstmt.setInt(5, j.getIdade());

        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public void atualizar(JogadoresBean j) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("update jogadores set nome = ?, time_futebol = ?, altura = ?, peso = ?, idade = ? where id = ?");
        pstmt.setString(1, j.getNome());
        pstmt.setString(2, j.getTime());
        pstmt.setFloat(3, j.getAltura());
        pstmt.setFloat(4, j.getPeso());
        pstmt.setInt(5, j.getIdade());
        pstmt.setInt(6, j.getId());

        pstmt.execute();

        pstmt.close();
        con.close();
    }

    /*public void deletar(JogadoresBean j) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("delete from jogadores where id = ?");
        pstmt.setInt(1, j.getId());
        
        pstmt.execute();

        pstmt.close();
        con.close();
    }*/
}
