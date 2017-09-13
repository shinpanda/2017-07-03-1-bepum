package com.bepum.web.controller.member;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/certification-request")
public class CertificationRequestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		String uri  = request.getRequestURI();
		
		request.setAttribute("uri", uri);*/
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/member/certification/request.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("certification-identify");
	}
	
}
