<div id="wrapper">
   <!--Menu feito para todas as paginas -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>
        <a href="/sapato-pim-gerencia/index.jsp" class="navbar-brand"><strong><span style="color:#006CCA">Sharp</span><span style="color:#009D73">Ware</span></strong></a>
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
                    <li><a href="/sapato-pim-gerencia/cliente/pesquisar"><i class="fa fa-search"></i>&nbsp;Pesquisar Cliente</a></li>
                    <li><a href="/sapato-pim-gerencia/cliente/formulario"><i class="fa fa-user-plus"></i>&nbsp;Cadastrar Cliente</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-fornecedor"><i class="fa fa-truck fa-lg"></i>&nbsp;&nbsp;Fornecedor <i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-fornecedor" class="collapse">
                    <li><a href="/sapato-pim-gerencia/fornecedor/pesquisar"><i class="fa fa-search"></i>&nbsp;Pesquisar Fornecedor</a></li>
                    <li><a href="/sapato-pim-gerencia/fornecedor/formulario"><i class="fa fa-ambulance"></i>&nbsp;Cadastrar Fornecedor</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-gerencia"><i class="fa fa-suitcase fa-lg"></i>&nbsp;&nbsp;Funcionario<i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-gerencia" class="collapse">
                    <li><a href="/sapato-pim-gerencia/funcionario/pesquisar"><i class="fa fa-search"></i>&nbsp;Pesquisar Funcionario</a></li>
                    <li><a href="/sapato-pim-gerencia/funcionario/formulario"><i class="fa fa-user-plus"></i>&nbsp;Cadastrar Funcionario</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-estoque"><i class="fa fa-shopping-cart fa-lg"></i>&nbsp;&nbsp;Estoque<i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-estoque" class="collapse">
                    <li><a href="/sapato-pim-estoque/produto/entrada"><i class="fa fa-cart-arrow-down"></i>&nbsp;Entrada de produto</a></li>
                    <li><a href="/sapato-pim-estoque/produto/pesquisar"><i class="fa fa-search"></i>&nbsp;Pesquisa de produto</a></li>
                    <li><a href="/sapato-pim-estoque/produto/formulario"><i class="fa fa-cart-plus"></i>&nbsp;Cadastro de Produto</a></li>
                </ul>
            </li>
            <li>
               <a href="javascript:;" data-toggle="collapse" data-target="#down-relatorios"><i class="fa fa-line-chart fa-lg"></i>&nbsp;&nbsp;Relatorios<i class="fa fa-caret-down pull-right"></i></a>
                <ul id="down-relatorios" class="collapse">
                    <li><a href="/sapato-pim-relatorio/venda/por-periodo"><i class="fa fa-calendar-check-o"></i>&nbsp;Relatorio de vendas por periodo</a></li>
                    <li><a href="/sapato-pim-relatorio/venda/por-vendedor"><i class="fa fa-balance-scale"></i>&nbsp;Relatorio de venda por vendedor</a></li>
                </ul>
            </li>
            
        </ul>    
    </div>
</nav>