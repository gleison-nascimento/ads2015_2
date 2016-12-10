

drop database loja;
create database loja;
use loja;

drop table usuarios;
create table usuarios (
  cpf varchar(11) not null, 
  rg varchar(15), 
  expedidor varchar(10), 
  nome varchar(200) not null, 
  sexo varchar(1) not null, 
  endereco_residencial text not null, 
  email varchar(255) not null, 
  telefone_residencial varchar(14), 
  telefone_profissional varchar(14), 
  telefone_celular varchar(14), 
  perfil varchar(1), 
  username varchar(15) not null, 
  senha varchar(255) not null, 
  situacao varchar(1),
  observacoes text,
  primary key (cpf)
);


drop table categorias;
create table categorias (
  id int auto_increment not null,
  nome varchar(50) not null, 
  descricao text,
  situacao varchar(1) not null,
  primary key (id)
);

drop table produtos;
create table produtos (
  id int auto_increment not null,
  nome varchar(200) not null, 
  descricao_detalhada text, 
  unidade_venda varchar(3) not null, 
  preco_unitario float not null, 
  parcelamento_pagamento varchar(20), 
  condicoes_entrega varchar(200), 
  foto varchar(255) not null, 
  quantidade_estoque float, 
  id_categoria int, 
  situacao varchar(1),
  observacoes text,
  primary key (id),
  foreign key (id_categoria) references categorias (id)
);

drop table pedidos;
create table pedidos (
  id int auto_increment not null,
  cpf_usuario varchar(11) not null,
  data_emissao datetime not null,
  condicoes_pagamento varchar(10) not null,
  forma_pagamento varchar(10) not null,
  numero_cartao varchar(16),
  bandeira_cartao varchar(10),
  codigo_seguranca_cartao varchar(4),
  valor_total float not null,
  condicoes_entrega text not null,
  situacao varchar(1) not null,
  observacoes text,
  primary key (id),
  foreign key (cpf_usuario) references usuarios(cpf)
);

drop table itens_pedido;
create table itens_pedido (
  id_pedido int not null,
  id_produto int not null,
  quantidade float,
  valor_unitario float,
  situacao varchar(1),
  observacoes text,
  primary key (id_pedido, id_produto),
  foreign key (id_pedido) references pedidos(id),
  foreign key (id_produto) references produtos(id)
);