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

<div id="timer_div" style="font-size:40px; margin-top:50px; margin-right:30px;">
</div>
<div class="details" > 
<p><b> Name:&nbsp&nbsp ${StudentDetails.SNAME} Yashashri Ramakant Chafekar.</b></p>
<p> <b>Student ID:&nbsp&nbsp ${StudentDetails.SID} 202166.</b></p>
<p><b> class:&nbsp&nbsp ${StudentDetails.std} MCA II.</b></p>
<p> <b>Subject:&nbsp&nbsp ${StudentDetails.std} Java.</b></p>
</div>
 <hr>
<!--  ========================the hidden filed used for time update and answer update===================== -->

<input type="hidden" name="SN" id="SN" value="1" />
		<input type="hidden" name="QueID" id="QueID" value="1" />
		<input type="hidden" name="SID" id="SID" value="1"/>
		<input type="hidden" name="EAID" id="EAID" value="1"/>
		<input type="hidden" name="ClassId" id="ClassId" value="1"/>



<!--  ============================================= -->
 <div class="Q">
 <p> 1.What is your name?</p>
 </div>
 <br>
 
 <div class="A">
 
 
  <label class="radio">
      <input type="radio" value="A" name="option"> A) : Yash.
    </label> <br> <br> <br>
    
       <label class="radio">
       <input type="radio" value="B" name="option"> B) : Yashu.
    </label>  <br> <br> <br>
    
         <label class="radio">
        <input type="radio" value="C" name="option"> C) : Maauu.
    </label>  <br> <br> <br>
              <label class="radio">
        <input type="radio" value="D" name="option"> D) : Yashashri.
    </label>
    
 </div>
 

 <div class="But">
 <table width="100%">
 <tr> 
 <td width="40%">
 <form action="<%=request.getContextPath()%>/Exam?action=prev" method="post">
						
 <input type="button" class="P" value="Pre" name="submit" style="width:90px; height:40px; font-size:20px;  border-radius:6px;" />
 </form>
 </td>
 <td width="20%">
 <form action="<%=request.getContextPath()%>/Exam?action=next" method="post">
 <input type="button" class="N" value="Next" name="submit" style="width:90px; height:40px;  font-size:20px; border-radius:6px;"/>
 </form>
 </td>
 <td width="50%">
 <form action="#popup1">   
 <input type="submit" class="S" value=" Submit " name="submit" style="width:90px; height:40px;font-size:20px;  border-radius:6px;"/>
</form>
</td>
 </table>
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
 
<script type="text/javascript">
	//Update Answer...
$(document).ready(function(){	
	$('input:radio[name="option"]').change(function(){
	var AnsVal = $(this).val();
	var sidVal=$("#SID").val();
	var QueidVal=$("#QueID").val();
	var SNVal=$("#SN").val();
	var	EAIDVal=$("#EAID").val();
	var ClassIDVal=$("#ClassId").val();
	var parseAnsData={action:"updateAnswer",EAID:EAIDVal,CLASSID:ClassIDVal,SID:sidVal,ANSWER:AnsVal,QID:QueidVal,SN:SNVal};
	//alert(AnsVal+","+sidVal+","+QueidVal+","+SNVal+","+SNVal+"==>"+EAIDVal); //${pageContext.request.contextPath}
	$.ajax({
		url:'${pageContext.request.contextPath}/Exam',
		type:'POST',
			data:parseAnsData,
   		success: function (Result) {
	   	console.log("Answer Updated Successfully.."+Result+"Ques ID:-"+QueidVal);
     		
	    	 		document.getElementById("alert").innerHTML="Question No. "+ QueidVal +" Answer Saved.";  
	          
       	},
   		error: function (Resl) {  
   			 document.getElementById("alert").innerHTML="Question No. "+ QueidVal +" Answer Not Saved Saved. Check Network and Restart Exam";  
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
var minutes = 320;
var seconds = 0;
if (minutes > 59) {
	Hours = Math.floor(minutes / 60);
	minutes = minutes % 60;
}
seconds = 0;
var timer_div= document.getElementById("timer_div");
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
	        document.getElementById("Submit").click();
			console.log("Time Is Over Auto Submited..");
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
		 timer_div.innerHTML = Hours + "H : " + minutes	+ "M : " + seconds + "S ";
		 applyCSS(timer_div);
	} else {
		timer_div.innerHTML = minutes + "M : "	+ seconds + "S ";
		applyCSS(timer_div);
	}
}, 1000);


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



//Prevent back btn...
	function preventBack() {
	window.history.forward();
}
setTimeout("preventBack()", 0);
window.onunload = function() {
	null
};


</script>
</body>
 </html>
 
 
 
 
 
 
 
 
 

