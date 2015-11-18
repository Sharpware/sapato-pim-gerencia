<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    	<title>Pesquisa de Cliente</title>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu/menu.jsp" />
            <div id="page-wrapper">
                <div id="div-pc-azul">

                    <p class="lbl-cclient"><strong><em>Pesquisa de Cliente</em></strong></p>
                    <br>
                    <form class="form-inline" id="codigo-pp-left">


                        <div class="form-group">
                            <label for="exampleInputName1">Codigo</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" maxlength="60" style="width: 70px">&nbsp;&nbsp;
                        </div>


                        <div class="form-group">
                            <label for="exampleInputName1">Nome</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" maxlength="60" style="width: 300px">&nbsp;&nbsp;
                        </div>

                        <div class="form-group" id="div-status-pc">
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
                                    CPF
                                </label>                            

                            </div>

                        </div>

                        <br>

                        <div class="form-group">
                            <label for="exampleInputName1">CPF</label>
                            <br>
                            <input type="text" class="form-control" id="exampleInputName1" placeholder="---_---_---_--" maxlength="11" style="width: 300px">&nbsp;&nbsp;
                        </div>

                    </form>

                    <!-- PAINEL BRANCO -->

                    <div id="grid-pc-branco" class="panel panel-default">

                        <!-- Tables no PAINEL BRANCO -->
                        <table class="table" border="1px">
                            <div>
                                <div>
                                    <thead>
                                        <tr>
                                            <th>
                                                Código
                                            </th>
                                            <th>
                                                Nome do Cliente
                                            </th>
                                            <th>
                                                CPF
                                            </th>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${clientes}" var="cliente">
                                            <tr>
                                                <td>
                                                    <input type="radio" name="cliente.id"/>${cliente.id}
                                                    &nbsp;
                                                </td>
                                                <td>
                                                    ${cliente.nome}
                                                </td>
                                                <td>
                                                    ${cliente.cpf}
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </div>
                        </table>
                    </div>

                    <br>
                    <br>

                    <button type="button" class="btn btn-info" id="btn-pc"><strong>Cadastrar Cliente</strong></button>

                    <button type="button" class="btn btn-info" id="btn-pc"><strong>Inativar Cliente</strong></button>

                    <button type="submit" class="btn btn-info" action="${linkTo[ClienteController].editar(cliente.id)}" id="btn-pc"><strong>Editar Cliente</strong></button>

            </div>
        </div>
        <c:import url="/WEB-INF/jsp/menu/script.jsp" />
    </body>
</html>