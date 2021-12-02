<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Examination System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/AddQCSS.css">
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	background-image: url();
	background-size: cover;
	backgound-position: center;
	font-family: sans-serif;
}

.menu-bar {
	/*backgound-color:rgb(0,100,0);*/
	background-color: #3ddDff;
	text-align: left;
/* 	height:68px; */
}

.menu-bar ul {
	display: inline-flex;
	list-style: none;
	color: #fff;
	text-align:center;
	vertical-align:middle;
}

.menu-bar ul li {
/* 	width: 130px; */
	margin: 2px;
	padding: 15px;
	border: 2px solid lightgray;
	margin-bottom: 0rem;
}

.menu-bar ul li a {
	text-decoration: none;
	color: #fff;
	top:5px;
	margin-bottom: 0rem;
	/* background-color: #dd1252; */
}

.active, .menu-bar ul li:hover {
	background: #2bab0d;
	border-radius: 3px;
	cursor: pointer;
	
}

.menu-bar.fa {
	margin-right: 8px;
	
}

.sub-menu-1 {
	display: none;
}

.menu-bar ul li:hover  .sub-menu-1 {
	display: block;
	position: absolute;
	/*background: rgb(0, 100, 0);*/
	background: #32cd32;
	margin-top: 15px;
	margin-left: -15px:
	
}

.menu-bar ul li:hover  .sub-menu-1 ul {
	display: block;
	margin: 10px;
}

.menu-bar ul li:hover.sub-menu-1 ul li {
	width: 150px;
	padding: 10px;
	border-bottom: 1px dotted #fff;
	background: transparent;
	border-radius: 0;
	text-align: left;
}

.menu-bar ul li:hover.sub-menu-1 ul li:last-child {
	border-bottom: none;
}

.menu-bar ul li:hover.sub-menu-1 ul li a:hover {
	color: #b2ff000;
	display:block;
}
.logo {
	position: absolute;
	left: 5px;
	top: 5px;
	box-radious: 50%;
	height: 150px;
	width: 100px;
	overflow: none;
}
dl, ol, ul {
    margin-top: 0;
    margin-bottom: 2px;
}

</style>
</head>
<body>
     <div class="logo" > 
    <img src="${pageContext.request.contextPath}/Images/OElogo.jpg" width=120px height="98px" alt="logo not found"/>
      </div>
    
    
    <%
     if(session.getAttribute("TID")==null){
        response.sendRedirect("../index.html");
     }

  %>
	<div style="text-align: center">
		<br>
		<h2>Welcome to SIMRANCOACHING</h2>
	
		<h3>Online examination System</h3>
		<br>
	</div>
	<div class="menu-bar">
		<ul>
			<li class="active"><a href="#"> Dashboard </a></li>

			<li><a href="#">Manage QuestionPapers </a>
				<div class="sub-menu-1">
					<ul>
						<li><a href="#"> QuestionSheet</a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/AddQuestion.jsp"> Add New</a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/importfile.jsp"> import/export </a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/ViewQ.jsp"> View</a></li>
						
					</ul>
				</div></li>

			<li><a href="#"> Student Examination</a>
				<div class="sub-menu-1">
					<ul>
						<li><a href="${pageContext.request.contextPath}/Teacher/DeclareResult.jsp"> Declare Result </a></li>
						
					</ul>
				</div></li>

			<li><a href="#"> Report </a>
				<div class="sub-menu-1">
					<ul>
						<li><a href="${pageContext.request.contextPath}/Teacher/AllSubClasswise.jsp"> Attendee Studets</a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/SubjectWiseReport.jsp"> Subject Wise</a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/NonDeclared.jsp"> Non Declared</a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/AttendedRpt.jsp"> Student Wise</a></li>
						<li><a href="${pageContext.request.contextPath}/Teacher/rptPendingResultDeclaration.jsp"> Pending Result Declare</a></li>
					</ul>
				</div></li>				
				<li><a href="#"> Manage ExamSet</a>
				<div class="sub-menu-1">
					<ul>					
						<li><a href="${pageContext.request.contextPath}/Teacher/AddESet.jsp"> AddSet</a></li>
						<li><a href="<%=request.getContextPath()%>/EsetServlet?action=view"> view</a></li>  
					</ul>
				</div></li>
				<li>
				<a href="#"> <%  String name=(String)session.getAttribute("TNAME"); 
		    	 out.print(name); %> </a>
				<div class="sub-menu-1">
					<ul>
					<li><a href="${pageContext.request.contextPath}/Teacher/TChangePass.jsp"> Change Password </a></li>
						<li> <a href="<%=request.getContextPath()%>/logoutservlet"> LogOut </a></li>
			</ul>
			</div></li>	
	</div>