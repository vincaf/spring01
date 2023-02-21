<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello from Spring Boot App JSP</title>
</head>
<body>
	<h1>Hello from Spring Boot App JSP</h1>
	<% String msg = (String) request.getAttribute("messaggio"); %>
	<div><%=msg %></div>
</body>
</html>