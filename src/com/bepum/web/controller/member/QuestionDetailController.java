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

import com.bepum.web.dao.SecretBoardDao;
import com.bepum.web.dao.jdbc.JdbcSecretBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/question-detail")
public class QuestionDetailController extends HttpServlet {
	String boardName = "FAQ";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String no = request.getParameter("no");
		String _privateKey = request.getParameter("secretKey");
		System.out.println(_privateKey);
		if (_privateKey == null && _privateKey == "")
			response.sendRedirect("question");
		else {
			SecretBoardDao dao = new JdbcSecretBoardDao();
			String key = dao.getSecretKey(no, boardName);
			if(_privateKey.equals(key))
			{
				int result = dao.updateHit(no, boardName);
				request.setAttribute("b", dao.get(no, boardName));
				request.setAttribute("br", "<br/>");
				request.setAttribute("cn", "\n");
				request.getRequestDispatcher("/WEB-INF/views/board/question/detail.jsp").forward(request, response);
			}
			else
				response.sendRedirect("question");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Object _id = request.getSession().getAttribute("id"); 
		String no = request.getParameter("no");

		SecretBoardDao dao = new JdbcSecretBoardDao();
		int isSecret = dao.isSecret(no, boardName);
		
		if (_id != null && !_id.equals(""))
		{
			String id = _id.toString();
			
			if(id.equals(dao.getId(no, boardName)))
				isSecret = 0;
		}
		
		request.setAttribute("isSecret", isSecret);
		if (isSecret == 0) {
			int result = dao.updateHit(no, boardName);
			request.setAttribute("b", dao.get(no, boardName));
			request.setAttribute("br", "<br/>");
			request.setAttribute("cn", "\n");
		}
		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/board/question/detail.jsp").forward(request, response);

	}
}
