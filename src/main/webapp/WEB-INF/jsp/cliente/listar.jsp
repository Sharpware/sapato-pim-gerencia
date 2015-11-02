<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de clientes cadastrados</title>
    </head>	
    <body>

        <h2>Lista de clientes cadatrados</h2>
        <ul>
            <c:forEach items="${clientes}" var="cliente">
                <li>
                    ID: ${cliente.id} Nome: ${cliente.nome} CPF: ${cliente.cpf} 
                    <a${linkTo[ClienteController].editar(cliente.id)}>Modificar</a>
                </li>
            </c:forEach>
        </ul>

    </body>
</html>