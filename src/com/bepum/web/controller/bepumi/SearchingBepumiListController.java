package com.bepum.web.controller.bepumi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.SearchingBepumiDao;
import com.bepum.web.dao.jdbc.JdbcSearchingBepumiDao;
import com.bepum.web.entity.Profile;

@WebServlet("/searching/bepumi-list")
public class SearchingBepumiListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String _page = request.getParameter("p");

		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);

		
		SearchingBepumiDao dao = new JdbcSearchingBepumiDao();
		request.setAttribute("list", dao.getList(page));
		request.setAttribute("count", dao.getCount());		
				
		
		request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/list.jsp").forward(request, response);

		
		
		
	}
}
