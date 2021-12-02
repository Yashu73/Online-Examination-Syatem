package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import custome.Global;
import dal.SubjectDal;
import modal.SubjectModal;

/**
 * Servlet implementation class ExamStartController
 */
@WebServlet("/ExamStartController")
public class ExamStartController extends HttpServlet {
	Global gb=new Global();
	int classId=0,subid=0;
	int StudentId=0,SID=0;
     int setid=0,EAID=0;
     int TOTQue=1;
     boolean setadd=false,QueAddedOrNot=false;
    public ExamStartController() {
     }
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String action=request.getParameter("action");
		SubjectDal sdal=new SubjectDal();
		if(action.equalsIgnoreCase("StartExam")) {
			System.out.print("Exam Started.......");
		HttpSession sess=request.getSession();
		StudentId=Integer.valueOf(String.valueOf(sess.getAttribute("Sid")));
		SID=StudentId;
		classId=Integer.valueOf(String.valueOf(sess.getAttribute("Studaclssid")));
		subid=Integer.valueOf(String.valueOf(request.getParameter("SubID")));
		setid=Integer.valueOf(String.valueOf(sess.getAttribute("EID")));
		////Set Insert in StudSet Table
		SubjectModal esetdata=new SubjectModal();
		System.out.print("Subject Name Getting... Subject Name *******:- "+setid);
		esetdata = sdal.SubGetBySubid(subid);
		esetdata.getSUBNAME();
		String SubName=esetdata.getSUBNAME();
		sess.setAttribute("SUBNAME",SubName);
		System.out.print("Subject Name Getting... Subject Id:- "+setid+"  Subject Name:-" + SubName);
		PrintWriter out = response.getWriter();
		// Stud Answer Table all set Ques Insert...
		boolean queaddAns=false;
		if (!ChkIsStudentExmStarted(setid,classId,subid,SID )) {
		  setadd= StudAttendSetAdd();
		}
		  if(setadd)
		  {
			  EAID= GETEAID();
			  if(EAID>0) {
				  String query="select nvl(REMAINTIME,1) REMAINTIME from STUDATNDEXAM_SET where EAID="+EAID+" and CLASSID="+classId+" and SETID ="+setid+"";
				  String  TOLREMNTIME=  gb.GetSingleValue(query,"REMAINTIME");
				  if(TOLREMNTIME.equalsIgnoreCase("null"))
				  {
					  TOLREMNTIME="1";
				  }
				  sess.setAttribute("ExmEAID",EAID);
				  sess.setAttribute("SubID",subid);
				  sess.setAttribute("SN",1);
				  sess.setAttribute("TOLREMAINTIME",TOLREMNTIME);
				  if(!ChkIsStudentExmStartedQues(setid,classId,subid,SID,EAID)) {
					  queaddAns=StudAttendQuesAdd();
				  }
				  else
				  {
					  request.getRequestDispatcher("Students/Exam.jsp?action=bgn").forward(request, response);
					  return;
				  }
			  sess.setAttribute("TOLQUES",TOTQue);
			  if(!queaddAns) {
			  out.print("Some Technique Problem Contact Admin. Question Bank Not Assigned");
			  RequestDispatcher rd = request.getRequestDispatcher("Students");
			  return;
			  }
			  }		  
			  else{
				out.print("Some Technique Problem Contact Admin.");
				RequestDispatcher rd = request.getRequestDispatcher("Students");
	       }
		 }
		 else 
		 {
		 	 out.print("Some Technique Problem Contact Admin.");
			 RequestDispatcher rd = request.getRequestDispatcher("Students");
	     }
		request.getRequestDispatcher("Students/Exam.jsp").forward(request, response);
	}
}
 public boolean StudAttendSetAdd() 
 {
	 	Global gb = new Global();
		StringBuilder sb = new StringBuilder();
		Connection conn = null;
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("  INSERT INTO STUDATNDEXAM_SET(EAID,SETID, DURATION, TOTLEQ, TOTLEMARKS,EXMADATE, STATUS, CLASSID,");
			sb.append(" SUBID, StartTIME,endTIME, ISSUBMTED, REMAINTIME,SID) ");
			sb.append(" SELECT (SELECT NVL(MAX(EAID),0)+1 FROM STUDATNDEXAM_SET),EID, DURATION,TOTLEQ,TOTLEMARKS,");
			sb.append(" (SELECT TO_char(SYSDATE,'dd-mm-yyyy' ) from dual),'R',  "+classId+ ",  "+subid+ ", ");//method called by ajax  --(SELECT TO_char(SYSDATE,'dd-mm-yyyy' ) from dual)
			sb.append("(SELECT TO_CHAR(SYSDATE,'hh:mi:ss') from dual) StartTIME,'' endTIME,'P', DURATION,"+SID+" ");
			sb.append("from EXAM_SET where eid="+setid+" and classid="+classId+" ");
			System.out.print("SET INSERT "+sb);
			int affectedRow= stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("Student Exam Set Inserted Successfully"+setid);
			if(affectedRow>0)
			return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("Error in Student Exam Set Inserting.." + sb);
			e.printStackTrace();
			return false;
		}
	}
 
 public boolean StudAttendQuesAdd() 
 	{
	 	Global gb = new Global();
		StringBuilder sb = new StringBuilder();
		Connection conn = null;
		ResultSet rs=null;
		
		EAID=GETEAID();
		if(EAID==0)
		{
			return false;
		}
		String RandoNMQuelry=" rownum " ;
	      int random_int = (int)Math.floor(Math.random()*(4-1+1)+1);

		if(random_int==1)
			 RandoNMQuelry=" rownum " ;
		if(random_int==2)
			 RandoNMQuelry=" row_number() over (partition by 1 order by A)  " ;
		if(random_int==3)
			 RandoNMQuelry=" row_number() over (partition by 1 order by B)  " ;
		else 
			RandoNMQuelry=" row_number() over (partition by 1 order by QID)  " ;
				
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append(" INSERT INTO STUDENTQUEANSWER(EAID,SID,SUBID,QID,QTYPE,ANS,EID,ANSID,TID,CLASSID,SN,CURANS,MARKS)");
			sb.append(" SELECT "+EAID+  " EAID, "+SID+ " SID, "+subid+ " SUBID, QID,QTYPE,'' ANS,SETID,0 ANSID,TID,");
			sb.append("  "+classId+ " CLASSID,"+RandoNMQuelry+" SN,ans CURANS,MARKS from QUESTIONPAPER where ");
			sb.append(" setid="+setid+" and classid="+classId+" and subid="+subid+""); 
			System.out.print("SET INSERT   "+sb);
			int affectedRow= stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("Student Exam Question Added Successfully");
			if(affectedRow>0) {
				TOTQue=affectedRow;
				return true;				
			}
			else
				return false;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("Error Getting in Student Question Adding " + sb);
			e.printStackTrace();
			return false;
		}
	}

 public int GETEAID() 
 {
	 	Global gb = new Global();
		StringBuilder sb = new StringBuilder();
		Connection conn = null;
		ResultSet rs=null;
		if(SID==0 || classId==0 || subid==0 )
		{
			return 0;
		}
		
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.delete(0,sb.toString().length());
			sb.append(" select eaid from STUDATNDEXAM_SET where  ");
		 	sb.append(" classId="+classId+ " and subid="+subid+  " ");
			sb.append(" and SETID="+setid+" and sid="+SID+" "); 
			System.out.print("Get The Exam Attendet ID***  "+sb);
			rs= stm.executeQuery(sb.toString());
		while(rs.next()) {
			EAID=rs.getInt("eaid");
		}
		conn.close();
		System.out.print("EAID found "+EAID);
		return EAID;		
		}
		catch (SQLException e) {
			System.out.print(e);
			System.out.print("Error in checking the Exam attended ID  ***" + sb);
			e.printStackTrace();
			return EAID;
		}
 	}

 private boolean ChkIsStudentExmStarted(int setid,int classid, int subid , int sid )
 {
	 Global gb = new Global();
		StringBuilder sb = new StringBuilder();
		Connection conn = null;
		ResultSet rs=null;
		sb.delete(0, sb.length());
		Boolean retval=false;
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select EAID from STUDATNDEXAM_SET where  SID="+sid+" and SETID="+setid+" and subid="+subid+" ");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				retval=true;
				setadd=true;
			}
			conn.close();
			System.out.print("Exam Already Atteted Or Not Checking");
			return retval;
		} catch (SQLException e) {
			System.out.print(sb);
			System.out.print("Id exiting checking error");
			e.printStackTrace();
			return false;
		}
 }
 
 private boolean ChkIsStudentExmStartedQues(int setid,int classid, int subid , int sid,int EAID )
 {
	 Global gb = new Global();
		StringBuilder sb = new StringBuilder();
		Connection conn = null;
		ResultSet rs=null;
		sb.delete(0, sb.length());
		Boolean retval=false;
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select EAID from STUDENTQUEANSWER where  SID="+sid+" and EID="+setid+" and subid="+subid+" and EAID="+EAID+" ");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				retval=true;
				QueAddedOrNot=true;
			}
			conn.close();
			System.out.print("Exam Already Atteted Or Not Checking"+sb);
			return retval;
		} catch (SQLException e) {
			System.out.print("*******  "+sb);
			System.out.print("Id exiting checking error");
			e.printStackTrace();
			return false;
		}
 }
}
