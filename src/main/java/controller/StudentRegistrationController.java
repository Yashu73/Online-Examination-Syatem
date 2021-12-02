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

import custome.Global;

/**
 * Servlet implementation class StudentRegistrationController
 */
@WebServlet("/StudentRegistrationController")
public class StudentRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationController() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet  Registration is called.......Sucessfully.");
		
		String username=request.getParameter("usrname");
		String password=request.getParameter("psw");
		String Email=request.getParameter("email");
		String Mob=request.getParameter("mob");
		String Gender=request.getParameter("gender");
		//String Class=request.getParameter("class");
		String std=request.getParameter("class");
		
		

		Global gb = new Global();
		
		Connection conn = null;
		StringBuilder sb =  new StringBuilder ();
		sb.delete(0, sb.length());
		sb.append("insert into STUDENT_MST( SID,SNAME,SLOGINID,SPASS, SGENDER ,Mob , EMAIL,std)");
		sb.append("values (( select nvl(max(sid),0)+1 from student_mst),'"+username+"'  , '"+Email+"' , '"+password+"' ,");
		sb.append(" '"+Gender+"' , '"+Mob+"' , '"+Email+"' , '"+std+"')");
				try {
					System.out.print("bEFORE cONNECTION rEADING");
			conn=gb.createConnection();
			System.out.print("cONNECTION rEADED.Sucessfully.");
			Statement stm= conn.createStatement();
			ResultSet rs = stm.executeQuery(sb.toString());
			request.getRequestDispatcher("Students/FrmStudLogin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(sb);
			e.printStackTrace();			
			//request.getRequestDispatcher("admin/AdminDashboard.jsp").forward(request, response);
			PrintWriter out = response.getWriter();
			out.print("e");

            RequestDispatcher rd = request.getRequestDispatcher("index.html");

			
		}
		System.out.println("Control Called Successfully");

		

		
	}

}
