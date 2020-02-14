<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="com.model.Employee" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success page</title>
<script type="text/javascript">

function deleterecords(){
	
	alert("delete")
	
	document.myform.action="del";
	document.myform.submit();
	
}

function updaterecords(){
	
	alert("update records")
	
	document.myform.action="update";
	document.myform.submit();
	
}


</script>

</head>
<body>
<form name="myform">
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
	List<Employee> el=(List)request.getAttribute("list");
	for(Employee e:el){
	%>
<td><input type="radio" name="eid" value="<%=e.getEmpid()%>"><%=e.getEmpid()%></td>
<td><%=e.getEname() %></td>
<td><%=e.getAddress() %></td>
<td><%=e.getUsername() %></td>
<td><%=e.getPassword() %></td>	
	
</tr>

<%} %>

<%request.setAttribute("el", el); %>

<tr><td><input type="button" value="delete" onclick="deleterecords()"></td>
<td><input type="button" value="update" onclick="updaterecords()"></td>
</tr>
</table>

</form>
</body>
</html>