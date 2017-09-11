package com.bepum.web.controller.bepumi;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.SearchingBepumiDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;
import com.bepum.web.dao.jdbc.JdbcSearchingBepumiDao;


@WebServlet("/searching/bepumi-list")
public class SearchingBepumiListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String _page = request.getParameter("p");
		String _babyAge = request.getParameter("kid-ages");
		String _isbepumDay = request.getParameter("select");
		String _startTime = request.getParameter("start-time");
		String _endTime = request.getParameter("end-time");
		String[] _bepumDay = null;
		String[] bepumDay = new String[7];
		for(int i = 0;  i<bepumDay.length; i++) {
			bepumDay[i] = "";
		}

		int babyAge = 0;
		if(_babyAge != null && !_babyAge.equals(""))
			babyAge = Integer.parseInt(_babyAge);
		
		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		if(_isbepumDay != null && !_isbepumDay.equals(""))
		{
			_bepumDay = request.getParameterValues("select");
			for(int i = 0;  i<_bepumDay.length; i++)
			{
				bepumDay[i] = _bepumDay[i];
			}
		}
		String startTime = "";
		if(_startTime != null && !_startTime.equals(""))
			startTime = _startTime;
		
		String endTime = "";
		if(_endTime != null && !_endTime.equals(""))
			endTime = _endTime;


		
		SearchingBepumiDao dao = new JdbcSearchingBepumiDao();
		request.setAttribute("list", dao.getList(page, babyAge, 
				bepumDay[0], bepumDay[1], bepumDay[2],
				bepumDay[3], bepumDay[4], bepumDay[5], bepumDay[6], startTime, endTime));
		request.setAttribute("count", dao.getCount(babyAge, 
				bepumDay[0], bepumDay[1], bepumDay[2],
				bepumDay[3], bepumDay[4], bepumDay[5], bepumDay[6], startTime, endTime));		
				
		
		request.getRequestDispatcher("/WEB-INF/views/searching/bepumi/list.jsp").forward(request, response);

	}
}
