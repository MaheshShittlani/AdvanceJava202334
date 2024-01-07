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
<title>Category Manage | Create Category</title>
</head>
<body>
	<h1>Create New Category</h1>
	<p><a href="category.jsp">View All Category</a></p>
	
	<p><b><%= message != null ? message : "" %></b></p>
	<form action="createCategory" method="post">
		<table>
        <tr>
            <td>
                <label for="title">Category Title:</label>
            </td>
            <td>
                <input type="text" id="title" name="title" required>
            </td>
        </tr>
        <tr>
            <td>
                <label for="status">Status:</label>
            </td>
            <td>
                <select id="status" name="status" required>
                    <option value="Active">Active</option>
                    <option value="Inactive">Inactive</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">Add Category</button>
            </td>
        </tr>
    </table>
	</form>
</body>
</html>