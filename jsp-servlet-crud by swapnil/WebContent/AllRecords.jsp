<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.List" %>
    <%@ page import="com.model.Employee" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All records</title>
</head>
<body>
<h2>Record deleted</h2>
<table border="2">
<tr>
<th>Empid</th>
<th>ename</th>
<th>address</th>
<th>username</th>
<th>password</th>
</tr>

<tr>
<%
	List<Employee> el=(List)request.getAttribute("list1");
	for(Employee e:el){
	%>
<td><%=e.getEmpid()%></td>
<td><%=e.getEname() %></td>
<td><%=e.getAddress() %></td>
<td><%=e.getUsername() %></td>
<td><%=e.getPassword() %></td>	
	
</tr>

<%} %>



</body>
</html>