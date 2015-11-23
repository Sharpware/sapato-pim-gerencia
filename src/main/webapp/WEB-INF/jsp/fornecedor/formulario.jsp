<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Formulário de Fornecedor</title>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu/menu.jsp" />

        <p class="lbl-cclient">
            <strong><em>Formulário de Fornecedor</em></strong>
        </p>

        <ul class="errors">
            <c:forEach items="${errors}" var="error">
                <li>${error.message}</li>
                </c:forEach>
        </ul>

        <form class="form-inline" id="codigo-pp-left"
              action="${linkTo[FornecedorController].salvar}" method="post">

            <input type="text" name="fornecedor.id" value="${fornecedor.id}"
                   hidden="true" />

            <div class="form-group">
                <label for="exampleInputName1">Razão Social</label> <br> <input
                    type="text" class="form-control" name="fornecedor.razaoSocial"
                    value="${fornecedor.razaoSocial}" id="exampleInputName1"
                    placeholder="" maxlength="60" style="width: 250px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Nome Fantasia</label> <br> <input
                    type="text" class="form-control" name="fornecedor.nomeFantasia"
                    value="${fornecedor.nomeFantasia}" id="exampleInputName1"
                    placeholder="" maxlength="60" style="width: 230px">&nbsp;&nbsp;
            </div>

            <div class="form-group" id="div-status-cc">
                <p style="color: white">
                    <strong>Situação</strong>
                </p>
                <div class="radio">
                    <label style="align: center"> <input type="radio"
                                                         name="optionsRadios" id="optionsRadios1" value="option1" checked>
                        Ativo
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios2"
                               value="option2"> Inativo
                    </label>
                </div>
            </div>

            <br> <br>

            <div class="form-group">
                <label for="exampleInputName1">CNPJ</label> <br> <input
                    type="text" class="form-control" name="fornecedor.cnpj"
                    value="${fornecedor.cnpj}" id="exampleInputName1"
                    placeholder="--.---.---/----.--" maxlength="14" style="width: 150px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">Email Principal</label> <br> <input
                    type="email" class="form-control" name="fornecedor.emailPrimario"
                    value="${fornecedor.emailPrimario}" id="exampleInputEmail2"
                    placeholder="Email do Fornecedor" maxlength="40"
                    style="width: 265px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">Email Secundário</label> <br> <input
                    type="email" class="form-control" name="fornecedor.Secundario"
                    value="${fornecedor.emailSecundario}" id="exampleInputEmail2"
                    placeholder="2º Email do Fornecedor" maxlength="40"
                    style="width: 265px">&nbsp;&nbsp;
            </div>

            <br> <br>

            <div class="form-group">
                <label for="exampleInputName1">Telefone 1</label> <br> <input
                    type="text" class="form-control" name="telefone1.numero"
                    value="${telefone1.numero}" id="exampleInputName1"
                    placeholder="DDD + Tel" maxlength="12" style="width: 130px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Telefone 2</label> <br> <input
                    type="text" class="form-control" name="telefone2.numero"
                    value="${telefone2.numero}" id="exampleInputName1"
                    placeholder="DDD + Tel" maxlength="12" style="width: 130px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Celular</label> <br> <input
                    type="text" class="form-control" name="telefone3.numero"
                    value="${telefone3.numero}" id="exampleInputName1"
                    placeholder="DDD + Cel" maxlength="12" style="width: 130px">&nbsp;&nbsp;
            </div>

            <br> <br>

            <div class="form-group">
                <label for="exampleInputName1">Logradouro</label> <br> <input
                    type="text" class="form-control"
                    name="fornecedor.endereco.logradouro"
                    value="${fornecedor.endereco.logradouro}" id="exampleInputName1"
                    placeholder="Endereço" maxlength="100" style="width: 210px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Número</label> <br> <input
                    type="text" class="form-control" name="fornecedor.endereco.numero"
                    value="${fornecedor.endereco.numero}" id="exampleInputName1"
                    placeholder="Endereço" maxlength="100" style="width: 80px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Complemento</label> <br> <input
                    type="text" class="form-control"
                    name="fornecedor.endereco.complemento"
                    value="${fornecedor.endereco.complemento}" id="exampleInputName1"
                    placeholder="" maxlength="100" style="width: 200px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Bairro</label> <br> <input
                    type="text" class="form-control" name="fornecedor.endereco.bairro"
                    value="${fornecedor.endereco.bairro}" id="exampleInputName1"
                    placeholder="" maxlength="100" style="width: 177px">&nbsp;&nbsp;
            </div>

            <br> <br>

            <div class="form-group">
                <label for="exampleInputName1">Cidade</label> <br> <input
                    type="text" class="form-control" name="fornecedor.endereco.cidade"
                    value="${fornecedor.endereco.cidade}" id="exampleInputName1"
                    placeholder="" maxlength="100" style="width: 250px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">CEP</label> <br> <input
                    type="text" class="form-control" name="fornecedor.endereco.cep"
                    value="${fornecedor.endereco.cep}" id="exampleInputName1"
                    placeholder="-----_---" maxlength="8" style="width: 90px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">UF</label> <br> <input
                    type="text" class="form-control" name="fornecedor.endereco.uf"
                    value="${fornecedor.endereco.uf}" id="exampleInputName1"
                    placeholder="Endereço" maxlength="2" style="width: 50px">&nbsp;&nbsp;
            </div>

            <br> <br>

            <div class="form-group">
                <label for="exampleInputName1">Observação</label> <br>
                <textarea rows="5" cols="50" class="form-control"
                          name="fornecedor.observacao" id="exampleInputName1"
                          placeholder="Escreva algo se for necessário." maxlength="500"
                          style="width: 706px; height: 100px">${fornecedor.observacao}</textarea>
                &nbsp;&nbsp;
            </div>
            <div>
                <button type="submit" class="btn btn-info" id="btn-cf2">
                    <strong>Salvar</strong>
                </button>
            </div>
            <div>
                <a href="/sapato-pim-gerencia/index.jsp">
                    <button type="button" class="btn btn-info" id="btn-cf2">
                        <strong>Cancelar</strong>
                    </button>
                </a>
            </div>
        </form>
        <c:import url="/WEB-INF/jsp/menu/script.jsp" />
    </body>
</html>