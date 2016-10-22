<%@page import="br.com.akira.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina inicial</title>
</head>
<body>
	<form>
		<table>
			<%
				Usuario usuario = (Usuario)request.getSession().getAttribute("loginConfirmado");
			%>
			<tr>
				<td>Bem vindo </td><td><%=usuario.getNome()%></td>
			</tr>
			<tr>
				<th><a href="usuController?acao=list">Lista de Usuários</a></th>
			</tr>
		</table>
	</form>
</body>
</html>