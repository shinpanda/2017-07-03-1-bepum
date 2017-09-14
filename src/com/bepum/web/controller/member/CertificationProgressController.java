package com.bepum.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;

@WebServlet("/member/certification-progress")
public class CertificationProgressController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri  = request.getRequestURI();
		
		
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		String id = _id.toString();


		BepumiRequestDao dao = new JdbcBepumiRequestDao();
		request.setAttribute("profile", dao.get(id));
		
		request.getRequestDispatcher("/WEB-INF/views/member/certification/progress.jsp").forward(request, response);

	}

}
