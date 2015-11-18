<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="/WEB-INF/jsp/menu/template.jsp" />
        <title>Formulário de Cliente</title>
    </head>	
    <body>
    	<c:import url="/WEB-INF/jsp/menu/menu.jsp" />
		<div id="page-wrapper">
               
               <div id="div-cc-azul">
                
                    <p class="lbl-cclient"><strong><em>Formulário de Funcionário</em></strong></p>
                            
                      <form class="form-inline" id="codigo-pp-left" action="${linkTo[FuncionarioController].salvar}" method="post">
                      <div class="form-group">
                        <label for="exampleInputName1">Nome</label>
                        <br>
                        <input type="text" class="form-control" name="funcionario.nome" value="${funcionario.nome}" id="exampleInputName1" placeholder="Nome completo do usuário" maxlength="60" style="width: 280px">&nbsp;&nbsp;
                      </div>
                      
                      <div class="form-group">
                        <label for="exampleInputEmail2">Email</label>
                        <br>
                        <input type="email" class="form-control" name="funcionario.email" value="${funcionario.email}" id="exampleInputEmail2" placeholder="Email do usuário" maxlength="40" style="width: 250px">&nbsp;&nbsp;
                      </div>
                      
                      <br>
                      <br>
                      
                      <div class="form-group">
                        <label for="exampleInputName1">Login</label>
                        <br>
                        <input type="text" class="form-control" name="funcionario.login" value="${funcionario.login}" id="exampleInputName1" placeholder="" maxlength="60" style="width: 200px">&nbsp;&nbsp;
                      </div>
                      
                      <div class="form-group">
                        <label for="exampleInputName1">Senha</label>
                        <br>
                        <input type="text" class="form-control" name="funcionario.senha" value="${funcionario.senha}" id="exampleInputName1" placeholder="" maxlength="14" style="width: 180px">&nbsp;&nbsp;
                      </div>
                      
                      <div class="form-group">
                      <label for="exampleInputEmail1">Tipo de usuário</label><br>    
                      <select class="form-control">
                          <option>Administrador</option>
	                      <option>Vendedor</option>
	                      <option>Caixa</option>
                      </select>
                        </div>
                        
                        <br>
                        <br>
                        
                        <div class="form-group" id="div-status-cfn">
                          <p style="color:white"><strong>Status</strong></p>
                          <div class="radio">
                              <label style="align: center">
                                <input type="radio" name="optionsRadios" id="optionsRadios1" name="${funcionario.situacao}" value="funcionario.situacao" checked>
                                Ativo
                              </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
                               <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios2" name="${funcionario.situacao}" value="funcionario.situacao">
                                Inativo
                              </label>
                            </div>
                      </div>
                      
                      <br>
                      <br>
                      <br>
                   </form>    
                              
                   <div>
                       
                        <button type="submit" class="btn btn-info" id="btn-cfn1"><strong>Salvar</strong></button>
                    </div>
                    
                   </div>
                </div>
		<c:import url="/WEB-INF/jsp/menu/script.jsp" />
	</body>
</html>