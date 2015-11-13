CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `tamanho` varchar(10) NOT NULL,
  `codigo_barra` varchar(25) NOT NULL,
  `preco_custo` double NOT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(20) NOT NULL,
  `tipo_telefone` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_cliente` (
  `id_cliente` int(11) NOT NULL,
  `id_telefone` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`,`id_telefone`),
  KEY `id_telefone` (`id_telefone`),
  CONSTRAINT `telefone_cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `telefone_cliente_ibfk_2` FOREIGN KEY (`id_telefone`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_venda` datetime NOT NULL,
  `valor_total` double NOT NULL,
  `tipo_venda` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_funcionario` (`id_funcionario`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `lista_preco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `preco` double NOT NULL,
  `data_inicio` datetime NOT NULL,
  `data_fim` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `lista_preco_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `data_entrada` date NOT NULL,
  `quantidade_produto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`),
  CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `itens_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor_total` double NOT NULL,
  `id_produto` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`),
  KEY `id_venda` (`id_venda`),
  CONSTRAINT `itens_venda_ibfk_1` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`),
  CONSTRAINT `itens_venda_ibfk_2` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;



