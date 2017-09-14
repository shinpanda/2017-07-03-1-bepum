package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.MatchingDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcMatchingDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;


@WebServlet("/admin/matching/list")
public class MatchingListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		
		String _cName = request.getParameter("search-sel");
		String _query = request.getParameter("search");
		
		String _page = request.getParameter("p");
		
		Object _id = session.getAttribute("id");
		
		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String id = _id.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(id);

		
		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String query = "";
		if (_query != null && !(_query.equals("")))
			query = _query;
		
		String cName = "writerId";
		if (_cName != null && !(_cName.equals("")))
			cName = _cName;
		
		MatchingDao dao = new JdbcMatchingDao();
		request.setAttribute("list", dao.getList(id, page, query));
		request.setAttribute("count", dao.getCount(id));
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/admin/matching/list.jsp").forward(request, response);
		
	}
}
}
