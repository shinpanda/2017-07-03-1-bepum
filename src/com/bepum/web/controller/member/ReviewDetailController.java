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
import com.bepum.web.dao.ReviewDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcReviewDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/review-detail")
public class ReviewDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		ReviewDao dao = new JdbcReviewDao();
		int result = dao.updateHit(no);
		request.setAttribute("b", dao.get(no));
		request.setAttribute("br", "<br/>");
		request.setAttribute("cn", "\n");
		

		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/board/review/detail.jsp").forward(request, response);
		
	}
}
