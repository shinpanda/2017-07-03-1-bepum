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
import com.bepum.web.entity.MatchingView;

@WebServlet("/bepumi/matching-list")
public class MatchingListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
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
				String _query = request.getParameter("arr");
				System.out.println(_query);
				String _page = request.getParameter("p");

				int page = 1;
				if (_page != null && !(_page.equals("")))
					page = Integer.parseInt(_page);

				String query = "";
				if (_query != null && !(_query.equals("")))
					query = _query;

				BepumiMatchingDao dao = new JdbcBepumiMatchingDao();
				request.setAttribute("list", dao.getList(id, page, query));
				request.setAttribute("count", dao.getCount(id));

				/* response.sendRedirect("notice.jsp"); */
				request.getRequestDispatcher("/WEB-INF/views/bepumi/matching/list.jsp").forward(request, response);
			}
		}
	}
}
