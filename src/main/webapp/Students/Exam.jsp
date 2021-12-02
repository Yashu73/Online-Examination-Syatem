<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Context/css/ExamStyle.css">
<script  type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
.container {
	margin: 20px;
}

.exmHeader {
	margin: 0;
	padding: 0;
	font-size: 20;
	background-color: #dfddff;
	height: 130px;
	border-radius:2px;
	
}

.StudDtls {
	postion: relative;
	color: blue;
	font-size: 20px;
	font-family: san-sarif;
	backgroud-color: #ddfffd;
	width: 50%;
	color: blue;
	font-size: 20px;
	font-family: san-sarif;
	backgroud-color: #ddfffd;
	width: 50%;
	margin-left: 5%;
}

.timerContainer {
	position: absolute;
	top: 25px;
	right: 50px;
	color: black;
	font-size: 30px;
	text-align: center;
	font-size: 30px;
	
}

.left {
	text-align: left;
}

.right {
	text-align: right;
}

.QueAnsContainer {
	margin-left: 5%;
	margin-right: 5%;
	padding: 10px;
}

.QueContainer {
	margin-left: 5%;
	margin-right: 5%;
	padding: 5px;
}

.AnswerContainer {
	margin-left: 5%;
	margin-right: 5%;
	padding: 2px;
}

.Quesnbttons {
	background-color: #dddffd;
	height: 55px;
	margin-top:120px;
}

.Prevbtn {
	position: relative;
	top: 0;
	margin-top: -2%;
	margin-left: 25%;
}

.Nextbtn {
	position: relative;
	top: 0;
	margin-top: -2%;
	margin-left: 40%;
}

