<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Context/css/AddQCSS.css">


<script>
    submitFormOkay = false;
    $(document.body).on("click", "a", function() {
        submitFormOkay = true;
    });
    window.onbeforeunload = function(event) {
        event.preventDefault(); 
        if (!submitFormOkay) {
            window.setTimeout(function () { 
                window.location = "index.html";
            }, 0); 
            window.onbeforeunload = null;
        }
    }
</script>


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

		<%  String name=(String)session.getAttribute("Sname"); 
		String id=(String) session.getAttribute("Sid");
    	 out.print(name);     
       %>



		<div class="dropdown" Style="color: white; position: relative;">

			<div class="Login">
				<a href="<%=request.getContextPath()%>/logoutservlet"
					class="dropbtn"><i class="fa fa-user-circle-o"></i>Logout </a>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>

	<div style="text-align: left; color: black; align: center;">
		<table class="table"
			style="align: center; margin-left: 35%; width: auto;">

			<%  String StudName=(String)session.getAttribute("Sname"); 
		String Studid=(String) session.getAttribute("Sid");
		String Classid=(String) session.getAttribute("Studaclssid"); %>
			<thead>

				<tr>
					<th>Student Name:</th>
					<td>
						<%out.print(StudName); %>
					</td>
				</tr>

				<tr>
					<th>Student Id:</th>
					<td>
						<% out.print(Studid); %>
					</td>
				</tr>

				<tr>
					<th>Subject:</th>
					<td>${SubjectName}</td>
				</tr>

				<tr>
					<th>Class:</th>
					<td>${ExmSubmitedDtls.CLASSID}<sup>th</sup></td>
				</tr>

				<tr>
					<th>Exam Id:</th>
					<td>${ExmSubmitedDtls.EAID}</td>
				</tr>

				<tr>
					<th>Start Duration:</th>
					<td>${StartTime}</td>
				</tr>

				<tr>
					<th>End Duration:</th>
					<td>${EndTime}</td>
				</tr>

				<tr>
					<th>Date:</th>
					<td>${examDate}</td>
				</tr>

				<tr>
					<th>Status:</th>
					<td>Submitted</td>
				</tr>

				<tr>
					<th>SIMRAN COACHING</th>
					<th>ONLINE EXAMINATION</th>
				</tr>
			</thead>
		</table>
	</div>

	<script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>

</body>
</html>