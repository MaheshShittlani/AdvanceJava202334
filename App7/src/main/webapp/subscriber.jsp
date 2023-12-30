<%@page import="business.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subscriber Detail</title>
</head>
<body>
	<h1>Thanks for subscribing us</h1>
	<p>You have filled the detail given below...</p>
	<% User user = (User)request.getAttribute("user"); %>
	
	<table border="1" width="200px">
		<tr>
			<td>Name: </td> <td><%=user.getName() %></td>
		</tr>
		<tr>	
			<td>Mobile: </td> <td><%= user.getMobile() %></td>
		</tr>
		<tr>	
			<td>Email: </td> <td><%= user.getEmail() %></td>
		</tr>
	</table>
	
	<h1>Page Visits: <%=request.getAttribute("counter") %></h1>
	<p><a href="index.html">Go Back</a></p>
</body>
</html>