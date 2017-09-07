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

import com.bepum.web.dao.BepumiMatchingDao;
import com.bepum.web.dao.jdbc.JdbcBepumiMatchingDao;

@WebServlet("/bepumi/matching-detail")
public class MatchingDetailController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BepumiMatchingDao dao = new JdbcBepumiMatchingDao();
		request.setAttribute("list", dao.get("testpumi", "1"));
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/bepumi/matching/detail.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BepumiMatchingDao dao = new JdbcBepumiMatchingDao();
		request.setAttribute("list", dao.get("testpumi", "1"));
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/bepumi/matching/detail.jsp").forward(request, response);
		
	}
}
