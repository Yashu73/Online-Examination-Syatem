<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Examination Sys</title>
<link rel="stylesheet" href="../Context/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<div class="wrapper"
		style="background-image: url('images/StudReg.jpg');">
		<div class="inner">
			<form action=" <%= request.getContextPath()%>/StudentRegistrationController" method="post">
				<h3>Register here...</h3>
				<div class="form-group">
					<div class="form-wrapper">
						<label for="">username:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-account-o"></i> 
							<input type="text"
								class="form-control" name="usrname" >
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Email:</label>
						<div class="form-holder">
							<i style="font-style: normal; font-size: 15px;">@</i> <input
								type="text" class="form-control" name="email" autocomplete="off">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-wrapper">
						<label for="">Password:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-lock-outline"></i> <input type="password"
								class="form-control" name="psw" placeholder="********">
						</div>
					</div>
					<div class="form-wrapper">
						<label for="">Repeat Password:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-lock-outline"></i> <input type="password"
								class="form-control" placeholder="********">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="form-wrapper">
						<label for="">Mobile No:</label>
						<div class="form-holder">
						 <input type="Text"
								class="form-control" name="mob" autocomplete="off">
									</div>
					</div>
					<div class="form-wrapper">
						<label for="">Gender:</label>
						<div class="form-holder select">
							<lable for="Male"><input type="radio" id="Male">Male</lable>
							<lable for="Female"><input type="radio" id="Female">Female</lable>
							<lable for="Other"><input type="radio" id="Other">other</lable>
						</div>
					</div>
				</div>
				<div class="form-group">
				<div class="form-wrapper">
						<label for="">Class:</label>
						
						<div class="form-holder">
<!-- 						 <input type="text" -->
<!-- 								class="form-control" name="class" autocomplete="off"> -->
								
								<select class="form-control" name="class" id="ddlClass">
						<option value="0">-Select-  &nbsp&nbsp</option>
						<option value="9">9th Class</option>
						<option value="10">10th Class</option>
						<option value="11">11th Class</option>
						<option value="12">12th Class</option>
				</select>
								
						</div>
						</div>
						
						<div class="form-wrapper">
						<label for="">Education Year:</label>
						<div class="form-holder">
							<i class="zmdi zmdi-lock-outline"></i> 
							<select class="form-control" name="class" id="ddlClass">
						<option value="0">-Select-  &nbsp&nbsp</option>
						<option value="10">2015-16</option>
						<option value="11">2016-17</option>
						<option value="12">2017-18</option>
						<option value="9">2018-19</option>
						<option value="10">2019-20</option>
						<option value="11">2020-21</option>
						<option value="12">2021-22</option>
						<option value="9">2022-23</option>
						<option value="10">2023-24</option>
						<option value="11">2024-25</option>
						<option value="12">2025-26</option>
				</select>
			
							
						</div>
					</div>
				</div>
				
				
				
				
				
				
				<div class="form-end">

					<div class="button-holder">
						<button>Register Now</button>
					</div>
					<br>
				

				</div>
				
				<div class="form-end">
					<div class="button-holder">
					<br>
					 If Already You Have Registered
					<a href="FrmStudLogin.jsp"> Login  Here</a>
					</div>
					</div>
			</form>
		</div>
	</div>
	



</body>
</html>


<select name="gender" id="" class="form-control" >
								<option value="M">Male</option>
								<option value="F">Female</option>
							</select> <i class="zmdi zmdi-face"></i>