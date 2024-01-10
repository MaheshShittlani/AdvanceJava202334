<%@page import="com.myweb.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myweb.dbutil.DBConnection"%>
<%@page import="com.myweb.dao.CategoryDao"%>
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
	<%! CategoryDao categoryDao = new CategoryDao(new DBConnection()); %>
	<%  ArrayList<Category>categories =   categoryDao.fetchAll(); 
		if(categories.size() > 0) {
			%>
			
		<table border="1" width="100%">
			<tr>
				<th>S.No.</th><th>Title</th><th>Status</th><th>Created At</th> <th>Update</th> <th>Actions</th>
			</tr>
			<% 
				for(Category category: categories) {
					%>
					<tr>
						<td><%=category.getId() %></td>
						<td><%=category.getTitle() %></td>
						<td><%=category.getStatus() %></td>
						<td><%=category.getCreatedAt() %></td>
						<td><%=category.getUpdateAt() %></td>
						<td>
							<a href="add-category.jsp?id=<%=category.getId() %>">Edit</a> 
							<a href="deleteCategory?id=<%=category.getId() %>">Delete</a>
						</td>
					</tr>
					<%
				}
			%>
		</table>	
			
			<%
		}
	%>
	
</body>
</html>