package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;

@WebServlet("/admin/bepumi/detail")
public class BepumiDetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/detail.jsp").forward(request, response);
	}

}
