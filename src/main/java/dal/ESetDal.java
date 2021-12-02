package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import custome.Global;
import modal.AddQuestion;
import modal.ESetModal;

//checked="${eset.EID}<%= ="A"?"checked":"" %> >

public class ESetDal {
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;
	//eid already exist or not??
	
	public Boolean iseidexist(int eid) {
		System.out.print("Id existing cheking");

sb.delete(0, sb.length());
		Boolean retval=false;
		try {
			
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select eid from exam_set where eid="+eid+" ");
			rs=stm.executeQuery(sb.toString());
			System.out.println("---------------Found Records-------------------------"+eid);
			while(rs.next())
			{
				retval=true;	
				System.out.println("---------------Found Records-------------------------");
			}


			conn.close();
			System.out.print("eid cheing successfuly");
			return retval;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("Id exiting checking error");
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
	
	
	//Get eid
	
	public int GetEId() {
		sb.delete(0, sb.length());
		ESetModal esetdata=new ESetModal();
		int eid=0;
		try {
			
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select nvl(max(eid),0)+1 id from exam_set");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				eid=(rs.getInt("id "));								
			}
			System.out.print("question DAL called");
			conn.close();
			System.out.print("question DAL Inserted");
			return eid;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return eid;
		}
	}
	
	
	//Insert
	
	public String insertEset(ESetModal set) {
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("insert into exam_set(id,EID, ETITLE ,DESCRIPTION ,TID ,DURATION ,TOTLEQ ,TOTLEMARKS ,SDET ,STATUS ,ISALLOWSTUD ,SUBID,CLASSID)");
			sb.append("values((select nvl(max(id),0)+1 from exam_set),"+set.getEID()+",'"+set.getETITLE()+"','"+set.getDESCRIPTION()+"',");
			sb.append(" "+set.getTID()+","+set.getDURATION()+","+set.getTOTLEQ()+","+set.getTOTLEMARKS()+","+set.getSDET()+", ");
			sb.append(" '"+set.getSTATUS()+"','"+set.getISALLOWSTUD()+"',"+set.getSubid()+" ,"+set.getClassID()+") ");

			System.out.print("SET INSERT "+sb);
			stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("question DAL Inserted");
			return "success";
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return "error";
		}
	}
	
