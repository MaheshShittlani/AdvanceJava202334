<%@page import="com.myweb.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	User user = (User)session.getAttribute("user"); 
	if(user == null) {
		user = new User();
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserApp | UserApp</title>
</head>
<body>
	<h1>Dashboard</h1>
	<h2>Welcome <%= user.getName() %></h2>
</body>
</html>