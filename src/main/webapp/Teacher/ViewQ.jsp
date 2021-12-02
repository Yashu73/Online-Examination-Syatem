

<%@ include file="/Teacher/TeacherHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Questions</h3>
			<hr>

			<form name="frm" action="<%=request.getContextPath()%>/QuestionSheetController?action=View" method="post">
				<table style="padding: 10px; cellspacing: 20px;">
					<tr>
						<td class="style_right_25">Class/Standard: &nbsp&nbsp</td>
						<td class="style_left_25"><select class="form-control"
							name="std" id="ddlClass">
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
						<td class="style_right_25"><br /></td>
						<td class="style_left_25"></td>
					</tr>
					<tr>
						<td class="style_right_25">Set Id: &nbsp&nbsp</td>
						<td class="style_left_25"> <input type="number"
							class="form-control" id="fname" name="setid" value=""
							STYLE="width: 35%;" /></td>
						<td class="style_right_25" colspan="2"><input type="submit" value="View"
							class="btn btn-primary" />			

				<a href="<%=request.getContextPath()%>/Teacher/AddQuestion.jsp"
					class="btn btn-success">Add Question</a>
					<a href="<%=request.getContextPath()%>/Teacher/importfile.jsp"
					class="btn btn-success">Import</a>
			</td>
		 			</tr>
				</table>
				<br>
							</form>
			</div>
			<div style="text-align: right; color: orange; width:90%;  margin-left:5%; margin-right:5% ; ">${setviewMsg}</div>   
			<div style="margin-left:5%; margin-right:5%;  width:90%;">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Question Id</th>
						<th>Question</th>
						<th>Op A</th>
						<th>Op B</th>
						<th>Op C</th>
						<th>Op D</th>
						<th>Answer</th>
						<th>Marks</th>
						
						
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Qset" items="${quedataslst}">
						<tr>
							<td><c:out value="${Qset.queid}" /></td>
							<td><c:out value="${Qset.QUESTION}" /></td>
							<td><c:out value="${Qset.opA}" /></td>
							<td><c:out value="${Qset.opB}" /></td>
							<td><c:out value="${Qset.opC}" /></td>
							<td><c:out value="${Qset.opD}" /></td>
							<td><c:out value="${Qset.ANS}" /></td>
							<td><c:out value="${Qset.marks}" /></td>
							<td><a
								href="QuestionSheetController?action=edit&Qid=<c:out value='${Qset.queid}'/>">
									Edit</a>  | 
									<a
								href="QuestionSheetController?action=Delete&Qid=<c:out value='${Qset.queid}'/>">
									Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
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
</body>
</html>