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

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;
import com.bepum.web.entity.Profile;

@WebServlet("/bepumi/profile")
public class BepumiProfileDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.sendRedirect("notice.jsp");*/
		
		ProfileDao dao = new JdbcProfileDao();

		request.setAttribute("isProfile", dao.getIsProfile());
		request.setAttribute("profile", dao.get());
		
		request.getRequestDispatcher("/WEB-INF/views/bepumi/profile/detail.jsp").forward(request, response);
		
	}
}
