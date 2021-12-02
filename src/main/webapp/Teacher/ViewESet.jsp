

<%@ include file="/Teacher/TeacherHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>

<header><div 
			style="background-color: tomato">
			<ul class="navbar-nav">
				<li><a href="#"	class="nav-link">Exam set</a></li>
			</ul>
	</div>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Exam Sets</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/Teacher/AddESet.jsp" class="btn btn-success">Add
					New Exam Set</a>
			</div>
			<br>
			<form name="frm" action="register?action=View" method="post">
			<div class="text-center">
			</div>

			</form>
			<div style="text-align:right; color:orange;">${setviewMsg}</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Exam Id</th>
						<th>Total Question</th>
						<th>Total Marks</th>
						<th>Duration</th>
						<th>Date</th>
						<th>Status</th>
						<th>Is Allowed Students</th> 
						<th>Action</th> 
					</tr>
				</thead>
				<tbody>
					<c:forEach var="eset" items="${esetdataslst}">
						<tr>
					<td><c:out value="${eset.EID}" /></td>
							<td><c:out value="${eset.TOTLEQ}" /></td>
							<td><c:out value="${eset.TOTLEMARKS}" /></td>
							<td><c:out value="${eset.DURATION}" /></td>
							<td><c:out value="${eset.SDET}" /></td>
							<td><c:out value="${eset.STATUS}" /></td>	
							<td><c:out value="${eset.ISALLOWSTUD}"/></td>							
							<td>
							<a href="EsetServlet?action=edit&eid=<c:out value='${eset.EID}'/>"> Edit</a>
							<c:out value='${emp.id}' />
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
</body>
</html>