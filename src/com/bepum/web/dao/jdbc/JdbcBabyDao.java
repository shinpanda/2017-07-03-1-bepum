package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bepum.web.dao.BabyDao;

public class JdbcBabyDao implements BabyDao {

	@Override
	public int insert(String reqID, String name, int age, int gender) {
		int result =0;
		
		String sql = "INSERT INTO Baby(no, name, age, bepumiID, gender) VALUES((select IFNULL(max(cast(no as unsigned)), 0)+1 from Baby b),?,?,?,?)";
		
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, age);
			st.setString(3, reqID);
			st.setInt(4, gender);

			
			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		
		System.out.println(result);
		return result;		
	}

}
