<%@page import="com.myweb.model.Category"%>
<%@page import="com.myweb.dbutil.DBConnection"%>
<%@page import="com.myweb.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp" %>
<%
String message = (String)session.getAttribute("message"); 
session.removeAttribute("message");
%>
<%! CategoryDao categoryDao = new CategoryDao(new DBConnection()); %>
<% 	
	String id = request.getParameter("id");  
	Category category = null;
	if(id != null) {
		int categoryId = Integer.parseInt(id);
		category = categoryDao.fetchOne(categoryId);
	}
	out.println(category);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Manage | Create Category</title>
</head>
<body>
	<h1>
		<% 
			if(id != null) {
				out.println("Update Category");
			} else {
				out.println("Create New Category");
			}
		%>
	</h1>
	<p><a href="category.jsp">View All Category</a></p>
	
	<p><b><%= message != null ? message : "" %></b></p>
	<form action="<% if(category!=null) {out.println("updateCategory");} else {out.println("createCategory");} %>" method="post">
		
		<% if(category != null) {
			%>
				<input type="hidden" name="id" value="<%=id %>">
			<% 
			} %>
		
		<table>
        <tr>
            <td>
                <label for="title">Category Title:</label>
            </td>
            <td>
                <input type="text" id="title" name="title" required value="<%= category !=null ?category.getTitle():"" %>">
            </td>
        </tr>
        <tr>
            <td>
                <label for="status">Status:</label>
            </td>
            <td>
                <select id="status" name="status" required>
                    <option value="Active" <% if(category !=null && category.getStatus().equals("Active")) {out.println("selected");} %> >Active</option>
                    <option value="Inactive" <% if(category !=null && category.getStatus().equals("Inactive")) {out.println("selected");} %>>Inactive</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit"><% if(category !=null) {out.println("Update Cagtgory"); } else {out.println("Add Category");} %></button>
            </td>
        </tr>
    </table>
	</form>
</body>
</html>