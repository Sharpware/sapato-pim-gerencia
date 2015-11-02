<%-- 
    Document   : formulario
    Created on : 01/11/2015, 23:52:59
    Author     : George
    Author     : Rodrigo
    Author     : Gabriel
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulario</title>
    <link href="../../../css/bootstrap.css" rel="stylesheet">
    <link href="../../../css/style.css" rel="../../../stylesheet" >
    <link href="../../../css/sb-admin.css" rel="stylesheet">
    <link href="../../../css/plugins/morris.css" rel="stylesheet">
    <link href="../../../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>    
    <!--Menu feito para todas as paginas -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>
        <a href="index.html" class="navbar-brand"><strong><span style="color:#006CCA">Sharp</span><span style="color:#009D73">Ware</span></strong></a>
    </div>
    <ul class="nav navbar-right top-nav">
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <i class="fa fa-user"></i> Login
            <span class="caret"></span>
        </a>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuDivider">
                <li> <a href="#"><i class="fa fa-fw fa-power-off"></i> Sair</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="https://github.com/Sharpware">&nbsp;<i class="fa fa-github"></i> github</a></li>
            </ul>
        </li>
    </ul>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav" >
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-cliente" ><i class="fa fa-users fa-lg"></i>&nbsp;&nbsp;Cliente <i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-cliente" class="collapse">
                    <li><a href="PesquisarCliente.html"><i class="fa fa-search"></i>&nbsp;Pesquisar Cliente</a></li>
                    <li><a href="CadastrarCliente.html"><i class="fa fa-user-plus"></i>&nbsp;Cadastrar Cliente</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-fornecedor"><i class="fa fa-truck fa-lg"></i>&nbsp;&nbsp;Fornecedor <i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-fornecedor" class="collapse">
                    <li><a href="PesquisarFornecedor.html"><i class="fa fa-search"></i>&nbsp;Pesquisar Fornecedor</a></li>
                    <li><a href="CadastrarFornecedor.html"><i class="fa fa-ambulance"></i>&nbsp;Cadastrar Fornecedor</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-estoque"><i class="fa fa-shopping-cart fa-lg"></i>&nbsp;&nbsp;Estoque<i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-estoque" class="collapse">
                    <li><a href="EntradaProduto.html"><i class="fa fa-cart-arrow-down"></i>&nbsp;Entrada de produto</a></li>
                    <li><a href="PesquisarProduto.html"><i class="fa fa-search"></i>&nbsp;Pesquisa de produto</a></li>
                    <li><a href="CadastrarFuncionario.html"><i class="fa fa-cart-plus"></i>&nbsp;Cadastro de Produto</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-gerencia"><i class="fa fa-suitcase fa-lg"></i>&nbsp;&nbsp;Gerencia<i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-gerencia" class="collapse">
                    <li><a href="CadastrarFuncionario.html"><i class="fa fa-user-plus"></i>&nbsp;Cadastrar funcionario</a></li>
                    <li><a href="PesquisarFuncionario.html"><i class="fa fa-search"></i>&nbsp;Pesquisar funcionario</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-relatorios"><i class="fa fa-line-chart fa-lg"></i>&nbsp;&nbsp;Relatorios<i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-relatorios" class="collapse">
                    <li><a href="RelatorioVendaPeriodo.html"><i class="fa fa-calendar-check-o"></i>&nbsp;Relatorio de vendas por periodo</a></li>
                    <li><a href="RelatorioVendaVendedor.html"><i class="fa fa-balance-scale"></i>&nbsp;Relatorio de venda por vendedor</a></li>
                </ul>
            </li>

        </ul>    
    </div>
    <!--Menu feito para todas as paginas -->
    <div id="page-wrapper" style="background-color:#AADBFF">
        <form action="${linkTo[ClienteController].salvar}" method="post">
        <h2>Formulário de Cadastro de Cliente</h2>
        <ul>
            <li>
                <p>Nome:</p>
                <input type="text" name="cliente.nome" value="${cliente.nome}" />
            </li>
            <li>
                <p>CPF:</p>
                <input type="text" name="cliente.cpf" value="${cliente.cpf}" />
            </li>
            <li>
                <p>Data de nascimento:</p>
                <input type="text" name="cliente.dataNascimento" value="${cliente.dataNascimento}" />
            </li>
            <li>
                <p>Descrição:</p>
                <textarea name="cliente.descricao" >${cliente.descricao}</textarea>
            </li>
            <li>
                <p>Email:</p>
                <input type="text" name="cliente.email" value="${cliente.email}" />
            </li>
            <li>
            <!--
                <p>Situação:</p>
                <input type="radio" name="cliente.ativo" value="${cliente.situacao}" checked />Ativo
                <input type="radio" name="cliente.inativo" value="${cliente.situacao}" />Inativo
            </li>
            -->
        </ul>
        <div class="endereco">
            <ul>
                <li>
                    <p>Logradouro:</p>
                    <input type="text" name="cliente.endereco.logradouro" value="${cliente.endereco.logradouro}" />
                </li>
                <li>
                    <p>N°:</p>
                    <input type="text" name="cliente.endereco.numero" value="${cliente.endereco.numero}" />
                </li>
                <li>
                    <p>CEP:</p>
                    <input type="text" name="cliente.endereco.cep" value="${cliente.endereco.cep}" />
                </li>
                <li>
                    <p>Complemento:</p>
                    <input type="text" name="cliente.endereco.complemento" value="${cliente.endereco.complemento}" />
                </li>
                <li>
                    <p>Bairro:</p>
                    <input type="text" name="cliente.endereco.bairro" value="${cliente.endereco.bairro}" />
                </li>
                <li>
                    <p>Cidade:</p>
                    <input type="text" name="cliente.endereco.cidade" value="${cliente.endereco.cidade}" />
                </li>
                <li>
                    <p>UF:</p>
                    <input type="text" name="cliente.endereco.uf" value="${cliente.endereco.uf}" />
                </li>
            </ul>
        </div>
        <!--
        <div class="telefones">
            <ul>
                <li>
                    <p>Telefone residencial:</p>
                    <input type="text" name="cliente.telefoneResidencial" value="${cliente.addTelefone}" />
                </li>
                <li>
                    <p>Telefone trabalho:</p>
                    <input type="text" name="cliente.telefoneTrabalho" value="${cliente.addTelefone}" />
                </li>
                <li>
                    <p>Celular:</p>
                    <input type="text" name="telefone.celular" value="${cliente.addTelefone}" />
                </li>
            </ul>
        </div>
        -->
        <input type="submit" value="Salvar" />
    </form>
    </div>
    <script type="text/javascript" src="../../../js/jquery.js"></script>
    <script type="text/javascript" src="../../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../../js/plugins/morris/raphael.min.js"></script>
    <script type="text/javascript" src="../../../js/plugins/morris/morris.min.js"></script>
</body>
</html>
