<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Context/bootstrap/css/bootstrap.min.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>

.details {
	background-color: GhostWhite;
	width: 450px;
	border: 2px solid LightGrey;
	padding: 50px;
	margin-top: 0;
	margin-left: 830px;
	height: 350px;
}

.body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	margin-top: 15px;
	margin-left: 10px;
	margin-right: 10px;
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #04AA6D;
	color: white;
}

.dropdown {
	float: right;
}

.btn {
	background-color: DodgerBlue;
	border: none;
	color: black;
	padding: 16px 32px;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	transition: 0.3s;
	float: right;
	margin-right: 250px;
	margin-top: 100px;
}

.btn:hover {
	background-color: #3e8e41;
	color: lightgreen;
}

.Login {
	position: relative;
	display: inline-block;
	/*	float: left; */
}

.Login-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.Login-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.Login a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}
</style>
</head>
<body>

	<%
     if(session.getAttribute("Sid")==null){
        response.sendRedirect("../index.html");
     }
      %>
	<div class="topnav">
		<a class="active"
			href="<%=request.getContextPath()%>/Students/StudentDashboard.jsp">
			<i class="fa fa-fw fa-dashboard"></i>Dashboard
		</a>


		<div class="dropdown" Style="color: white; position: relative;">

			<%  String name=(String)session.getAttribute("Sname"); 
		String id=(String) session.getAttribute("Sid");
		String Studaclssid=(String) session.getAttribute("Studaclssid");
		
    	 out.print(name);     
    %>

			<div class="Login">
				<a href="<%=request.getContextPath()%>/logoutservlet"
					class="dropbtn"><i class="fa fa-user-circle-o"></i>Logout </a>
			</div>
		</div>
	</div>
</head>


<div class="container" style="margin-top: 70px">
	<h3 style="color: red;">Instructions to follow :</h3>
	<div class="row">
	
	<div class="col-md-4"  style="background-color: GhostWhite; border:1px solid  LightGrey;">
			<p><b>Name:&nbsp&nbsp ${StudentDetails.SNAME}</b></p>
			<p><b>Student ID:&nbsp&nbsp ${StudentDetails.SID}</b></p>
			<p><b>Class:&nbsp&nbsp ${StudentDetails.STD} th</b></p>
			<hr>
			<p><b>Subject:&nbsp&nbsp (${selectedExamSetDet.subid}) ${selectedExamSetDet.SUBNAME}</b></p>
			<p><b>Set:&nbsp&nbsp ${activeSelectedExSet.EID}</b></p>
			<p><b>Duration:&nbsp&nbsp ${activeSelectedExSet.DURATION}</b></p>
			<p><b>Number of Questions:&nbsp&nbsp ${activeSelectedExSet.TOTLEQ}</b></p>
			<p><b>Total Marks:&nbsp&nbsp ${activeSelectedExSet.TOTLEMARKS}</b></p>
		</div>
		
		<div class="col-md-4" style="color: black; font-size: 20px;">
			<p>1.Go to current active exams and select yours</p>
			<p>2.if you have selected,read next instruction and say continue.</p>
			<p>3.After submiting your exam your score or result will display
				soon.</p>
			<p>4.To see your result,go to result option.</p>
			<p></p>
		</div>
		<div class="col-md-4" style="color: black; font-size: 20px;">
			<p>5.All Question should be attend,its mandatory.</p>
			<p>6.If you submit test without attending all question then your
				test will be submitted with attempted questions only.</p>
			<p>7.Try to solve all Question within time</p>
		</div>
		

	</div>
</div>
<div class="container">
	<form action="ExamStartController?action=StartExam" method="post"> 
	     <input type="hidden" name="SubID" value="${selectedExamSetDet.subid}"/>
     	<input type="hidden" name="EID" value="${activeSelectedExSet.EID}"/>
<input type="hidden" name="Studassid" value="11" />
<input type="hidden"  name="ClassID" value="${StudentDetails.std}" />
<input type="hidden"  name="SubID" value="${selectedExamSetDet.subid}" />
  		<button class="btn" style="width: 110px; height: 50px">
			Start <i class="fa fa-arrow-right"></i>
		</button>
	</form>
</div>
<marquee>Best Of Luck !</marquee>





</body>
</html>