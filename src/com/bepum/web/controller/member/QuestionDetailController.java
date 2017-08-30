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

import com.bepum.web.entity.Board;

@WebServlet("/board/question-detail")
public class QuestionDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		Board b = null;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM Notice where id = ?";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model

			// 결과 사용
			while (rs.next()) {
				b = new Board();
				b.setNo(rs.getString("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriterId(rs.getString("writerId"));
				b.setRegDate(rs.getDate("regDate"));
				b.setHit(rs.getInt("hit"));
			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("b", b);
		request.setAttribute("br", "<br/>");
		request.setAttribute("cn", "\n");
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/board/question/detail.jsp").forward(request, response);
		
	}
}
