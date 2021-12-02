<%@ include file="/Teacher/TeacherHeader.jsp"%>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Context/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/AddQCSS.css">                                                                                                                                                                              

<title>Insert title here</title>
<style>

.container {
	text-align: center;
	background-color: #f1f1f1;
	padding: 20px;
	height:300px;
	border-radius: 15px
}

#btn{
     background-color: #D8BFD8;
     color:black;
     border:1px solid black;
}
#btn:hover{
         background-color:#9ACD32;
    
}

</style>
</head>
<body>
<div style="background: lightorange ; margin-top: 6%; margin-left:28%; width:40%; border-radius: 15px; -moz-border-radius: 15px;">
		<div class="container">
<%-- 		<form name="frm" action="<%=request.getContextPath()%>/DeclareResult?action=DeclareR" method="post"> --%>
		<div>
		<%  
		String tid=(String) session.getAttribute("TID");    	      
    	%>
		<input type="hidden" value="<%out.print(tid); %>" name="TID" id="TID" />
		<table class="style_1">
     <tr>                       		
				<td class="style_right_12">Class: &nbsp&nbsp </td>
				<td class="style_left_21"><select class="form-control" name="std" id="ddlClass">
					<option value="0">-Select-</option>
					            <option value="9">9th Class</option>
								<option value="10">10th Class</option>
								<option value="11">11th Class</option>
								<option value="12">12th Class</option>
					</select></td>
	
	
				<td class="style_right_12">
				<label for="setid"><br>Education &nbsp&nbsp Year: &nbsp&nbsp</label> 
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
              </tr>
              <tr>
              <td class="style_right_12"><br><br>Subjects: &nbsp&nbsp </td> <br>
				<td class="style_left_21"><br>
				<select class="form-control" name="Subid" id="ddlSubjects">
					<option value="0">-Select-</option>
					</select></td> 
					
					 <td class="style_right_12">&nbsp&nbsp</td>
					<td class="style_left_21"> <br> 
               <input type="submit" class="form-control" id="btn" name="setid" value="Declare" onclick="DeclareResult();" STYLE="width:45%;"/>
                </td>
                
               </tr>
               <tr><td colspan="2">
               <span id="msgAlert"></span>
               </td></tr>
	</table>
	</div>
<!-- 	</form> -->
		
		</div>
		</div>
		

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

<script>

function DeclareResult(){
	
		console.log('Result Declaration process beging..');	//
		$("#msgAlert").val('');
		var eduYear=$("#Eduyear").val();
		var ClassIDVal=$("#ddlClass").val();
		var SUBID=$("#ddlSubjects").val();
		var TID=$("#TID").val();
		if(ClassIDVal==0){
			 alert('Select Class');
			 return;
		 }
		if(SUBID==0){
			 alert('Select Subject');
			 return;
		 }
 if(eduYear==0){
	 alert('Select Education Year');
	 return;
 }
	 
		var parseAnsData={action:"DeclareResult",CLASSID:ClassIDVal,EDUYEAR:eduYear,SUBID:SUBID};
		console.log('Result Declaration started..');	
		$.ajax({
			url:'${pageContext.request.contextPath}/DeclareResult',
			type:'POST',
				data:parseAnsData,
	   		success: function (Result) {
	   			console.log('Result Declared..');	
 			$("#msgAlert").html("Result Declared");
 	  		},
	   		error: function (Resl) {  
	   		console.log(Resl);
	   		 alert('Result Not Declared Check Internet Connection..');
	   }
	});
 }

</script>


</body>
</html>