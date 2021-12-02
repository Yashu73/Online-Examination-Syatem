package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.ReportSetDal;
import modal.ReportSetModal;

/**
 * Servlet implementation class ReportSetController
 */
@WebServlet("/ReportSetController")
public class ReportSetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EAID = null;
	ReportSetDal rptdal = new ReportSetDal();
	ArrayList<ReportSetModal> rptdllst = new ArrayList<ReportSetModal>();

	public ReportSetController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String action = request.getParameter("action");
		// Get result Subject Wise & classWise
		if (action != null && action.equalsIgnoreCase("subwise")) {
			String Subid = request.getParameter("subject");
			String ClassID = request.getParameter("std");
			String EdueYear = request.getParameter("EduYear");
			String FromDate = "", ToDate="";
			rptdllst = rptdal.getReportSetSubjectwise(Integer.valueOf(ClassID),Integer.valueOf(Subid),EdueYear,FromDate, ToDate);
			
			if(rptdllst.size()==0) {
				request.setAttribute("RptViewAlert", "Records Not Found.. !!");
			}
			else {
				request.setAttribute("RptViewAlert", rptdllst.size()+" Records Found ");
			request.setAttribute("SubjectwiseRpt", rptdllst);
			}
			request.getRequestDispatcher("/Teacher/SubjectWiseReport.jsp").forward(request, response);
			return;
		}
//------------------------------------------------------------------------------------------------------------------------------------------------		
		//  classwise report all subjects
		if (action != null && action.equalsIgnoreCase("AllSubClasswise")) {
			String ClassID = request.getParameter("std");
			String Subid = request.getParameter("subject");
			String EdueYear = request.getParameter("EduYear");
			//rptdllst = rptdal.getResultSubwise(Integer.valueOf(setid), Integer.valueOf(ClassID));
			rptdllst=rptdal.getReportClasswise( Integer.valueOf(ClassID),Integer.valueOf(Subid),EdueYear);
			if(rptdllst.size()==0) {
				request.setAttribute("RptViewAlert", "Records Not Found.. !!");
			}
			else {
				request.setAttribute("RptViewAlert", rptdllst.size()+" Records Found ");
			request.setAttribute("Classwise", rptdllst);
			}
			request.getRequestDispatcher("/Teacher/AllSubClasswise.jsp").forward(request, response);
			return;
			}
//---------------------------------------------------------------------------------------------------------------------------------------------------
		//Non declare student result
		if (action != null && action.equalsIgnoreCase("NonDeclared")) {       //            
			String Subid = request.getParameter("subject");
			String ClassID = request.getParameter("std");
			String EdueYear = request.getParameter("EduYear");			
			rptdllst=rptdal.getReportNonDeclared (Integer.valueOf(ClassID),Integer.valueOf(Subid),EdueYear);
			if(rptdllst.size()==0) {
				request.setAttribute("RptViewAlert", "Records Not Found.. !!");
			}
			else {
				request.setAttribute("RptViewAlert", rptdllst.size()+" Records Found ");
			request.setAttribute("NonDeclaredS", rptdllst);
			}
			request.getRequestDispatcher("/Teacher/NonDeclared.jsp").forward(request, response);
			return;
		}
//---------------------------------------------------------------------------------------------------------------------------------------------------------
		// get report student attended exam
		if (action != null && action.equalsIgnoreCase("Attended")) {
			 
			String ClassID = request.getParameter("std");
			String EdueYear = request.getParameter("EduYear");			
			rptdllst=rptdal.getReportAttended(Integer.valueOf(ClassID), EdueYear);
			if(rptdllst.size()==0) {
				request.setAttribute("RptViewAlert", "Records Not Found.. !!");
			}
			else {
				request.setAttribute("RptViewAlert", rptdllst.size()+" Records Found ");
			request.setAttribute("SAttended", rptdllst);
			}
			request.getRequestDispatcher("/Teacher/AttendedRpt.jsp").forward(request, response);
			return;
		}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//StudReport
		
		if (action != null && action.equalsIgnoreCase("Studrpt")) {
			
			System.out.print("Student Report called...");
			
			HttpSession session=request.getSession();	
			String ClassID = request.getParameter("std");
			if(ClassID.equalsIgnoreCase("0"))
				return;
			
			String Sid =String.valueOf(session.getAttribute("Sid"));			
			rptdllst=rptdal.getReportStudReport(Integer.valueOf(Sid),Integer.valueOf(ClassID));
			if(rptdllst.size()==0) {
				request.setAttribute("RptViewAlert", "Records Not Found.. !!");
			}
			else {
				request.setAttribute("RptViewAlert", rptdllst.size()+" Students Records Found ");
			request.setAttribute("StudReport", rptdllst);
			}
			request.getRequestDispatcher("/Students/StudReport.jsp").forward(request, response);
			return;
		}
	
	
	}
	
	
}
