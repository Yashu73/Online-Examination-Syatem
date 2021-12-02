package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import custome.Global;
import modal.ESetModal;
import modal.StudentModal;

public class StudentDal {
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;
		
	public StudentModal getByStudid(int Sid) {
		StudentModal SM=new StudentModal();
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select * from STUDENT_MST where SID="+Sid+"");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				SM.setSID(rs.getInt("SID"));
				SM.setSNAME(rs.getString("SNAME"));
				SM.setSLOGINID(rs.getString("SLOGINID"));
				SM.setSTD(rs.getString("STD"));
				SM.setMOB(rs.getString("MOB"));
				SM.setEMAIL(rs.getString("EMAIL"));
			}
			System.out.print(" Get Studets Details ");
			stm.executeUpdate(sb.toString());
			conn.close();
			return SM;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print (" Error in Get Studet Detils  " + sb);
			e.printStackTrace();
			return SM;
		}
		
		}

}
