package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.SecretBoardDao;
import com.bepum.web.dao.jdbc.JdbcSecretBoardDao;

@WebServlet("/admin/report/list")
public class ReportListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _cName = request.getParameter("search-sel");
		String _query = request.getParameter("search");
		
		String _page = request.getParameter("p");
		
		
		
		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String query = "";
		if (_query != null && !(_query.equals("")))
			query = _query;
		
		String cName = "writerId";
		if (_cName != null && !(_cName.equals("")))
			cName = _cName;
		
		SecretBoardDao dao = new JdbcSecretBoardDao();

		request.setAttribute("list", dao.getList(page, cName, query, "Report"));
		request.setAttribute("count", dao.getCount("Report"));
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/admin/report/list.jsp").forward(request, response);
		
	}
}
