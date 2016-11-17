/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

/**
 *
 * @author 10070216
 */
public class PedidoBean {
    private int id;
    private String cpf_usuario;
    private String data_emissao;
    private String condicoes_pagamento;
    private String forma_pagamento;
    private String numero_cartao;
    private String bandeira_cartao;
    private String codigo_seguranca_cartao;
    private double valor_total;
    private double condicoes_entrega;
    private String situacao;
    private String observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(String data_emissao) {
        this.data_emissao = data_emissao;
    }

    public String getCondicoes_pagamento() {
        return condicoes_pagamento;
    }

    public void setCondicoes_pagamento(String condicoes_pagamento) {
        this.condicoes_pagamento = condicoes_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public String getBandeira_cartao() {
        return bandeira_cartao;
    }

    public void setBandeira_cartao(String bandeira_cartao) {
        this.bandeira_cartao = bandeira_cartao;
    }

    public String getCodigo_seguranca_cartao() {
        return codigo_seguranca_cartao;
    }

    public void setCodigo_seguranca_cartao(String codigo_seguranca_cartao) {
        this.codigo_seguranca_cartao = codigo_seguranca_cartao;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getCondicoes_entrega() {
        return condicoes_entrega;
    }

    public void setCondicoes_entrega(double condicoes_entrega) {
        this.condicoes_entrega = condicoes_entrega;
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
