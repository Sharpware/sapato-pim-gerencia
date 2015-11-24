
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Pesquisa de Funcionario</title>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu/menu.jsp" />
        <table class="table" border="1px">
            <div>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome do Funcionario</th>
                        <th>CPF</th>
                        <th>Editar</th>
                </thead>
                <tbody>
                    <c:forEach items="${funcionarios}" var="funcionario">
                        <tr>
                            <td>${funcionario.id}</td>
                            <td>${funcionario.nome}</td>
                            <td>${funcionario.cpf}</td>
                            <td>
                                <a href="${linkTo[FuncionarioController].editar(funcionario.id)}">
                                    <button type="button" class="btn btn-info" id="btn-pc">
                                        <strong>
                                            Editar Funcionario
                                        </strong>
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </div>
        </table>
        <c:import url="/WEB-INF/jsp/menu/script.jsp" />
    </body>
</html>