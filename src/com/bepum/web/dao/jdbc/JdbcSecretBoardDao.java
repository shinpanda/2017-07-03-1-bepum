package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.SecretBoardDao;
import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.SecretBoardView;

public class JdbcSecretBoardDao implements SecretBoardDao {

	@Override
	public List<SecretBoardView> getList(int page, String cName, String query, String tName) {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<SecretBoardView> list = null;
		int offset = ((page - 1) * 15);

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT * FROM "+tName+"View where "+cName+" like ? order by regDate desc limit ?, 15";

			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, String.format("%%%s%%", query));
			st.setInt(2, offset);
			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// ��� ���
			while (rs.next()) {
				SecretBoardView b = new SecretBoardView();
				b.setNo(rs.getString("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriterId(rs.getString("writerId"));
				b.setRegDate(rs.getDate("regDate"));
				b.setHit(rs.getInt("hit"));
				b.setCountCmt((rs.getInt("countCmt")));
				list.add(b);
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

	public int getCount(String tName) {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(id) as count FROM "+tName+"View";
			
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */

			/*st.setString(1, "%"+title+"%");*/

			Statement stCount = con.createStatement();
			ResultSet rsCount = stCount.executeQuery(sqlCount);
			
			if(rsCount.next())
				count = rsCount.getInt("count");
			
			// ��� ��������

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
	public int update(String no, String title, String content, int isPrivate, String privateKey, String tName) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update "+tName+" set title  = ?, content  = ? where id = ?";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, no);

			result = st.executeUpdate();
			// ������Ʈ�� row ���� �˷���

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
	public int insert(String title, String content, int isPrivate, String privateKey, String tName) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO "+tName+"(id, title, content, writerId, isPrivate, privateKey) VALUES ((select IFNULL(max(cast(id as unsigned)), 0)+1 from Notice n), ?, ?, ?, ? ,?)";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, "testpumi");
			st.setInt(4, isPrivate);
			st.setString(5, privateKey);

			/* st.setString(1, "%"+title+"%"); */

			// ��� ��������
			result = st.executeUpdate();
			// ������Ʈ�� row ���� �˷���

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
	public SecretBoardView get(String no, String tName) {
		SecretBoardView b = null;

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM "+tName+"View where id = ?";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, no);

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model

			// ��� ���
			while (rs.next()) {
				b = new SecretBoardView();
				b.setNo(rs.getString("id"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriterId(rs.getString("writerId"));
				b.setRegDate(rs.getDate("regDate"));
				b.setHit(rs.getInt("hit"));
				b.setIsPrivate(rs.getInt("isPrivate"));
				b.setPrivateKey(rs.getString("privateKey"));
				b.setCountCmt(rs.getInt("countCmt"));
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
		return b;
	}

}