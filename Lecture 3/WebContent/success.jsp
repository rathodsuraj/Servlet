<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.servlet.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success page</title>
</head>
<body>
<% String un=request.getParameter("Username");%>
Username:-<%= un %> <br>
<%String ps=request.getParameter("password");%>
Password:-<%= ps %><br>

<% Student stu =(Student)request.getAttribute("data"); %>
ROLLNO:-<%=stu.getId() %><br>
NAME:-<%=stu.getName() %><br>
ADDRESS:-<%=stu.getAddress() %><br>
</body>
</html>