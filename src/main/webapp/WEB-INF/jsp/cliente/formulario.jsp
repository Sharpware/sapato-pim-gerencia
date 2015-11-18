<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>
    <body>    
    	<c:import url="/WEB-INF/jsp/menu/menu.jsp" />
            <div id="div-cc-azul">
                    <p class="lbl-cclient"><strong><em>Formulario de Cliente</em></strong></p>

                    <form class="form-inline" id="codigo-pp-left" action="${linkTo[ClienteController].salvar}" method="post">
                        <input type="text" name="cliente.id" value="${cliente.id}" hidden="true" />
                        <div class="form-group">
                            <label for="exampleInputName1">Nome</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="cliente.nome" value="${cliente.nome}" maxlength="60" style="width: 300px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputEmail2">Email</label>
                            <br>
                            <input type="email" class="form-control" id="exampleInputEmail2" name="cliente.email" value="${cliente.email}" placeholder="jane.doe@example.com" maxlength="40" style="width: 250px">&nbsp;&nbsp;
                        </div>

                        <br>
                        <br>

                        <div class="form-group">
                            <label for="exampleInputName1">CPF</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="cliente.cpf" value="${cliente.cpf}" placeholder="---.---.---.--" maxlength="11" style="width: 130px">&nbsp;&nbsp;

                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">Data de Nascimento</label>
                            <br>
                            <input type="date" class="form-control" id="exampleInputName1" name="cliente.dataNascimento" value="${cliente.dataNascimento}" style="width: 160px">&nbsp;&nbsp;
                        </div>

                        <!--Situação-->
                        <div class="form-group" id="div-status-cc">
                            <p style="color:white"><strong>Situação</strong></p>
                            <div class="radio">
                                <label style="align: center">
                                    <input type="radio" name="optionsRadios" id="ativo" value="option1" checked>
                                    Ativo
                                </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
                                <label>
                                    <input type="radio" name="optionsRadios" id="inativo" value="option2">
                                    Inativo
                                </label>
                            </div>
                        </div>

                        <br>
                        <br>

                        <!--Telefone-->
                        <div class="form-group">
                            <label for="exampleInputName1">Telefone Residencial</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="telefone1.numero" placeholder="DDD + Tel" maxlength="12" style="width: 130px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">Telefone Comercial</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="telefone2.numero" placeholder="DDD + Tel" maxlength="12" style="width: 130px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">Celular</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="telefone3.numero" placeholder="DDD + Cel" maxlength="12" style="width: 130px">&nbsp;&nbsp;
                        </div>

                        <br>
                        <br>

                        <!--Endereco-->
                        <div class="form-group">
                            <label for="exampleInputName1">Logradouro</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.logradouro" value="${cliente.endereco.logradouro}" placeholder="Endereço" maxlength="100" style="width: 210px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">Número</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.numero" value="${cliente.endereco.numero}" placeholder="Endereço" maxlength="100" style="width: 90px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">Complemento</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.complemento" value="${cliente.endereco.complemento}" maxlength="100" style="width: 200px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">Bairro</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.bairro" value="${cliente.endereco.bairro}"  maxlength="100" style="width: 180px">&nbsp;&nbsp;
                        </div>

                        <br>
                        <br>

                        <div class="form-group">
                            <label for="exampleInputName1">Cidade</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.cidade" value="${cliente.endereco.cidade}" maxlength="100" style="width: 250px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">CEP</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.cep" value="${cliente.endereco.cep}" placeholder="-----_---" maxlength="8" style="width: 90px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group">
                            <label for="exampleInputName1">UF</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="endereco.uf" value="${cliente.endereco.uf}" maxlength="2" style="width: 50px">&nbsp;&nbsp;
                        </div>

                        <br>
                        <br>

                        <div class="form-group">
                            <label for="exampleInputName1">Observação</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" name="cliente.observacao" value="${cliente.observacao}" maxlength="500" style="width: 706px">&nbsp;&nbsp; 
                        </div>

                        <button type="submit" class="btn btn-info" id="btn-cc">
                        	<strong>Salvar</strong>
                        </button>
                    </form>
            </div>
        </div>
        <c:import url="/WEB-INF/jsp/menu/script.jsp" />
    </body>
</html>