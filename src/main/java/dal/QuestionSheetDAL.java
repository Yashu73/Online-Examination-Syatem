package dal;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import custome.Global;
import modal.AddQuestion;

public class QuestionSheetDAL {

	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;

	public String insertQues(AddQuestion que) {
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.append(
					"insert into questionpaper( QID,eid,QUESTION ,A ,B ,C ,D ,ANS ,QTYPE ,SUBID ,CLASSID ,TID ,STATUS ,SETID ,QSN, STDID,Marks)");
			sb.append("values((select nvl(max(qid),0)+1 from questionpaper),0,'" + que.getQUESTION() + "','"
					+ que.getA() + "' , '" + que.getB() + "' ,");
			sb.append("'" + que.getC() + "' ,'" + que.getD() + "' , '" + que.getANS() + "' ,'" + que.getQTYPE() + "', "
					+ que.getSUBID() + " , " + que.getCLASSID() + ",");
			sb.append("" + que.getTID() + " , '" + que.getSTATUS() + "' , " + que.getSETID()
					+ " , (select nvl(max(qsn),0)+1 from questionpaper where setid=" + que.getSETID() + "), "
					+ que.getSTDID() + ", "+que.getMarks()+")");
			
			System.out.print("    ");
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

	public String update(AddQuestion que, int Qid) {
		try {
			sb.delete(0, sb.length());
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.delete(0, sb.length());
			sb.append("update questionpaper set QUESTION ='" + que.getQUESTION() +"',eid= 0 ,A ='" + que.getA() + "' ,B= '"
					+ que.getB() + "' ,C ='" + que.getC() + "' ,D='" + que.getD() + "',ANS= '" + que.getANS()
					+ "' ,QTYPE ='" + que.getQTYPE() + "',SUBID= '" + que.getSUBID() + "',CLASSID ='" + que.getCLASSID()
					+ "',TID ='" + que.getTID() + "' ,STATUS ='" + que.getSTATUS() + "',SETID ='" + que.getSETID()
					+ "', STDID= '" + que.getSTDID() + "' , Marks= "+que.getMarks()+"");
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

	public String delete(int Qid) {
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.delete(0, sb.length());
			sb.append(" delete from questionpaper where Qid="+Qid+" ");
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

	public ArrayList<AddQuestion> getQuestions(int subid, int setid) {
		ArrayList<AddQuestion> quelst = new ArrayList<AddQuestion>();
		try {

			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.delete(0, sb.length());
			sb.append("select * from Questionpaper where setid =setid and subid=subid");

			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				AddQuestion que = new AddQuestion();
				que.setEID(rs.getString("EID"));
				que.setQUESTION(rs.getString("QUESTION"));
				que.setQid(rs.getString("Qid"));
				que.setA(rs.getString("A"));
				que.setB(rs.getString("B"));
				que.setC(rs.getString("C"));
				que.setANS(rs.getString("ANS"));
				que.setSUBID(rs.getString("SUBID"));
				que.setSETID(rs.getString("SETID"));
				que.setQSN(rs.getString("QSN"));
				que.setMarks(rs.getString("Marks"));
				quelst.add(que);

			}

			conn.close();
			System.out.print("question DAL Inserted");
			return quelst;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return quelst;
		}
	}

// insert

// Update
// Select

	public ArrayList<AddQuestion> getQuesByclssid(int subid, int setid, int classid) {
		ArrayList<AddQuestion> quelst = new ArrayList<AddQuestion>();
		try {
			conn = gb.createConnection();
			Statement stm = conn.createStatement();
			sb.delete(0, sb.length());
			sb.append("select * from Questionpaper where setid=" + setid + " and subid=" + subid + " and CLASSID="	+ classid + "");

			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				AddQuestion que = new AddQuestion();
				que.setEID(rs.getString("EID"));
				que.setQUESTION(rs.getString("QUESTION"));
				que.setQid(rs.getString("Qid"));
				que.setQueid(rs.getString("Qid"));
				que.setA(rs.getString("A"));
				que.setOpA(rs.getString("A"));
				System.out.print("option a"+rs.getString("A"));
				que.setB(rs.getString("B"));
				que.setOpB(rs.getString("B"));
				que.setC(rs.getString("C"));
				que.setOpC(rs.getString("C"));
				que.setD(rs.getString("D"));
				que.setOpD(rs.getString("D"));
				que.setANS(rs.getString("ANS"));
				que.setSUBID(rs.getString("SUBID"));
				que.setSETID(rs.getString("SETID"));
				que.setQSN(rs.getString("QSN"));
				que.setMarks(rs.getString("Marks"));
				
				quelst.add(que);

			}
			conn.close();
			
			return quelst;
		} catch (SQLException e) {
			System.out.print(e);
			System.out.print("question DAL Inserted" + sb);
			e.printStackTrace();
			return quelst;
		}
	}
}
