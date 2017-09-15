package com.bepum.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.entity.Bepumi;
import com.bepum.web.entity.BepumiRequest;
import com.bepum.web.entity.ProfileView;

public class JdbcBepumiRequestDao implements BepumiRequestDao {

	@Override
	public int insert(String reqID, String applicationFormCopy, String applicationForm, String hCCopy, String hC, String fRCCopy,
			String fRC, String vCCopy, String vC) {
		
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO BepumiRequest(no, reqID, reqDate, applicationForm, applicationForm_copy, HC, HC_copy, FRC, FRC_copy, VC, VC_copy, applicationFormStatus, FRCStatus,  HCStatus, VCStatus) VALUES ((select IFNULL(max(cast(no as unsigned)), 0)+1 from BepumiRequest br), ?, sysdate(), ?, ?, ?, ?, ?, ?, ?, ?, '제출 완료','제출 완료','제출 완료','제출 완료')";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, reqID);
			st.setString(2, applicationForm);
			st.setString(3, applicationFormCopy);
			st.setString(4, hC);
			st.setString(5, hCCopy);
			st.setString(6, fRC);
			st.setString(7, fRCCopy);
			st.setString(8, vC);
			st.setString(9, vCCopy);
			

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

	@Override
	public List<BepumiRequest> getList(int page, String query, String cName) {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		List<BepumiRequest> list = null;
		int offset = ((page - 1) * 15);

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "SELECT * FROM BepumiRequestView where (HCStatus='제출 완료' || applicationFormStatus='제출 완료' || FRCStatus='제출 완료' || VCStatus='제출 완료') order by reqDate desc limit ?, 15 ;";

			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, offset);
			/* st.setString(1, "%"+title+"%"); */

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// 결과 사용
			while (rs.next()) {
				BepumiRequest b = new BepumiRequest(); 
				b.setNo(rs.getString("no"));
				b.setReqId(rs.getString("reqID"));
				b.setReqDate(rs.getDate("reqDate"));
/*				b.setApplicationForm(rs.getString("applicationForm"));
				b.setApplicationForm_Copy(rs.getString("applicationForm_copy"));
				b.setFRC(rs.getString("FRC"));
				b.setFRC_Copy(rs.getString("FRC_copy"));
				b.setHC(rs.getString("HC"));
				b.setHC_Copy(rs.getString("HC_copy"));
				b.setVC(rs.getString("VC"));
				b.setVC_Copy(rs.getString("VC_copy"));*/
				
				b.setName(rs.getString("name"));
				b.setGender(rs.getInt("gender")); 
				b.setBirth(rs.getString("birthday"));
				b.setEmail(rs.getString("email")); 
				b.setGrade(rs.getInt("grade"));
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

	@Override
	public int getCount() {
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		int count = 0;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sqlCount = "SELECT count(no) as count FROM BepumiRequest";
			
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
	public BepumiRequest get(String id) {		
		
		BepumiRequest b = null;

		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
	
			String sql = "SELECT * FROM BepumiRequestView where reqID= ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
	
			// 결과 가져오기
			ResultSet rs = st.executeQuery();
	
			// model
	
			// 결과 사용
			if (rs.next()) {
				b = new BepumiRequest(); 
				b.setNo(rs.getString("no"));
				b.setReqId(rs.getString("reqID"));
				b.setReqDate(rs.getDate("reqDate"));
				b.setApplicationForm(rs.getString("applicationForm"));
				b.setApplicationForm_Copy(rs.getString("applicationForm_copy"));
				b.setFRC(rs.getString("FRC"));
				b.setFRC_Copy(rs.getString("FRC_copy"));
				b.setHC(rs.getString("HC"));
				b.setHC_Copy(rs.getString("HC_copy"));
				b.setVC(rs.getString("VC"));
				b.setVC_Copy(rs.getString("VC_copy"));
				b.setApplicationFormStatus(rs.getString("applicationFormStatus"));
				b.setFRCStatus(rs.getString("FRCStatus"));
				b.setHCStatus(rs.getString("HCStatus"));
				b.setVCStatus(rs.getString("VCStatus"));
				
				
				b.setName(rs.getString("name"));
				b.setGender(rs.getInt("gender")); 
				b.setBirth(rs.getString("birthday"));
				b.setEmail(rs.getString("email")); 
				b.setGrade(rs.getInt("grade"));
				
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

	@Override
	public int update(String reqID, String applicationFormStatus, String fRCStatus, String hCStatus, String vCStatus) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "update BepumiRequest set applicationFormStatus = ?, HCStatus = ?, FRCStatus = ?, VCStatus = ? where reqID = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, applicationFormStatus);
			st.setString(2, hCStatus);
			st.setString(3, fRCStatus);
			st.setString(4, vCStatus);
			st.setString(5, reqID);

			
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
	public int updateDoc(String reqID, String applicationFormCopy, String applicationForm, String hCCopy, String hC,
			String fRCCopy, String fRC, String vCCopy, String vC, String applicationFormStatus, String hCStatus, String fRCStatus, String vCStatus) {
		int result = 0;
		String url = "jdbc:mysql://211.238.142.247/bepumdb?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String sql = "update BepumiRequest set reqDate = sysdate(), applicationForm  = ?, applicationForm_copy = ?, HC = ?, HC_copy = ?, FRC = ?, FRC_copy = ?, VC = ?, VC_copy = ?, applicationFormStatus= ?, HCStatus = ?, FRCStatus = ?, VCStatus = ? where reqID = ?";
			Connection con = DriverManager.getConnection(url, "bepum", "bepum123");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
	
			st.setString(1, applicationForm);
			st.setString(2, applicationFormCopy);
			st.setString(3, hC);
			st.setString(4, hCCopy);
			st.setString(5, fRC);
			st.setString(6, fRCCopy);
			st.setString(7, vC);
			st.setString(8, vCCopy);
			st.setString(9, applicationFormStatus);
			st.setString(10, hCStatus);
			st.setString(11, fRCStatus);
			st.setString(12, vCStatus);
			st.setString(13, reqID);
			

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
	}}

