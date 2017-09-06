package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				p.setPay(rs.getString("pay"));
				p.setStrTime(rs.getString("startTime"));
				p.setEndTime(rs.getString("endTime"));
				p.setBepumDay(rs.getString("bepumDay"));
				p.setProfilePic(rs.getString("profilePic"));
				p.setEtc(rs.getString("etc"));
				p.setIntro(rs.getString("intro"));
				p.setHouseImg1(rs.getString("homeImg1"));
				p.setHouseImg2(rs.getString("homeImg2"));
				p.setHouseImg3(rs.getString("homeImg3"));
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

	@Override
	public int getIsProfile() {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "select count(id) as count from Profile where id = ?";
			
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement stCount = con.prepareStatement(sqlCount);
			/*st.setString(1, "%"+title+"%");*/
			stCount.setString(1, "testpumi");
			ResultSet rsCount = stCount.executeQuery();
			
			
			
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
	public int insert(String others, String selfIntro, String bepumDay, String startTime, String endTime,
			String profilePic, String homePhoto1, String homePhoto2, String homePhoto3, String pay) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO Profile(ID, startTime, endTime, bepumDay, profilePic, etc, intro, homeImg1, homeImg2, homeImg3, pay) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "testpumi");
			st.setString(2, startTime);
			st.setString(3, endTime);
			st.setString(4, bepumDay);
			st.setString(5, profilePic);
			st.setString(6, others);
			st.setString(7, selfIntro);
			st.setString(8, homePhoto1);
			st.setString(9, homePhoto2);
			st.setString(10, homePhoto3);
			st.setString(11, pay);
			

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

}
