<%@ include file="/Teacher/TeacherHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<br> <div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Import Questions</h3>
			<hr>
			<div class="container text-left">
				
			</div>
			<form name="frm" action="<%=request.getContextPath()%>/QuestionSheetController?action=import"  enctype="multipart/form-data" method="post">
  <table style="padding: 10px; cellspacing: 20px;">
  <tr>
	<td class="style_right_25">Class/Standard: &nbsp&nbsp</td>
	<td class="style_left_25"><select class="form-control"	name="std" id="ddlClass">
								<option value="0">-Select- &nbsp&nbsp</option>
								<option value="9">9th Class</option>
								<option value="10">10th Class</option>
								<option value="11">11th Class</option>
								<option value="12">12th Class</option>
						</select></td>

	<td class="style_right_25">Subject: &nbsp&nbsp</td>
    <td class="style_left_25"><select class="form-control"
							name="subid" id="ddlSubjects">
								<option value="0">-Select-</option>
                    </select></td>
					</tr>
					<tr>
						<td class="style_right_25"></td>
						<td class="style_left_25"></td>

						<td class="style_right_25"><br/></td>
						<td class="style_left_25"></td>
					</tr>

					<tr>

						<td class="style_right_25">Set Id: &nbsp&nbsp</td>
						<td class="style_left_25"><input type="number"
							class="form-control" id="fname" name="setid" value=""
							STYLE="width: 35%;" /></td>
								<td class="style_right_25"><br/></td>
						<td class="style_left_25"></td>
                      </tr> 
                     
					<tr> 
					<td class="style_right_25"> </td> 
						<td class="style_left_25"> <br> <input type="file"  
							class="form-control" id="fname" name="choosefile" value=""  onchange="checkfile(this);"/>
							</td>
								<td class="style_left_25" colspan="2"> ${importALrtMsg} </td>

							</tr>
							
					<tr>
					<td class="style_right_25"></td>
						<td class="style_left_25"> <br> <input type="submit" value="Import"
							STYLE="width: 40%; background-color:LightGray;" class="btn" /></td>
								<td class="style_right_25"><br/></td>
						<td class="style_left_25"></td>
							</tr>
							
			</table>
			</form>
			</div>
</div>
		<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#ddlClass')
								.on(
										'change',
										function(e) {
											//	 alert("1. hii");  
											var Value = $(this).val();
											$
													.ajax({
														url : '${pageContext.request.contextPath}/SubjectController',
														type : 'POST',
														data : {
															action : "getSubjects",
															classid : Value
														},
														success : function(
																Result) {
															console.log(Result);
															$("#ddlSubjects")
																	.empty();
															$("#ddlSubjects")
																	.append(
																			$(
																					"<option></option>")
																					.val(
																							'0')
																					.html(
																							"-Select-"));
															$
																	.each(
																			Result,
																			function(
																					key,
																					value) {
																				console
																						.log(Result);
																				console
																						.log((value.SID)
																								+ '---'
																								+ (value.SUBNAME));
																				$(
																						"#ddlSubjects")
																						.append(
																								$(
																										"<option></option>")
																										.val(
																												value.SUBID)
																										.html(
																												value.SUBNAME));
																			});
														},
														error : function(Resl) {
															alert("Error"
																	+ Resl);
															console.log(Resl);
														}
													});
										});
					});
</script>
<script type="text/javascript" language="javascript">
function checkfile(sender) {
    var validExts = new Array(".xlsx", ".xls");
    var fileExt = sender.value;
    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
    if (validExts.indexOf(fileExt) < 0) {
      alert("Invalid file selected, valid files are of " +
               validExts.toString() + " types.");
      return false;
    }
    else return true;
}
</script>
</body>
</html>
