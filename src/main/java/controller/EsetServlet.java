package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.ESetDal;
import modal.ESetModal;

/**
 * Servlet implementation class EsetServlet
 */
@WebServlet("/EsetServlet")
public class EsetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//setviewMsg
		
		System.out.println(request.getParameter("action"));
		System.out.println("View Set Called");
		String acn = request.getParameter("action");
		ESetDal esdal=new ESetDal();
		if(acn.equalsIgnoreCase("view")) {
		
		ArrayList<ESetModal> esetdatas=new ArrayList<ESetModal>();
		esetdatas=esdal.EsetGetall();
		request.setAttribute("esetdataslst", esetdatas);
		request.getRequestDispatcher("/Teacher/ViewESet.jsp").forward(request, response);
		}
		if(acn.equalsIgnoreCase("edit")) {
			String eid = request.getParameter("eid");
			ESetModal eset=new ESetModal();
			eset= esdal.EsetGetById(Integer.parseInt(eid));
			request.setAttribute("eset", eset);
			request.getRequestDispatcher("/Teacher/EditESet.jsp").forward(request, response);
		}
		////response.getWriter().append("Served at: ").append(request.getContextPath());
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("setAddedSuccess", "");
        HttpSession session = request.getSession();

		//session.setAttribute("TID", Tid);
		ESetDal esdal=new ESetDal();
		String actn=request.getParameter("action");
		System.out.println("Insert cond called."+actn);
		if(actn!=null && actn.equalsIgnoreCase("getid"))	{
			int eid=esdal.GetEId();
		request.setAttribute("MAXEID", eid);
		
		}
		if(actn!=null && actn.equalsIgnoreCase("insert"))	{
			String id=(String) session.getAttribute("TID");
			//che is eid exist or not
			
			if(esdal.iseidexist(Integer.parseInt(request.getParameter("esetid")))) {
			request.setAttribute("setAddedSuccess", "The Exam Set ID Aready Exist..!!");
			request.getRequestDispatcher("/Teacher/AddESet.jsp").forward(request, response);
			return;
			}
		
			
			//
		System.out.println("Insert cond called.");
			ESetModal esetdata=new ESetModal();
			esetdata.setEID(Integer.parseInt(request.getParameter("esetid")));
			
			System.out.println(" id readed "+id);
			esetdata.setTID(Integer.parseInt(id));
			//esetdata.setETITLE(request.getParameter(""));
			//esetdata.setDESCRIPTION(request.getParameter(""));
			esetdata.setClassID(Integer.parseInt(request.getParameter("std")));
			esetdata.setDURATION(Integer.parseInt(request.getParameter("duration")));
			esetdata.setTOTLEQ(Integer.parseInt(request.getParameter("TotalQ")));
			esetdata.setTOTLEMARKS(Integer.parseInt(request.getParameter("totalM")));
			esetdata.setSDET(request.getParameter(""));
			esetdata.setSubid(Integer.parseInt(request.getParameter("subject")));
			esetdata.setSTATUS(request.getParameter("status"));
			esetdata.setISALLOWSTUD(request.getParameter("isallowstud"));
			String resl= esdal.insertEset(esetdata);
			if(resl.equalsIgnoreCase("success")) {
				
				request.setAttribute("setAddedSuccess", "Set Added Successfully");				
			}
		 
			else
			{
				request.setAttribute("setAddedSuccess", "Set not Added Successfully..!!");
			}
			request.getRequestDispatcher("/Teacher/AddESet.jsp").forward(request, response);
		}
		if(actn!=null && actn.equalsIgnoreCase("edit")) {
			
		}
		
		if(actn!=null && actn.equalsIgnoreCase("Update")) 
		{
			String id=(String) session.getAttribute("TID");
			 
			System.out.println("Update cond called.");
			ESetModal esetdata=new ESetModal();
			String esetid=request.getParameter("esetid");
			esetdata.setEID(Integer.parseInt(esetid));
						System.out.println(" id readed "+id);
			esetdata.setTID(Integer.parseInt(id));
			esetdata.setClassID(Integer.parseInt(request.getParameter("std")));
			esetdata.setDURATION(Integer.parseInt(request.getParameter("duration")));
			esetdata.setTOTLEQ(Integer.parseInt(request.getParameter("TotalQ")));
			esetdata.setTOTLEMARKS(Integer.parseInt(request.getParameter("totalM")));
			esetdata.setSDET(request.getParameter(""));
			esetdata.setSubid(Integer.parseInt(request.getParameter("subject")));
			esetdata.setSTATUS(request.getParameter("status"));//
			esetdata.setISALLOWSTUD(request.getParameter("isallowstud"));
			String resl= esdal.UpdateEset(esetdata);
			if(resl.equalsIgnoreCase("success")) {
				
				request.setAttribute("setAddedSuccess", "Set Updated Successfully");
					}
		 
			else
			{
				request.setAttribute("setAddedSuccess", "Set not Added Successfully..!!");
			}
			request.getRequestDispatcher("/Teacher/EditESet.jsp").forward(request, response);
		}
		
		if(actn!=null && actn.equalsIgnoreCase("getbyid")) {
			//esetlist
			
		}
		
		if(actn!=null && actn.equalsIgnoreCase("getall")) {
		//	esetlist 
			
			
			ArrayList<ESetModal> esetlst=new ArrayList<ESetModal>();
			request.setAttribute("esetlist", "");
		
			esetlst=	esdal.EsetGetall();
			
			request.setAttribute("esetlist", esetlst);
		}
		
		
		
			doGet(request, response);
	}

}
