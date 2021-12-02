<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Examination System</title>


<script> 
function validate()
{ 
     var fullname = document.form.fullname.value;
     var email = document.form.email.value;
     var username = document.form.username.value; 
     var password = document.form.password.value;
     var conpassword= document.form.conpassword.value;
     
     if (fullname==null || fullname=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (email==null || email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (password!=conpassword)
     { 
     alert("Confirm Password should match with the Password"); 
     return false; 
     }
 } 
</script>

</head>
<body>




	<div style="align: center;">
		<h2>New Registration</h2>
	</div>
	<form name="form" action="teacherRegistration" method="post"
		onsubmit="return validate()">
		<table style="align: center;">
			<tr>
				<td>Full Name</td>
				<td><input type="text" name="fullname" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Mobile No</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><input type="date" name="DOB" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="conpassword" /></td>
			</tr>
			<tr>
				<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></input> <input
					type="reset" value="Reset"></input></td>
			</tr>
		</table>
	</form>
	<br>
	<hr>
	<br>
	<div style="text-align: center;">


		<table style="width: 100%;">
			<tr>
				<td style="width: 10%;"></td>
				<td style="width: 80%;">
					<table style="border: 1px solid black; width: 100%">
			<thead style="border: 1px solid black;">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Date of Birth</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody style="border: 1px solid black;">
				<tr>
					<td>1</td>
					<td>Yash</td>
					<td>Yash@gmail.com</td>
					<td>9975168796</td>
					<td>07Dec1999</td>
					<td>Active</td>
					<td>Edit</td>

				</tr>
				<tr>
					<td>2</td>
					<td>Shri</td>
					<td>Shrih@gmail.com</td>
					<td>9678615799</td>
					<td>01Jan1997</td>
					<td>Active</td>
					<td>Edit</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Shri</td>
					<td>Shrih@gmail.com</td>
					<td>9678615799</td>
					<td>01Jan1997</td>
					<td>Active</td>
					<td>Edit</td>
				</tr>
			</tbody>
		</table>
				
				</td>
				<td style="width: 10%;"></td>
			</tr>
		</table>

		</div>

</body>



</body>
</html>