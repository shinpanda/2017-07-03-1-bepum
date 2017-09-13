package com.bepum.web.controller.bepumi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.SearchingMatchingDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcSearchingMatchingDao;

@WebServlet("/searching/matching-list-detail")
public class SearchingMatchingListDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		
		SearchingMatchingDao dao = new JdbcSearchingMatchingDao();
		request.setAttribute("profile", dao.get(no));
		
		//매칭상태에 따라 다른 화면 반환하기
		
		/*request.getRequestDispatcher("/WEB-INF/views/searching/matching/detail1.jsp").forward(request, response);*/
		request.getRequestDispatcher("/WEB-INF/views/searching/matching/detail.jsp").forward(request, response);
	}
}
