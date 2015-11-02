<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de clientes cadastrados</title>
    </head>	
    <body>

        <h2>Lista de funcionarios cadatrados</h2>
        <ul>
            <c:forEach items="${funcionarios}" var="funcionario">
                <li>
                    ID: ${funcionario.id} Nome: ${funcionario.nome} CPF: ${funcionario.cpf} 
                    <a${linkTo[FuncionarioController].editar(funcionario.id)}>Modificar</a>
                </li>
            </c:forEach>
        </ul>

    </body>
