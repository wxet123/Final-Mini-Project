<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Evaluation</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="images/ELearningFavicon.png" type="image/x-icon">
    <link rel="stylesheet" href="css/niks.css">
    
</head>
</head>
<body>
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
            <i class="fas fa-user-circle fa-lg"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right dropdown-default" aria-labelledby="navbarDropdownMenuLink-333">
            <a class="dropdown-item" href="#">Account Setting</a>
            <a class="dropdown-item" href="login.jsp">Logout</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <!--/Navbar -->
  
    <div class="nav-bread" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a class="text-dark" href="dashboard.jsp">Dashboard</a></li>
        <li class="breadcrumb-item active">Evaluation</li>
      </ol>
    </div>
    <div class="container evaluation-centered">
        <div class="row">
            <div class="col-sm-12 col-md-8 offset-md-2 col-lg-8 offset-lg-2">
                <h1 class="mb-4 px-md-3 text-center">Evaluation</h1>
                <div class="card px-md-3 py-md-3">
                    <div class="card-body">
                        <form action="evaluate" method="GET">
                            <div class="form-group">
                                <span class="d-block p-2 bg-fujitsu text-white">Survey about your experience during your training with Fujitsu</span>
                                <p class="mt-3">Title of Training here</p>
                                <p class="mt-3"><span class="asterist">*</span> Did the training content meet your expectations?</p>
                                <select class="custom-select custom-select-sm" required name="q1">
                                    <option value="" selected disabled>Select your answer</option>
                                    <option value="Strongly Agree">Strongly Agree</option>
                                    <option value="Agree">Agree</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Disagree">Disagree</option>
                                    <option value="Strongly Disagree">Strongly Disagree</option>
                                </select>

                                <p class="mt-3"><span class="asterist">*</span> Was the size of your training group appropriate?</p>
                                <select class="custom-select custom-select-sm" required name="q2">
                                    <option value="" selected disabled>Select your answer</option>
                                    <option value="Strongly Agree">Strongly Agree</option>
                                    <option value="Agree">Agree</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Disagree">Disagree</option>
                                    <option value="Strongly Disagree">Strongly Disagree</option>
                                </select>

                                <p class="mt-3"><span class="asterist">*</span> How would you rate the quality of the training?</p>
                                <select class="custom-select custom-select-sm" required name="q3">
                                    <option value="" selected disabled>Select your answer</option>
                                    <option value="Strongly Agree">Strongly Agree</option>
                                    <option value="Agree">Agree</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Disagree">Disagree</option>
                                    <option value="Strongly Disagree">Strongly Disagree</option>
                                </select>

                                <p class="mt-3"><span class="asterist">*</span> Was the mix of presentations and activities suitable?</p>
                                <select class="custom-select custom-select-sm" required name="q4">
                                    <option value="" selected disabled>Select your answer</option>
                                    <option value="Strongly Agree">Strongly Agree</option>
                                    <option value="Agree">Agree</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Disagree">Disagree</option>
                                    <option value="Strongly Disagree">Strongly Disagree</option>
                                </select>

                                <p class="mt-3"><span class="asterist">*</span> How would you rate the quality of the instructor?</p>
                                <select class="custom-select custom-select-sm" required name="q5">
                                    <option value="" selected disabled>Select your answer</option>
                                    <option value="Strongly Agree">Strongly Agree</option>
                                    <option value="Agree">Agree</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Disagree">Disagree</option>
                                    <option value="Strongly Disagree">Strongly Disagree</option>
                                </select>

                                <label for="exampleFormControlTextarea2" class="mt-3"><span class="asterist">*</span> Comment or suggestions:</label>
                                <textarea class="form-control" id="exampleFormControlTextarea2" rows="3" required name="comments"></textarea>
                                  
                                <div class="text-center">
                                    <button type="submit" class="btn mt-5" value="submit" name="btn-submit">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <footer class="page-footer font-small bg-fujitsu">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2021 Team 2,
        <a href="#"> All Right Reserved.</a>
        </div>
        <!-- Copyright -->
    
    </footer>
    <!-- Footer -->
<!-- JQuery -->
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

