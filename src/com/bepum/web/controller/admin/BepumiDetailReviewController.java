package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.ReviewDao;
import com.bepum.web.dao.jdbc.JdbcReviewDao;



@WebServlet("/admin/bepumi/reviewdetail")
public class BepumiDetailReviewController extends HttpServlet{
		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String no = request.getParameter("no");
			
			ReviewDao dao = new JdbcReviewDao();
			int result = dao.updateHit(no);
			request.setAttribute("b", dao.get(no));
			request.setAttribute("br", "<br/>");
			request.setAttribute("cn", "\n");
			

			/*response.sendRedirect("notice.jsp");*/
			request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/reviewdetail.jsp").forward(request, response);
			
		}
	}
