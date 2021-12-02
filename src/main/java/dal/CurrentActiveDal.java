package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import custome.Global;
import modal.CurrentActiveModal;
import modal.ESetModal;

public class CurrentActiveDal {
	
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;

public  CurrentActiveModal CAGetBytId(int Eid) {
	sb.delete(0, sb.length());
	CurrentActiveModal CA=new CurrentActiveModal();
	 	try {
	 		
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select * from exam_set where eid="+Eid+"");
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			
			CA.setETITLE(rs.getString("ETITLE"));
			CA.setDESCRIPTION(rs.getString("DESCRIPTION"));
			CA.setDURATION(rs.getInt("DURATION"));
			CA.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
			CA.setSDET(rs.getString("SDET"));
	        CA.setSTATUS(rs.getString("STATUS"));
			CA.setTID(rs.getInt("TID"));
			CA.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
			CA.setTOTLEQ(rs.getInt("TOTLEQ"));
		    CA.setEID(rs.getInt("EID"));
		    CA.setSUBID(rs.getInt("SUBID"));
		    
		}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return CA;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return CA;
	}
}


public ArrayList<CurrentActiveModal> CAGetall() {
	sb.delete(0, sb.length());
	ArrayList<CurrentActiveModal> active=new ArrayList<CurrentActiveModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select * from exam_set");
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			CurrentActiveModal CA=new CurrentActiveModal();
			CA.setETITLE(rs.getString("ETITLE"));
			CA.setDESCRIPTION(rs.getString("DESCRIPTION"));
			CA.setDURATION(rs.getInt("DURATION"));
			CA.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
			CA.setSDET(rs.getString("SDET"));
			CA.setSTATUS(rs.getString("STATUS"));
			CA.setTID(rs.getInt("TID"));
			CA.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
			CA.setTOTLEQ(rs.getInt("TOTLEQ"));
			CA.setEID(rs.getInt("EID"));
		    active.add(CA);
		
		}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return active;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return active;
	}
}




public ArrayList<CurrentActiveModal> CAGetallBycId(int classid) {
	sb.delete(0, sb.length());
	ArrayList<CurrentActiveModal> active=new ArrayList<CurrentActiveModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select * from exam_set where ISALLOWSTUD='Y' and CLASSID="+classid+" and ");
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{
			CurrentActiveModal CA=new CurrentActiveModal();
			CA.setETITLE(rs.getString("ETITLE"));
			CA.setDESCRIPTION(rs.getString("DESCRIPTION"));
			CA.setDURATION(rs.getInt("DURATION"));
			CA.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
			CA.setSDET(rs.getString("SDET"));
			CA.setSTATUS(rs.getString("STATUS"));
			CA.setTID(rs.getInt("TID"));
			CA.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
			CA.setTOTLEQ(rs.getInt("TOTLEQ"));
			CA.setEID(rs.getInt("EID"));
		    active.add(CA);
		
		}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return active;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return active;
	}
}



public ArrayList<CurrentActiveModal> CAGetallByClassId(int classid) {
	sb.delete(0, sb.length());
	ArrayList<CurrentActiveModal> active=new ArrayList<CurrentActiveModal>();
	try {
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append("select es.*,sbj.SUBNAME from exam_set es, SUBJECT_MST sbj where sbj.SUBID=es.SUBID and ISALLOWSTUD='Y' and es.CLASSID="+classid+" ");
		rs=stm.executeQuery(sb.toString());
		while(rs.next())
		{                                                  
			CurrentActiveModal CA=new CurrentActiveModal();             
			CA.setETITLE(rs.getString("ETITLE"));
			CA.setDESCRIPTION(rs.getString("DESCRIPTION"));
			CA.setDURATION(rs.getInt("DURATION"));
			CA.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
			CA.setSDET(rs.getString("SDET"));
			CA.setSTATUS(rs.getString("STATUS"));
			CA.setTID(rs.getInt("TID"));
			CA.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
			CA.setTOTLEQ(rs.getInt("TOTLEQ"));
			CA.setEID(rs.getInt("EID"));//
			CA.setSubname(rs.getString("SUBNAME"));
		    active.add(CA);
		}
		System.out.print("question DAL called");
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("question DAL Inserted");
		return active;
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("question DAL Inserted" + sb);
		e.printStackTrace();
		return active;
	}
}
}
