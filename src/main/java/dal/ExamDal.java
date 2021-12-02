package dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import custome.Global;
import modal.ExamModal;

public class ExamDal {
	
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs = null;
	//	Update Remaing Time
	public boolean UpdateRemainTime(int Eaid, int classid, int sid,int ReamainTime) {

		try {
			sb.delete(0,sb.length());
			boolean retval = false;
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("update STUDATNDEXAM_SET set REMAINTIME="+ReamainTime+"  where EAID=" + Eaid + " and CLASSID=" + classid + " and sid=" + sid + " ");
			int rowAffected = stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("***Remaing Time Updated successfuly*****"+sb);
			if (rowAffected > 0)
				retval = true;
			return retval;
		} catch (SQLException e) {
			System.out.print(sb);
			System.out.print("Id exiting checking error");
			e.printStackTrace();
			return false;
		}
	}
	
////Get  Remaining Time...
	public int getRemainTime(int Eaid, int classid, int sid) {

		try {
			sb.delete(0,sb.length());
			int retval = 1;
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("Select REMAINTIME from STUDATNDEXAM_SET  where EAID=" + Eaid + " and CLASSID=" + classid + " and sid=" + sid + " ");
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
					retval=(Integer.valueOf(rs.getString("REMAINTIME")));
			}			
			conn.close();
			System.out.print("Get Remainig Timing");
			return retval;
		} catch (SQLException e) {
			System.out.print(sb);
			System.out.print("Error Getting in Remainig Time");
			e.printStackTrace();
			return 0;
		}
	} 
	 
	
	//Update Answer
	public boolean UpdateAnswer(int Eaid, int classid, int sid,int Qid,int sn, String Answer) {
		try {
			boolean retval = false;
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append(" update STUDENTQUEANSWER set ANS='"+Answer+"'  where EAID=" + Eaid + " ");
			sb.append(" and CLASSID=" + classid + " and SID=" + sid + " and SN="+sn+" and EID="+Qid+" ");
			int rowAffected = stm.executeUpdate(sb.toString());
			conn.close();
		
			if (rowAffected > 0) {
				System.out.print("A*****nswer Updated Successfuly"+sb);
				retval = true;
			}
			else
				System.out.print("A*****nswer NOt not not not not Updated Successfuly  "+sb);
			
				
			return retval;
		} catch (SQLException e) {
			System.out.print("       "+sb.toString()+"      ");
			System.out.print("Error in Updating Answer");
			e.printStackTrace();
			return false;
		}
	}
	
	// Get Question. By EAID, EID,SID,CLASSID,SUBID,SN
		public ExamModal getQuesn(int EAID,int SETID,int SID,int CLASSID, int SUBID,int SN) {
		ExamModal retExm=new ExamModal();
		try {
			if(SN==0)
				SN=1;
			
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			sb.delete(0,sb.length());
			sb.append(" select s.Sid, q.QUESTION,q.a,q.b,q.c,q.d,nvl(s.ans,' ') ans,q.QID from QUESTIONPAPER q, STUDENTQUEANSWER S ");
			sb.append(" where q.QID=s.QID and q.CLASSID=s.CLASSID and q.SUBID=s.SUBID and s.eaid="+EAID+"  ");
			sb.append(" and s.sid="+SID+" and q.classid="+CLASSID+" and sn="+SN+" and setid="+ SETID+" ");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				System.out.print("Admin Data Readed.Sucessfully.");
				retExm.setSID(Integer.valueOf(rs.getString("Sid").trim()));
				retExm.setQUESTION(String.valueOf(rs.getString("QUESTION").trim()));
				retExm.setA(String.valueOf(rs.getString("A").trim()));
				retExm.setB(String.valueOf(rs.getString("B").trim()));
				retExm.setC(String.valueOf(rs.getString("C").trim()));
				retExm.setD(String.valueOf(rs.getString("D").trim()));
				retExm.setANS(String.valueOf(rs.getString("ans").trim()));	
				retExm.setQID(Integer.valueOf(rs.getString("QID").trim()));	
			}
			stm.close();
			conn.close();
			return retExm;
		} catch (SQLException e) {
 			System.out.print(sb);
			e.printStackTrace();
			return retExm;
		} 
		} 

		//Exam Submit
		
		public boolean SubmitExam(int Eaid, int classid, int sid) {
			try {
				boolean retval = false;
				conn = gb.createConnection();
				Statement stm = conn.createStatement();
				sb.delete(0,sb.length());
				sb.append(" update STUDATNDEXAM_SET set ISSUBMTED='Y',ISRSLTDCLRD='N',ENDTIME=(select to_char(sysdate,'hh:mi:ss') from dual)  where EAID=" + Eaid + " ");
				sb.append(" and CLASSID=" + classid + " and SID=" + sid + " ");
				int rowAffected = stm.executeUpdate(sb.toString());
				conn.close();
				System.out.print("Exam Submitted Successfuly"+rowAffected+ "  =="+sb);
				if (rowAffected > 0)
					retval = true;
				return retval;
			} catch (SQLException e) {
				System.out.print("       "+sb.toString()+"      ");
				System.out.print("Error in Exam submitting   "+sb);
				e.printStackTrace();
				return false;
			}
		}
		

		//Get details after submit
		
		
		public ExamModal getDetailsAfterSubmit(int EAID,int SID,int CLASSID, int SUBID,int SN) {
		ExamModal retExm=new ExamModal();
		try {
			if(SN==0)
				SN=1;			
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			sb.delete(0,sb.length());
			sb.append("  select sa.EAID,sa.EXMADATE,sa.STARTTIME,nvl(sa.ENDTIME, '00:00:00') ENDTIME,sb.subid,sb.subname,sa.classid from  STUDATNDEXAM_SET sa,subject_mst sb ");
			sb.append(" where sa.subid=sb.subid  ");
			sb.append(" and sa.sid="+SID+" and sa.EAID="+EAID+" and  sa.classid="+CLASSID+"");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				System.out.print("Exam Submited Details Readed Sucessfully.");
				retExm.setEAID(Integer.valueOf(rs.getString("EAID").trim()));
				retExm.setExamDate(String.valueOf(rs.getString("EXMADATE").trim()));
				retExm.setStartTime(String.valueOf(rs.getString("STARTTIME").trim()));
				retExm.setEndTime(String.valueOf(rs.getString("ENDTIME").trim()));
				retExm.setSUBID(Integer.valueOf(rs.getString("subid").trim()));
				retExm.setSubName(String.valueOf(rs.getString("SubName").trim())); 	
				retExm.setSub_Name(String.valueOf(rs.getString("SubName").trim()));
				retExm.setCLASSID(Integer.valueOf(rs.getString("classid").trim()));
			}
			stm.close();
			conn.close();
			return retExm;
		} catch (SQLException e) {
 			System.out.print(sb);
			e.printStackTrace();
			return retExm;
		} 
		} 

		
		
		
		
		
		
}
