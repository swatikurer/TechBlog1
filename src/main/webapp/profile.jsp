
<%@page import="com.tech.blog.entities.user"%>
<%@page errorPage="Error_page.jsp" %>

<%
user userr = (user) session.getAttribute("currentUser");
if (userr == null) {
	response.sendRedirect("login.jsp");
}
%>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%=userr.getName()%>
	<br>
	<%=userr.getEmail()%>
	<br>
	<%=userr.getAbout()%>
	

</body>
</html>