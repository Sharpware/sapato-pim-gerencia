<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                <li>ID: ${cliente.id} Nome: ${cliente.nome} CPF: ${cliente.cpf}</li>
            </c:foreach>
        </ul>

    </body>
</html>