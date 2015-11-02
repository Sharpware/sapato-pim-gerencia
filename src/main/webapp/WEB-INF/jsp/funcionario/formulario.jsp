<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrado de funcionario</title>
    </head>	
    <body>
		<form action="${linkTo[FuncionarioController].salvar}" method="post">
		    <h2>Formulário de Cadastro de Funcionario</h2>
		    <ul>
		        <li>
		            <p>Nome:</p>
		            <input type="text" name="funcionario.nome" value="${funcionario.nome}" />
		        </li>
		        <li>
		            <p>CPF:</p>
		            <input type="text" name="funcionario.cpf" value="${funcionario.cpf}" />
		        </li>
		        <li>
		            <p>Data de nascimento:</p>
		            <input type="text" name="funcionario.dataNascimento" value="${funcionario.dataNascimento}" />
		        </li>
		        <li>
		            <p>Descrição:</p>
		            <textarea name="funcionario.descricao" >${funcionario.descricao}</textarea>
		        </li>
		        <li>
		            <p>Email:</p>
		            <input type="text" name="funcionario.email" value="${funcionario.email}" />
		        </li>
		        <li>
		        <!--
		            <p>Situação:</p>
		            <input type="radio" name="funcionario.ativo" value="${funcionario.situacao}" checked />Ativo
		            <input type="radio" name="funcionario.inativo" value="${funcionario.situacao}" />Inativo
		        </li>
		        -->
		    </ul>
		    <div class="endereco">
		        <ul>
		            <li>
		                <p>Logradouro:</p>
		                <input type="text" name="funcionario.endereco.logradouro" value="${funcionario.endereco.logradouro}" />
		            </li>
		            <li>
		                <p>N°:</p>
		                <input type="text" name="funcionario.endereco.numero" value="${funcionario.endereco.numero}" />
		            </li>
		            <li>
		                <p>CEP:</p>
		                <input type="text" name="funcionario.endereco.cep" value="${funcionario.endereco.cep}" />
		            </li>
		            <li>
		                <p>Complemento:</p>
		                <input type="text" name="funcionario.endereco.complemento" value="${funcionario.endereco.complemento}" />
		            </li>
		            <li>
		                <p>Bairro:</p>
		                <input type="text" name="funcionario.endereco.bairro" value="${funcionario.endereco.bairro}" />
		            </li>
		            <li>
		                <p>Cidade:</p>
		                <input type="text" name="funcionario.endereco.cidade" value="${funcionario.endereco.cidade}" />
		            </li>
		            <li>
		                <p>UF:</p>
		                <input type="text" name="funcionario.endereco.uf" value="${funcionario.endereco.uf}" />
		            </li>
		        </ul>
		    </div>
		    <!--
		    <div class="telefones">
		        <ul>
		            <li>
		                <p>Telefone residencial:</p>
		                <input type="text" name="funcionario.telefoneResidencial" value="${funcionario.addTelefone}" />
		            </li>
		            <li>
		                <p>Telefone trabalho:</p>
		                <input type="text" name="funcionario.telefoneTrabalho" value="${funcionario.addTelefone}" />
		            </li>
		            <li>
		                <p>Celular:</p>
		                <input type="text" name="funcionario.celular" value="${funcionario.addTelefone}" />
		            </li>
		        </ul>
		    </div>
		    -->
		    <div class="login">
		    	<ul>
		    		<li>
		    			<p>Login</p>
		    			<input type="text" name="funcionario.login" value="${funcionario.login}" />
		    		</li>
		    		<li>
		    			<p>Senha</p>
		    			<input type="text" name="funcionario.senha" value="${funcionario.senha}" />
		    		</li>
		    	</ul>
		    </div>
		    <input type="submit" value="Salvar" />
		</form>
	</body>
</html>