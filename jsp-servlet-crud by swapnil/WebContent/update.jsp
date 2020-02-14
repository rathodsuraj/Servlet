<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update page</title>
</head>
<body>
<h1>Update page</h1>
<form action="updatedb">

<% 
Employee e=(Employee)request.getAttribute("emp");
%>

<input type="hidden" name="emid" value="<%=e.getEmpid() %>"><br>
Ename:<input type="text" name="name" value="<%=e.getEname()%>"><br>
Address:<input type="text" name="add" value="<%=e.getAddress()%>"><br>
UserName:<input type="text" name="uname" value="<%=e.getUsername()%>"><br>
password:<input type="text" name="pass" value="<%=e.getPassword()%>"><br>
<input type="submit" value="Updatedata">

</form>
</body>
</html>