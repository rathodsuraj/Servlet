<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.servlet.*"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success page</title>
<style type="text/css">
h1 {
	text-align: center;
}
</style>
</head>
<body>
<h1>success page</h1>
<%
List<Student> list=(List)request.getAttribute("data");
for(Student s:list)
{
%>
Roll No:-<%=s.getRollno() %>
<br>
Name:-<%=s.getName() %>
<br>
Address:-<%=s.getAddress() %>
<br>
<% } %>
</body>
</html>