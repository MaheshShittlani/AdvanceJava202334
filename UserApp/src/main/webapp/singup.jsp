<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Signup Page</title>
</head>
<body>
	<form method="post" action="user/signup">
		<table align="center">
			<tr>
				<td colspan="2" align="center">
					<h2>Signup</h2>
				</td>
			</tr>
			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" id="name" name="name" required>
				</td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="email" id="email" name="email" required>
				</td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input type="password" id="password" name="password" required>
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
