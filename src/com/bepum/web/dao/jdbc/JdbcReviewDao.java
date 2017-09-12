package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.ReviewDao;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.ReviewView;

public class JdbcReviewDao implements ReviewDao {

	@Override
	public List<ReviewView> getList(int page, String cName, String query) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<ReviewView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BepumiMatchingView는 목록에서만 작동... 뷰단에서 select 하는 거는 다른 객체를 만드는 것이 맞을 듯 아기가 2이상일
			// 수도 있으니까..
			String sql = "select * from ReviewView where "+cName+" like ? order by regDate desc limit ?, 15";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
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
				ReviewView m = new ReviewView();
				m.setNo(rs.getString("no"));
				m.setBepumiID(rs.getString("bepumiID"));
				m.setWriterID(rs.getString("writerID"));
				m.setTitle(rs.getString("title"));
				m.setRegDate(rs.getTimestamp("regDate"));
				m.setHit(rs.getInt("hit"));
				list.add(m);
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

	@Override
	public int getCount() {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(no) as count FROM ReviewView";
			
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
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
	public ReviewView get(String no) {
		ReviewView r = null;

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM ReviewView where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model

			// 결과 사용
			while (rs.next()) {
				r = new ReviewView();
				r.setNo(rs.getString("no"));
				r.setTitle(rs.getString("title"));
				r.setContent(rs.getString("content"));
				r.setBepumiID(rs.getString("bepumiID"));
				r.setWriterID(rs.getString("writerID"));
				r.setRegDate(rs.getTimestamp("regDate"));
				r.setHit(rs.getInt("hit"));
				r.setBepumDate(rs.getString("bepumDate"));
				r.setRequirement(rs.getString("requirement"));
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
		return r;
	}
	
	@Override
	public int updateHit(String no) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update Review set hit = hit+1 where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

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

	

}
