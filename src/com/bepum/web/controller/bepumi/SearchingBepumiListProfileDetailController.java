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

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;
import com.bepum.web.entity.Profile;

@WebServlet("/searching/detail-profile")
public class SearchingBepumiListProfileDetailController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
				request.setCharacterEncoding("UTF-8");
				String secret = request.getParameter("sec-btn");
				System.out.println(secret);
				int sec = 1;
				if (secret != null && !secret.equals("")) {
					if (secret.equals("open"))
						sec = 0;
				}
				ProfileDao dao = new JdbcProfileDao();
				response.sendRedirect("profile");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*		response.setCharacterEncoding("UTF-8");
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
				 response.sendRedirect("notice.jsp"); 
				ProfileDao dao = new JdbcProfileDao();

				request.setAttribute("isProfile", dao.getIsProfile(id));
				request.setAttribute("profile", dao.get(id));
				request.setAttribute("br", "<br/>");
				request.setAttribute("cn", "\n");

				request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/detail-profile.jsp").forward(request, response);
			}
		}*/

		String id = request.getParameter("id");
		
		ProfileDao dao = new JdbcProfileDao();
		request.setAttribute("profile", dao.get(id));
		request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/detail-profile.jsp").forward(request, response);
	}
}
