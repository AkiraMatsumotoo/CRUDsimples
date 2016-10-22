<%@page import="br.com.akira.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.com.akira.dao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
		<a href="usuController?acao=cad">Cadastrar</a>
		
	<form>
		<fieldset>
			<legend>Lista de Usuários</legend>
			<table border="1" bgcolor="#DADADA" >
				<%
					List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
				%>
				<tr>
					<th width="20">ID</th>
					<th width="150">Nome</th>
					<th width="20">Login</th>
					<th width="20">Senha</th>
					<th width="20">Excluir</th>
					<th width="20">Editar</th>
				</tr>
				<%
					for (Usuario u : lista) {
				%>
				<tr>
					<td><%=u.getId()%></td>
					<td><%=u.getNome()%></td>
					<td><%=u.getLogin()%></td>
					<td><%=u.getSenha()%></td>
					<td><a href="usuController?acao=exc&id=<%=u.getId()%>" onclick="return confirm('Deseja excluir ?')">Excluir</a></td>
					<td><a href="usuController?acao=alt&id=<%=u.getId()%>">Editar</a></td>
				</tr>
				<%
					}
				%>
			</table>
		</fieldset>
	</form>
</body>
</html>