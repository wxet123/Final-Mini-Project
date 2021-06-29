<%@page
	import="com.team2.DAO.ListOfTrainingDAO,com.team2.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List Of Trainings</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="adminAmbrad.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="images/ELearningFavicon.png"
	type="image/x-icon">

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
		<a href="adminDashboard.jsp"> <img src="images/ELearningIcon.png"
			width="40px">
		</a> <a class="navbar-brand ml-3" href="adminDashboard.jsp">E - Learning</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent-555"
			aria-controls="navbarSupportedContent-555" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent-555">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link mr-5"
					href="adminDashboard.jsp"> Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link mr-5" href="#">About</a>
				</li>
				<li class="nav-item dropdown"><a class="nav-link"
					id="navbarDropdownMenuLink-333" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"><span
						style="font-weight: 300; margin-right: 10px;"> Welcome back
							<em>${username}</em>
					</span> <i class="fas fa-user-circle fa-lg"></i> </a>
					<div class="dropdown-menu dropdown-menu-right dropdown-default"
						aria-labelledby="navbarDropdownMenuLink-333">
						<a class="dropdown-item" href="#">Account Setting</a>
						<form action="Logout" method="post">
							<input type="submit" class="dropdown-item log-out" value="Logout">
						</form>
					</div></li>
			</ul>
		</div>
	</nav>
	<!--/Navbar -->

	<div class="nav-bread" aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a class="text-dark"
				href="adminDashboard.jsp">Dashboard</a></li>
			<li class="breadcrumb-item active">List of Trainings</li>
		</ol>
	</div>
	<div class="container evaluation-centered" >
		<div class="row">
			<div class="col-sm-12 col-md-8 offset-md-2 col-lg-8 offset-lg-2">
				<h1 class="mb-4 px-md-3 text-center">List of Trainings</h1>
				<div class="card px-md-3 py-md-3" style = "  margin: auto; width:1200px; left: -250px;">
					<div class="card-body">
						<span class="d-block p-2 bg-fujitsu text-white">List of
							training meetings created</span>



						<c:set var= "userID" value = "${username}" />
						
						<%
						
						String userID = (String)pageContext.getAttribute("userID");
						
						List<ListOfTrainings> listAll = ListOfTrainingDAO.getAllRecords(userID);
						request.setAttribute("listAll", listAll);
						
						
						
						ListOfTrainingDAO ldao = new ListOfTrainingDAO();


						%>

						<br>
						<table class="styled-table">
							<thead>
								<tr>
									<th class="th">COURSE ID</th>
									<th class="th">COURSE</th>
									<th class="th">DATE</th>
									<th class="th">Enrolled Students</th>
									<th class="th">Status</th>
								</tr>
							</thead>

							<c:forEach items="${listAll}" var="u" varStatus = "loop">
								<tbody>
									<tr class="active-row">
										<td>${u.getCourse_id()}</td>
										<td>${u.getCourse_title()}</td>
										<td>${u.getDate()}</td>
										<td>
									
										
										<c:set var= "tID" value = "${u.getTraining_id()}" />
						
									<%
										
									int tID = Integer.valueOf(""+pageContext.getAttribute("tID"));
					
									
									List<EnrolledStudents> students = ListOfTrainingDAO.getStudentsEnrolled(userID, tID);
									request.setAttribute("students", students);
									
									%>

										
						
											<select class="form-select" multiple aria-label="multiple select example">
 									
  													
												<c:forEach items="${students}" var="s" varStatus = "studentCount">
												
  													<option value="<c:out   value="${studentCount}" />">  ${s.getFullName()}</option>
  													
  												</c:forEach>
  													
  												<c:if test="${empty students}">
														
														<option >No enrollments yet</option>			
												
												</c:if>
  												
											</select>
										</td>
										
								
								

										<td>
										<form action="remove" method = "post" id="deleteForm">
										
											 <input type="hidden" name="training_id" value="<c:out value="${u.getTraining_id()}"/>">
											 
									<!-- 		 <input type="hidden" name="courseName" value="<c:out value="${u.getCourse_title()}"/>">  -->
											<div class = "table-btns">
												<button id="btn-remove"
												
													style="	outline: none;
													background: none;
													border: none;
													color: #f50024;
													height: 5rem;
													width: 4rem;
													transition: 0.15s;"
													
												onclick = "remove()">
												<i 
													onMouseover= "this.style.color='#ff4c88'"
													onMouseout= "this.style.color='#f50024'"
												 class="icon fa fa-minus-circle fa-2x"></i>
												</button>
											</div>
										</form>
											<div class = "table-btns">
											
												<form action="done" method = "post" id="statusDone">
											 <input type="hidden" name="training_id" value="<c:out value="${u.getTraining_id()}"/>">
											 <input type="hidden" name="status" value="2">
													<button id="btn-done"
													style="	outline: none;
													background: none;
													border: none;
													color: #66DE93;
													height: 5rem;
													width: 4rem;
													transition: 0.15s;"
													
														onclick = "submit()">
														<i 
															onMouseover= "this.style.color='#B3E283'"
															onMouseout= "this.style.color='#66DE93'"
														 class="icon far fa-check-circle fa-2x"></i>
													</button>
													</form>
														</div>

										</td>
										
									</tr>
							</c:forEach>

							</tbody>
						</table>

						<c:if test="${empty listAll}">
							<div class="noDATA">
								<br> <br>
								<h3 class="errorTitle">NO DATA FOUND</h3>

							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer class="page-footer font-small bg-fujitsu">

		<!-- Copyright -->
		<div class="footer-copyright text-center py-3">
			© 2021 Team 2, <a href="#"> All Right Reserved.</a>
		</div>
		<!-- Copyright -->

	</footer>
	<!-- Footer -->
	<!-- JQuery -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
	<script>
		$(document).ready(function() {

		});

		function remove() {
			document.getElementById("deleteForm").submit();

		}
		function submit() {
			document.getElementById("statusDone").submit();

		}
		
		

		
	
		
	</script>
</body>

</html>
