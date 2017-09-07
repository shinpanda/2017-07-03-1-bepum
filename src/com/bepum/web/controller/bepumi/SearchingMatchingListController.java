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

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.SearchingMatchingDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcSearchingMatchingDao;

@WebServlet("/searching/matching-list")
public class SearchingMatchingListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = "yeonjoo";
		String _query = request.getParameter("search");  //얘 "매칭완료" 아니고 "search"인 이유가 궁금하다
		
		String _page = request.getParameter("p");

		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String query = "";
		if (_query != null && !(_query.equals("")))
			query = _query;
		
		
		SearchingMatchingDao dao = new JdbcSearchingMatchingDao();
		request.setAttribute("list", dao.getList(id, page, query));
		request.setAttribute("count", dao.getCount(id));
		
		request.getRequestDispatcher("/WEB-INF/views/searching/matching/list.jsp").forward(request, response);

	}
}
