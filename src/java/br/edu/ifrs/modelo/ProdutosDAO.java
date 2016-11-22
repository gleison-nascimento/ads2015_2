/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import br.edu.ifrs.modelo.bean.ProdutosBean;
import br.edu.ifrs.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class ProdutosDAO {
   
    
    public void inserir(ProdutosBean p) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("insert into produtos (nome, descricao_detalhada, unidade_venda, preco_unitario, parcelamento_pagamento, condicoes_entrega, foto, quantidade_estoque, id_categoria, situacao, observacoes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, p.getNome());
        pstmt.setString(2, p.getDescricao());
        pstmt.setString(3, p.getUnidade_Venda());
        pstmt.setFloat(4, p.getPreco_Unitario());
        pstmt.setString(5, p.getParcelamento_Pagamento());
        pstmt.setString(6, p.getCondicoes_Entrega());
        pstmt.setString(7, p.getFoto());
        pstmt.setFloat(8, p.getQuantidade_Estoque());
        pstmt.setInt(9, p.getId_Categoria());
        pstmt.setString(10, p.getSituacao());
        pstmt.setString(11, p.getObservacoes());
        

        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public void atualizar(ProdutosBean p) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("update podutos set nome = ?, descricao_detalhada = ?, unidade_venda = ?, preco_unitario = ?, parcelamento_pagamento = ?, condicoes_entrega = ?, foto = ?, quantidade_estoque = ?, id_categoria = ?, situacao = ?, observacoes = ? where id = ?");
        pstmt.setString(1, p.getNome());
        pstmt.setString(2, p.getDescricao());
        pstmt.setString(3, p.getUnidade_Venda());
        pstmt.setFloat(4, p.getPreco_Unitario());
        pstmt.setString(5, p.getParcelamento_Pagamento());
        pstmt.setString(6, p.getCondicoes_Entrega());
        pstmt.setString(7, p.getFoto());
        pstmt.setFloat(8, p.getQuantidade_Estoque());
        pstmt.setInt(9, p.getId_Categoria());
        pstmt.setString(10, p.getSituacao());
        pstmt.setString(11, p.getObservacoes());

        pstmt.execute();

        pstmt.close();
        con.close();
    }

    public List<ProdutosBean> buscar(ProdutosBean prod) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("select * from produtos where nome like ? and id_categoria = ?");
        pstmt.setString(1, "%"+prod.getNome()+"%");
        pstmt.setInt(2, prod.getId_Categoria());
        
        ResultSet rs = pstmt.executeQuery();
        List<ProdutosBean> lista = new ArrayList<ProdutosBean>();
        while (rs.next() == true) {
            ProdutosBean p = new ProdutosBean();
            p.setId(rs.getInt("id"));
	    p.setNome(rs.getString("nome"));
	    p.setDescricao(rs.getString("descricao"));
            p.setUnidade_Venda(rs.getString("unidade_venda"));
            p.setPreco_Unitario(rs.getFloat("preco_unitario"));
            p.setParcelamento_Pagamento(rs.getString("parcelamento_pagamento"));
            p.setCondicoes_Entrega(rs.getString("condicoes_entrega"));
            p.setFoto(rs.getString("foto"));
            p.setQuantidade_Estoque(rs.getFloat("quantidade_estoque"));
            p.setId_Categoria(rs.getInt("id_categoria"));
            p.setSituacao(rs.getString("situcao"));
            p.setObservacoes(rs.getString("observacoes"));
          
            lista.add(p);
        }

        rs.close();
        pstmt.close();
        con.close();
        
        return lista;
    }

    public void deletar(ProdutosBean p) throws Exception {
        Connection con = Conexao.abrir();

        PreparedStatement pstmt = con.prepareStatement("delete from produtos where id = ?");
        pstmt.setInt(1, p.getId());
        
        pstmt.execute();

        pstmt.close();
        con.close();
    }
    
    public ProdutosBean buscarPorNomeECategoria(ProdutosBean prod) throws Exception {
        Connection con = Conexao.abrir();
        
        PreparedStatement pstmt = con.prepareStatement("select * from produtos where nome like ? and id_categoria like ?");
        pstmt.setString(1, "%"+prod.getNome()+"%");
        pstmt.setInt(2, prod.getId_Categoria());
        
        ResultSet rs = pstmt.executeQuery();
        ProdutosBean p = new ProdutosBean();
        
        if (rs.next() == true) {
            p.setNome(rs.getString("nome"));
            p.setId_Categoria(rs.getInt("id_categoria"));
            p.setUnidade_Venda(rs.getString("unidade_venda"));
            p.setPreco_Unitario(rs.getFloat("preco_unitario"));
        }

        rs.close();
        pstmt.close();
        con.close();
        
        return p;
    }
}
