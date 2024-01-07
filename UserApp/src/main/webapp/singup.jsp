<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HashMap<String,String> errors = (HashMap<String,String>)session.getAttribute("errors");

if(errors == null) {
	 errors = new HashMap<String,String>();
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
	.error {
		color: red;
	}
</style>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Signup Page</title>
</head>
<body>
	<form method="post" action="signup">
		<table align="center">
			<tr>
				<td colspan="2" align="center">
					<h2>Signup</h2>
				</td>
			</tr>
			<tr>
				<td><label for="name">Name:</label></td>
				<td>
					<input type="text" id="name" name="name">
					<span class="error"><% if(errors.containsKey("name")) {out.println(errors.get("name"));} %></span>
				</td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
				<td>
					<input type="email" id="email" name="email">
					<span class="error"><% if(errors.containsKey("email")) {out.println(errors.get("email"));} %></span>
				</td>
				
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input type="password" id="password" name="password">
					<span class="error"><% if(errors.containsKey("password")) {out.println(errors.get("password"));} %></span>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">Signup</button>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<p>
						Already have an account? <a href="login.html">Login</a>
					</p>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
