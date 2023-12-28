<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subscribed Info</title>
</head>
<body>
	<h1>Thanks for subscribing us</h1>
	<p>You have filled the detail given below...</p>
	<table border="1" width="200px">
		<tr>
			<td>Name: </td> <td><%=request.getParameter("name") %></td>
		</tr>
		<tr>	
			<td>Mobile: </td> <td><%= request.getParameter("mobile") %></td>
		</tr>
		<tr>	
			<td>Email: </td> <td><%= request.getParameter("email") %></td>
		</tr>
	</table>
	<p><a href="index.jsp">Go Back</a></p>
</body>
</html>