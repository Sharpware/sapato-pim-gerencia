<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrado de fornecedor</title>
    </head>	
    <body>
		<form action="${linkTo[FornecedorController].salvar}" method="post">
		    <h2>Formulário de Fornecedor de Cliente</h2>
		    <ul>
		        <li>
		            <p>Nome fantasia:</p>
		            <input type="text" name="fornecedor.nomeFantasia" value="${fornecedor.nomeFantasia}" />
		        </li>
		        <li>
		        	<p>Razão social:</p>
		        	<input type="text" name="fornecedor.razaoSocial" value="${fornecedor.razaoSocial}" />
		        </li>
		        <li>
		            <p>CNPJ:</p>
		            <input type="text" name="fornecedor.cnpj" value="${fornecedor.cnpj}" />
		        </li>
		        <li>
		            <p>Data de nascimento:</p>
		            <input type="text" name="fornecedor.dataNascimento" value="${fornecedor.dataNascimento}" />
		        </li>
		        <li>
		            <p>Descrição:</p>
		            <textarea name="fornecedor.descricao" >${fornecedor.descricao}</textarea>
		        </li>
		        <li>
		            <p>Email:</p>
		            <input type="text" name="fornecedor.email" value="${fornecedor.email}" />
		        </li>
		        <li>
		        <!--
		            <p>Situação:</p>
		            <input type="radio" name="fornecedor.ativo" value="${fornecedor.situacao}" checked />Ativo
		            <input type="radio" name="fornecedor.inativo" value="${fornecedor.situacao}" />Inativo
		        </li>
		        -->
		    </ul>
		    <div class="endereco">
		        <ul>
		            <li>
		                <p>Logradouro:</p>
		                <input type="text" name="fornecedor.endereco.logradouro" value="${fornecedor.endereco.logradouro}" />
		            </li>
		            <li>
		                <p>N°:</p>
		                <input type="text" name="fornecedor.endereco.numero" value="${fornecedor.endereco.numero}" />
		            </li>
		            <li>
		                <p>CEP:</p>
		                <input type="text" name="fornecedor.endereco.cep" value="${fornecedor.endereco.cep}" />
		            </li>
		            <li>
		                <p>Complemento:</p>
		                <input type="text" name="fornecedor.endereco.complemento" value="${fornecedor.endereco.complemento}" />
		            </li>
		            <li>
		                <p>Bairro:</p>
		                <input type="text" name="fornecedor.endereco.bairro" value="${fornecedor.endereco.bairro}" />
		            </li>
		            <li>
		                <p>Cidade:</p>
		                <input type="text" name="fornecedor.endereco.cidade" value="${fornecedor.endereco.cidade}" />
		            </li>
		            <li>
		                <p>UF:</p>
		                <input type="text" name="fornecedor.endereco.uf" value="${fornecedor.endereco.uf}" />
		            </li>
		        </ul>
		    </div>
		    <!--
		    <div class="telefones">
		        <ul>
		            <li>
		                <p>Telefone residencial:</p>
		                <input type="text" name="fornecedor.telefoneResidencial" value="${fornecedor.addTelefone}" />
		            </li>
		            <li>
		                <p>Telefone trabalho:</p>
		                <input type="text" name="fornecedor.telefoneTrabalho" value="${fornecedor.addTelefone}" />
		            </li>
		            <li>
		                <p>Celular:</p>
		                <input type="text" name="fornecedor.celular" value="${fornecedor.addTelefone}" />
		            </li>
		        </ul>
		    </div>
		    -->
		    <input type="submit" value="Salvar" />
		</form>
	</body>
</html>