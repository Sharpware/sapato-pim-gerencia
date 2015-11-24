<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário de Funcionário</title>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>	
    <body>
        <c:import url="/WEB-INF/jsp/menu/menu.jsp" />

        <p class="lbl-cclient"><strong><em>Formulário de Funcionário</em></strong></p>

        <ul class="errors">
            <c:forEach items="${errors}" var="error">
                <li>
                    ${error.message}
                </li>
            </c:forEach>
        </ul>

        <form class="form-inline" id="codigo-pp-left" action="${linkTo[FuncionarioController].salvar}" method="post">

            <input type="text" name="funcionario.id"
                   value="${funcionario.id}" hidden="true" />

            <input type="text" name="telefone1.id"
                   value="${telefone1.id}" hidden="true" />

            <input type="text" name="telefone2.id"
                   value="${telefone2.id}" hidden="true" />

            <input type="text" name="telefone3.id"
                   value="${telefone3.id}" hidden="true" />

            <div class="form-group">
                <label for="exampleInputName1">Nome</label>
                <br>
                <input type="text" class="form-control" name="funcionario.nome" value="${funcionario.nome}" id="exampleInputName1" placeholder="Nome completo do usuário" maxlength="60" style="width: 280px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">CPF</label>
                <br>
                <input type="text" class="form-control" name="funcionario.cpf" value="${funcionario.cpf}" id="exampleInputName1" placeholder="" maxlength="60" style="width: 200px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">Email</label>
                <br>
                <input type="email" class="form-control" name="funcionario.email" value="${funcionario.email}" id="exampleInputEmail2" placeholder="Email do usuário" maxlength="40" style="width: 250px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Login</label>
                <br>
                <input type="text" class="form-control" name="funcionario.login" value="${funcionario.login}" id="exampleInputName1" placeholder="" maxlength="60" style="width: 200px">&nbsp;&nbsp;
            </div>

            <div class="form-group">
                <label for="exampleInputName1">Senha</label>
                <br>
                <input type="text" class="form-control" name="funcionario.senha" value="${funcionario.senha}" id="exampleInputName1" placeholder="" maxlength="14" style="width: 180px">&nbsp;&nbsp;
            </div>

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

            <div class="form-group">
                <label for="exampleInputEmail1">Tipo de usuário</label><br>    
                <select class="form-control">
                    <option>Administrador</option>
                    <option>Vendedor</option>
                    <option>Caixa</option>
                </select>
            </div>

            <br>
            <br>

            <div class="form-group" id="div-status-cfn">
                <p style="color:white"><strong>Situacao</strong></p>
                <div class="radio">
                    <label style="align: center">
                        <input type="radio" name="optionsRadios" id="optionsRadios1" name="${funcionario.situacao}" value="funcionario.situacao" checked>
                        Ativo
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios2" name="${funcionario.situacao}" value="funcionario.situacao">
                        Inativo
                    </label>
                </div>
            </div>

            <br>
            <br>
            <br>
            <button type="submit" class="btn btn-info" id="btn-cfn1"><strong>Salvar</strong></button>
        </form>
    </div>
</div>
<c:import url="/WEB-INF/jsp/menu/script.jsp" />
</body>
</html>