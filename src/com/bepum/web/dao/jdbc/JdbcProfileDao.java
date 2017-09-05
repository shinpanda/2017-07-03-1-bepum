package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bepum.web.dao.ProfileDao;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.Profile;

public class JdbcProfileDao implements ProfileDao {

	@Override
	public Profile get() {
		Profile p = null;

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM ProfileView where id = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "testpumi");

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model

			// 결과 사용
			if (rs.next()) {
				p = new Profile();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setAddress(rs.getString("address"));
				p.setPhoneNum(rs.getString("phoneNum"));
				p.setGrade(rs.getInt("grade"));
				p.setStrTime(rs.getString("startTime"));
				p.setEndTime(rs.getString("endTime"));
				p.setBepumiDay(rs.getString("bepumiDay"));
				p.setProfileImg(rs.getString("profilePic"));
				p.setOthers(rs.getString("etc"));
				p.setHouseImg(rs.getString("houseImg"));
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
		return p;
	}

}