.submitbtn {
	position: relative;
	top: 0;
	float: right;
	margin-top: -2%;
	margin-right: 10px;
}
.alertPanal
{
	position: relative;
	top: 20px;
	text-align:center;
	margin-top: -2%;
}
</style>
</head>
<body>
 <%
     if(session.getAttribute("Sid")==null){
        response.sendRedirect("../index.html");
     }
      %>
	<div class="container">
		<div class="exmHeader">
			<div class="StudDtls">
				<%  String name=(String)session.getAttribute("Sname"); 
		String Sid=(String) session.getAttribute("Sid");
		String Classid=(String) session.getAttribute("Studaclssid");
		String SUBID=String.valueOf(session.getAttribute("SubID"));
		String SUBJECTNAME=(String) session.getAttribute("SUBNAME");

		String ExmEAID1=(String.valueOf(session.getAttribute("ExmEAID")));
		String	ExmEID=(String.valueOf(session.getAttribute("EID")));
		String	ExmSID1 =(String.valueOf(session.getAttribute("Sid")));
		String	ExmCLASSID1=(String.valueOf(session.getAttribute("Studaclssid")));
		String	ExmSUBID1=(String.valueOf(session.getAttribute("SubID")));
		String SN1=(String.valueOf(session.getAttribute("SN")));
		String	TOLQUES1=(String.valueOf(session.getAttribute("TOLQUES")));
		String	TOLREMAINTIME=(String.valueOf(session.getAttribute("TOLREMAINTIME")));
    %>
   
				<table>
					<tr>
						<td class="right">Name:</td>
						<td class="left"><b> <%out.print(name);     
    %></b></td>
					</tr>
					<tr>
						<td class="right">Class:</td>
						<td class="left"><b> <%out.print(Classid);     
    %> th</b></td>
					</tr>
					<tr>
						<td class="right">Student ID:</td>
						<td class="left"><b><%out.print(Sid);  %>
						</b></td>
					</tr>
					<tr>
						<td class="right">Subject:</td>
						<td class="left"><b><%out.print(SUBJECTNAME);  %></b></td>
					</tr>
				</table>
			</div>
	<div class="alertPanal">
	  <p id="alert" style="font-style:bold; font-size: 14px"> Alert Message </p>
	</div>
			<div class="timerContainer">
				<label id="demo" class="timer">mm:ss</label> 
				<input type="hidden" name="timerCountDown" id="timerCountDown" />	                                                   
			</div>                                                                      
		</div>
		<hr>
		 	
		<div class="QueAnsContainer">
		<input type="hidden" name="SN" id="SN" value="<%out.print(SN1);%>" />
		<input type="hidden" name="SUBID" id="SUBID" value="<%out.print(SUBID);%>" />
		<input type="hidden" name="QueID" id="QueID" value="1" />
		<input type="hidden" name="SID" id="SID" value="<%out.print(Sid);  %>"/>
		<input type="hidden" name="EID" id="EID" value="<%out.print(ExmEID);%>"/>
		<input type="hidden" name="EAID" id="EAID" value="<%out.print(ExmEAID1); %>"/>
		<input type="hidden" name="ClassId" id="ClassId" value="<%out.print(Classid); %>"/>
		<input type="hidden" name="totalQues" id="totalQues" value="<%out.print(TOLQUES1); %>"/>                  
		<input type="hidden" name="TOLREMAINTIME" id="TOLREMAINTIME" value="<%out.print(TOLREMAINTIME); %>"/>                                           
		
		
			<div class="QueContainer">
				<p>
					<b> <span id="QueSN"> </span></b> <span id="Quesns"> Questions </span>
				</p>
			</div>
			<div class="AnswerContainer">
				<p>
					<b>Option A|</b>
					 <input type="radio" value="A" name="option" /> 
					 <Label	for="A" id="OptnA"> Teacher 1</Label>
				</p>
				<br>
				<p>
					<b>Option B|</b><input type="radio" value="B" name="option"  /> 
					<Label	for="B" id="OptnB"> Teacher 2</Label>
				</p>
				<br>
				<p>
					<b>Option C|</b><input type="radio" value="C" name="option"  /> 
					<Label 	for="C" id="OptnC"> OP 3</Label>
				</p>
				<br>
				<p>
					<b>Option D|</b><input type="radio" value="D" name="option"/>
					 <Label	for="D" id="OptnD"> OPN 4</Label>
				</p>
				<br>
			</div>
		</div>
		<br>
		<div class="Quesnbttons">
		<br>
			<div class="btns">
				<table width="100%">
					<tr>
						<td width="30%">
 								<input type="submit" value="Prev" name="Prev" id="Prev" />
 						</td>
						<td width="20%">
 								<input type="submit" value="Next" name="Next" id="Next" />
 						</td>
						<td width="50%">
							 <a class="button" href="#popup1"> Exam submit. </a>			
						</td>						
					</tr>
				</table>
			</div>
					
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
								<form action="<%=request.getContextPath()%>/Exam?action=Submit" method="post">
								<input type="hidden" name="SID1" id="SID1" value="<%out.print(Sid);  %>"/>
								<input type="hidden" name="EID1" id="EID1" value="<%out.print(ExmEID);%>"/>
								<input type="hidden" name="EAID1" id="EAID1" value="<%out.print(ExmEAID1); %>"/>
								<input type="hidden" name="ClassId1" id="ClassId1" value="<%out.print(Classid); %>"/>
									<input id="YesSubmit" type="submit" name="YesSubmit" value="Yes"
										style="font-size: 14px; width: 100px; height: 30px; border-radius: 8px; background-color: orange;" />
								</form>
							</td>
							<td style="align: center;">
							<input id="No" type="submit" name="No" onclick="popupclose();" value="No"
								style="font-size: 14px; width: 100px; height: 30px; border-radius: 8px;" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	</div> 
	
	
</body> 	
<!-- <script type="text/javascript" src=${pageContext.request.contextPath}/js/Exam1.js></script>	 -->

<script type="text/javascript">


function popupclose(){
	
	var popid= document.getElementById("alert");
	popup.style.display='popup1';
}



	//Update Answer...
$(document).ready(function(){	
	$('input:radio[name="option"]').change(function(){
	var AnsVal = $(this).val();
	var sidVal=$("#SID").val();
	var QueidVal=$("#QueID").val();
	var SNVal=$("#SN").val();
	var	EAIDVal=$("#EAID").val();
	var SETIDVAL=$("#EID").val();
	var ClassIDVal=$("#ClassId").val();
	var parseAnsData={action:"updateAnswer",EAID:EAIDVal,CLASSID:ClassIDVal,SID:sidVal,ANSWER:AnsVal,QID:QueidVal,SN:SNVal,SETID:SETIDVAL};
	$.ajax({
		url:'${pageContext.request.contextPath}/Exam',
		type:'POST',
			data:parseAnsData,
   		success: function (Result) {
	   	console.log("Answer Updated Successfully.."+Result+"Ques ID:-"+SNVal);
    	 	document.getElementById("alert").innerHTML="Question No. "+ SNVal +" Answer Saved.";  
	     },
   		error: function (Resl) {  
   			 document.getElementById("alert").innerHTML="Question No. "+ SNVal +" Answer Not Saved Saved. Check Network and Restart Exam";  
    		 console.log(Resl);
   }
});
});
});
//

