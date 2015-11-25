<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulário de Funcionário</title>
<c:import url="/WEB-INF/jsp/menu/template.jsp" />
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu/menu.jsp" />
	<form action="${linkTo[FuncionarioController].salvar}" method="post"
		class="form-horizontal col-md-offset-2 col-md-8 ">
		<h1 class="text-center">
			<strong><em>Formulário de Funcionario</em></strong>
		</h1>

		<ul class="errors">
			<c:forEach items="${errors}" var="error">
				<li>${error.message}</li>
			</c:forEach>
		</ul>

		<input type="text" name="funcionario.id" value="${funcionario.id}"
			hidden="true" /> <input type="text" name="telefone1.id"
			value="${telefone1.id}" hidden="true" /> <input type="text"
			name="telefone2.id" value="${telefone2.id}" hidden="true" /> <input
			type="text" name="telefone3.id" value="${telefone3.id}" hidden="true" />

		<br>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="loginTbx">Login</label> <input type="text"
						class="form-control" id="loginTbx" placeholder="Login"
						name="funcionario.login" value="${funcionario.login}" />
				</div>
				<div class="form-group">
					<label for="senhaTbx">Senha</label> <input type="text"
						class="form-control" id="senhaTbx" placeholder="Senha"
						name="funcionario.senha" value="${funcionario.senha}" />
				</div>
			</div>
			<div class="col-md-5 col-md-push-1">
				<br>
				<div class="radio borda">
					<h4 class="text-center">Tipo de funcionario</h4>
					<div class="col-md-offset-2">
						<label class="col-md-12"> <input type="radio" name=""
							id="ativoRb" value="" checked> Gerente
						</label> <label class="col-md-12"> <input type="radio" name=""
							id="inativoRb" value=""> Caixa
						</label> <label> <input type="radio" name="" id="inativoRb"
							value=""> Vendedor
						</label>
					</div>
					<br>
				</div>
			</div>
			<br>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="nomeTbx">Nome</label> <input type="text"
						class="form-control" id="nomeTbx" placeholder="Nome"
						name="funcionario.nome" value="${funcionario.nome}" />
				</div>
			</div>
			<div class="col-md-5 col-md-push-1">
				<div class="form-group">
					<label for="emailTbx">Email</label> <input type="text"
						class="form-control" id="emailTbx" placeholder="Email"
						name="funcionario.email" value="${funcionario.email}" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="cpfTbx">CPF</label> <input type="text"
						class="form-control" id="cpfTbx" placeholder="CPF"
						name="funcionario.cpf" value="${funcionario.cpf}"
						data-mask="999.999.999-99" />
				</div>
				<div class="form-group">
					<label for="nomeTbx">Data de Nascimento</label> <input type="text"
						class="form-control" id="dataNascimentoTbx"
						placeholder="Data de nascimento" name="funcionario.dataNascimento"
						value="${funcionario.dataNascimento}" data-mask="99/99/9999" />
				</div>
			</div>
			<br>
			<div class="col-md-5 col-md-push-1">
				<div class="radio borda">
					<h4 class="text-center">Situação</h4>
					<div class="col-md-offset-2">
						<label class="col-md-12"> <input type="radio"
							name="situacao" id="ativoRb" value="situacao.ativo" checked>
							Ativo
						</label> <label> <input type="radio" name="situacao"
							id="inativoRb" value="situacao.inativo"> Inativo
						</label>
					</div>
					<br>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label for="telefoneResidencialTbx">Telefone Residencial</label> <input
						type="text" class="form-control" id="residencial"
						placeholder="Telefone Residencial" name="telefone1.numero"
						value="${telefone1.numero}" data-mask="(99)9999-9999" />
				</div>
			</div>
			<div class="col-md-3 col-md-offset-1">
				<div class="form-group">
					<label for="telefoneComercialTbx">Telefone Comercial</label> <input
						type="text" class="form-control" id="telefoneComercialTbx"
						placeholder="Telefone comercial" name="telefone2.numero"
						value="${telefone2.numero}" data-mask="(99)9999-9999" />
				</div>
			</div>
			<div class="col-md-3 col-md-offset-1">
				<div class="form-group">
					<label for="celularTbx">Celular</label> <input type="text"
						class="form-control" id="celularTbx" placeholder="Celular"
						name="telefone3.numero" value="telefone3.numero"
						data-mask="(99)9-9999-9999" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="logradouroTbx">Logradouro</label> <input type="text"
						class="form-control" id="logradouroTbx" placeholder="Logradouro"
						name="endereco.logradouro"
						value="${funcionario.endereco.logradouro}" />
				</div>
			</div>
			<div class="col-md-5 col-md-push-1">
				<div class="form-group">
					<label for="numeroTbx">Numero</label> <input type="text"
						class="form-control" id="numeroTbx" placeholder="Numero"
						name="endereco.numero"
						value="${funcionario.endereco.numero}" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label for="complementoTbx">Complemento</label> <input type="text"
						class="form-control" id="complementoTbx" placeholder="Complemento"
						name="endereco.complemento"
						value="${funcionario.endereco.complemento}" />
				</div>
			</div>
			<div class="col-md-5 col-md-push-1">
				<div class="form-group">
					<label for="bairroTbx">Bairro</label> <input type="text"
						class="form-control" id="bairroTbx" placeholder="Bairro"
						name="endereco.bairro"
						value="${funcionario.endereco.bairro}" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div class="form-group">
					<label for="cidadeTbx">Cidade</label> <input type="text"
						class="form-control" id="cidadeTbx" placeholder="Cidade"
						name="endereco.cidade"
						value="${funcionario.endereco.cidade}" />
				</div>
			</div>
			<div class="col-md-4 col-md-push-1">
				<div class="form-group">
					<label for="cepTbx">CEP</label> <input type="text"
						class="form-control" id="cepTbx" placeholder="CEP"
						name="endereco.cep"
						value="${funcionario.endereco.cep}" data-mask="99999-999" />
				</div>
			</div>
			<div class="col-md-1 col-md-push-2">
				<div class="form-group">
					<label for="ufTbx">UF</label> <input type="text"
						class="form-control" id="ufTbx" placeholder="UF"
						name="endereco.uf" value="${funcionario.endereco.uf}"
						data-mask="AA" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="form-group">
					<label for="observacaoTbx">Observação</label>
					<textarea name="funcionario.observacao"
						class="form-control col-md-12" rows="4">${funcionario.observacao}</textarea>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-6 col-md-push-8">
				<a href="../index.jsp">
					<button type="button" class="btn btn-danger col-md-4 col-md-pull-1">
						<span class="glyphicon glyphicon-remove"></span> Cancelar
					</button>
				</a>
				<button type="submit" class="btn btn-success col-md-4 ">
					<span class="glyphicon glyphicon-floppy-save"></span> Salvar
				</button>
				<br> <br> <br>
			</div>
		</div>
	</form>
	<c:import url="/WEB-INF/jsp/menu/script.jsp" />
</body>
</html>