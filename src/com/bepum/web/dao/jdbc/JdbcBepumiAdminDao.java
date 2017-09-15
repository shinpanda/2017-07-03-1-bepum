package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bepum.web.dao.BepumiAdminDao;
import com.bepum.web.entity.BepumiAdmin;
import com.bepum.web.entity.MatchingView;

public class JdbcBepumiAdminDao implements BepumiAdminDao {

	@Override
	public BepumiAdmin getRatingStatus(String id) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		BepumiAdmin m = null;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "select avg(rating) as rating , count(status) as countAll, (select count(status) from SearchingMatchingView where id = ? and status='매칭완료') as countComplete from SearchingMatchingView where id = ?;";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, id);
			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			ResultSet rs = st.executeQuery();


			// 결과 사용
			if (rs.next()) {
				m = new BepumiAdmin();
				m.setAvgRating(rs.getInt("rating"));
				m.setCountStatus(rs.getInt("countAll"));
				m.setCountComplete(rs.getInt("countComplete"));
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

		return m;
	}

}
