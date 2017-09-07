package com.bepum.web.controller.bepumi;

import java.io.IOException;
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

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;


@WebServlet("/searching/bepumi-list")
public class SearchingBepumiListController extends HttpServlet {
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

		String cName = "id";
		if (_cName != null && !(_cName.equals("")))
			cName = _cName;

		ProfileDao dao = new JdbcProfileDao();

		request.setAttribute("isProfile", dao.getIsProfile());
		request.setAttribute("profile", dao.get());
		
		
		MemberDao dao2 = new JdbcMemberDao();

		request.setAttribute("list", dao2.getList(page, query, cName));
		request.setAttribute("count", dao2.getCount());
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/list.jsp").forward(request, response);

		
		
		
	}
}
