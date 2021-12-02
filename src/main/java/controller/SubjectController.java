package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dal.SubjectDal;
import modal.SubjectModal;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String acn = request.getParameter("action");
		System.out.println("method called by ajax  " + acn);
		//List<SubjecMst> list = new ArrayList<SubjecMst>();
		
		List<SubjectModal> esetdatalst=new ArrayList<SubjectModal>();
		if (acn.equalsIgnoreCase("getSubjects")) {
			String classid = request.getParameter("classid");
			/////////// traacking
			 
			try {
				SubjectDal sdal=new SubjectDal();
				esetdatalst= sdal.SubGetByClassid(Integer.valueOf(classid));
				String json = new Gson().toJson(esetdatalst);			
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				System.out.println(json);

			} catch (Exception e) {
			}

		}
		
		
		
		
	}

}
