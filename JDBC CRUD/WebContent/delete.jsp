<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.*,com.servlet.model.Employee" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Page</title>
</head>
<body>


<form name="myform">
	<table border="2">
		<tr>
			<th>Eid</th>
			<th>Name</th>
			<th>Address</th>
			<th>UserName</th>
			<th>Password</th>
		</tr>
		<tr>
			<%
				List<Employee> list = (List) request.getAttribute("data");
				for (Employee emp : list) {
			%>
			<td><input type="radio" name="eid" value="<%=emp.getEid()%>"><%=emp.getEid()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getAddress()%></td>
			<td><%=emp.getUsername()%></td>
			<td><%=emp.getPassword()%></td>

		</tr>
		
	
	<%
		}
	%>
	</table>
	</form>
<a href="login.jsp">login Page</a>


</body>
</html>