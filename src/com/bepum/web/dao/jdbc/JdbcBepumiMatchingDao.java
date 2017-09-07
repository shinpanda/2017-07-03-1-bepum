package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.MatchingView;

public class JdbcBepumiMatchingDao implements BepumiMatchingDao {

	@Override
	public List<MatchingView> getList(String id, int page, String query) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<MatchingView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BepumiMatchingView는 목록에서만 작동... 뷰단에서 select 하는 거는 다른 객체를 만드는 것이 맞을 듯 아기가 2이상일
			// 수도 있으니까..
			String sql = "select * from BepumiMatchingView where bepumiID = ? and status like ? order by reqDate desc limit ?, 15";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, id);
			st.setString(2, String.format("%%%s%%", query));
			st.setInt(3, offset);
			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// 결과 사용
			while (rs.next()) {
				MatchingView m = new MatchingView();
				m.setNo(rs.getString("no"));
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGrade(rs.getInt("grade"));
				m.setReqDate(rs.getDate("reqDate"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setStatus(rs.getString("status"));
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
	public int getCount(String id) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(no) as count FROM BepumiMatchingView where id = ?";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			PreparedStatement stCount = con.prepareStatement(sqlCount);
			stCount.setString(1, id);

			/* Statement stCount = con.createStatement(); */
			ResultSet rsCount = stCount.executeQuery();

			if (rsCount.next())
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
	public List<MatchingView> get(String id, String no) {

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<MatchingView> list = null;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// BepumiMatchingView는 목록에서만 작동... 뷰단에서 select 하는 거는 다른 객체를 만드는 것이 맞을 듯 아기가 2이상일
			// 수도 있으니까..
			String sql = "SELECT * FROM BepumiMatchingDetailView where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);
			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// 결과 사용
			while (rs.next()) {
				MatchingView m = new MatchingView();
				m.setNo(rs.getString("no"));
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGrade(rs.getInt("grade"));
				m.setPhoneNum(rs.getString("phoneNum"));
				m.setAddress(rs.getString("address"));
				m.setReqDate(rs.getDate("reqDate"));
				m.setBepumDate(rs.getDate("bepumDate"));
				m.setRequirement(rs.getString("requirement"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setStatus(rs.getString("status"));
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

}
