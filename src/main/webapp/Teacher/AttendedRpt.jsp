<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ONLINE EXAMINATION SYSTEM</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/AddQCSS.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#Students {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 80%;
  margin-left:150px;
  margin-top:20px;
}

#Students td, #Students th {
  border: 1px solid #ddd;
  padding: 8px;
}

#Students tr:nth-child(even){background-color: #f2f2f2;}

#Students tr:hover {background-color: #ddd;}

#Students th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
.Print{
    width:50px; 
    height:40px; 
    margin-left:1300px; 
    border-radius:6px;
    margin-top:90px;
}

.Print:hover{
 background: red;

}

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

.btn {
	background-color: DodgerBlue;
	border: none;
	color: black;
	padding: 16px 32px;
	text-align: center;
	font-size: 16px;
	margin: 4px 2px;
	transition: 0.3s;
	float: right;
	margin-right: 250px;
	margin-top: 100px;
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
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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


	
    <div align="center" >
	<h5> Students Report</h5>
	</div>
	<br> 
	<div>${QueAddAlert}</div>
	<form name="form" class="form-group" action="<%=request.getContextPath()%>/ReportSetController?action=Attended" method="post">
	<div class="container">
	<div style="float:right;">${RptViewAlert}</div>
	<table>
     <tr>                       		
			<td class="style_right_12">				
	            <label for="setid">Education Year&nbsp&nbsp</label>
	           </td>
	             <td class="style_left_21">
                <select class="form-control" name="Eduyear" id="Eduyear">
                  <option value="0">-Select-</option>
					            <option value="2018-2019">2018-19</option>
								<option value="2019-2020">2019-20</option>
								<option value="2020-2021">2020-21</option>
								<option value="2021-2022">2021-22</option>
								<option value="2022-2023">2022-23</option>
								<option value="2023-2024">2023-24</option>               
                </select>
                </td>
                <td class="style_blank_1"></td>	 				
				<td class="style_right_12"> Class/Standard: &nbsp&nbsp</td>
				<td class="style_left_21">	 
				<select class="form-control" name="std" id="ddlClass">
						<option value="0">-Select-  &nbsp&nbsp</option>
						<option value="9">9th Class</option>
						<option value="10">10th Class</option>
						<option value="11">11th Class</option>
						<option value="12">12th Class</option>
				</select></td>
				<td class="style_right_12"> Subject: &nbsp&nbsp </td>
				<td class="style_left_21"><select class="form-control" name="subject" id="ddlSubjects">
					<option value="0">-Select-</option>
					</select></td>
					<td></td>
					<td></td>
					<td></td>					
					<td class="style_left_21"> 
               <input type="submit" class="form-control" id="fname" name="setid" value="View" STYLE="width:100%;"/>
                </td>               
				</tr>
	</table>
	</div>
	</form>
<br> <br>
<div id="R2">
<table id="Students">
<tr>

<h4 style="text-align:center"> SIMRAN COACHING ONLINE EXAMINATION</h4>
<div style="text-align:center">
<hr/>
<b>Title : Attended Report.</b>
<hr/>
 </div>
 </tr> 
  <thead>
	<tr>
  <th>Sr.No</th>
  <th>Student Id</th>
    <th>Student Name</th>
    <th>Subject</th>
    <th>Set </th>    
     <th>Marks/Total</th>
     </tr>
      </thead>
       <tbody>
					<c:forEach var="subwiserpt" items="${SAttended}">
						<tr>
							<td><c:out value="${subwiserpt.SN}" /></td>
							<td><c:out value="${subwiserpt.SID}" /></td>
							<td><c:out value="${subwiserpt.SNAME}" /></td>							
							<td><c:out value="${subwiserpt.subjectsnm}" /></td>
							<td><c:out value="${subwiserpt.setid}" /></td>
							<td><c:out value=" ${subwiserpt.OPTNMARKS} " />/<c:out value=" ${subwiserpt.totaltarks}" /></td>							
							</tr>
							</c:forEach>
							</tbody> 
  		 </table>
  		 </div>s

<form action="#" method="post">
<input type="button" id="Print" value="Print" style="margin-left:1300px; width:50px;  border-radius:6px;  height:40px; margin-top:90px; onMouseOver=this.style.color='red' ;">
  </form>
  
   <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
   
    <script type="text/javascript">
        $("body").on("click", "#Print", function () {
            html2canvas($('#R2')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Report.pdf");
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

