
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
    </head>
    <body>
        <c:import url="/WEB-INF/jsp/menu/menu.jsp" />
            <div id="page-wrapper" style="background-color:#AADBFF">
               <ul>
		            <c:forEach items="${funcionarios}" var="funcionario">
		                <li>
		                    ID: ${funcionario.id} Nome: ${funcionario.nome} CPF: ${funcionario.cpf} 
		                    <a${linkTo[FuncionarioController].editar(funcionario.id)}>Modificar</a>
		                </li>
		            </c:forEach>
		        </ul>
            </div>
        </div>
        <c:import url="/WEB-INF/jsp/menu/script.jsp" />
    </body>
</html>