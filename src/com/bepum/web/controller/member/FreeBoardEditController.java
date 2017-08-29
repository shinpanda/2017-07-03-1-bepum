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

import com.bepum.web.entity.Board;

@WebServlet("/board/free-edit")
public class FreeBoardEditController extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		title = title.replaceAll("\n","<br>"); // 줄바꿈처리
		title = title.replaceAll("\u0020","&nbsp;"); // 스페이스바로 띄운 공백처리
		String content = request.getParameter("content");
		
		Board b = null;
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update Notice set title  = ?, content  = ? where id = ?";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, no);

			int result = st.executeUpdate();
			//업데이트된 row 개수 알려줌

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
		
		response.sendRedirect("free-detail?no="+no);		
	}


	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/board/freeboard/edit.jsp").forward(request, response);
		
	}
}
