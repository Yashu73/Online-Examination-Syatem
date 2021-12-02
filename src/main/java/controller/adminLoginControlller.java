package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import custome.Global;

/**
 * Servlet implementation class adminLoginControlller
 */
@WebServlet("/adminLoginControlller")
public class adminLoginControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminLoginControlller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String username = request.getParameter("usrname");
		String password = request.getParameter("psw");

		Global gb = new Global();

		Connection conn = null;
		StringBuilder sb = new StringBuilder();
		String dESING = "TR", ISRECFOUND = "NO";
		sb.delete(0, sb.length());
		sb.append("select Tid ,Tname,TDESIG FROM TEACHER_MST WHERE TLOGINID ='" + username + "' AND TPASS='" + password
				+ "'");
		try {
			System.out.print("bEFORE cONNECTION rEADING");
			conn = gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			while (rs.next()) {
				System.out.print("Admin Data Readed.Sucessfully.");
				String Tid = rs.getString("Tid");
				String Tname = rs.getString("Tname");
				dESING = rs.getString("TDESIG").toUpperCase();
				HttpSession session = request.getSession();
				session.setAttribute("TID", Tid);
				session.setAttribute("TNAME", Tname);				
				ISRECFOUND = "YES";
				
			}
			conn.close();
			stm.close();
			if (ISRECFOUND.equalsIgnoreCase("YES")) {
				if (dESING.trim().equals("IT")) {
					System.out.print("1. End line Readed.");
					response.sendRedirect("admin/AdminDashboard.jsp");
					System.out.print("End line Readed.");
				} 
				else {
					System.out.print("2. End line Readed." + request.getContextPath()+"Desc   "+dESING);

					request.getRequestDispatcher("Teacher/TeacherDashboard1.jsp")
							.forward(request, response);

				}
			} else {
				// PrintWriter out = response.getWriter();
		           // out.print("Username or Password invalid..!!");
		            request.setAttribute("invalidcr", "Username or Password invalid..!!");
		            request.getRequestDispatcher("Teacher/FrmTeacherLogin.jsp").forward(request, response);

		           // response.sendRedirect("Teacher/FrmTeacherLogin.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(sb);
			e.printStackTrace();
			System.out.print(e);
		//	request.getRequestDispatcher("admin/AdminDashboard.jsp").forward(request, response);
		}
		// System.out.println("Control Called Successfully");

	}

}
