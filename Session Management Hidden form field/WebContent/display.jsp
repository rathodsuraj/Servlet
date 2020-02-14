<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>

First Data:-<%=request.getParameter("t1") %>
<br>
Second Data:-<%=request.getParameter("t2") %>
<br>
Third Data:-<%=request.getParameter("t3") %>
</body>
</html>