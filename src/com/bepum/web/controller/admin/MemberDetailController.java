package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.entity.Member;
import com.bepum.web.entity.Profile;

@WebServlet("/admin/member/detail")
public class MemberDetailController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
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

				String _id = request.getParameter("id");

				String id = "";

				if (_id != null && !_id.equals(""))
					id = _id;

				System.out.println(id);

				MemberDao dao = new JdbcMemberDao();

				Member m = dao.get(id);

				/* List<Notice> list = null; */

				request.setAttribute("member", m);

				request.getRequestDispatcher("/WEB-INF/views/admin/member/detail.jsp").forward(request, response);

			} else {
				out.write("<script> alert('잘못된 접근입니다.'); history.back(); </script>");
			}
		}
	}

}
