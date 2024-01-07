<%@page import="java.util.ArrayList"%>
<%@page import="com.myweb.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String message = (String)session.getAttribute("message"); 
	session.removeAttribute("message");
	
	User user = (User)session.getAttribute("user");
	
	if(user != null) {
		response.sendRedirect("dashboard.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserApp | Login Page</title>
</head>
<body>
	<p><%= message!=null ? message : "" %></p>
	<form method="post" action="login">
		<table align="center">
			<tr>
				<td colspan="2" align="center">
					<h2>Login</h2>
				</td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="email" id="email" name="email" required>
				</td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input type="password" id="password" name="password"
					required></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Login</button>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<p>
						Don't have an account? <a href="singup.jsp">Signup</a>
					</p>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>