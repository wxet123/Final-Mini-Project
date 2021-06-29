
 <%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>  
  
<html>  
	<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Of Trainings</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet"> 
	<link rel="stylesheet" href="ambrad.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="shortcut icon" href="images/ELearningFavicon.png" type="image/x-icon">
	  
	<title>View Users</title>  
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
   <a href="dashboard.jsp"> <img src="images/ELearningIcon.png" width="40px"> </a>
    <a class="navbar-brand ml-3" href="dashboard.jsp">E - Learning</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
      aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link mr-5" href="dashboard.jsp">
            Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link mr-5" href="#">About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" id="navbarDropdownMenuLink-333" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
            <span style="font-weight: 300; margin-right:10px;"> Welcome back <em>${username}</em></span> 
            <i class="fas fa-user-circle fa-lg"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right dropdown-default" aria-labelledby="navbarDropdownMenuLink-333">
            <a class="dropdown-item" href="#">Account Setting</a>
           						<form action="Logout" method="post" >
							<input type="submit"   class="dropdown-item log-out" value="Logout">
						</form>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <!--/Navbar -->
  
    <div class="nav-bread" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a class="text-dark" href="dashboard.jsp">Dashboard</a></li>
        <li class="breadcrumb-item active">List of Trainings</li>
      </ol>
    </div> 
  <div class="container evaluation-centered">
        <div class="row">
            <div class="col-sm-12 col-md-8 offset-md-2 col-lg-8 offset-lg-2">
                <h1 class="mb-4 px-md-3 text-center">List of Trainings</h1>
                <div class="card px-md-3 py-md-3">
                    <div class="card-body">
                     <span class="d-block p-2 bg-fujitsu text-white">List of on going trainings.</span>
                     
					<%@page import="com.team2.DAO.ListOfTrainingDAO,com.team2.model.*,java.util.*"%>  
					<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
 						<c:set var= "userID" value = "${username}" />
						
					<%
					String userID = (String)pageContext.getAttribute("userID");
					
					List<ListOfTrainings> listAll=ListOfTrainingDAO.postInprogressPerEmp(userID);  
					request.setAttribute("listAll",listAll);  
					

					List<ListOfTrainings> listDone=ListOfTrainingDAO.getDoneByEmpID(userID); 
					request.setAttribute("listDone", listDone);
					
					%>
                	
                    <br>    
					<table class="styled-table"> 
					<thead> 
						<tr>
							<th class = "th">COURSE ID</th>
							<th class = "th">COURSE</th>
							<th class = "th">Date</th>
						</tr>
					</thead>
					
					
					<c:forEach items="${listAll}" var="u">

					<tbody>
						<tr class="active-row">
							<td>${u.getCourse_id()}</td>
							<td>${u.getCourse_title()}</td>
							<td>${u.getDate()}</td>
						</tr>
					</c:forEach>
					
					</tbody>
					<c:if test="${empty listAll}">
						<div class="noDATA">
							<br>
							<br>
							<h3 class="errorTitle">No trainings enrolled</h3>
							
						</div>
						</c:if>
					</table>
			
						
				 <div class="card-body">
                     <span class="d-block p-2 bg-fujitsu text-white"  style= "background-color: #8E9775;">List of finished trainings.</span>
                     
                	
          
					<table class = "styled-table "  >
					<thead >
						<tr>
							<th class = "th" style= "background-color: #8E9775;">COURSE ID</th>
							<th class = "th" style= "background-color: #8E9775;">COURSE</th>
							<th class = "th" style= "background-color: #8E9775;">Date</th>			
						</tr>
					</thead>
					
						<c:forEach items="${listDone}" var="d">
					
					<tbody>
						<tr class="active-row">
							<td>${d.getCourse_id()}</td>
							<td>${d.getCourse_title()}</td>
							<td>${d.getDate()}</td>
						</tr>
					</c:forEach>
						
						<c:if test="${empty listDone}">
						<div class="noDATA">
							<br>
							<br>
							<h3 class="errorTitle">No trainings finished</h3>
							
						</div>
						</c:if>
						
					</table>
						</div>
						
						
						
                </div>
            </div>
        </div>
    </div>
    
    


<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
<script>
$(document).ready(function() {
	
});
</script>
</body> 

</html>  