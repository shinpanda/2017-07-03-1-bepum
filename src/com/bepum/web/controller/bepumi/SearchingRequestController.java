package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.MatchingDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.jdbc.JdbcMatchingDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;


@WebServlet("/searching/request")
public class SearchingRequestController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//여기서 신청서 정보를 matching, matchingSituation에 insert 하면됨
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		//신청자 세션 불러오기
		Object _id = session.getAttribute("id");
		String requestID = _id.toString();
		
		//돌보미 프로필 불러오기
		String bepumiID= request.getParameter("bepum-id");
		
		String bepumDate = request.getParameter("bepumDate");
		String requirement = request.getParameter("requirement");
		String startTime = request.getParameter("start-time");
		String endTime = request.getParameter("end-time");
		

		MatchingDao dao = new JdbcMatchingDao();
		
		int result0 = dao.insert0(requestID, bepumiID);
		int result = dao.insert(bepumDate, requirement, startTime, endTime);
		

		response.sendRedirect("matching-list");

		
		//신청 버튼 눌렀을 때 팝업메세지 뜨고 매칭목록으로 가게...
/*	   response.setContentType("text/html; charset=UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   
		PrintWriter out = response.getWriter();		
		 out.write(
		 "<script>alert('돌보미가 승인 후 결제 요청을 하면 결제를 완료해주세요.');"
		 + "location.href='request?returnURL=../matching-list';</script>");
*/
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		//신청자 세션 불러오기
		Object _id = session.getAttribute("id");
		String id = _id.toString();
		//돌보미 프로필 불러오기
		String bepumiID= request.getParameter("bepum-id");
		
		
		ProfileDao dao = new JdbcProfileDao();
		request.setAttribute("profile", dao.get(bepumiID));
		request.setAttribute("reqprofile", dao.get(id));
				
		request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/request.jsp").forward(request, response);

	}
}
