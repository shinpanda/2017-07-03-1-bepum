package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		

		
		response.sendRedirect("list");
	}
}
