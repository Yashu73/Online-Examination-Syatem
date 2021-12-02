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
 * Servlet implementation class StudentLoginController
 */
@WebServlet("/StudentLoginController")
public class StudentLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.print("Servlet is called.......Sucessfully.");
		String username = request.getParameter("usrname");
		String password = request.getParameter("psw");

		Global gb = new Global();
        Boolean isrecordfound=false;
		Connection conn = null;
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append("select Sid ,Sname,STD FROM STUDENT_MST WHERE SLOGINID ='" + username + "' AND SPASS='" + password
				+ "'");
		try {
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				System.out.print("Admin Data Readed.Sucessfully.");
				String Sid = rs.getString("Sid");
				String Sname = rs.getString("Sname");
				String STD = rs.getString("STD");
				
				isrecordfound=true;
				HttpSession session = request.getSession();
				session.setAttribute("Sid", Sid);
				session.setAttribute("Sname", Sname);
				session.setAttribute("Studaclssid", STD);
				System.out.println("heloo" +Sid+"   "+Sname);
			}
			conn.close();
			stm.close();
			if(isrecordfound==true)
			{
				request.getRequestDispatcher("Students/StudentDashboard.jsp").forward(request, response);
			}
			else
			{
		        PrintWriter out = response.getWriter();
	            out.print("Username or Password invalid..!!");
	            RequestDispatcher rd = request.getRequestDispatcher("Students/FrmStudLogin.jsp");
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(sb);
			e.printStackTrace();
			request.getRequestDispatcher("Students/StudentDashboard.jsp").forward(request, response);
		} 
	} 
}

