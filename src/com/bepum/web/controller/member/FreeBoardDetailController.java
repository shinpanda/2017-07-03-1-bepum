package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.bepum.web.dao.BoardCmtDao;
import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.jdbc.JdbcBoardCmtDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardComment;
import com.bepum.web.entity.BoardView;

@WebServlet("/board/free-detail")
public class FreeBoardDetailController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String no = request.getParameter("no");
		Object _id = session.getAttribute("id");
		String btnOption = request.getParameter("cmt-btn");
		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String cmt = request.getParameter("cmt");
			if (cmt != null && !cmt.equals("")) {
				String id = _id.toString();
				BoardCmtDao cmtDao = new JdbcBoardCmtDao();
				int result = cmtDao.insert(no, id, cmt, "Free");
				response.sendRedirect(request.getHeader("Referer"));
			} else {
				out.write("<script> alert('내용을 작성해주세요.'); history.back(); </script>");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String no = request.getParameter("no");

		BoardDao dao = new JdbcBoardDao();
		int result = dao.updateHit(no);
		BoardView b = dao.get(no, "Free");
		request.setAttribute("b", b);
		request.setAttribute("br", "<br/>");
		request.setAttribute("cn", "\n");

		if (b.getCountCmt() > 0) {
			BoardCmtDao cmtDao = new JdbcBoardCmtDao();
			request.setAttribute("cmtList", cmtDao.getList(no, "Free"));
		}
		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/detail.jsp").forward(request, response);

	}
}
