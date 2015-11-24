<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Pesquisa de Fornecedor</title>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu/menu.jsp" />

        <p class="lbl-cclient"><strong><em>Pesquisar Fornecedor</em></strong></p>
        <br>
        <form class="form-inline" id="codigo-pp-left">

            <div class="form-group">
                <label for="exampleInputName1">Nome</label>
                <br>
                <input type="text" class="form-control" id="exampleInputName1" placeholder="Nome do Fornecedor" maxlength="60" style="width: 300px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Código</label>
                <br>
                <input type="email" class="form-control" id="exampleInputName1" placeholder="Código do Fornecedor" maxlength="40" style="width: 250px">&nbsp;&nbsp;
            </div>

            <div class="form-group" id="div-status-pf">
                <p style="color:white" class="texto-status-pc"><strong>Status</strong></p>

                <div class="radio">
                    <label class="texto-status-pc">
                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                        Nome
                    </label>

                    <br> 

                    <label class="texto-status-pc">
                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                        Código
                    </label>

                    <br>

                    <label class="texto-status-pc">
                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3">
                        CNPJ
                    </label>                            

                </div>

            </div>

            <br>

        </form>
        <!-- PAINEL BRANCO -->
        <div id="grid-pc-branco" class="panel panel-default">
            <!-- Tables no PAINEL BRANCO -->
            <table class="table" border="1px">
                <div>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nome do Fornecedor</th>
                            <th>CNPJ</th>
                            <th>Editar</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${fornecedores}" var="fornecedor">
                            <tr>
                                <td>${fornecedor.id}</td>
                                <td>${fornecedor.nomeFantasia}</td>
                                <td>${fornecedor.cnpj}</td>
                                <td>
                                    <a href="${linkTo[FornecedorController].editar(fornecedor.id)}">
                                        <button type="button" class="btn btn-info" id="btn-pc">
                                            <strong>
                                                Editar Fornecedor
                                            </strong>
                                        </button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>

        <br>
        <br>

        <button type="submit" class="btn btn-info" id="btn-pc"><strong>Cadastrar Fornecedor</strong></button>
        <button type="submit" class="btn btn-info" id="btn-pc"><strong>Inativar Fornecedor</strong></button>

    </div>
</div>
<c:import url="/WEB-INF/jsp/menu/script.jsp" />
</body>
</html>