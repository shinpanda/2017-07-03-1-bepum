package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BabyDao;
import com.bepum.web.dao.BepumiDao;
import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcBabyDao;
import com.bepum.web.dao.jdbc.JdbcBepumiDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;

@WebServlet("/admin/bepumi/request/detail")
public class BepumiRequestDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		BepumiRequestDao dao = new JdbcBepumiRequestDao();
		request.setAttribute("profile", dao.get(id));

		request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/request-list-detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String[] checkBoxes = request.getParameterValues("checkBox");
		String applicationFormStatus ="심사 완료";
		String FRCStatus ="심사 완료";
		String HCStatus ="심사 완료";
		String VCStatus ="심사 완료";
		
		String name;
		int age;
		int gender;

		String reqID = request.getParameter("id");
		
			if(checkBoxes!=null) {
			for (int i = 0; i < checkBoxes.length; i++) {
				if (checkBoxes[i].equals("0")) {
					applicationFormStatus ="재심사 필요";}
				else if (checkBoxes[i].equals("1")) {
					FRCStatus ="재심사 필요";}
				else if (checkBoxes[i].equals("2")) {
					HCStatus ="재심사 필요";}
				else if (checkBoxes[i].equals("3")) {
					VCStatus ="재심사 필요";}
			}}else
				{
				 MemberDao dao1 = new JdbcMemberDao();
				 dao1.updateGrade(reqID);
				 BepumiDao dao2 = new JdbcBepumiDao();
				 dao2.insert(reqID);
				}


			BepumiRequestDao dao = new JdbcBepumiRequestDao();
			dao.update(reqID, applicationFormStatus, FRCStatus, HCStatus, VCStatus);
			
			BabyDao dao3 = new JdbcBabyDao();
			name=request.getParameter("babyName");
			age=Integer.parseInt(request.getParameter("babyAge"));
			gender=Integer.parseInt(request.getParameter("gender"));
			
			dao3.insert(reqID, name, age, gender);
		 
			response.sendRedirect("list");
	}
}
