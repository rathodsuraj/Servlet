<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>
h1 {
	text-align: center;
	color: red;
}
</style>
</head>
<body>
<h1>This is Login Page</h1>

<form action="login">

Username:-<input type="text" name="uname" placeholder="enter your name"><br>
Password:-<input type="password" name="password" placeholder="enter your password"><br>
<input type="submit" value="Login">
Don't hava an account?<a href="singup.jsp">SingUp</a>
</form>
</body>
</html>