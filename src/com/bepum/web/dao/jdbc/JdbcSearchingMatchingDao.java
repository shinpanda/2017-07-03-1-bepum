package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.SearchingMatchingDao;
import com.bepum.web.entity.MatchingView;

public class JdbcSearchingMatchingDao implements SearchingMatchingDao {
	@Override
	public List<MatchingView> getList(String id, int page, String query) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<MatchingView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "";
			if(query.equals("") || query.equals("결제완료") || query.equals("매칭완료"))
				sql = "select * from SearchingMatchingView where requestID = ? and status like ? order by reqDate desc limit ?, 15";
			else
				sql = "select * from SearchingMatchingView where requestID = ? and (status like ? or status like ?) order by reqDate desc limit ?, 15";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, id);
			if(query.equals("") || query.equals("결제완료") || query.equals("매칭완료")) {
				st.setString(2, String.format("%%%s%%", query));
				st.setInt(3, offset);
			}
			else if(query.equals("1")){
				st.setString(2, String.format("%%%s%%", "신청대기"));
				st.setString(3, String.format("%%%s%%", "매칭실패"));
				st.setInt(4, offset);
			}
			else if(query.equals("2")){
				st.setString(2, String.format("%%%s%%", "결제대기"));
				st.setString(3, String.format("%%%s%%", "결제실패"));
				st.setInt(4, offset);
			}
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

			String sqlCount = "SELECT count(no) as count FROM SearchingMatchingView where id = ?";

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
	public MatchingView get(String no) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		MatchingView m = null;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM SearchingMatchingView where no = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);
			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			ResultSet rs = st.executeQuery();


			// 결과 사용
			while (rs.next()) {
				m = new MatchingView();
				m.setNo(rs.getString("no"));
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGrade(rs.getInt("grade"));
				m.setPhoneNum(rs.getString("phoneNum"));
				m.setAddress(rs.getString("address"));
				m.setReqDate(rs.getDate("reqDate"));
				m.setBepumDate(rs.getString("bepumDate"));
				m.setStartTime(rs.getString("startTime"));
				m.setEndTime(rs.getString("endTime"));
				m.setStatus(rs.getString("status"));

				m.setPaymentOption(rs.getInt("option"));
				m.setPaymentPayDate(rs.getDate("payDate"));
				m.setReviewRating(rs.getInt("rating"));
				m.setReviewTitle(rs.getString("title"));
				m.setReviewContent(rs.getString("content"));
				
				m.setProfilePic(rs.getString("profilePic"));
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
