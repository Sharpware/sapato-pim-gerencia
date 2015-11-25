<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Pesquisa de Fornecedor</title>
<c:import url="/WEB-INF/jsp/menu/template.jsp" />
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu/menu.jsp" />

	<h1 class="text-center">
		<strong><em>Pesquisa de Fornecedor</em></strong>
	</h1>
	<br>
	<div class="form-horizontal col-md-offset-2 col-md-8">
		<label for="nomeTbx">Nome Fantasia</label>
		<div class="col-md-8 input-group">
			<input type="text" class="form-control" id="nomeTbx"
				placeholder="Nome"> <span class="input-group-btn">
				<button type="submit" class="btn btn-success ">
					<span class="glyphicon glyphicon-search"></span> Pesquisar
				</button>
			</span>
		</div>
		<label for="nomeTbx">Codigo</label>
		<div class="col-md-8 input-group">
			<input type="text" class="form-control" id="nomeTbx"
				placeholder="Codigo"> <span class="input-group-btn">
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-search"></span> Pesquisar
				</button>
			</span>
		</div>
		<label for="nomeTbx">CNPJ</label>
		<div class="col-md-8 input-group">
			<input type="text" class="form-control" id="nomeTbx"
				placeholder="CPF"> <span class="input-group-btn">
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-search"></span> Pesquisar
				</button>
			</span>
		</div>
		<br> <br>
		<table class="table table-bordered table-hover tabela">
			<thead>
				<tr class="success">
					<th>Id</th>
					<th>Nome</th>
					<th>CNPJ</th>
					<th>Email</th>
					<th>Funções</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fornecedores}" var="fornecedor">
					<tr>
						<td>${fornecedor.id}</td>
						<td>${fornecedor.nomeFantasia}</td>
						<td>${fornecedor.cnpj}</td>
						<td>${fornecedor.emailPrimario}</td>
						<td>
							<button type="submit" class="btn btn-primary btn-sm ">
								<span class="glyphicon glyphicon-ban-circle"></span> Inativar
							</button> <a href="${linkTo[FornecedorController].editar(fornecedor.id)}">
								<button type="button" class="btn btn-primary btn-sm ">
									<span class="glyphicon glyphicon-pencil"></span> Editar
								</button>
						</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col-md-6 col-md-push-7">
				<a href="../index.jsp"><button type="button"
						class="btn btn-danger col-md-4 col-md-pull-1">
						<span class="glyphicon glyphicon-remove"></span> Cancelar
					</button></a>
				<form action="${linkTo[FornecedorController].pesquisarTodos}"
					method="get">
					<button type="submit" class="btn btn-success col-md-6">
						<span class="glyphicon glyphicon-search"></span> Pesquisar todos
					</button>
				</form>
				<br> <br> <br>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/jsp/menu/script.jsp" />
</body>
</html>