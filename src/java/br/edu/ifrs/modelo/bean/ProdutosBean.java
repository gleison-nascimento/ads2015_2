/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

/**
 *
 * @author 10070206
 */
public class ProdutosBean {
    private int id;
    private String nome;
    private String descricao_detalhada;
    private String unidade_venda ;
    private float preco_unitario ;
    private String parcelamento_pagamento ;
    private String condicoes_entrega ;
    private String foto;
    private float quantidade_estoque ;
    private int id_categoria ;
    private String situacao;
    private String observacoes;
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao_detalhada;
    }
    public void setDescricao(String descricao) {
        this.descricao_detalhada = descricao;
    }
    
    public String getUnidade_Venda() {
        return unidade_venda;
    }
    public void setUnidade_Venda(String unidade) {
        this.unidade_venda = unidade;
    }
    
    /* continua */
}
