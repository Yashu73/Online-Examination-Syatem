<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="/Teacher/TeacherHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Sets</title>


</head>
<body>
	<div>
		<br>
		<div
			style="Border: 1px solid black; margin-left: 20%; margin-right: 20%; top: 2%; padding: 20px;">
			<h2 class="text-center">Edit Question Set</h2>

			<div class="alert alert-warning" role="alert">${setAddedSuccess}</div>
			<br>
			<form action="<%=request.getContextPath()%>/EsetServlet?action=Update"
				method="post">
				<table style="with: auto;">
								<tr>
						<td>Class </td><td>
				<select class="form-control" name="std" id="ddlClass">
						<option value="0">-Select-  &nbsp&nbsp</option>
						<option value="9">9th Class</option>
						<option value="10">10th Class</option>
						<option value="11">11th Class</option>
						<option value="12">12th Class</option>
				</select>
				
				<td class="style_right_25">Subject: &nbsp&nbsp </td>
				<td class="style_left_25"><select class="form-control" name="subject" id="ddlSubjects">
					<option value="0">-Select-</option>
						
				</select></td>
				
				</td>
				</tr>
				 <tr>
     <td>ESetId</td>
     <td><input type="number" maxlength="3"  name="esetid" value="${eset.EID}"  /></td>
    </tr>
			 		 
					<tr>
						<td>Total Questions</td>
						<td><input type="number" maxlength="3" name="TotalQ"
							value="${eset.TOTLEQ}" /></td>
					</tr>
					<tr>
						<td>Total Marks</td>
						<td><input type="number" maxlength="3" name="totalM"
							value="${eset.TOTLEMARKS}" /></td>
					</tr>
					<tr>
						<td>Duration(time in min)</td>
						<td><input type="number" maxlength="3" name="duration"
							value="${eset.DURATION}" /></td>
					</tr>
					<tr>
						<td>Status</td>
						<td><input type="radio" name="status" checked="checked"
							value="A" width="20%" /> <label for="A">Active</label> <input
							type="radio" name="status" value="D" width="20%" /> <label
							for="B"> Deactive </label></td>
					</tr>
					<tr>
					<tr>
						<td>Is Allowed For Students</td>
						<td><input type="radio" name="isallowstud" checked="checked"
							value="Y" width="20%" /> <label for="Y">Yes</label> <input
							type="radio" name="isallowstud" value="N" width="20%" /> <label
							for="N"> No </label></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="btn btn-success"
							value="Submit" /> &nbsp &nbsp <input class="btn btn-warning"
							type="submit" value="cancel" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
</body>
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

</html>