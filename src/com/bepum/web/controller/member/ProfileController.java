package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;

@WebServlet("/member/profile")
public class ProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); location.href='../index'; </script>");
		else {
			String id = _id.toString();
			MemberDao memberDao = new JdbcMemberDao();
			request.setAttribute("member", memberDao.get(id));
			request.getRequestDispatcher("/WEB-INF/views/member/profile.jsp").forward(request, response);
		}
	/*	String uri = request.getRequestURI();
		request.setAttribute("uri", uri);*/
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result =0;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		String id = _id.toString();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String birthYear = request.getParameter("birth-year");
		String birthMonth = request.getParameter("birth-month");
		String birthDay = request.getParameter("birth-day");
		String birth = birthYear+"-"+birthMonth+"-"+birthDay;
		String email = request.getParameter("email");
		
		MemberDao memberDao = new JdbcMemberDao();
		result =memberDao.update(id,name,pwd,birth,email);
		
		if(result>0) {
			out.println("<script>alert('회원정보가 수정되었습니다.');location.href='profile';</script>");
		}else {
			out.println("<script>alert('회원정보수정에 오류가 있습니다. 다시 시도해 주세요');history.go(-1);</script>");
		}

	}
}
