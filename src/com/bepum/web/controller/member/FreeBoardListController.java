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
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.entity.Board;


@WebServlet("/board/free")
public class FreeBoardListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _title = request.getParameter("title");
		String _page = request.getParameter("p");
		
		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String title = "";
		if (_title != null && !(_title.equals("")))
			title = _title;
		
		BoardDao dao = new JdbcBoardDao();

		request.setAttribute("list", dao.getList(page, title, "Free"));
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/list.jsp").forward(request, response);
		
	}
}
