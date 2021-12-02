<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Examanination System</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/* Style all input fields */
input {
	width: 40%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
}

/* Style the submit button */
input[type=submit] {
	background-color: #4CAF50;
	color: white;
}

/* Style the container for inputs */
.container {
	text-align: center;
	background-color: #f1f1f1;
	padding: 20px;
}
</style>
</head>
<body>
	<div style="background: lightorange ; margin-top: 10%; margin-left:25%; width:50%; border-radius: 15px; -moz-border-radius: 15px;">
		<div class="container">
			<h2>Login Yourself here</h2>
			<form name="form" action="<%= request.getContextPath() %>/adminLoginControlller" method="post" onsubmit="return check()">
				
				<label for="usrname">Username</label>
				 <input type="text" id="usrname" name="usrname" maxlength="40" autocomplete="off"> <br>
				
				  <label for="psw">Password</label> 
				  <input type="password" id="psw" name="psw" maxlength="40" autocomplete="off"> <br>
				<label  style="color:red" > ${invalidcr} </label>
				<div style="align-text: center; margin-left: 6%">
				<input type="submit" value="Submit" width="25%" ID="SUBMIT" onclick="check()"> <br>
										 If new  <a href="TeacherRegi.jsp"> Sign Up </a>  here  <br> <br>
				<span class="psw"><a href="#"> Forgot password?</a></span>
				</div>
			</form>
		</div>
	</div>
	<script>
function check()
 {
	//adminLoginControlller  
	var username =document.getElementById("usrname").value;
	var password =document.getElementById("psw").value;
	if (username==null || username=="")
		{
		  alert (" Please Enter Username");
		  username.focus();
		  return false;
		}
	
	if (password==null || password=="")
	{
	  alert (" Please Enter Password");
	  password.focus();
	  return false;
	}
	return true;	
 }
 
</script>
</body>
</html>