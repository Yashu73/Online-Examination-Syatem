<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ONLINE EXAMINATION SYSTEM.</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/AddQCSS.css">
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
  margin-top:10px;
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
 
</head>
<body>

 <%
     if(session.getAttribute("Sid")==null){
        response.sendRedirect("../index.html");
     }
      %>

<div class="topnav">
 <a class="active" href=""> <i class="fa fa-fw fa-dashboard"></i>Dashboard</a>
 
  <a href="ActiveExam?action=view"><i class="fa fa-check-square-o"></i>Current Active</a>
   <a href="#contact"> View Result </a>
 
 
 
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
  </div>
   
  </div>
</div>
<br>

<div class="container">
	<div class="text-center">
		<h3> View your Result</h3>
	</div>
	<br>
	<div>${QueAddAlert}</div>
	<form name="form" class="form-group" action="<%=request.getContextPath()%>/ReportSetController?action=Studrpt" method="post">
	<div>
	<table class="style_1">
     <tr>       
     	<td class="style_right_12">
	            <label for="setid"> Class: </label>
	           </td>
	           <td class="style_left_21">
              <select class="form-control" name="std" id="ddlClass">
						<option value="0">--Select--</option>
						<option value="9">9th Class</option>
						<option value="10">10th Class</option>
						<option value="11">11th Class</option>
						<option value="12">12th Class</option>
				</select>
                </td>                
                 <td class="style_left_21">
               <input type="submit" class="form-control" id="fname" name="setid" value="View" STYLE="width:40%;"/>
             </td>               
			</tr>
	</table>
	</div>
	</form>
	</div>
	<br> 
	<br> 
	
	<div id="Report" class="container" style="background-color:#F8F8FF;margin-left:10%; width:100%;border-radius:5px; margin-right:10%;">
	 <table align="center">
	 <tr><td style="color:green;"> Student Name :<% out.print(name); %>.</td></tr>
	  <tr><td style="color:green;">Class : <%String clssid=String.valueOf(session.getAttribute("Studaclssid"));
	  								out.print(clssid); %> </td></tr>
	  <tr><td style="color:green;"> </td></tr>
	 	</table>
	 	<br><br>
	 	<table style="width:100% ; text-align:center;" border=1>	 
	 <thead>
	 <tr>
	 	
	 	<th style="color:blue;" > Sr. No.</th>
	 	<th style="color:blue;" >Set ID </th>
	 	<th style="color:blue;" > Subject</th>
	 	<th style="color:blue;" > Exam Date</th>
	 	<th style="color:blue;" > Total Ques</th>
	     <th style="color:blue;"> Total Marks </th>
	     <th style="color:blue;"> Marks </th>	     
	 </tr>	 
	 </thead>
	  
	 <tbody>
					<c:forEach var="subwiserpt" items="${StudReport}">
						<tr>
							<td><c:out value="${subwiserpt.SN}" /></td>
							<td><c:out value="${subwiserpt.setid}" /></td>
							<td><c:out value="${subwiserpt.subjectsnm}" /></td>
							<td><c:out value="${subwiserpt.EXMADATE}" /></td>
							<td><c:out value="${subwiserpt.TOTLEQ}" /></td>			
							<td><c:out value=" ${subwiserpt.totaltarks}" /></td>					
							<td><c:out value=" ${subwiserpt.OPTNMARKS} " /></td>
														
							</tr>
					</c:forEach>
	</tbody> 
	 </table>
	
	</div>


<form action="#" method="post">
<input type="button" id="Print" value="Print" style="margin-left:1300px; width:50px;  border-radius:6px;  height:40px; margin-top:60px;
 onMouseOver=this.style.color='red' ;">
  </form>
  
   <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
   
    <script type="text/javascript">
        $("body").on("click", "#Print", function () {
            html2canvas($('#Report')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("StudReport.pdf");
                }
            });
        });
    </script>
	
	
	
<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>                                    
<script type="text/javascript">
$(document).ready(function(){	
	$('#ddlClass').on('change', function (e) {
	//	 alert("1. hii");  
	var  Value = $(this).val();
	 $.ajax({
	url:'${pageContext.request.contextPath}/SubjectController',
	type:'POST',
   	data:  {action:"getSubjects", classid:Value},
	   success: function (Result) {
		   console.log(Result);
		   $("#ddlSubjects").empty();
		   $("#ddlSubjects").append($("<option></option>").val('0').html("-Select-"));
		  $.each(Result, function (key, value) {  
			  console.log(Result);
          console.log((value.SID)+'---'+(value.SUBNAME));
          $("#ddlSubjects").append($("<option></option>").val(value.SUBID).html(value.SUBNAME));  
             });  
           },
       error: function (Resl) {  
         alert("Error" +Resl); 
         console.log(Resl);
       }  
	});
	 });
});
</script>
</body>
</html>