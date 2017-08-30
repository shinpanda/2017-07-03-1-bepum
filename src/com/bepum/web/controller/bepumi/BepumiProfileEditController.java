package com.bepum.web.controller.bepumi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bepumi/profile-edit")
public class BepumiProfileEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _pay = request.getParameter("pay");
		
		String _profileImg = request.getParameter("profile-img");
		
		String _homePhoto1 = request.getParameter("home-photo1");
		String _homePhoto2 = request.getParameter("home-photo2");
		String _homePhoto3 = request.getParameter("home-photo3");
		
		String[] _bepumiDay = request.getParameterValues("bepumi-day");
		
		String _startTime = request.getParameter("start-time");
		String _endTime = request.getParameter("end-time");
		
		String others = request.getParameter("others");
		String selfIntro = request.getParameter("self-intro");
		
		response.sendRedirect("profile");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/bepumi/profile/edit.jsp").forward(request, response);
		
	}
}
