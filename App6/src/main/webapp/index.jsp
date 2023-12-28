<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subscribe Form</title>
</head>
<body>
	<h1>Subscriber Form</h1>
	<p>Please fill the form given below</p>
	<form method="post" action="subscribe.jsp">
		<p>Name: <input type="text" name="name" placeholder="Enter your name"></p>
		<p>Mobile: <input type="text" name="mobile" placeholder="Enter mobile number"></p>
		<p>Email: <input type="email" name="email" placeholder="example@email.com"></p>
		<p><button type="submit" name="sub">Subscribe</button></p>
	</form>
</body>
</html>