package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.NoticeDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcNoticeDao;
import com.bepum.web.entity.Board;

@WebServlet("/admin/notice/edit")
public class NoticeEditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _adminId = session.getAttribute("id");

		if (_adminId == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String adminId = _adminId.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(adminId);

			if (role == 999) {
				String no = request.getParameter("no");

				NoticeDao dao = new JdbcNoticeDao();
				request.setAttribute("b", dao.get(no));
				request.setAttribute("br", "<br/>");
				request.setAttribute("cn", "\n");

				/* response.sendRedirect("notice.jsp"); */

				request.getRequestDispatcher("/WEB-INF/views/admin/notice/edit.jsp").forward(request, response);
			} else {
				out.write("<script> alert('잘못된 접근입니다.'); history.back(); </script>");
			}
		}
	}
}
