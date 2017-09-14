package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList(int page, String query, String cName) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<Member> list = null;
		int offset = ((page - 1) * 15);

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT * FROM Member where "+cName+" like ? order by regDate desc limit ?, 15";

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
				Member m = new Member(); 
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getInt("gender")); 
				m.setBirth(rs.getString("birthday"));
				m.setEmail(rs.getString("email"));
				
				m.setGrade(rs.getInt("grade"));
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

			String sqlCount = "SELECT count(id) as count FROM Member";
			
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
	public int insert(Member member) {
		int result =0;
		
		
		String sql = "INSERT INTO Member(ID, name, pwd, gender, birthday, email, grade,address, phone) VALUES(?,?,?,?,?,?,?,?,?)";
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
			st.setString(8, member.getAddress());
			st.setString(9, member.getPhone());
			
			
			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		
		System.out.println(result);
		return result;
	}

	@Override
	public Member get(String id) {
		String sql = "SELECT * FROM Member where id=?";
		Member m = null;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			/* list = new ArrayList<>(); */
			while (rs.next()) { 
				m = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("gender"),
						rs.getString("birthday"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getInt("grade"),rs.getDate("regDate"));
			}
			
//			System.out.println(m.getId());
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		return m;
	}

	@Override
	public int update(String id, String name, String pwd, String birth, String address, String phone, String email) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
//				ID, name, pwd, gender, birthday, email, grade
			String sql = "update Member set name = ?, pwd = ?, birthday = ?, address = ? , phone = ?, email = ? where ID = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, name);
			st.setString(2, pwd);
			st.setString(3, birth);
			st.setString(4, address);
			st.setString(5, phone);
			st.setString(6, email);
			st.setString(7, id);
			
			
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

	@Override
	public int delete(String id, String pwd) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		String grade = "44444";//탈퇴 회원 번호
		String delpwd = "";
		
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
//				ID, name, pwd, gender, birthday, email, grade
			String sql = "update Member set grade = ?, pwd =? where ID = ? and pwd =?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1, grade);
			st.setString(2, delpwd);
			st.setString(3, id);
			st.setString(4, pwd);
			
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

	public int checkId(String id) {
		int result=0;
		System.out.println(id+"???????");
		String sql = "SELECT * FROM Member where id=?";
		Member m = null;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			System.out.println();
			if(!rs.next()) {
				result = 1;
			}
			else
				result = 0;
			
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
		}
		return result;
	}

	public int updateGrade(String reqID) {		
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
	//			ID, name, pwd, gender, birthday, email, grade
			String sql = "update Member set grade=1 where ID = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
					
			st.setString(1, reqID);
		
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
