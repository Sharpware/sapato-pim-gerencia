CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `tamanho` varchar(10) NOT NULL,
  `codigo_barra` varchar(25) NOT NULL,
  `preco_custo` double NOT NULL,
  `descricao` varchar(300) DEFAULT NULL,
  tipo_produto varchar(50) NOT NULL,
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
  PRIMARY KEY (`id`)
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
  tipo_funcionario varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_cliente` (
  `cliente_id` int(11) NOT NULL,
  `telefone_id` int(11) NOT NULL,
  PRIMARY KEY (`cliente_id`,`telefone_id`),
  KEY `telefone_id` (`telefone_id`),
  CONSTRAINT `telefone_cliente_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `telefone_cliente_ibfk_2` FOREIGN KEY (`telefone_id`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_funcionario` (
  `funcionario_id` int(11) NOT NULL,
  `telefone_id` int(11) NOT NULL,
  PRIMARY KEY (`funcionario_id`,`telefone_id`),
  KEY `telefone_id` (`telefone_id`),
  CONSTRAINT `telefone_funcionario_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `telefone_funcionario_ibfk_2` FOREIGN KEY (`telefone_id`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `telefone_fornecedor` (
  `fornecedor_id` int(11) NOT NULL,
  `telefone_id` int(11) NOT NULL,
  PRIMARY KEY (`fornecedor_id`,`telefone_id`),
  KEY `telefone_id` (`telefone_id`),
  CONSTRAINT `telefone_fornecedor_ibfk_1` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`),
  CONSTRAINT `telefone_fornecedor_ibfk_2` FOREIGN KEY (`telefone_id`) REFERENCES `telefone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
