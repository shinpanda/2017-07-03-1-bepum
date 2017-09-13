package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.SecretBoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcSecretBoardDao;
import com.bepum.web.entity.Board;

@WebServlet("/board/report-reg")
public class ReportRegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _id = session.getAttribute("id");

		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String id = _id.toString();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String _isPrivate = request.getParameter("sec-btn");
			int isPrivate = 0;
			String privateKey = "";

			if (_isPrivate != null && !_isPrivate.equals("")) {
				if (_isPrivate.equals("sec")) {
					isPrivate = 1;
					String _privateKey = request.getParameter("sec-key");
					if (_privateKey == null || _privateKey.equals(""))
						privateKey = _privateKey;
					else {
						out.write("<script> alert('비밀번호를 설정해주세요.'); history.back(); </script>");
						// 여기가 안먹힘...
						// System.out.println() 이건 됨.. 스크립트를 실행하는게 안되는데.. 흠... 뷰단에서 체크해줘야하나..
					}
				}
			}

			SecretBoardDao dao = new JdbcSecretBoardDao();
			int result = dao.insert(id, title, content, isPrivate, privateKey, "Report");

			response.sendRedirect("report");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _id = session.getAttribute("id");

		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			/* response.sendRedirect("notice.jsp"); */
			request.getRequestDispatcher("/WEB-INF/views/board/report/reg.jsp").forward(request, response);
		}

	}
}
