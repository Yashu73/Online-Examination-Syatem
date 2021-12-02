
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>

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
	top:20%;
	vertical-align:middle;
	border-radius: 15px; -moz-border-radius: 15px;
	}
</style>
</head>
<body>
	<div style="background-color:#f1f1f1; margin-top: 10%; margin-left:25%; width:50%; border-radius: 15px; -moz-border-radius: 15px;">
	<form action=" <%= request.getContextPath()%>/ChangePassController?action=VerifyOTP" method="post">
		<div class="container">
			<h2>Verifying Email OTP</h2>
			<hr></hr>
			
				<label for="usrname">Enter OTP</label>
				 <input type="text" id="usrname" name="OTP" maxlength="40" autocomplete="off" placeholder="OTP"> <br>
					<div style="align-text: center; margin-left: 6%">
					<h5 style="color:red;">${FogetEmailAlert}</h5>
				<input type="Submit" value="OK" width="25%"><br>
					
			</div>
		</div>
		</form>
	</div>
</body>
</html>