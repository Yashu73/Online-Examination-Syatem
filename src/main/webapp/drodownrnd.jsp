<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){	
	$('#ddlClass').on('change', function (e) {
	//	 alert("1. hii");  
	var  Value = $(this).val();
	 $.ajax({
	url:'${pageContext.request.contextPath}/DropdownBindServlet',
	type:'POST',
   	data:  {action:"getSubjects", classid:Value},
	   success: function (Result) {
		   console.log(Result);
		   $("#ddlSubjects").empty();
		   $("#ddlSubjects").append($("<option></option>").val('0').html("-Select-"));
		  $.each(Result, function (key, value) {  
			  console.log(Result);
          console.log((value.SID)+'---'+(value.SName));
          $("#ddlSubjects").append($("<option></option>").val(value.SID).html(value.SName));  
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

</head>
<body>
<div style="text-align:center;">
<div>

<select id="ddlClass" name="classes">
<option value="0">-Select-</option>
<option value="1"> 1St </option>
<option value="2"> 2St </option>
<option value="3"> 3St </option>
<option value="4"> 4St </option>
<option value="5"> 5St </option>
<option value="6"> 6St </option>
<option value="7"> 7St </option>
<option value="8"> 8St </option>
<option value="9"> 9St </option>
<option value="10"> 10St </option>
<option value="11"> 11St </option>
<option value="12"> 12St </option>
</select>
</div>
<select id="ddlSubjects" name="Subjects">
<option value="0">-Select-</option>
</select>
</div>

</body>
</html>