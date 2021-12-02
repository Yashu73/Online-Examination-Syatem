<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="Context/bootstrap/css/bootstrap.min.css">


<style>

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  margin-left: 10px;
  margin-right:10px;
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
  float:right;
  margin-right: 250px;
  margin-top:500px;
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
	box-shadow: 0px 8px 16px 0px  rgba(0,0,0,0.2);
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

<style>
.dropbtn {
  color: red;
  padding: 16px;
  font-size: 16px;
  border: 1px solid black;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

 .dropdown-content a:hover {background-color: #ddd;}  
 .dropdown:hover .dropdown-content {display: block;}
 .dropdown:hover .dropbtn {background-color: #ddffdd;} 
</style>



</head>
<body>

<div class="logo" > 
    <img src="Images/OElogo.jpg" width=120px height="80px" alt="logo not found"/>
      </div>
      <div style="text-align: center"> 
      <h1>Online Examination</h1>
     </div>
     
      <%
     if(session.getAttribute("Sid")==null){
        response.sendRedirect("../index.html");
     }
      %>
      
  
<div class="topnav">
 <a class="active" href="<%=request.getContextPath()%>/Students/StudentDashboard.jsp"><i class="fa fa-fw fa-dashboard"></i>Dashboard</a>
 
  <a href="ActiveExam?action=view"><i class="fa fa-check-square-o"></i>Current Active</a>
   <a href="${pageContext.request.contextPath}/Students/StudReport.jsp"> View Result </a>
    <div class="dropdown" Style="color:white; position :relative;">
  
   	<%  String name=(String)session.getAttribute("Sname"); 
		String id=(String) session.getAttribute("Sid");
    	 out.print(name);     
    %>
 
   <div class="Login"><a href="<%=request.getContextPath()%>/logoutservlet" class="dropbtn"><i class="fa fa-user-circle-o"></i>Logout
     </a>
   <div id="myLogin" class="Login-content">
   <a href="#"> View Profile</a>
	<a href="#"> Change Password</a>
	<a href="#"> LogOut</a>
	</div>	
	<div class="menu-bar">
	<ul>
	<li>
				<a href="#"> <%  String name1=(String)session.getAttribute("TNAME"); 
		    	 out.print(name); %> </a>
				<div class="sub-menu-1">
					<ul>
					<li><a href="${pageContext.request.contextPath}/Teacher/TChangePass.jsp"> Change Password </a></li>
						<li> <a href="<%=request.getContextPath()%>/logoutservlet"> LogOut </a></li>
			</ul>
			</div>
			</li>	
			</ul>
	
	
  </div>
   
  </div>
</div>
</body>
<script>
function myFunction() {
  document.getElementById("myLogin").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var Logins = document.getElementsByClassName("Login-content");
    var i;
    for (i = 0; i < Logins.length; i++) {
      var openLogin = Logins[i];
      if (openLogin.classList.contains('show')) {
        openLogin.classList.remove('show');
      }
    }
  }
}
 </script>
 
 <script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>
</html>
