package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import custome.Global;
import modal.ESetModal;
import modal.SubjectModal;

public class SubjectDal {

	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;
	
public ArrayList<SubjectModal> SubGetByClassid(int classid) {
	
	ArrayList<SubjectModal> esetdatalst=new ArrayList<SubjectModal>();
	
	try {
		sb.delete(0, sb.length());
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select * from Subject_mst where classid="+classid+"");
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			SubjectModal esetdata=new SubjectModal();
			esetdata.setSUBID(rs.getInt("subid"));
			esetdata.setDESCRIPTION(rs.getString("DESCRIPTION"));
			esetdata.setSUBNAME(rs.getString("subname"));
			esetdata.setCLASSID(rs.getInt("classid"));
			esetdata.setSTATUS(rs.getString("STATUS"));
			esetdatalst.add(esetdata);
			
		}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return esetdatalst;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return esetdatalst;
}
}



public SubjectModal SubGetBySubid(int subid) {
	SubjectModal esetdata=new SubjectModal();
	try {
		sb.delete(0, sb.length());
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select * from Subject_mst where classid="+subid+"");
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			esetdata.setSUBID(rs.getInt("subid"));
			esetdata.setDESCRIPTION(rs.getString("DESCRIPTION"));
			esetdata.setSUBNAME(rs.getString("subname"));
			esetdata.setCLASSID(rs.getInt("classid"));
			esetdata.setSTATUS(rs.getString("STATUS"));
		}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return esetdata;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return esetdata;
}
}




}