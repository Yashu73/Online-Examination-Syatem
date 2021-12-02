package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dal.CurrentActiveDal;
import dal.ESetDal;
import dal.ExamDal;
import modal.CurrentActiveModal;
import modal.ESetModal;
import modal.ExamModal;
import modal.StuAtndExam;

/**
 * Servlet implementation class StudExam
 */
@WebServlet("/Exam")
public class Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public Exam() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			String actn = request.getParameter("action");
			ExamDal exmdal = new ExamDal();
			ExamModal exmQueOptn = new ExamModal();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (action.equalsIgnoreCase("null")) {
				out.print("Action Not Found ");
				return;
			}

			HttpSession session = request.getSession();
			String ExmEAID1 = "", ExmEID1 = "", ExmSID1 = "", ExmCLASSID1 = "", ExmSUBID1 = "", SN1 = "", minutes1 = "",TOLQUES1 = "";
			int ExmEAID = 0, ExmEID = 0, ExmSID = 0, ExmCLASSID = 0, ExmSUBID = 0, SN = 1, minutes = 10;
 
			ExmEAID1 = (String.valueOf(session.getAttribute("ExmEAID")));
			ExmEID1 = (String.valueOf(session.getAttribute("EID")));
			ExmSID1 = (String.valueOf(session.getAttribute("Sid")));
			ExmCLASSID1 = (String.valueOf(session.getAttribute("Studaclssid")));
			ExmSUBID1 = (String.valueOf(session.getAttribute("SubID")));
			SN1 = (String.valueOf(session.getAttribute("SN")));
			TOLQUES1 = (String.valueOf(session.getAttribute("TOLQUES")));

			System.out.println("Exam Started With Question***********==>" + action);
			if (ExmEAID1.equalsIgnoreCase("null") || ExmEID1.equalsIgnoreCase("null") || ExmSID1.equalsIgnoreCase("null")				|| ExmCLASSID1.equalsIgnoreCase("null") || ExmSUBID1.equalsIgnoreCase("null")
					|| SN1.equalsIgnoreCase("null") || minutes1.equalsIgnoreCase("null")) {
				System.out.println("EAID=" + ExmEAID1 + ",setid=" + ExmEID1 + ",Sid=" + ExmSID1 + ", classid=" + ExmCLASSID1+ ",SubId=" + ExmSUBID1 + ", Sn-" + SN1 + ", minutes-" + minutes1 + "");
				return;
			} else {
				System.out.println("EAID-" + ExmEAID1 + ",setid-" + ExmEID1 + ",Sid-" + ExmSID1 + ", classid-" + ExmCLASSID1 + ",SubId-" + ExmSUBID1 + ", Sn-" + SN1 + ", minutes-" + minutes1 + "");
				ExmEAID = Integer.valueOf(ExmEAID1);
				ExmEID = Integer.valueOf(ExmEID1);
				ExmSID = Integer.valueOf(ExmSID1);
				ExmCLASSID = Integer.valueOf(ExmCLASSID1);
				ExmSUBID = Integer.valueOf(ExmSUBID1);
				SN = Integer.valueOf(SN1);
				minutes1 = String.valueOf(exmdal.getRemainTime(ExmEAID, ExmCLASSID, ExmSID));
				minutes = Integer.valueOf(minutes1);
			}

			if (action != null && action.equalsIgnoreCase("bgn")) {
				int EAID = Integer.valueOf(request.getParameter("EAID").trim());
				int SID = Integer.valueOf(request.getParameter("SID").trim());
				int CLASSID = Integer.valueOf(request.getParameter("CLASSID").trim()); 
				int Sn = Integer.valueOf(request.getParameter("SN").trim());
				int SUBID = Integer.valueOf(request.getParameter("SUBID").trim());
				String ExmEID11 = (request.getParameter("SETID").trim()); 
				System.out.println(ExmEID11 + "<<==**next**>*****" + EAID + "," + ExmEID + "," + SID + "," + CLASSID + "," + SUBID + "," + Sn);
				System.out.println("Next....");

				if (SN == 0) {
					System.out.println("********Next******.");
					SN = 1;
					System.out.println("*****");
				}
				exmQueOptn = exmdal.getQuesn(EAID, ExmEID, SID, CLASSID, ExmSUBID, Sn);
				String json = new Gson().toJson(exmQueOptn);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				System.out.println(json);
				System.out.println("Hello" + json);
			}
			/// Previous Quetion.....
			if (action.equalsIgnoreCase("Prev")) {

				int EAID = Integer.valueOf(request.getParameter("EAID").trim());
				int SID = Integer.valueOf(request.getParameter("SID").trim());
				int CLASSID = Integer.valueOf(request.getParameter("CLASSID").trim());
				// int QID=Integer.valueOf(request.getParameter("QID").trim());
				int Sn = Integer.valueOf(request.getParameter("SN").trim());
				int SUBID = Integer.valueOf(request.getParameter("SUBID").trim());
				String ExmEID11 = (request.getParameter("SETID").trim());

				if (SN == 0) {
					System.out.println("Prev btn pressed....");
					SN = 1;
					System.out.println("*****");
				}
				exmQueOptn = exmdal.getQuesn(EAID, ExmEID, SID, CLASSID, ExmSUBID, Sn);
				String json = new Gson().toJson(exmQueOptn);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				System.out.println(json);
				return;
			}

			if (action.equalsIgnoreCase("Next")) {
				int EAID = Integer.valueOf(request.getParameter("EAID").trim());
				int SID = Integer.valueOf(request.getParameter("SID").trim());
				int CLASSID = Integer.valueOf(request.getParameter("CLASSID").trim());
				// int QID=Integer.valueOf(request.getParameter("QID").trim());
				int Sn = Integer.valueOf(request.getParameter("SN").trim());
				int SUBID = Integer.valueOf(request.getParameter("SUBID").trim());
				String ExmEID11 = (request.getParameter("SETID").trim());

				System.out.println(ExmEID11 + "<<==**next**>*****" + EAID + "," + ExmEID + "," + SID + "," + CLASSID + "," + SUBID + "," + Sn);
				System.out.println("Next....");

				if (SN == 0) {
					System.out.println("********Next******.");
					SN = 1;
					System.out.println("*****");
				}
				exmQueOptn = exmdal.getQuesn(EAID, ExmEID, ExmSID, CLASSID, ExmSUBID, Sn);
				String json = new Gson().toJson(exmQueOptn);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				System.out.println(json);
				System.out.println("Hello" + json);
				return;
			}

			// Submit..***********
			if (action.equalsIgnoreCase("Submit")) {
				System.out.print("Exam Submit Button Called Successfully....  " + action);
				int EAID = Integer.valueOf(request.getParameter("EAID1").trim());
				int SID = Integer.valueOf(request.getParameter("SID1").trim());
				int CLASSID = Integer.valueOf(request.getParameter("ClassId1").trim());				 
				if(!exmdal.SubmitExam(EAID,  CLASSID, SID))
				{
					out.print("EXAM Not Submited. Login And Submit the exam..<a href=\"index.html\">Click Here Login</a>");
					return;
				}
				CurrentActiveDal esdal=new CurrentActiveDal();
				exmQueOptn = exmdal.getDetailsAfterSubmit(EAID,  SID, CLASSID, ExmSUBID, SN);
				request.setAttribute("ExmSubmitedDtls", exmQueOptn);
				request.setAttribute("SubjectName", exmQueOptn.getSub_Name());
				request.setAttribute("StartTime", exmQueOptn.getStartTime());
				request.setAttribute("EndTime", exmQueOptn.getEndTime());
				request.setAttribute("examDate", exmQueOptn.getExamDate());
				request.setAttribute("CLASSID", CLASSID);
				System.out.println("<---Exam Submitted Successfully--->"+exmQueOptn.getSub_Name());
				request.getRequestDispatcher("/Students/Submitted.jsp").forward(request, response);
				//request.getRequestDispatcher("/Students/Submitted.jsp").forward(request, response); 
				return;
			}
			/// Update Answer....*******
			if (action.equalsIgnoreCase("updateAnswer")) {
				int EAID = Integer.valueOf(request.getParameter("EAID").trim());
				int SID = Integer.valueOf(request.getParameter("SID").trim());
				int CLASSID = Integer.valueOf(request.getParameter("CLASSID").trim());
				int QID = Integer.valueOf(request.getParameter("QID").trim());
				String ANSWER = (request.getParameter("ANSWER").trim());
				int Sn = Integer.valueOf(request.getParameter("SN").trim());
				int SETID = Integer.valueOf(request.getParameter("SETID").trim());
				
				System.out.print("Update selected answer " + EAID);
				ExamDal exmDal = new ExamDal();
				exmDal.UpdateAnswer(EAID, CLASSID, SID, SETID, Sn, ANSWER);
				// ------------------
				String json = new Gson().toJson("********Sucessfully Upadated Answer*****");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				System.out.println(json);
				return;
			}

			if (action.equalsIgnoreCase("updateRemainigTime")) {
				System.out.print("Remaing Time Update");
				int remainTime = Integer.valueOf(request.getParameter("RemainTime").trim());
				System.out.print("Remaing Time" + remainTime);
				int EAID = Integer.valueOf(request.getParameter("EAID").trim());
				int SID = Integer.valueOf(request.getParameter("SID").trim());
				int CLASSID = Integer.valueOf(request.getParameter("CLASSID").trim());
				ExamDal exmDal = new ExamDal();
				if (exmDal.UpdateRemainTime(EAID,CLASSID , SID ,remainTime))
					System.out.print("Remaiing Time Update Sucessfully...Yes..");
				// ------------------
				String json = new Gson().toJson("********Sucessfully Upadated Time******SID****"+SID+"");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				System.out.println(json);
				return;
			}
		}
	}