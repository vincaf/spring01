<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="com.example.database.entity.Cliente" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/table-style.css">
	<title>Clienti JSP</title>
</head>
<body>
	<h1>Elenco dei Clienti</h1>
	<%
	List<Cliente> clienti = (List<Cliente>)request.getAttribute("lista.clienti");
	
	/* per stampare una lista con ordine decrescente per id
	 Comparator<Cliente> cl = (x, x1) -> { 
	 	return x1.getIdCliente() - x.getIdCliente(); 
	 };
	 clienti = clienti.stream().sorted(cl).toList();
	*/
	
	%>

	<table>
		<tr>
			<th>#</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th>Indirizzo</th>
			<th>Citta</th>
			<th>Provincia</th>
			<th>CAP</th>
		</tr>
		<!-- repeating group di TR una per ciascuna provincia -->
		<%for(Cliente c: clienti) { %>
		<tr>
			<td><%=c.getIdCliente()%></td>
			<td><%=c.getNome()%></td>
			<td><%=c.getCognome()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getIndirizzo() %></td>
			<td><%=c.getCitta() %></td>
			<td><%=c.getProvincia() %></td>
			<td><%=c.getCap() %></td>
		</tr>
		<%} %>
	</table>

	<h3>Inserimento Cliente</h3>
    <form action="/mvc-clienti" method="POST">
		<div>
			<label for="nome">Nome</label>
			<input type="text" id="nome" name="nome">
		</div>
		<div>
			<label for="nome">Cognome</label>
			<input type="text" id="cognome" name="cognome">
		</div>
		<div>
			<label for="email">Email</label>
			<input type="text" id="email" name="email">
		</div>
		<div>
			<label for="indirizzo">Indirizzo</label>
			<input type="text" id="indirizzo" name="indirizzo">
		</div>
		<div>
			<label for="citta">Città</label>
			<input type="text" id="citta" name="citta">
		</div>
		<div>
			<label for="provincia">Provincia</label>
			<input type="text" id="provincia" name="provincia" maxlength="2">
		</div>
		<div>
			<label for="cap">CAP</label>
			<input type="number" id="cap" name="cap" maxlength="5">
		</div>
		<div>
			<input type="submit" value="Invia">
		</div>
    </form>
</body>
</html>