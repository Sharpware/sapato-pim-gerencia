<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário de Cadastro de Cliente</title>
</head>
<body>

	<h2>Formulário de Cadastro de Cliente</h2>
	<form method="post">
		<ul>
			<li>
				<p>Nome:</p>
				<input type="text" name="cliente.nome" value="${cliente.nome}" />
			</li>
			<li>
				<p>CPF:</p>
				<input type="text" name="cliente.cpf" value="${cliente.cpf}" />
			</li>
			<li>
				<p>Data de nascimento:</p>
				<input type="text" name="cliente.dataNascimento" value="${cliente.dataNascimento}" />
			</li>
			<li>
				<p>Descrição:</p>
				<textarea name="cliente.descricao" >${cliente.descricao}</textarea>
			</li>
			<li>
				<p>Email:</p>
				<input type="text" name="cliente.email" value="${cliente.email}" />
			</li>
			<li>
				<p>Situação:</p>
				<input type="radio" name="situacao" value="${cliente.situacao}" checked />Ativo
				<input type="radio" name="situacao" value="${cliente.situacao}" />Inativo
			</li>
		</ul>
		<div class="endereco">
			<ul>
				<li>
					<p>Logradouro:</p>
					<input type="text" name="endereco.logradouro" value="${cliente.endereco.logradouro}" />
				</li>
				<li>
					<p>N°:</p>
					<input type="text" name="endereco.numero" value="${cliente.endereco.numero}" />
				</li>
				<li>
					<p>CEP:</p>
					<input type="text" name="endereco.cep" value="${cliente.endereco.cep}" />
				</li>
				<li>
					<p>Complemento:</p>
					<input type="text" name="endereco.complemento" value="${cliente.endereco.complemento}" />
				</li>
				<li>
					<p>Bairro:</p>
					<input type="text" name="endereco.bairro" value="${cliente.endereco.bairro}" />
				</li>
				<li>
					<p>Cidade:</p>
					<input type="text" name="endereco.cidade" value="${cliente.endereco.cidade}" />
				</li>
				<li>
					<p>UF:</p>
					<input type="text" name="endereco.uf" value="${cliente.endereco.uf}" />
				</li>
			</ul>
		</div>
		<div class=telefones>
			<ul>
				<li>
					<p>Telefone residencial:</p>
					<input type="text" name="telefone.numero" value="${telefone.numero}" />
				</li>
				<li>
					<p>Telefone trabalho:</p>
					<input type="text" name="telefone.numero" value="${telefone.numero}" />
				</li>
				<li>
					<p>Celular:</p>
					<input type="text" name="telefone.numero" value="${telefone.numero}" />
				</li>
			</ul>
		</div>
		<input type="submit" value="Salvar" />
	</form>
	
</body>
</html>