package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import custome.Global;
import modal.ESetModal;
import modal.ReportSetModal;


public class ReportSetDal {
	
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;

////SubjectWise Report1
public ArrayList<ReportSetModal> getReportSetSubjectwise (int classid,int Subid,String Eduyear,String FromDate,String ToDate){
	sb.delete(0, sb.length());
	ArrayList<ReportSetModal> report1=new ArrayList<ReportSetModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append(" select rownum sn, EXM.EAID, EXM.SID,STUD.SNAME,nvl(EXM.OPTNMARKS,0) OPTNMARKS,EXM.SUBID,SUB.SUBNAME,EXM.TOTLEMARKS,Setid, "
				+ "(case when  ISSUBMTED='N' then 'Not Submited' when ISSUBMTED='Y' then 'Submmited' when ISSUBMTED='P' then 'Pending' end)"
				+ " sbmtStatus,ISSUBMTED FROM STUDATNDEXAM_SET EXM,STUDENT_MST STUD,SUBJECT_MST SUB"
				+ " WHERE STUD.SID=EXM.SID AND SUB.SUBID=EXM.SUBID AND EXM.CLASSID="+classid+" AND EXM.SUBID="+Subid+" order by exm.eaid");
		
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			ReportSetModal rptdata=new ReportSetModal();
			rptdata.setSN(rs.getInt("SN"));
			rptdata.setEAID(rs.getString("EAID"));
			rptdata.setSID(rs.getString("SID"));
			rptdata.setSNAME(rs.getString("SNAME"));
			rptdata.setSUBID(rs.getInt("SUBID"));
			rptdata.setOPTNMARKS(rs.getString("OPTNMARKS"));
			rptdata.setSbmtStatus(rs.getString("sbmtStatus"));
			rptdata.setSubjectsnm(rs.getString("SUBNAME"));
			rptdata.setTotaltarks(rs.getString("TOTLEMARKS"));
			rptdata.setSetid(rs.getInt("Setid"));
			
			report1.add(rptdata);
		}
		System.out.print("----------------Get Subject wise reports details- ---------------");
		stm.executeUpdate(sb.toString());
		conn.close();
		return report1;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("----->> Error in subject wise report..---->" + sb);
		e.printStackTrace();
		return report1;
	}
}

////Classwise totalSubject exam attended Report2
public ArrayList<ReportSetModal> getReportClasswise( int classid,int subid,String eduyear){
	sb.delete(0, sb.length());
	ArrayList<ReportSetModal> report1=new ArrayList<ReportSetModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select row_number() over (partition by exm.sid order by 1)  SN,count (EXM.Sid) cnt, EXM.SID,STUD.SNAME,sum(EXM.OPTNMARKS) OPTNMARKS,SUM(TOTLEMARKS) TOTLEMARKS"
				+ " FROM STUDATNDEXAM_SET EXM,STUDENT_MST STUD"
				+ " WHERE STUD.SID=EXM.SID AND  EXM.CLASSID="+classid+" AND EXM.SUBID="+subid+"  GROUP BY EXM.SID,SNAME");
		
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			ReportSetModal rptdata=new ReportSetModal();
			rptdata.setSN(rs.getInt("SN"));
			rptdata.setSID(rs.getString("SID"));
			rptdata.setSNAME(rs.getString("SNAME"));
			rptdata.setCount(rs.getInt("cnt"));
			rptdata.setOPTNMARKS(rs.getString("OPTNMARKS"));
			rptdata.setTotaltarks(rs.getString("TOTLEMARKS"));
			
			
			report1.add(rptdata);
		
		}
		System.out.print("Classwise   Report");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return report1;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return report1;
	}
}

////NON DECLARED STUDENT RESULT SUBJECT AND CLASS WISE
public ArrayList<ReportSetModal> getReportNonDeclared (int  classid, int subid, String EduYear){
	sb.delete(0, sb.length());
	ArrayList<ReportSetModal> report1=new ArrayList<ReportSetModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append(" select row_number() over (partition by 1 order by 1)  SN, EXM.Setid, EXM.EAID, EXM.SID,STUD.SNAME,EXM.OPTNMARKS,EXM.SUBID,SUB.SUBNAME,sub.Classid"
				+ " FROM STUDATNDEXAM_SET EXM,STUDENT_MST STUD,SUBJECT_MST SUB"
				+ " WHERE STUD.SID=EXM.SID AND SUB.SUBID=EXM.SUBID AND  NVL(ISRSLTDCLRD,'N')='N' and EXM.CLASSID=sub.classid AND EXM.SUBID=sub.Subid");
		
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			ReportSetModal rptdata=new ReportSetModal();
			rptdata.setEAID(rs.getString("EAID"));
			rptdata.setSetid(rs.getInt("Setid"));
			rptdata.setSN(rs.getInt("SN"));
			rptdata.setSID(rs.getString("SID"));
			rptdata.setSNAME(rs.getString("SNAME"));
			rptdata.setSUBID(rs.getInt("SUBID"));
			rptdata.setOPTNMARKS(rs.getString("OPTNMARKS"));
			rptdata.setSubname(rs.getString("Subname"));		
					report1.add(rptdata);
			}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("non Declared Result report");
		return report1;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("Error getting in non declared result." + sb);
		e.printStackTrace();
		return report1;
	}
}

