package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import custome.Global;
import modal.ESetModal;
import modal.StuAtndExam;

public class StudAtndExam {

	
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;
	
	public  StuAtndExam getStudAttednExamsetByEaid(int EAID) {
		


		StuAtndExam stdudexmsetDta=new StuAtndExam();
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select * from STUDATNDEXAM_SET where eaid="+EAID+"");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				
				stdudexmsetDta.setDURATION(rs.getInt("DURATION"));
				stdudexmsetDta.setREMAINTIME(rs.getInt("REMAINTIME"));
				stdudexmsetDta.setCLASSID(rs.getInt("SDET"));
				stdudexmsetDta.setSTATUS(rs.getString("STATUS"));
				stdudexmsetDta.setEXMADATE(rs.getString("EXMADATE"));
				stdudexmsetDta.setSTARTTIME(rs.getString("STARTTIME"));
				stdudexmsetDta.setENDTIME(rs.getString("ENDTIME"));
				stdudexmsetDta.setSUBID(rs.getInt("SUBID"));
				
			}
			System.out.print("question DAL called");
			stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("question DAL Inserted");
			return stdudexmsetDta;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return stdudexmsetDta;
		}		
	}	
}
