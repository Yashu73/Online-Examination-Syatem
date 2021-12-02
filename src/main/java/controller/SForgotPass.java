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

/**
 * Servlet implementation class ChangePassController
 */
@WebServlet("/ChangePassController")
public class SForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String FrgetSid="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SForgotPass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String actin=request.getParameter("action");
	System.out.println(actin+"**");
	  HttpSession session = request.getSession();
	if(actin!="null" &&actin.equalsIgnoreCase("GetOtp")) {
	 String email=request.getParameter("usrname");
	 boolean isemailfound=false;
	 System.out.println("**--"+email+"**");
	 isemailfound=verifyEmail(email);
	 if(isemailfound) {
		 System.out.println("Email Found"+email+""+FrgetSid);
		 UpdateOTP(email,Integer.valueOf(FrgetSid),"4796");	
		 session.setAttribute("FrgetSid",FrgetSid);
		 session.setAttribute("Frgetemail",email);
		 			
			request.getRequestDispatcher("/Students/OTPVerify.jsp").forward(request, response);  
			return;
	 }	 
	 else {
		  request.setAttribute("FogetEmailAlert", "Invalid Eamil ID..!!");			
		  request.getRequestDispatcher("/Students/GetOTP.jsp").forward(request, response);  
		  return;
	 }
	}
	if(actin!="null" &&actin.equalsIgnoreCase("VerifyOTP")) {
		String otp=request.getParameter("OTP");
		String Frgetemail =String.valueOf(session.getAttribute("Frgetemail"));
		boolean otpcurr=false;
		otpcurr=verifyOTP(Frgetemail,otp);
		 if(otpcurr) {			
				request.getRequestDispatcher("/Students/ForgetPassNewSet.jsp").forward(request, response);  
				return;
		 }	 
		 else {
			  request.setAttribute("FogetEmailAlert", "Invalid OTP..!!");			
			  request.getRequestDispatcher("/Students/OTPVerify.jsp").forward(request, response);  
			  return;
		 }
	}
	//New password Submit
	if(actin!="null" &&actin.equalsIgnoreCase("NewPassSubmit")) {
		String newpass=request.getParameter("pswNew");
		String Frgetemail =String.valueOf(session.getAttribute("Frgetemail"));
		String Frgetsid =String.valueOf(session.getAttribute("FrgetSid"));
		UpdateNewPass(Frgetemail,Integer.valueOf(Frgetsid),newpass);		
		 request.getRequestDispatcher("/Students/FrmStudLogin.jsp").forward(request, response);  
		  return;
	}
	
	}
	
	//veryEamilID
	
	private boolean verifyEmail(String emailid )
	{
		Global gb = new Global();
        Boolean isrecordfound=false;
		Connection conn = null;
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(" select Sid from student_mst where EMAIL='"+emailid+"' ");
		try {
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				 FrgetSid = rs.getString("Sid");
				isrecordfound=true;
				}
			conn.close();
			stm.close();
			if(isrecordfound==true)
			{
				return isrecordfound;
			}
			else
			{
		        return isrecordfound;
            }
		} catch (SQLException e) {
			System.out.print(sb);
			e.printStackTrace();
			return false;
		}  	}
	
	
	//Verify OTP& EAMil

	
	private boolean verifyOTP(String emailid,String OTP )
	{
		Global gb = new Global();
        Boolean isrecordfound=false;
		Connection conn = null;
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(" select Sid from student_mst where EMAIL='"+emailid+"' AND  OTP='"+OTP+"'" );
		try {
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				 FrgetSid = rs.getString("Sid");
				isrecordfound=true;
				}
			conn.close();
			stm.close();
			if(isrecordfound==true)
			{
				return isrecordfound;
			}
			else
			{
		        return isrecordfound;
            }

		} catch (SQLException e) {
			System.out.print(sb);
			e.printStackTrace();
			return false;
		}  	}
	
	
	
//UpdateNew Password
	

	private boolean UpdateNewPass(String emailid,int Sid,String NewPass )
	{
		Global gb = new Global();
        Boolean isrecordfound=false;
		Connection conn = null;
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(" update student_mst set SPASS='"+NewPass+"' where SID="+Sid+" and EMAIL='"+emailid+"'");
		try {
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				 FrgetSid = rs.getString("Sid");
				isrecordfound=true;
				}
			conn.close();
			stm.close();
			if(isrecordfound==true)
			{
				return isrecordfound;
			}
			else
			{
		        return isrecordfound;
            }

		} catch (SQLException e) {
			System.out.print(sb);
			e.printStackTrace();
			return false;
		}  	}
	
	/////update OTP
	
	private boolean UpdateOTP(String emailid,int Sid,String OTP)
	{
		Global gb = new Global();
        Boolean isrecordfound=false;
		Connection conn = null;
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(" update student_mst set OTP='"+OTP+"' where SID="+Sid+" and EMAIL='"+emailid+"'");
		try {
			conn = gb.createConnection();			
			Statement stm = conn.createStatement();
			stm.executeQuery(sb.toString());
			
			conn.close();
			stm.close();
			if(isrecordfound==true)
			{
				return isrecordfound;
			}
			else
			{
		        return isrecordfound;
            }

		} catch (SQLException e) {
			System.out.print(sb);
			e.printStackTrace();
			return false;
		}  
		}	
	}