//// STUDETN ATTENTED EXAMINATION REPORT 
public ArrayList<ReportSetModal> getReportAttended(int classid,String Subname){
	sb.delete(0, sb.length());
	ArrayList<ReportSetModal> report1=new ArrayList<ReportSetModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append(" select row_number() over (partition by exm.sid order by 1)  SN,  EXM.EAID,EXM.SETID, EXM.SID,STUD.SNAME,EXM.OPTNMARKS,EXM.SUBID,SUB.SUBNAME,(case when  ISRSLTDCLRD='N' then 'Not Declared' when  ISRSLTDCLRD='Y' then 'result declared' end)  resultstus, "
				+ " (case when ISSUBMTED='N' then 'Not Submitted' when ISSUBMTED='Y' then 'Submitted' else 'Pending' end) ISSUBMTED  FROM STUDATNDEXAM_SET EXM,STUDENT_MST STUD,SUBJECT_MST SUB "
				+ "WHERE STUD.SID=EXM.SID AND SUB.SUBID=EXM.SUBID AND EXM.CLASSID="+classid+" ");// AND Eduyear='2020-2021'
		
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			ReportSetModal rptdata=new ReportSetModal();
			rptdata.setSN(rs.getInt("SN"));
			rptdata.setEAID(rs.getString("EAID"));
			rptdata.setSID(rs.getString("SID"));
			rptdata.setSNAME(rs.getString("SNAME"));
			rptdata.setSUBID(rs.getInt("SUBID"));
			rptdata.setOPTNMARKS(rs.getString("OPTNMARKS"));
			rptdata.setSetid(rs.getInt("Setid"));
			rptdata.setSubjectsnm(rs.getString("Subname"));//resultstus
			rptdata.setSubname(rs.getString("resultstus"));//
			report1.add(rptdata);
		
		}
		System.out.print("Select Attented Studetn list");
		stm.executeUpdate(sb.toString());
		conn.close();
		
		return report1;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("Error getting in attend student list  " + sb);
		e.printStackTrace();
		return report1;
	}
}
///StudReport
public ArrayList<ReportSetModal> getReportStudReport(int Sid,int Classid){
	
	ArrayList<ReportSetModal> report1=new ArrayList<ReportSetModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.delete(0, sb.length());
		sb.append(" select row_number() over (partition by sat.sid order by 1)  SN,sat.SETID,sat.EAID,sat.TOTLEQ,TOTLEMARKS,to_char(sat.EXMADATE,'dd/mm/yyyy') EXMADATE,sat.STARTTIME, sat.OPTNMARKS, sb.subname from STUDATNDEXAM_SET sat,subject_mst sb where sat.subid=sb.subid  and sat.ISRSLTDCLRD='Y'  "
				+ " and sat.sid="+Sid+" and sat.classid="+Classid+" order by EXMADATE desc   ");// AND Eduyear='2020-2021'
		
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			ReportSetModal rptdata=new ReportSetModal();
			rptdata.setSN(rs.getInt("SN"));
			rptdata.setEAID(rs.getString("EAID"));
			rptdata.setTOTLEQ(rs.getString("TOTLEQ"));
			rptdata.setTotaltarks(rs.getString("TOTLEMARKS"));
			rptdata.setEXMADATE(rs.getString("EXMADATE"));
			rptdata.setOPTNMARKS(rs.getString("OPTNMARKS"));
			rptdata.setSetid(rs.getInt("SETID"));
			rptdata.setSubjectsnm(rs.getString("subname"));//resultstus
			rptdata.setSubname(rs.getString("subname"));//
			report1.add(rptdata);
		
		}
		System.out.print("Select Attented Studetn list");
		stm.executeUpdate(sb.toString());
		conn.close();
		
		return report1;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("Error getting in attend student list" + sb);
		e.printStackTrace();
		return report1;
	}
}









}



