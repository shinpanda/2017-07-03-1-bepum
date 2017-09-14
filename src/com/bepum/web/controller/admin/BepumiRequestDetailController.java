package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BepumiDao;
import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.MemberDao;
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

		String[] checkBoxes = request.getParameterValues("checkBox");
		String applicationFormStatus ="심사 완료";
		String FRCStatus ="심사 완료";
		String HCStatus ="심사 완료";
		String VCStatus ="심사 완료";

		String reqID = request.getParameter("id");
		
			if(checkBoxes!=null) {
			// 전체선택 시
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

			System.out.println(applicationFormStatus);

			System.out.println(FRCStatus);

			System.out.println(HCStatus);

			System.out.println(VCStatus);
			

			BepumiRequestDao dao = new JdbcBepumiRequestDao();
			int result = dao.update(reqID, applicationFormStatus, FRCStatus, HCStatus, VCStatus);
		 

			response.sendRedirect("list");
	}
}
