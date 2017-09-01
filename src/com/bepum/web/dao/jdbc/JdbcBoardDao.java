package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;

public class JdbcBoardDao implements BoardDao {

	@Override
	public List<BoardView> getList(int page, String t_name, String query, String bName) {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<BoardView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT * FROM NoticeView where "+t_name+" like ? order by regDate desc limit ?, 15";

			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, String.format("%%%s%%", query));
			st.setInt(2, offset);
			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// 결과 사용
			while (rs.next()) {
				BoardView b = new BoardView();
				b.setNo(rs.getString("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriterId(rs.getString("writerId"));
				b.setRegDate(rs.getDate("regDate"));
				b.setHit(rs.getInt("hit"));
				b.setCountCmt(rs.getInt("countCmt"));
				list.add(b);
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

		return list;
	}

	public int getCount() {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(id) as count FROM Notice";
			
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */

			/*st.setString(1, "%"+title+"%");*/

			Statement stCount = con.createStatement();
			ResultSet rsCount = stCount.executeQuery(sqlCount);
			
			if(rsCount.next())
				count = rsCount.getInt("count");
			
			// 결과 가져오기

			rsCount.close();
			stCount.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	@Override
	public int update(String no, String title, String content, String bName) {
		int result = 0;
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

			result = st.executeUpdate();
			// 업데이트된 row 개수 알려줌

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(String title, String content, String bName) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO Notice(id, title, content, writerId) VALUES ((select IFNULL(max(cast(id as unsigned)), 0)+1 from Notice n), ?, ?, ?)";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, "newlec");

			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			result = st.executeUpdate();
			// 업데이트된 row 개수 알려줌

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public BoardView get(String no, String bName) {
		BoardView b = null;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM NoticeView where id = ?";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model

			// 결과 사용
			while (rs.next()) {
				b = new BoardView();
				b.setNo(rs.getString("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriterId(rs.getString("writerId"));
				b.setRegDate(rs.getDate("regDate"));
				b.setHit(rs.getInt("hit"));
				b.setCountCmt(rs.getInt("countCmt"));
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
		return b;
	}

}
