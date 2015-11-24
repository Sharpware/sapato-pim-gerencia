CREATE DATABASE `sharpware` /*!40100 DEFAULT CHARACTER SET utf8 */;
select database()sharpware;
use sharpware;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `observacao` text,
  `situacao` varchar(20) NOT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `uf` varchar(5) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `fornecedor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) DEFAULT NULL,
  `email_primario` varchar(255) DEFAULT NULL,
  `email_secundario` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `nome_fantasia` varchar(255) DEFAULT NULL,
  `observacao` text,
  `razao_social` varchar(255) DEFAULT NULL,
  `situacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(16) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `observacao` text,
  `situacao` varchar(20) NOT NULL,
  `logradouro` varchar(50) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `complemento` varchar(50) DEFAULT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `uf` varchar(5) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `tipo_funcionario` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `tamanho` varchar(10) NOT NULL,
  `codigo_barra` varchar(25) NOT NULL,
  `preco_custo` double NOT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  `tipo_produto` varchar(50) NOT NULL,
  `fornecedor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fornecedor_id` (`fornecedor_id`),
  CONSTRAINT `fornecedor_id` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `lista_preco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) NOT NULL,
  `preco` double NOT NULL,
  `data_inicio` datetime NOT NULL,
  `data_fim` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `lista_preco_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) NOT NULL,
  `data_entrada` date NOT NULL,
  `quantidade_produto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `data_venda` datetime NOT NULL,
  `valor_total` double NOT NULL,
  `tipo_venda` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionario_id` (`funcionario_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `itens_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor_total` double NOT NULL,
  `produto_id` int(11) NOT NULL,
  `venda_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_id` (`produto_id`),
  KEY `venda_id` (`venda_id`),
  CONSTRAINT `itens_venda_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `itens_venda_ibfk_2` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(20) NOT NULL,
  `tipo_telefone` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_cliente` (
  `cliente_id` int(11) NOT NULL,
  `telefone_id` int(11) NOT NULL,
  PRIMARY KEY (`cliente_id`,`telefone_id`),
  KEY `telefone_id` (`telefone_id`),
  CONSTRAINT `telefone_cliente_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `telefone_cliente_ibfk_2` FOREIGN KEY (`telefone_id`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_fornecedor` (
  `fornecedor_id` int(11) NOT NULL,
  `telefone_id` int(11) NOT NULL,
  PRIMARY KEY (`fornecedor_id`,`telefone_id`),
  KEY `telefone_id` (`telefone_id`),
  CONSTRAINT `telefone_fornecedor_ibfk_1` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`),
  CONSTRAINT `telefone_fornecedor_ibfk_2` FOREIGN KEY (`telefone_id`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_funcionario` (
  `funcionario_id` int(11) NOT NULL,
  `telefone_id` int(11) NOT NULL,
  PRIMARY KEY (`funcionario_id`,`telefone_id`),
  KEY `telefone_id` (`telefone_id`),
  CONSTRAINT `telefone_funcionario_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `telefone_funcionario_ibfk_2` FOREIGN KEY (`telefone_id`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

set foreign_key_checks=0;
TRUNCATE `sharpware`.`cliente`;
TRUNCATE `sharpware`.`estoque`;
TRUNCATE `sharpware`.`fornecedor`;
TRUNCATE `sharpware`.`funcionario`;
TRUNCATE `sharpware`.`itens_venda`;
TRUNCATE `sharpware`.`lista_preco`;
TRUNCATE `sharpware`.`produto`;
TRUNCATE `sharpware`.`telefone_cliente`;
TRUNCATE `sharpware`.`telefone`;
TRUNCATE `sharpware`.`telefone_fornecedor`;
TRUNCATE `sharpware`.`telefone_funcionario`;
TRUNCATE `sharpware`.`venda`;

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("noAccessLog", "inexPoint", "Vendedor", "<<Sem Vendedor>>", ""
,"111.111.111-11","2015-01-01","Ativo","", "", "","", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (1,1);
insert into telefone_funcionario (funcionario_id, telefone_id) values (1,2);
insert into telefone_funcionario (funcionario_id, telefone_id) values (1,3);

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("rodrigo1208", "1208", "Gerente", "Rodrigo Felipe Cardoso", "rodrigo.fcardoso@hotmsil.com"
,"401.813.178-00","1995-08-12","Ativo","Rua Nobuiushi Watanabe", "689", "14140-000","Jardim das acassias", "SP", "Cravinhos");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (2,4);
insert into telefone_funcionario (funcionario_id, telefone_id) values (2,5);
insert into telefone_funcionario (funcionario_id, telefone_id) values (2,6);

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("geoge123", "123", "Gerente", "George Alves da Silveira", "george@gmail.com"
,"125.547.874-01","1996-12-12","Ativo","Rua Ribeirao", "555", "45412-000","Ipiranga", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (3,7);
insert into telefone_funcionario (funcionario_id, telefone_id) values (3,8);
insert into telefone_funcionario (funcionario_id, telefone_id) values (3,9);

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("joao1212", "1234", "Vendedor", "Joao Santos", "Joao@mail"
,"454.154.788-11","1991-07-01","Ativo","", "", "","", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (4,10);
insert into telefone_funcionario (funcionario_id, telefone_id) values (4,11);
insert into telefone_funcionario (funcionario_id, telefone_id) values (4,12);

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("professor", "1010", "Gerente", "Professor", ""
,"100.100.100-10","2015-12-12","Ativo","", "", "","", "SP", "Cravinhos");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (5,13);
insert into telefone_funcionario (funcionario_id, telefone_id) values (5,14);
insert into telefone_funcionario (funcionario_id, telefone_id) values (5,15);

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("carina150", "1501", "Vendedor", "Carina Augusta", "carina@mail"
,"544.478.123-10","1991-10-05","Ativo","", "", "","", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (6,16);
insert into telefone_funcionario (funcionario_id, telefone_id) values (6,17);
insert into telefone_funcionario (funcionario_id, telefone_id) values (6,18);

insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("manuel111", "1111", "Vendedor", "Manuel Silva", "manuel@mail"
,"321.154.788-10","1989-04-21","Ativo","", "", "","", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (7,19);
insert into telefone_funcionario (funcionario_id, telefone_id) values (7,20);
insert into telefone_funcionario (funcionario_id, telefone_id) values (7,21);
 
insert into funcionario (login, senha, tipo_funcionario, nome, email, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("Ricardo333", "3333", "Vendedor", "Ricardo Oliveira", "ricardo@mail"
,"152.141.411-12","1987-07-01","Ativo","", "", "","", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_funcionario (funcionario_id, telefone_id) values (8,22);
insert into telefone_funcionario (funcionario_id, telefone_id) values (8,23);
insert into telefone_funcionario (funcionario_id, telefone_id) values (8,24);
 
insert into fornecedor (cnpj, email_primario, nome_fantasia, razao_social, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("12.145.123/4515-12", "alpino@alpino.com.br", "Alpinos Sapatos", "Alexandre Sapatos LTDA","Ativo", "Rua Presidente Dutra", "454"
,"15464-554","Luanel", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_fornecedor (fornecedor_id, telefone_id) values (1,25);
insert into telefone_fornecedor (fornecedor_id, telefone_id) values (1,26);
insert into telefone_fornecedor (fornecedor_id, telefone_id) values (1,27);

insert into cliente (nome, cpf, data_nascimento, situacao, logradouro, numero, cep, bairro, uf, cidade)
values ("<<Cliente Generico>>"
,"000.000.000-00","2015-01-01","Ativo","", "", "","", "SP", "Ribeirao Preto");
insert into telefone (numero, tipo_telefone) values ("", "Residencial");
insert into telefone (numero, tipo_telefone) values ("", "Celular");
insert into telefone (numero, tipo_telefone) values ("", "Trabalho");
insert into telefone_cliente (cliente_id, telefone_id) values (1,28);
insert into telefone_cliente (cliente_id, telefone_id) values (1,29);
insert into telefone_cliente (cliente_id, telefone_id) values (1,30);

insert into produto (nome, marca, tamanho, codigo_barra, preco_custo, descricao, tipo_produto, fornecedor_id)
values ("Nike Shocks", "NIKE", "39", "12345678910", 45, "Verde com listras brancas", "CorridaPerformance", 1);
insert into estoque (produto_id, data_entrada, quantidade_produto) values (1, "2015-11-19", 10);
insert into lista_preco (produto_id, preco, data_inicio, data_fim) values (1, 150, "2015-11-19", "2015-12-29")