	//Update
	public String UpdateEset(ESetModal set) {
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("Update exam_set set ETITLE ='"+set.getETITLE()+"',DESCRIPTION='"+set.getDESCRIPTION()+"' ,TID="+set.getTID()+" ");
			sb.append(",DuRATION= "+set.getDURATION()+",TOTLEQ ="+set.getTOTLEQ()+",TOTLEMARKS="+set.getTOTLEMARKS()+"");
			sb.append(",SDET="+set.getSDET()+" ,STATUS='"+set.getSTATUS()+"' ,ISALLOWSTUD='"+set.getISALLOWSTUD()+"', classid="+set.getClassID()+" ,Subid="+set.getSubid()+" where eid="+set.getEID()+"");
		 
			
			System.out.print("Question Set updated");
			stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("Question Set Updated Successfully.");
			return "success";
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return "error";
		}
	}
	//getByid
	public ESetModal EsetGetById(int eid) {
		ESetModal esetdata=new ESetModal();
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select es.*,sbj.SUBNAME from exam_set es, SUBJECT_MST sbj where sbj.SUBID=es.SUBID and eid="+eid+"");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				esetdata.setETITLE(rs.getString("ETITLE"));
				esetdata.setDESCRIPTION(rs.getString("DESCRIPTION"));
				esetdata.setDURATION(rs.getInt("DURATION"));
				esetdata.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
				esetdata.setSDET(rs.getString("SDET"));
				esetdata.setSTATUS(rs.getString("STATUS"));
				esetdata.setTID(rs.getInt("TID"));
				esetdata.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
				esetdata.setTOTLEQ(rs.getInt("TOTLEQ"));
				esetdata.setEID(rs.getInt("EID"));
				esetdata.setSubid(rs.getInt("Subid"));
				esetdata.setSUBNAME(rs.getString("SUBNAME"));
			}
			System.out.print("Get Exam Set Details");
			stm.executeUpdate(sb.toString());
			conn.close();
			
			return esetdata;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("Erro int Getting Exm set Details" + sb);
			e.printStackTrace();
			return esetdata;
		}
	}
	
	//get all sets by tid
	public ArrayList<ESetModal> EsetGetBytId(int tid) {
		sb.delete(0, sb.length());
		ArrayList<ESetModal> esetdatas=new ArrayList<ESetModal>();
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select * from exam_set where eid="+tid+"");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				ESetModal esetdata=new ESetModal();
				esetdata.setETITLE(rs.getString("ETITLE"));
				esetdata.setDESCRIPTION(rs.getString("DESCRIPTION"));
				esetdata.setDURATION(rs.getInt("DURATION"));
				esetdata.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
				esetdata.setSDET(rs.getString("SDET"));
				esetdata.setSTATUS(rs.getString("STATUS"));
				esetdata.setTID(rs.getInt("TID"));
				esetdata.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
				esetdata.setTOTLEQ(rs.getInt("TOTLEQ "));
				esetdata.setEID(rs.getInt("EID"));
				esetdata.setSubid(rs.getInt("Subid"));
				esetdatas.add(esetdata);
			
			}
			System.out.print("question DAL called");
			stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("question DAL Inserted");
			return esetdatas;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return esetdatas;
		}
	}
	
	
	public ArrayList<ESetModal> EsetGetall() {
		sb.delete(0, sb.length());
		ArrayList<ESetModal> esetdatas=new ArrayList<ESetModal>();
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("select * from exam_set");
			rs=stm.executeQuery(sb.toString());
			while(rs.next())
			{
				ESetModal esetdata=new ESetModal();
				esetdata.setETITLE(rs.getString("ETITLE"));
				esetdata.setDESCRIPTION(rs.getString("DESCRIPTION"));
				esetdata.setDURATION(rs.getInt("DURATION"));
				esetdata.setISALLOWSTUD(rs.getString("ISALLOWSTUD"));
				esetdata.setSDET(rs.getString("SDET"));
				esetdata.setSTATUS(rs.getString("STATUS"));
				esetdata.setTID(rs.getInt("TID"));
				esetdata.setTOTLEMARKS(rs.getInt("TOTLEMARKS"));
				esetdata.setTOTLEQ(rs.getInt("TOTLEQ"));
				esetdata.setEID(rs.getInt("EID"));
				esetdata.setSubid(rs.getInt("Subid"));
				esetdatas.add(esetdata);
			
			}
			System.out.print("question DAL called");
			stm.executeUpdate(sb.toString());
			conn.close();
			System.out.print("question DAL Inserted");
			return esetdatas;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return esetdatas;
		}
	}
	
	//delete 
	public String DelEset(int eid) {
		sb.delete(0, sb.length());
		try
		{
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append("delete from  exam_set where eid="+eid+"");
			stm.executeUpdate(sb.toString());
			conn.close();
			
			return "success";
			
		} catch  (SQLException e){
			return "error";
			
		
		 
	}
}
	
	
	
	//Update Set as per Question bank
	
	public void getCountAndSumMrksBySetID(int setid, int Classid, int SUBID) {
		Global gb1 = new Global();
		StringBuilder sb = new StringBuilder();
		Connection conn1 = null;

		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.delete(0, sb.length());
			sb.append("select sum(MARKS) TMarks, count(tid) QUECount,setid  from Questionpaper where setid=" + setid + "  group by setid ");
			String EID="";
			String QUECount="00";
			String TMarks="";
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				EID=(rs.getString("setid"));
				QUECount=(rs.getString("QUECount"));	 
				TMarks=(rs.getString("TMarks"));
		}
			System.out.print(" Updating..  "+EID+"  , "+QUECount+" , "+SUBID+" ,  "+Classid+" , "+TMarks);
			
			sb.delete(0, sb.length());
			sb.append("Update exam_set set ");
			sb.append(" TOTLEQ ="+QUECount+",TOTLEMARKS="+TMarks+"");
			sb.append(", classid="+Classid+" ,Subid="+SUBID+" where eid="+setid+" ");
		 	
			//conn = gb1.createConnection();
			//Statement stm1 = conn.createStatement();
 			 stm.executeUpdate(sb.toString());
			 System.out.print(sb);
			 System.out.print("New..... Updated the on question from exam Set");
			conn.close();
			}
		catch (SQLException e) 
		{
			System.out.print(e);
			System.out.print("Exam Set Update Erro   " + sb);
			e.printStackTrace();
		}
	}
	
	
	
	
}
