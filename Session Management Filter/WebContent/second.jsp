<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second Page</title>
</head>
<body>


<form action="second.do">

First Data:- <%=session.getAttribute("fn") %>
<br>
 Second Data:- <input type="text" name="t2">
 <input type="submit">

</form>

</body>
</html>