<%@ include file="/Teacher/TeacherHeader.jsp"%>


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

<div class="container">
	<div class="text-center">
		<h3>Add New Question Sheet</h3>
	</div>
	<div>${QueAddAlert}</div>
	<form name="form" class="form-group"	action="<%=request.getContextPath()%>/QuestionSheetController?action=insert" method="post">
	<div>
	<table class="style_1">
     <tr>       
				<td class="style_right_12"> Class/Standard: &nbsp&nbsp</td>
				<td class="style_left_21">	 
				<select class="form-control" name="std" id="ddlClass">
						<option value="0">-Select-  &nbsp&nbsp</option>
						<option value="9">9th Class</option>
						<option value="10">10th Class</option>
						<option value="11">11th Class</option>
						<option value="12">12th Class</option>
				</select></td>
		

				<td class="style_right_12">Subject: &nbsp&nbsp </td>
				<td class="style_left_21"><select class="form-control" name="subject" id="ddlSubjects">
					<option value="0">-Select-</option>
						</select></td>
				<td class="style_right_12">
	            <label for="setid">SetId &nbsp&nbsp</label><br>
	           </td>
	           <td class="style_left_21">
               <input type="number" class="form-control" id="fname" name="setid" value="" STYLE="width:85%;"/> <br> 
                </td>
                <td class="style_blank_1"></td>
				
			</tr>
	</table>
	</div>
	<table>
    		<tr>
		
				<td class="style_right_25">Question &nbsp&nbsp</td>
				<td class="style_left_25" colspan="3">
				<br>
					<textarea rows="2" cols="40" class="form-control" id="qestion"  autocomplete="off" name="qestion"></textarea></td>
				<td class="style_left_25"></td>
			</tr>
			<tr>
				<td class="style_right_25">Option A &nbsp&nbsp</td>
				<td class="style_left_25" colspan="3">
				<br>
					<INPUT rows="1.5" cols="40" class="form-control" autocomplete="off" name="opA" id="opA" /></td>
				<td class="style_left_25"></td>
			</tr>
			<tr>
				<td class="style_right_25">Option B &nbsp&nbsp  </td>
				<td class="style_left_25" colspan="3">
				<br>
				<INPUT rows="1.5" cols="40" type="text" name="opB" autocomplete="off" id="opB" class="form-control" /></td>
				<td class="style_left_25"></td>
			</tr>
			<tr>
				<td class="style_right_25">Option C &nbsp&nbsp </td>
				<td class="style_left_25" colspan="3">
				<br>
				<INPUT rows="1.5" cols="40"  name="opC" id="opC" autocomplete="off" class="form-control" /></td>
				<td class="style_left_25"></td>
			</tr>
			<tr>
				<td class="style_right_25">Option D &nbsp&nbsp</td>
				<td class="style_left_25" colspan="3">
				<br>
				<INPUT rows="1.5" cols="40"  name="opD" id="opD" autocomplete="off" class="form-control"></INPUT></td>
				<td class="style_left_25"></td>
				
			
			</tr>
			
			<tr>
				<td class="style_right_25">Answer &nbsp&nbsp </td>
				<td class="style_left_25" colspan="3">
				<br>
				<input type="radio" name="ANS"  value="A"  width="20%" />
				<label for="A">A</label>
								<input type="radio" name="ANS" value="B" width="20%" />
				<label for="B">B</label>
								<input type="radio" name="ANS" value="C" width="20%" />
				<label for="C">C</label>
								<input type="radio" name="ANS" value="D" width="20%" />
				<label for="D">D</label>
								</td>
				<td class="style_left_25"></td>
				
				<td>  <label for="Marks">Marks</label>
                      <input type="text" id="fname" name="Marks" size="5"/>  
                </td>
			</tr>
			 <tr>
				<td class="style_right_25"></td>
				<td class="style_left_25" colspan="3">
				<input	class="btn btn-success" type="submit" value="Submit" name="submit" width="40%"/>
				&nbsp &nbsp 
				<input	class="btn btn-warning" type="button" value="Clear" width="40%" />
				</td>
				<td class="style_left_25"></td>
			</tr>
			
			</table>
	</form>
</div>
</body>
</html>