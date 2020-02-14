<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.servlet.model.Employee,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success Page</title>
<script type="text/javascript">

function delete_record() {
	alert("delete")
document.myform.action="delete"
document.myform.submit();
}
function update_record() {
	alert("update")
	document.myform.action="edit"
	document.myform.submit();
}


</script>

<style type="text/css">
h1 {
	text-align: center;
	color: red;
}
</style>
</head>
<body>
	<h1>This is my success page</h1>
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
	<tr>
		<td><input type="button" value="delete" onclick="delete_record()" ></td>
		<td> <input type="button" value="update" onclick="update_record()"></td>
			
		</tr>
</table>
</form>


</body>
</html>