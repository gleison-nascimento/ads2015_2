/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  anderson
 * Created: Nov 14, 2016
 */


create database loja;

use loja;

create table usuarios (
    idusu int auto_increment not null primary key,
    cpf varchar(20) not null,
    rg varchar(20),
    orgao_expedidor varchar(100),
    nome varchar(200) not null,
    sexo varchar(20) not null,
    endereco varchar(200) not null,
    email varchar(200) not null,
    tel_residencial varchar(20),
    tel_profissional varchar(20),
    tel_celular varchar(20),
    perfil varchar(10),
    username varchar(30) not null,
    senha varchar(30) not null,
    situacao varchar(20),
    observacoes varchar(300)
);


create table categorias (
    idcateg int auto_increment not null primary key,
    nome varchar(200) not null,
    descricao varchar(300),
    situacao varchar(20) not null
);


create table produtos (
    idprod int auto_increment not null primary key,
    nome varchar(200) not null,
    descricao varchar(300),
    unid_de_venda varchar(200) not null,
    preco_un float not null,
    parcelamento int,
    condicoes_entrega int,
    foto large blob not null,
    situacao varchar(20),
    observacoes varchar(300),
    constraint fkcategorias FOREIGN KEY(idcateg) REFERENCES categorias(idcateg)
); 