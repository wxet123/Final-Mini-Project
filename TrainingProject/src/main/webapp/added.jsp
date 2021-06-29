<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page
	import="com.team2.DAO.ListOfTrainingDAO,com.team2.model.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="HandheldFriendly" content="true">
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="casas.css">
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

<title>E-Learning</title>
</head>

<body>

	<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	



    <section class="navigation">
        <nav class="mb-1 navbar navbar-expand-lg navbar-dark">
            <a href="dashboard.jsp"> <img src="images/ELearningIcon.png" width="40px">
            </a> <a class="navbar-brand" href="dashboard.jsp">E - Learning</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent-555" aria-controls="navbarSupportedContent-555"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a class="nav-link mr-5" href="dashboard.jsp"> Home
                            <span class="sr-only">(current)</span>
                        </a></li>
                    <li class="nav-item"><a class="nav-link mr-5" href="#">About</a>
                    </li>
                    <li class="nav-item dropdown"><a class="nav-link" id="navbarDropdownMenuLink-333"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span
                                style="font-weight: 300; margin-right: 10px;">
                                Welcome back
                                <em>${username}</em>
                            </span> <i class="fas fa-user-circle fa-lg"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-default"
                            aria-labelledby="navbarDropdownMenuLink-333">
                            <a class="dropdown-item" href="#">Account Setting</a>
                            <form action="Logout" method="post">
                                <input type="submit" value="Logout" class="dropdown-item log-out">
                            </form>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

    </section>

    <section class="grid-table">

        <div class="container evaluation-centered">
            <div class="row">
                <div class="col-sm-12 col-md-8 offset-md-2 col-lg-8 offset-lg-2">
                    <h1 class="mb-4 px-md-3 text-center">List of Trainings</h1>
                    <div class="card px-md-3 py-md-3">
                        <div class="card-body">
                            <span class="d-block p-2 bg-fujitsu text-white">List of
                                training meetings created</span>



						<c:set var= "userID" value = "${username}" />
					

						<%
						  response.setIntHeader("Refresh", 5);
			            Calendar calendar = new GregorianCalendar();
			            
			            int hour = calendar.get(Calendar.HOUR);
			            int minute = calendar.get(Calendar.MINUTE);
			            int second = calendar.get(Calendar.SECOND);
			          
						
						String userID = (String)pageContext.getAttribute("userID");
						
						List<ListOfTrainings> listAll = ListOfTrainingDAO.enrollInProgressCoursesByEmpID(userID);
						
						request.setAttribute("listAll", listAll);
						request.setAttribute("justDisplay", userID);
						ListOfTrainingDAO ldao = new ListOfTrainingDAO();
						


						%>
						
									
                        <div class="accordion" id="accordionExample">
							<c:forEach items="${listAll}" var="u" varStatus = "loop" >

                             
									
                                    <div class="accordion-item">
                                      <h2 class="accordion-header" id="heading<c:out   value="${loop.count}" />">
                                        <button class="accordion-button" type="button" 
                                        		data-bs-toggle="collapse" 
                                        		data-bs-target="#collapse<c:out   value="${loop.count}" />" 
                                        		aria-expanded="true" 
                                        		aria-controls="collapse<c:out   value="${loop.count}" />">
                                        	
                                        	
                                          <h4>${u.getCourse_id()}  -  ${u.getCourse_title()}</h4> 
                                        </button>
                                      </h2>
                                      
                                      <div id="collapse<c:out   value="${loop.count}" />"
                                      		 class="accordion-collapse collapse" 
                                      		 aria-labelledby="heading<c:out   value="${loop.count}" />" 
                                   		   	 data-bs-parent="#accordionExample">
                                      	 
                                        <div class="accordion-body">
 
                                        <div class = "wrapper">
                                      	  <div class="grid">
                                        	  <h5><strong>  ${u.getDayName()}  - ${u.getMonth()} ${u.getDateNumber()},      ${u.getStartTime()} - ${u.getEndTime()} </strong></h5> 
                                        	  <h6>by ${u.getInstructor()}</h6>
                                       	   		<p>Course Overview: </p>
                                       	   		  <p  style= "text-indent: 50px;">	 ${u.getDescription()}</p>
                                       	   	
                                       	  		 <form action = "addemptraining" method= "post" id="enrollForm">
								   					<input type="hidden" name="training_id" value="<c:out value="${u.getTraining_id()}"/>">	
								   	
								   					<input type="hidden" name="date" value="<c:out value="${u.getDate()}"/>">	
                                     				<input type="hidden" name="status" value="1">
                                     				<input type="hidden" name="empUsername" value="<c:out value="${username}"/>">
                                     				<input type="hidden" name="startTime" value="<c:out value="${u.getStartTime()}"/>">
                                     				<input type="hidden" name="endTime" value="<c:out value="${u.getEndTime()}"/>">
                                    				<input type="hidden" name="instructor" value="<c:out value="${u.getInstructor()}"/>">
                                     
                                     
                                     
                                        		 		 <div class = "grid">
                                       		   					<div class = "enroll-btn" onclick = "submit()" id = "submit">
                                          						</div>
                                          				</div>
                                         		 </form>
                                        </div>
                                        
                                        
                                        
                                      </div>
                                    </div>
                                  </div>
                       		 </div>
				 			 </c:forEach>
                    </div>
                    
                        
                                        	<c:if test="${empty listAll}">
													<div class="noDATA" >
														<br> <br>
														<h3 class="errorTitle">No trainings scheduled</h3>
	
													</div>
											</c:if>
                </div>
            </div>
        </div>
	</div>

    </section>


    <script type="text/javascript">
		function submit() {
			document.getElementById("enrollForm").submit();

		}
    </script>



</body>

</html>