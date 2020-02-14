<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>


First Data:- <%=session.getAttribute("fn") %>
<br>
Second Data:- <%=session.getAttribute("sd") %>
<br>
 Third Data:- <%=session.getAttribute("t3") %>
 

</body>
</html>