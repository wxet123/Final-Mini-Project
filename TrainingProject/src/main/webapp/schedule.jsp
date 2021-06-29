<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.team2.DAO.ListOfTrainingDAO,com.team2.model.*,java.util.*"%>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="HandheldFriendly" content="true">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css" />
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous">
	
</script>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" />
<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="dashboard.css" />
<link rel="shortcut icon" href="images/ELearningFavicon.png"
	type="image/x-icon">

<!-- JQuery -->

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Bootstrap tooltips -->

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js">
	
</script>

<!-- Bootstrap core JavaScript -->

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- MDB core JavaScript -->

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>



<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet" />
<title>E-Learning</title>
</head>
<body>

			<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<!--Navbar -->
	<nav class="mb-1 navbar navbar-expand-lg navbar-dark">
		<a href="dashboard.jsp"> <img src="images/ELearningIcon.png"
			width="40px" />
		</a> <a class="navbar-brand" href="dashboard.jsp">E - Learning</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent-555"
			aria-controls="navbarSupportedContent-555" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent-555">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link mr-5"
					href="dashboard.jsp"> Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link mr-5" href="#">About</a>
				</li>
				<li class="nav-item dropdown">
				<a class="nav-link"
					id="navbarDropdownMenuLink-333" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <span style="font-weight: 300; margin-right:10px;"> Welcome back <em>${username}</em></span> <i
						class="fas fa-user-circle fa-lg"></i>
				</a>
					<div class="dropdown-menu dropdown-menu-right dropdown-default"
						aria-labelledby="navbarDropdownMenuLink-333">
						<a class="dropdown-item" href="#">Account Setting</a>
						<form action="Logout" method="post">
							<input type="submit" value="Logout" class="dropdown-item log-out">
						</form>
					</div></li>
			</ul>
		</div>
	</nav>
	<!--/.Navbar -->
    <div class="nav-bread" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a class="text-dark" href="dashboard.jsp">Dashboard</a></li>
        <li class="breadcrumb-item active">Training Schedule</li>
      </ol>
    </div> 
				

				
				<%
						List<ListOfTrainings> listAll=ListOfTrainingDAO.getRecords();  
						request.setAttribute("listAll",listAll);  
						
						ListOfTrainingDAO ldao = new ListOfTrainingDAO();
				%>

			
	<div class="container-sched">
	
	
            	<c:forEach items="${listAll}" var = "u">
            	
			

		<div class="row row-striped">
			<div class="col-2 text-right">
				<h1 class="display-4">
					<span class="badge">${u.getDateNumber()}</span>
				</h1>
				<h2>${u.getMonth()}</h2>
			</div>
			<div class="col-10">
				<h3 class="text-uppercase">
					<strong>${u.getCourse_title()}</strong>
				</h3>
				<ul class="list-inline">
					<li class="list-inline-item"><i class="fa fa-calendar-o"
						aria-hidden="true"></i> ${u.getDayName()}</li>
					<li class="list-inline-item"><i class="fa fa-clock-o"
						aria-hidden="true"></i> ${u.getStartTime()} - ${u.getEndTime()}</li>
					<li class="list-inline-item"><i class="fas fa-user-tie"></i> ${u.getInstructor()}</li>
				</ul>
				<p>${u.getDescription()}</p>
			</div>
		</div>
		
	            	</c:forEach>    
	            	
	            	
	            		<c:if test="${empty listAll}">
						<div class="noDATA" style="position: absolute; top:30%; left:45%">
							<br>
							<br>
							<h2 class="errorTitle" style="color: #9f5f80;  text-shadow: 2px 2px 5px;">No training seminars scheduled</h2>"
							
						</div>
						</c:if>

	</div>
</body>
</html>
