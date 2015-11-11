<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de fornecedores cadastrados</title>
    </head>	
    <body>

        <h2>Lista de fornecedores cadatrados</h2>
        <ul>
            <c:forEach items="${fornecedores}" var="fornecedor">
                <li>
                    ID: ${fornecedor.id} Nome fantasia: ${fornecedor.nomeFantasia} CPF: ${fornecedor.cnpj} 
                    <a${linkTo[FornecedorController].editar(fornecedor.id)}>Modificar</a>
                </li>
            </c:forEach>
        </ul>

    </body>
</html>