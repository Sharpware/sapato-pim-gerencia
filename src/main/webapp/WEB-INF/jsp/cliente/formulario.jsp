<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrado de cliente</title>
    </head>	
    <body>
        <form action="${linkTo[ClienteController].salvar}" method="post">
            <h2>Formulário de Cadastro de Cliente</h2>
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
                <!--
                <li>
                    <p>Situação:</p>
                    <input type="radio" name="cliente.situacao" value="${cliente.situacao}" checked />Ativo
                    <input type="radio" name="cliente.situacao" value="${cliente.situacao}" />Inativo
                </li>
                -->
            </ul>
            <div class="endereco">
                <ul>
                    <li>
                        <p>Logradouro:</p>
                        <input type="text" name="cliente.endereco.logradouro" value="${cliente.endereco.logradouro}" />
                    </li>
                    <li>
                        <p>N°:</p>
                        <input type="text" name="cliente.endereco.numero" value="${cliente.endereco.numero}" />
                    </li>
                    <li>
                        <p>CEP:</p>
                        <input type="text" name="cliente.endereco.cep" value="${cliente.endereco.cep}" />
                    </li>
                    <li>
                        <p>Complemento:</p>
                        <input type="text" name="cliente.endereco.complemento" value="${cliente.endereco.complemento}" />
                    </li>
                    <li>
                        <p>Bairro:</p>
                        <input type="text" name="cliente.endereco.bairro" value="${cliente.endereco.bairro}" />
                    </li>
                    <li>
                        <p>Cidade:</p>
                        <input type="text" name="cliente.endereco.cidade" value="${cliente.endereco.cidade}" />
                    </li>
                    <li>
                        <p>UF:</p>
                        <input type="text" name="cliente.endereco.uf" value="${cliente.endereco.uf}" />
                    </li>
                </ul>
            </div>
            <!--
            <div class="telefones">
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
            -->
            <input type="submit" value="Salvar" />
        </form>
    </body>
</html>