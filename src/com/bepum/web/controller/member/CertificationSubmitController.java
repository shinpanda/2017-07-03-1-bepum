package com.bepum.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/certification-submit")
public class CertificationSubmitController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri  = request.getRequestURI();
		
		
	
		request.getRequestDispatcher("/WEB-INF/views/member/certification/submit.jsp").forward(request, response);

	}
}
