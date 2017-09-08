package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BepumiDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcBepumiDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;

@WebServlet("/admin/bepumi/list")
public class BepumiListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String _cName = request.getParameter("search-sel");
		String _query = request.getParameter("search");

		String _page = request.getParameter("p");

		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);

		String query = "";
		if (_query != null && !(_query.equals("")))
			query = _query;

		String cName = "id";
		if (_cName != null && !(_cName.equals("")))
			cName = _cName;

		BepumiDao dao = new JdbcBepumiDao();

		request.setAttribute("list", dao.getList(page, query, cName));
		request.setAttribute("count", dao.getCount());
		request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/list.jsp").forward(request, response);
	}
}
