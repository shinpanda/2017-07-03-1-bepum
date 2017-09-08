package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bepum.web.dao.MemberRoleDao;

public class JdbcMemberRoleDao implements MemberRoleDao {

	@Override
	public int getRole(String id) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int role = 0;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT grade FROM Member where id = ?";
			
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			/*st.setString(1, "%"+title+"%");*/

			/*Statement stCount = con.createStatement();*/
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				role = rs.getInt("grade");


			// 결과 가져오기

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
		return role;
	}

}
