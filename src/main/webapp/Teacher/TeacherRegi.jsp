<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Online Examination Sys</title>

<link rel="stylesheet" href="../Context/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="wrapper"
		style="background-image: url('images/StudReg.jpg');">
		<div class="inner">
			<form action="<%= request.getContextPath() %>/TeacherRegistrationController" method="Post">
				<h3>Register here...</h3>
				<div class="form-group">
					<div class="form-wrapper">
						<label for="">Username:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-account-o"></i> <input type="text" name="usrname" 
								class="form-control" autocomplete="off">
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Email:</label>
						<div class="form-holder">
							<i style="font-style: normal; font-size: 15px;">@</i> <input
								type="text"  name="email" class="form-control" autocomplete="off">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-wrapper">
						<label for="">Password:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-lock-outline"></i> <input type="password"  name="psw"
								class="form-control" placeholder="********">
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Repeat Password:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-lock-outline"></i> <input type="password" name="rpsw"
								class="form-control" placeholder="********">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-wrapper">
						<label for="">Mobile No:</label>
						<div class="form-holder">
						 <input type="Text" name="mob"
								class="form-control" autocomplete="off">
						
						
						
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Gender:</label>
						<div class="form-holder select">
							<select name="gender" id="" class="form-control">
								<option value="M">Male</option>
								<option value="F">Female</option>
							</select> <i class="zmdi zmdi-face"></i>
						</div>
					</div>
				</div>
				<div class="form-group">
				<div class="form-wrapper">
						<label for=""> Designation:</label>
						<div class="form-holder">
						 <input type="text" name="desig"
								class="form-control">
						</div>
						</div>
				</div>
				<div class="form-end">

					<div class="button-holder">
					<input type="SUBMIT" value="Register Now"> 	</div>
					<br>
				

				</div>
				
				<div class="form-end">
					<div class="button-holder">
					<br>
					 If Already You Have Registered
					<a href="FrmTeacherLogin.jsp"> Login  Here</a>
					</div>
					</div>
			</form>
		</div>
	</div>
	</body>
</html>