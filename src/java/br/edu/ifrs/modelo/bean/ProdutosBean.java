/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

/**
 *
 * @author 10070206 - Cristian
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
    public float getPreco_Unitario() {
        return preco_unitario;
    }
    public void setPreco_Unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }
    
    public String getParcelamento_Pagamento() {
        return parcelamento_pagamento;
    }
    public void setParcelamento_Pagamento(String parcelamento_pagamento) {
        this.parcelamento_pagamento = parcelamento_pagamento;
    }
    
    public String getCondicoes_Entrega() {
        return condicoes_entrega;
    }
    public void setCondicoes_Entrega(String condicoes_entrega) {
        this.condicoes_entrega = condicoes_entrega;
    }        
    
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.nome = foto;
    }
    
    public float getQuantidade_Estoque() {
        return quantidade_estoque;
    }
    public void setQuantidade_Estoque(float quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
    
    public int getId_Categoria() {
        return id_categoria;
    }
    public void setId_Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
