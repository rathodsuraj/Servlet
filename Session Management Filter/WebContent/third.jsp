<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Third Page</title>
</head>
<body>


<form action="third.do">
First Data:- <%=session.getAttribute("fn") %>
<br>
Second Data:- <%=session.getAttribute("sd") %>
<br>
 Third Data:- <input type="text" name="t3">
 <input type="submit">

</form>


</body>
</html>