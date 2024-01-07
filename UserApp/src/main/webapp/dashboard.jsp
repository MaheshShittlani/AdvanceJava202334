<%@page import="com.myweb.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserApp | UserApp</title>
</head>
<body>
	<h1>Dashboard</h1>
	<h2>Welcome <%= user.getName() %></h2>
	<p><a href="change-profile.jsp">Change Profile</a></p>
	<form action="logout" method="Post">
		<button type="submit">Logout</button>
	</form>
	
	<p><a href="category.jsp">Category Manager</a></p>
</body>
</html>