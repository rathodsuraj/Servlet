<%@page import="com.servlet.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form action="updatedb">
<%Employee emp=(Employee) request.getAttribute("details"); %>


<input type="hidden" name="emid" value="<%=emp.getEid() %>"><br>
Address:<input type="text" name="address" value="<%=emp.getAddress()%>"><br>
Name<input type="text" name="ename" value="<%=emp.getName()%>"><br>
Username:<input type="text" name="uname" value="<%=emp.getUsername() %>"><br>
Password:<input type="text" name="passwd" value="<%=emp.getPassword() %>"><br>

<input type="submit" value="UpdateData">
</form>

</body>
</html>