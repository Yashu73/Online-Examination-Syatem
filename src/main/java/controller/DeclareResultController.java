package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custome.Global;



/**
 * Servlet implementation class DeclareResultController
 */
@WebServlet("/DeclareResult")
public class DeclareResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Global gb = new Global();
	StringBuilder sb = new StringBuilder();
	Connection conn = null;
	ResultSet rs=null;
       
    
    public DeclareResultController() { 
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String actn=request.getParameter("action");
		 if(actn.equalsIgnoreCase("DeclareResult"))
		 {
		 System.out.print("Result Declared Process Begine......");
		 String classid=request.getParameter("CLASSID");
		 String Subid=request.getParameter("SUBID");
		 String Eduyear=request.getParameter("EDUYEAR");
		 DeclareResult(Integer.valueOf(classid), Integer.valueOf(Subid),Eduyear);
		 System.out.print("Result Declared Process Completed.");
		 }		 
	}



/////////////////Q1
public String DeclareResult(int Classid,int Subid,String Eduyear ) {
	try {
		sb.delete(0, sb.length());
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append(" SELECT nvl(SUM(MARKS),0) OPNMARKS,CLASSID,SID,EAID,Subid "
				+ "FROM STUDENTQUEANSWER"
				+ " WHERE eaid IN(SELECT  EAID FROM STUDATNDEXAM_SET  "
				+ "WHERE ISSUBMTED='Y' AND CLASSID="+Classid+" AND SUBID="+Subid+") AND ANS=CURANS GROUP BY SID, SUBID, EAID,CLASSID"
				+ " ");  	 			
		System.out.print("Result Declareing Started..    "+sb);
		ResultSet rs= stm.executeQuery(sb.toString());
		while(rs.next()) {
			UpdateMarks(rs.getString("OPNMARKS") , "Y", rs.getInt("CLASSID") ,rs.getInt("Subid"), rs.getInt("SId"),rs.getInt("EAID"));
		}			
		conn.close();
		System.out.print("Result Declared Successfully.");
		return "success";
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("Error in Declaration " + sb);
		e.printStackTrace();
		return "error";
	}
}
  
//////////////////Q2

public String UpdateMarks( String OPTNMARKS, String ISRSLTDCLRD, int classid,int Subid, int Sid,int EAID) {                                                                                                                                                                                      
	try {
		sb.delete(0, sb.length());
		conn = gb.createConnection();
		Statement stm = conn.createStatement();
		sb.append(" UPDATE STUDATNDEXAM_SET SET OPTNMARKS="+OPTNMARKS+",  ISRSLTDCLRD='Y' WHERE CLASSID="+classid+" AND SUBID="+Subid+" AND SID="+Sid+" AND EAID="+EAID+""+ " ");                
	 			
		System.out.print("Question Set updated   "+sb );
		stm.executeUpdate(sb.toString());
		conn.close();
		System.out.print("Result Declared Successfully.");
		return "success";
	} catch (SQLException e) {
		System.out.print(e);
		System.out.print("Error in Declaration " + sb);
		e.printStackTrace();
		return "error";
	}
}

}
