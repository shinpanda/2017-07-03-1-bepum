package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;

@WebServlet("/admin/bepumi/request/detail")
public class BepumiRequestDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");


		BepumiRequestDao dao = new JdbcBepumiRequestDao();
		request.setAttribute("profile", dao.get(id));
		
		request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/request-list-detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] checkBoxes = request.getParameterValues("checkBox");
		String applicationFormStatus;
		String FRCStatus;
		String HCStatus;
		String VCStatus;

		
		//전체선택 시 
		for(int i=0; i<checkBoxes.length; i++) {
			if(Integer.parseInt(checkBoxes[i])==i) {
				System.out.println(checkBoxes[i]);}
		}
			
		
/*		if(Integer.parseInt(checkBoxes[0])==0) {
			System.out.println("재심사 필요");			
			//applicationFormStatus = "재심사 필요";
		}else {
			System.out.println("심사완료");}
		//	applicationFormStatus = "심사 완료";}		
*/
		
		
		//체크를 하면 value가 넘어옴, 재심사가 필요
		
		
/*		if(Integer.parseInt(checkBoxes[1])==1) {
			System.out.println("1");			
			//applicationFormStatus = "재심사 필요";
		}else {
			System.out.println("11");
		//	applicationFormStatus = "심사 완료";
		}
		
		if(Integer.parseInt(checkBoxes[2])==2) {
			System.out.println("2");			
			//applicationFormStatus = "재심사 필요";
		}else {
			System.out.println("22");
		//	applicationFormStatus = "심사 완료";
		}
		
		if(Integer.parseInt(checkBoxes[3])==3) {
			System.out.println("3");			
			//applicationFormStatus = "재심사 필요";
		}else {
			System.out.println("33");
		//	applicationFormStatus = "심사 완료";
		}*/
	
		
/*		if(checkBoxes[1]=="1") {
			FRCStatus = "심사 완료";
		}else {
			FRCStatus = "재심사 필요";
		}
		
		if(checkBoxes[2]=="2") {
			HCStatus = "심사 완료";
		}else {
			HCStatus = "재심사 필요";
		}
		
		if(checkBoxes[3]=="3") {
			VCStatus = "심사 완료";
		}else {
			VCStatus = "재심사 필요";
		}
		*/


		
		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		String reqID = _id.toString();

		
		BepumiRequestDao dao = new JdbcBepumiRequestDao();
	//	int result = dao.update(reqID, applicationFormStatus, FRCStatus, HCStatus, VCStatus);
		
		response.sendRedirect("list");
	}
}
