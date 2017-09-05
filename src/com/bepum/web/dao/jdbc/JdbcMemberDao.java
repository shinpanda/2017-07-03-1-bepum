package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int insert(Member member) {
		int result =0;
		
		String sql = "INSERT INTO Member(ID, name, pwd, gender, birthday, email, grade) VALUES(?,?,?,?,?,?,?)";
		/*String sql = "INSERT INTO Member(ID, name, pwd, gender) VALUES(?,?,?,?)";*/
		
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getId());
			st.setString(2, member.getName());
			st.setString(3, member.getPwd());
			st.setInt(4, member.getGender());
			st.setString(5, member.getBirth());
			st.setString(6, member.getEmail());
			st.setInt(7, member.getGrade());
			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		
		
		return result;
	}

	
	
}
