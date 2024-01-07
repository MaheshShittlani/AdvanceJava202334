<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<%
String message = (String)session.getAttribute("message"); 
session.removeAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Manager</title>
</head>
<body>
	<p><b><%= message != null ? message : "" %></b></p>
	<p><a href="add-category.jsp">Create New Category</a></p>
	<table border="1" width="100%">
		<tr>
			<th>S.No.</th><th>Title</th><th>Status</th><th>Actions</th>
		</tr>
	</table>
</body>
</html>