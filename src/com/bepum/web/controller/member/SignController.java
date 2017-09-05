package com.bepum.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.entity.Member;


@WebServlet("/member/sign")
public class SignController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		request.setAttribute("uri", uri);
		request.getRequestDispatcher("/WEB-INF/views/member/sign.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		int grade = 000;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pw");
		String gender = request.getParameter("gender");
		
		String birthday_year = request.getParameter("birthday_year");
		String birthday_month = request.getParameter("birthday_month");
		String birthday_day = request.getParameter("birthday_day");
		String email = request.getParameter("email");
		
		String birth = birthday_year+"-"+birthday_month+"-"+birthday_day;
		
		MemberDao memberDao = new JdbcMemberDao();
		
		Member member = new Member(id, name, pwd, Integer.parseInt(gender), birth, email, grade);
		int result = memberDao.insert(member);
		if(result>0)
			response.sendRedirect("confirm");
		else
			response.sendRedirect("../error?code=1234");
	}
}
