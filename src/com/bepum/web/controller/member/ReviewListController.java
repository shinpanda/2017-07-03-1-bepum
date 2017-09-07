package com.bepum.web.controller.member;

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

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.NoticeDao;
import com.bepum.web.dao.ReviewDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcNoticeDao;
import com.bepum.web.dao.jdbc.JdbcReviewDao;
import com.bepum.web.entity.Board;
import com.bepum.web.entity.ReviewView;


@WebServlet("/board/review")
public class ReviewListController extends HttpServlet {
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
		
		String cName = "bepumiID";
		if (_cName != null && !(_cName.equals("")))
			cName = _cName;
		
		ReviewDao dao = new JdbcReviewDao();
		
		request.setAttribute("list", dao.getList(page, cName, query));
		request.setAttribute("count", dao.getCount());
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/board/review/list.jsp").forward(request, response);
		
	}
}
