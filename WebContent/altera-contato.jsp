<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração de contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h3>Formulário para alteração de contatos:</h3>
	<br />
	<form action="mvc" method="POST">
		Id: <input type="text" name="id" /><br /> Nome: <input type="text"
			name="nome" /><br /> E-mail: <input type="text" name="email" /><br />
		Endereço: <input type="text" name="endereco" /><br /> Data de
		Nascimento:	<caelum:campoData id="dataNascimento" />
		<input type="hidden" name="logica" value="AlteraContatoLogic" /> <input
			type="submit" value="Enviar" />
	</form>
	<c:import url="rodape.jsp" />

</body>
</html>