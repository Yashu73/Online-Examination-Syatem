package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.CurrentActiveDal;
import dal.ESetDal;
import dal.StudentDal;
import modal.CurrentActiveModal;
import modal.ESetModal;
import modal.StudentModal;

/**
 * Servlet implementation class ActiveExam
 */
@WebServlet("/ActiveExam")
public class CurrentActiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentActiveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println(request.getParameter("action"));
		String acn = request.getParameter("action");
		CurrentActiveDal esdal=new CurrentActiveDal();
		if(acn.equalsIgnoreCase("view")) {
			HttpSession ssion=request.getSession();
	   //ArrayList<CurrentActiveModal> active=new ArrayList<CurrentActiveModal>();
		//active=esdal.CAGetall();
			
			String clasid=(String) ssion.getAttribute("Studaclssid");
			int classid=Integer.valueOf(clasid);
		    ArrayList<CurrentActiveModal> active=new ArrayList<CurrentActiveModal>();
			active=esdal.CAGetallByClassId(classid);

			
			
		request.setAttribute("currentactivelst", active);
		request.getRequestDispatcher("/Students/CurrentActive.jsp").forward(request, response);
		}

		if(acn.equalsIgnoreCase("select")) {
		int eid=Integer.valueOf( request.getParameter("eid"));
			HttpSession session = request.getSession();
			session.setAttribute("EID",eid);
			HttpSession sesn = request.getSession();
			String SidStr =(String) (sesn.getAttribute("Sid")); 
		    CurrentActiveModal active=new CurrentActiveModal();
			active=esdal.CAGetBytId(eid);
			request.setAttribute("activeSelectedExSet", active);
			
			ESetDal stDal=new ESetDal();
			ESetModal esetdtls=new ESetModal();
					
			esetdtls=stDal.EsetGetById(eid);
			request.setAttribute("selectedExamSetDet", esetdtls);
			
			StudentModal SM = new StudentModal();
			StudentDal SD = new StudentDal();
		    SM=SD.getByStudid(Integer.valueOf(SidStr));
		    request.setAttribute("StudentDetails", SM);
		    
			request.getRequestDispatcher("/Students/ExamDetails.jsp").forward(request, response);
			}
		
		}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
