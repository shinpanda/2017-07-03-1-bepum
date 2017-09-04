package com.bepum.web.controller.member;

import java.io.IOException;
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
import javax.servlet.jsp.PageContext;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/free-detail")
public class FreeBoardDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		BoardDao dao = new JdbcBoardDao();
		int result = dao.updateHit(no);
		request.setAttribute("b", dao.get(no, "Free"));
		request.setAttribute("br", "<br/>");
		request.setAttribute("cn", "\n");
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/detail.jsp").forward(request, response);
		
	}
}
