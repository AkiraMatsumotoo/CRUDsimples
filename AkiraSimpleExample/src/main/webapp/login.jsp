<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
	<form method="post" action="loginController">
		<fieldset>
			<legend>Tela de Login</legend>
			<table>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" value="" /></td>
				</tr>
				<tr>
					<td>Senha</td>
					<td><input type="text" name="senha" value="" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="" value="Entrar" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>