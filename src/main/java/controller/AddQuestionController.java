package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dal.ESetDal;
import dal.Qbankimport;
import dal.QuestionSheetDAL;
import modal.AddQuestion;

/**
 * Servlet implementation class QuestionSheetController
 */
@WebServlet("/QuestionSheetController")
@MultipartConfig
public class AddQuestionController extends HttpServlet {  
	
	private static final long serialVersionUID = 1L;
        
    public AddQuestionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionSheetDAL Quesheet=new QuestionSheetDAL();
		System.out.println(request.getParameter("action"));
		System.out.println("hiiiiii");
		String ac = request.getParameter("action");
		if (ac != null && ac.equalsIgnoreCase("delete")) {
			System.out.println("hiiiiii");
			int Qid = Integer.valueOf(request.getParameter("Qid"));
			System.out.println(" Employee delete method ID: " + Qid);
			List<AddQuestion> lstques=new ArrayList<AddQuestion>();
			try {
				Quesheet.delete(Qid);
				 HttpSession session = request.getSession();
					int classid=(int)(session.getAttribute("Qclassid"));	
					int Subjectid=(int) session.getAttribute("Qsubid" );	
					int Setid=(int) session.getAttribute("Qsetid" );	
					
						lstques=Quesheet.getQuesByclssid(Subjectid, Setid,classid);
						request.setAttribute("quedataslst", lstques);
						System.out.println("Insert cond called."+lstques.size());
						request.getRequestDispatcher("/Teacher/ViewQ.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
						
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionSheetDAL dal=new QuestionSheetDAL();
		ESetDal esedal = new ESetDal();
		System.out.print("question control called");
		request.setAttribute("QueAddAlert", "");
		AddQuestion ques=new AddQuestion();
		  HttpSession session = request.getSession();
		  String actn=request.getParameter("action");
			System.out.println("Insert cond called."+actn);
			if(actn!=null && actn.equalsIgnoreCase("insert"))	{
			
		
		ques.setQUESTION(request.getParameter("qestion"));
		ques.setA(request.getParameter("opA"));
		ques.setB(request.getParameter("opB"));
		ques.setC(request.getParameter("opC"));
		ques.setD(request.getParameter("opD"));
		ques.setANS(request.getParameter("ANS"));
		ques.setSUBID(request.getParameter("subject"));
		ques.setSTDID(request.getParameter("std"));
		ques.setCLASSID(request.getParameter("std"));
		ques.setSETID(request.getParameter("setid"));	
		ques.setMarks(request.getParameter("Marks"));	
		
		if(request.getSession(false).getAttribute("TID")!=null) {
		ques.setTID(String.valueOf(request.getSession(false).getAttribute("TID")));	
		}
		else 
		{
			  request.setAttribute("invalidcr", "Login time Expired..!!");
	            request.getRequestDispatcher("Teacher/FrmTeacherLogin.jsp").forward(request, response);
		}
		System.out.print("hiii"+request.getParameter("qestion")+"2255555"+request.getParameter("opA")+request.getParameter("opB")+request.getParameter("opC")+request.getParameter("opD")+request.getParameter("ANS")+request.getParameter("subject")+request.getParameter("std"));
		
	   String retval= dal.insertQues(ques);
	   if(retval.toUpperCase().equals("SUCCESS"))
	   { 
		   esedal.getCountAndSumMrksBySetID(Integer.valueOf(request.getParameter("setid")),Integer.valueOf(request.getParameter("std")), Integer.valueOf(request.getParameter("subject")));
		   request.setAttribute("QueAddAlert", "Question Added Successfully");
		   request.getRequestDispatcher("Teacher/AddQuestion.jsp").forward(request, response);
		   
	   }
	   else
	   {
		   request.setAttribute("QueAddAlert", "Question Not Added");
		   request.getRequestDispatcher("Teacher/AddQuestion.jsp").forward(request, response);
	   }
	   
			}
			
			///View Question Using Question Set id and class and Subject Id Wise
			
			List<AddQuestion> lstques=new ArrayList<AddQuestion>();
			
		
			System.out.println("Insert cond called."+actn);
			if(actn!=null && actn.equalsIgnoreCase("View"))	{
				
				//HttpSession session = request.getSession();
				
				int classid=Integer.valueOf(request.getParameter("std"));
				int Subjectid=Integer.valueOf(request.getParameter("subid"));
				int Setid=Integer.valueOf(request.getParameter("setid"));
				
				session.setAttribute("Qclassid",classid);
				session.setAttribute("Qsubid", Subjectid);	
				session.setAttribute("Qsetid", Setid);	
			
				lstques=dal.getQuesByclssid(Subjectid, Setid,classid);
				request.setAttribute("quedataslst", lstques);
				System.out.println("Insert cond called."+lstques.size());
				request.getRequestDispatcher("/Teacher/ViewQ.jsp").forward(request, response);
				
			}
			// importing excel file 
			if(actn!=null && actn.equalsIgnoreCase("import")) {
				System.out.println("heyyy");
				Qbankimport Qi = new Qbankimport();
			InputStream inputStream = null; // input stream of the upload file
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("choosefile");

	        if (filePart != null) {
	        	
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	            String subject= (request.getParameter("subid"));
	           String tid=String.valueOf(request.getSession(false).getAttribute("TID"));
	            String std=(request.getParameter("std"));
	          
	    		String setid=(request.getParameter("setid"));	
	    		String TID=String.valueOf(request.getSession(false).getAttribute("TID"));
	            //obtains input stream of the upload file
	            //the InputStream will point to a stream that contains
	            //the contents of the file
	            inputStream = filePart.getInputStream();
	            
	            System.out.println("Hello File is found"+subject+std+setid);
	            String ss= Qi.Qimport(inputStream,subject,std,setid, TID);
	            System.out.println("Hello File is found"+ss);
	            	            
	            request.setAttribute("importALrtMsg", ss);
				System.out.println("Insert cond called."+lstques.size());
				//esedal.getCountAndSumMrksBySetID(Integer.valueOf(request.getParameter("setid")),Integer.valueOf(request.getParameter("std")), Integer.valueOf(request.getParameter("subject")));
				request.getRequestDispatcher("/Teacher/importfile.jsp").forward(request, response);
	            }
	        else {

	        	  request.setAttribute("importALrtMsg", "Question Bankd Excel Sheet Not selected..!!");
					System.out.println("Insert cond called."+lstques.size());
					request.getRequestDispatcher("/Teacher/importfile.jsp").forward(request, response);      
	        }
}
}
}

