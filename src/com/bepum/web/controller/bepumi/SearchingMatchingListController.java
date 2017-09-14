package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.SearchingMatchingDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcSearchingMatchingDao;

@WebServlet("/searching/matching-list")
public class SearchingMatchingListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		//신청자 세션 불러오기
		Object _id = session.getAttribute("id");
		String id = _id.toString();
		
		String _query = request.getParameter("arr");  
		
		String _page = request.getParameter("p");

		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String query = "";
		if (_query != null && !(_query.equals("")))
			query = _query;
		/*
		 * 베푸미 찾기 - 매칭 내역 
		 * 매칭 신청 
		 * 승인 중 -> 신청 대기, 매칭 실패 1
		 * 결제 확인 -> 결제 대기, 결제 실패  2
		 *  매칭 진행 -> 결제 완료 3
		 *  매칭 완료 4
		 */
		if (query.equals("3"))
			query = "결제완료";
		if (query.equals("4"))
			query = "매칭완료";

		SearchingMatchingDao dao = new JdbcSearchingMatchingDao();
		request.setAttribute("list", dao.getList(id, page, query));
		request.setAttribute("count", dao.getCount(id));
		
		request.getRequestDispatcher("/WEB-INF/views/searching/matching/list.jsp").forward(request, response);

	}
}
