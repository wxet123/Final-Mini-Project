<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.team2.DAO.EmployeeDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	
	
	
		if(session.getAttribute("username") == null){
			 response.sendRedirect("login.jsp");
		}
	%>
   		<jsp:useBean id="employee" class="com.team2.model.Employee" />

 		<jsp:setProperty property="*" name="employee" />

		<%
  			
  		   	out.print("You are successfully registered");
  		 	 
		%>

</body>
</html>