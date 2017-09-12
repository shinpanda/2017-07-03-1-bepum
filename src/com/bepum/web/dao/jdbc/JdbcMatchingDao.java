package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bepum.web.dao.MatchingDao;

public class JdbcMatchingDao implements MatchingDao {

	@Override
	public int insert0(String requestID, String bepumiID) {		
		
	int result0 = 0;
	String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

	// JDBC 드라이버 로드
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		
		String sql = "INSERT INTO MatchingSituation(no, status, requestID, bepumiID) values ((select IFNULL(max(cast(no as unsigned)), 0)+1 from MatchingSituation mcs), '신청대기', ?,?)";
		Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
		/* Statement st = con.createStatement(); */
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, requestID);
		st.setString(2, bepumiID);

		

		/* st.setString(1, "%"+title+"%"); */

		// 결과 가져오기
		result0 = st.executeUpdate();
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

	return result0;
	}
	
	@Override
	public int insert(String bepumDate, String requirement, String startTime, String endTime) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			String sql = "INSERT INTO Matching(no, requirement, reqDate, acceptDate, bepumDate, startTime, endTime) values ((select IFNULL(max(cast(no as unsigned)), 0)+1 from Matching m), ?, sysdate(), null, ?, ?, ?)";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, requirement);
			st.setString(2, bepumDate);
			st.setString(3, startTime);
			st.setString(4, endTime);
			

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
