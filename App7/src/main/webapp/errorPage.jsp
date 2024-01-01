<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500- Something went wrong</title>
</head>
<body>
	<h1>Somehing went wrong.</h1>
	<p>Opps:) Will fix this soon.</p>
	<p>Error detail: <%= exception.toString() %> </p>
</body>
</html>