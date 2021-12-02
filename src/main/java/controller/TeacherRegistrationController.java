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
import javax.servlet.http.HttpSession;

import custome.Global;

/**
 * Servlet implementation class TeacherRegistrationController
 */
@WebServlet("/TeacherRegistrationController")
public class TeacherRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("Servlet  Registration is called.......Sucessfully.");
		String username=request.getParameter("usrname");
		String password=request.getParameter("psw");
		String Email=request.getParameter("email");
		String Mobile=request.getParameter("mob");
		String Gender=request.getParameter("gender");
		String designation=request.getParameter("desig");
			
		
		Global gb = new Global();
		
		Connection conn = null;
		StringBuilder sb =  new StringBuilder ();
		sb.delete(0, sb.length());
		sb.append("insert into TEACHER_MST( TID,TNAME,TDESIG,TLOGINID,TPASS, TGENDER ,MOBILE , EMAIL)");
		sb.append("values (( select nvl(max(tid),0)+1 from teacher_mst),'"+username+"'  , '"+designation+"' , '"+Email+"' ,");
		sb.append(" '"+password+"' , '"+Gender+"' , '"+Mobile+"' , '"+Email+"')");
				try {
					System.out.print("bEFORE cONNECTION rEADING");
			conn=gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm= conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			request.getRequestDispatcher("Teacher/FrmTeacherLogin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(sb);
			e.printStackTrace();			
			request.getRequestDispatcher("admin/AdminDashboard.jsp").forward(request, response);
		}
		System.out.println("Control Called Successfully");

		

	}

}

