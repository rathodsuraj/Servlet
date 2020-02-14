
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Success Page</title>
</head>
<body>

<%-- <jsp:useBean id="stu" class="com.Student">
<jsp:setProperty property="rollno" name="stu" param="t1"/>
<jsp:setProperty property="name" name="stu" param="t2"/>
</jsp:useBean> --%>

<!-- If we are having saving object -->
<jsp:useBean id="data" class="com.Student" scope="request"></jsp:useBean>
<%-- <% Student stu=(Student) request.getAttribute("data"); %>
 --%>
Name:${data.rollno}
<br>
RollNO:${data.name}
<br>


<%-- 
Rollno:-<jsp:getProperty property="rollno" name="stu"/>
<br>
Name:-<jsp:getProperty property="name" name="stu"/>

RollNo:${stu.rollno}
<br>
Name:${stu.name}
 --%>
 </body>
</html>