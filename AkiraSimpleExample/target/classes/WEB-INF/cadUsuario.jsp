<%@page import="br.com.akira.dao.UsuarioDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.com.akira.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tela de Usuários</title>
</head>
<body>
	<fieldset>
		<legend>Tela de Usuários</legend>
		<form action="usuController" method="post">
			<table>
				<% Usuario usuario = (Usuario)request.getAttribute("usuario"); %>
				<tr>
					<td>ID</td><td><input type="text" name="id" value="<%=usuario.getId()%>" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>Nome</td><td><input type="text" name="nome" value="<%=usuario.getNome()%>" /></td>
				</tr>			
				<tr>
					<td>Login</td><td><input type="text" name="login" value="<%=usuario.getLogin()%>" /></td>
				</tr>
				<tr>
					<td>Senha</td><td><input type="text" name="senha" value="<%=usuario.getSenha()%>" /></td>
				</tr>
				<tr>
					<td></td><td><input type="submit" name="" value="Savlar"/></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>