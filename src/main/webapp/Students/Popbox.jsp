<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/ExamStyle.css">
<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
</head>
<body>
<div class="box">
	<a class="button" href="#popup1"> Exam submitted. </a>
	<form action="#popup1" >
	<input type="submit" class="button value="Exam" />
</form>
</div>

	<div id="popup1" class="overlay">
		<div class="popup">
			<a class="close" href="#">&times;</a>
			<div class="content">

				Are you sure to submit your exam? Then Click yes.. <br> <br>
				<br>

				<div style="align: center;">
					<table style="width: 90%; align: center;">
						<tr>
							<td style="align: center;">
								<form
									action="<%=request.getContextPath()%>/Students/Submitted.jsp"
									method="post">
									<input id="YesSubmit" type="submit" name="YesSubmit"
										value="Yes"
										style="font-size: 14px; width: 100px; height: 30px; border-radius: 8px; background-color: orange;" />
								</form>
							</td>
							<td style="align: center;"><input id="YesSubmit"
								type="submit" name="YesSubmit" value="No"
								style="font-size: 14px; width: 100px; height: 30px; border-radius: 8px;" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>



</body>
</html>