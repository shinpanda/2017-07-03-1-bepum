package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;

@WebServlet("/bepumi/matching-detail")
public class MatchingDetailController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BepumiMatchingDao dao = new JdbcBepumiMatchingDao();
		request.setAttribute("list", dao.get("testpumi", "1"));

		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/bepumi/matching/detail.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _id = session.getAttribute("id");

		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String id = _id.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(id);

			if (role < 1)
				out.write("<script> alert('잘못된 요청입니다.'); history.back(); </script>");
			else {
				BepumiMatchingDao dao = new JdbcBepumiMatchingDao();
				request.setAttribute("list", dao.get("testpumi", "1"));

				/* response.sendRedirect("notice.jsp"); */
				request.getRequestDispatcher("/WEB-INF/views/bepumi/matching/detail.jsp").forward(request, response);
			}
		}

	}
}
