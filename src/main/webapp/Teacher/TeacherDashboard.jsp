<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Online Examination Sys</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	width: 100%;
	background-color:#555;
}

.navbar a {
	float: left;
	padding: 12px;
	color: white;
	text-decoration: none;
	font-size: 17px;
}

.navbar a:hover {
	background-color:#000;
}

.dropbtn {
	background-color: red;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
	background-color: ;
}

.Update{
	position: relative;
	display: inline-block;
	/*	float: left; */
}

.Update-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px  rgba(0,0,0,0.2);
	z-index: 1;
}

.Update-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.Update a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}

.active {
	background-color: #4CAF50;
}

@media screen and (max-width: 500px) {
	.navbar a {
		float: none;
		display: block;
	}
	}
</style>

</head>
<body>

	<h1>Welcome To SIMRANCOACHING</h1>
	<h2>Online Examination</h2>
	<h1> Teacher Dashboard</h1>
	

	<div class="navbar">
		<a class="active"  href="TeacherDashboard.jsp"><i class="fa fa-fw fa-home"></i> Dashboard</a> 
		<a href=""> <i class="fa fa-fw fa-search"></i> View Students</a> 
		<a href=""> <i class="fa fa-fw fa-envelope"></i> Report </a>
		<div class="Update">
			<button onclick="myFunction()" class="dropbtn"> Update</button>
			<div id="myUpdate" class="Update-content">
				<a href=""> Add Paper </a> <br>
				<a href="">Result </a> <br> <br> 
				<a href=""> xyz </a>
			</div>
		</div>
	</div> <br> <br> <br> 
	

	
<script>
function myFunction() {
  document.getElementById("myUpdate").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var Updates = document.getElementsByClassName("Update-content");
    var i;
    for (i = 0; i < Updates.length; i++) {
      var openUpdate = [i];
      if (openUpdate.classList.contains('show')) {
        openUpdate.classList.remove('show');
      }
    }
  }
}
 </script>

</body>
</html>