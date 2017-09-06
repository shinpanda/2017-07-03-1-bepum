package com.bepum.web.controller.bepumi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/bepumi/profile-reg")
public class BepumiProfileRegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		String saveDirectory = "C:\\dev\\upload";
		int maxPostSize = 1024*1024*10;// 10MB 
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());
		
		String _pay = multi.getParameter("pay");
		String _profileImg = multi.getParameter("profile-img");
		System.out.println(_pay);
		String _homePhoto1 = multi.getParameter("home-photo1");
		String _homePhoto2 = multi.getParameter("home-photo2");
		String _homePhoto3 = multi.getParameter("home-photo3");

		String[] bepumiDays = multi.getParameterValues("bepumi-day");

		String bepumiDay = "";
		if (multi.getParameter("bepumi-day") != null) {
			for (int i = 0; i < bepumiDays.length; i++) {
				if (bepumiDays[i] != null)
					if (bepumiDay=="")
						bepumiDay += bepumiDays[i];
					else
						bepumiDay += ", " + bepumiDays[i];
			}
		}
		System.out.println(bepumiDay);

		String _startTime = multi.getParameter("start-time");
		String _endTime = multi.getParameter("end-time");

		String others = multi.getParameter("others");
		String selfIntro = multi.getParameter("self-intro");

		response.sendRedirect("profile");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* response.sendRedirect("notice.jsp"); */
		ProfileDao dao = new JdbcProfileDao();

		request.setAttribute("profile", dao.get());

		request.getRequestDispatcher("/WEB-INF/views/bepumi/profile/reg.jsp").forward(request, response);

	}
}
