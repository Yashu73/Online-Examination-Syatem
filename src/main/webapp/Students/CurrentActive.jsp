<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/AddQCSS.css">
<style>

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
    	 out.print(name);     
    %>

			<div class="Login">
				<a href="<%=request.getContextPath()%>/logoutservlet"
					class="dropbtn"><i class="fa fa-user-circle-o"></i>Logout </a>
			</div>
		</div>
	</div>
	
	
<br>
<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">List of Exams</h3>
			<hr>
			
			<form name="frm" action="register?action=View" method="post">
			<div class="text-center">
			</div>

			</form>
			<div style="text-align:right; color:orange;">${setviewMsg}</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Exam Id</th>
						<th>Subject</th>
						
						<th>Total Question</th>
						<th>Total Marks</th>
						<th>Duration</th>
						<th>Date</th>
						
						<th>Action</th> 
					</tr>
				</thead>
				<tbody>
					<c:forEach var="eset" items="${currentactivelst}">
						<tr>
					<td><c:out value="${eset.EID}" /></td>
					<td><c:out value="${eset.subname}" /></td>
					
							<td><c:out value="${eset.TOTLEQ}" /></td>
							<td><c:out value="${eset.TOTLEMARKS}" /></td>
							<td><c:out value="${eset.DURATION}" /></td>
							<td><c:out value="${eset.SDET}" /></td>
														
							<td>
							<a href="ActiveExam?action=select&eid=<c:out value='${eset.EID}'/>"> select</a>
							<c:out value='${emp.id}' />
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>