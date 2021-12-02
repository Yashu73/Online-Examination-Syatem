
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
.contain {
	text-align: center;
	background-color: #f1f1f1;
	padding: 20px;
	top:auto;
	vertical-align:middle;
	border-radius: 15px; -moz-border-radius: 15px;

	}
	#but{
	width:100px;
	margin-left:220px;
	}
	
</style>
</head>
<body>
    <form action=" <%= request.getContextPath()%>/ChangePassController?action=NewPassSubmit" method="post">
	<div style="background-color:#f1f1f1; margin-top: 6%; margin-left:30%; width:40%; border-radius: 15px; -moz-border-radius: 15px;">
		<div class="contain">
		<h3>Save New Password</h3>
		<hr></hr>
			<table align="center">
			<tr>
				 
			<tr><td> <label for="psw">Enter New Password</label></td>
			<td> <input type="password" id="psw"  class="form-control" name="pswNew" maxlength="40" placeholder="Enter Password"></td></tr>
				 
			<tr><td><label for="psw">Enter Confirm Password</label></td>
			<td><input type="password" id="psw" class="form-control"  name="pswCon" maxlength="40" placeholder="Enter Confirm Password"> </td></tr>
			</table>
			  
			   
			   <input type="Submit"  class="form-control" id="but" value="Submit" width="20%">
					
			</div>
		</div>
		</form>
</body>
</html>