////Update Time
function  UpdateRemainigTime(mints) {
{
	//var  AnsVal = $(this).val();
	var sidVal=$("#SID").val();
	var QueidVal=$("#QueID").val();
	var SNVal=$("#SN").val();
	var	EAIDVal=$("#EAID").val();
	var ClassIDVal=$("#ClassId").val();
 	var  RemainTimeVal = mints;
 	var parseData={action:"updateRemainigTime",SID:sidVal,RemainTime:RemainTimeVal,EAID:EAIDVal,CLASSID:ClassIDVal};
//${pageContext.request.contextPath}
 $.ajax({
		url:'${pageContext.request.contextPath}/Exam',
		type:'POST',
			data: parseData,
   			success: function (Result) {
   				console.log(Result+"Time Updated Time:-"+RemainTimeVal);
   			},
   error: function (Resl) {  
	   document.getElementById('alert').innerHTML='Check Network and Restart Exam';
		   console.log(Resl);
   }  
});
}
}

var countMin = 60;
var Hours = 0;
var minutes = document.getElementById("TOLREMAINTIME").value;
var seconds = 0;
if (minutes > 59) {
	Hours = Math.floor(minutes / 60);
	minutes = minutes % 60;
}
seconds = 0;
// Update the count down every 1 second
var x = setInterval(function() {
	if (seconds == 0) {
		if (minutes > 0) {
			minutes--;
			
			//Update time every one min
			UpdateRemainigTime(minutes+1);
			seconds = 59;
		}
		else if (minutes == 0 && Hours > 0) {
			Hours--;
			minutes = 59;
		} else {
			UpdateRemainigTime(0);
			 $( "#YesSubmit" ).click();
	       // document.getElementById("YesSubmit").click();
			console.log("Time Is Over Auto Submited..");
	        clearInterval(x);

		}
	}
	else {
		seconds--;
	}
		if(seconds<10)
			seconds="0"+seconds;
		
		if(minutes<10){
	 		minutes="0"+parseInt(minutes);
		}			
		if(Hours<10){ 
			Hours="0"+parseInt(Hours);
			}
	 if (Hours > 0) {
		document.getElementById("demo").innerHTML = Hours + "h: " + minutes	+ "m: " + seconds + "s ";
	} else {
		document.getElementById("demo").innerHTML = minutes + "m: "	+ seconds + "s ";
	}
	 applyCSS(document.getElementById("demo"));	 
}, 1000);
	function preventBack() {
	window.history.forward();
}
setTimeout("preventBack()", 0);
window.onunload = function() {
	null
};



function applyCSS(timer_div){
	timer_div.style.fontsize="20px";
	timer_div.style.color="red";
	timer_div.style.fontweight="bold";
	timer_div.style.width="270px";
	timer_div.style.padding="5px";
	timer_div.style.textAlign="center";
	timer_div.style.border="3px solid LightGrey";
	timer_div.style.float="right";
	timer_div.style.height="50px";
}
</script>

<script>

$(document).ready(function(){	
	$('#Next').click(function(){ 
	var AnsVal = $(this).val();
	var sidVal=$("#SID").val();
	var QueidVal=$("#QueID").val();
	var SNVal=$("#SN").val();
	var	EAIDVal=$("#EAID").val();
	var ClassIDVal=$("#ClassId").val();
	var SUBID=$("#SUBID").val();
	var SETIDVAL=$("#EID").val();
	var totalQues=$("#totalQues").val();
	
	if(totalQues==SNVal)
		{
		alert("This is the Last Question");
		return;
	}
	SNVal++;
	 	
	var parseAnsData={action:"Next",EAID:EAIDVal,CLASSID:ClassIDVal,SID:sidVal,SETID:SETIDVAL,SN:SNVal,SUBID:SUBID};
	$.ajax({
		url:'${pageContext.request.contextPath}/Exam',
		type:'POST',
			data:parseAnsData,
   		success: function (Result) {
   	   		$("#Quesns").html(Result.QUESTION);  
	   		$("#OptnA").html(Result.A);  
             $("#OptnB").html(Result.B); 
             $("#OptnC").html(Result.C);  
        	 $("#OptnD").html(Result.D);  
        	 $("#QueSN").html(SNVal);
        	 $("#SN").val(SNVal);
        	 $("#QueID").val(Result.QID);
        	 bindRadoBtnCheckAns(Result.ANS);
  	 	},
   		error: function (Resl) {  
   			console.log(Resl);
   }
});
});
});
	
	function bindRadoBtnCheckAns(ans){
		$('input:radio[name="option"]').removeAttr('checked')
		if(ans=="A"){
    		 $("#A").attr('checked', 'checked');
    	 }
    		 if(ans=="B"){
    			 $("#B").attr('checked', 'checked');
    		 }
    			 if(ans=="C"){
    				 $("#C").attr('checked', 'checked');
    			 }
    				 if(ans=="D"){
    					 $("#D").attr('checked', 'checked');
    				 }
    				 else
    					 {
    					 return;
    					 }
	}
		
	$(document).ready(function(){	
	$('#Prev').click(function(){	 
		var AnsVal = $(this).val();
		var sidVal=$("#SID").val();
		var QueidVal=$("#QueID").val();
		var SNVal=$("#SN").val();
		var	EAIDVal=$("#EAID").val();
		var ClassIDVal=$("#ClassId").val();
		var SUBID=$("#SUBID").val();
		var SETIDVAL=$("#EID").val();
		var totalQues=$("#totalQues").val();
		
		if(1==SNVal)
			{
			alert("This is the First Question");
			return;
		}
		SNVal--;
		if(SNVal==0)
		{
			SNVal=1;
		} 		
		var parseAnsData={action:"Next",EAID:EAIDVal,CLASSID:ClassIDVal,SID:sidVal,SETID:SETIDVAL,SN:SNVal,SUBID:SUBID};
		$.ajax({
			url:'${pageContext.request.contextPath}/Exam',
			type:'POST',
				data:parseAnsData,
	   		success: function (Result) {
	   	   		$("#Quesns").html(Result.QUESTION);  
		   		$("#OptnA").html(Result.A);  
	             $("#OptnB").html(Result.B); 
	             $("#OptnC").html(Result.C);  
	        	 $("#OptnD").html(Result.D);  
	        	 $("#QueSN").html(SNVal);
	        	 $("#SN").val(SNVal);
	        	 $("#QueID").val(Result.QID);
	        	 bindRadoBtnCheckAns(Result.ANS);
	  	 	},
	   		error: function (Resl) {  
	   			console.log(Resl);
	   }
	});
  });
});
</script>

<script>

ExamBegin();

function ExamBegin(){
	
	console.log('Exam beging..');	
		//var AnsVal = $(this).val();
		var sidVal=$("#SID").val();
		var QueidVal=$("#QueID").val();
		var SNVal=$("#SN").val();
		var	EAIDVal=$("#EAID").val();
		var ClassIDVal=$("#ClassId").val();
		var SUBID=$("#SUBID").val();
		var SETIDVAL=$("#EID").val();
		var totalQues=$("#totalQues").val();
		console.log('Exam beging..222');
		SNVal=1; 
		var parseAnsData={action:"Next",EAID:EAIDVal,CLASSID:ClassIDVal,SID:sidVal,SETID:SETIDVAL,SN:SNVal,SUBID:SUBID};
		console.log('Exam beging..33');
		$.ajax({
			url:'${pageContext.request.contextPath}/Exam',
			type:'POST',
				data:parseAnsData,
	   		success: function (Result) {
	   	   		$("#Quesns").html(Result.QUESTION);  
		   		$("#OptnA").html(Result.A);  
	             $("#OptnB").html(Result.B); 
	             $("#OptnC").html(Result.C);  
	        	 $("#OptnD").html(Result.D);  
	        	 $("#QueSN").html(SNVal);
	        	 $("#SN").val(SNVal);
	        	 $("#QueID").val(Result.QID);
	        	 //bindRadoBtnCheckAns(Result.ANS);
	  	 	},
	   		error: function (Resl) {  
	   			console.log(Resl);
	   }
	});
 }

</script>
</html>