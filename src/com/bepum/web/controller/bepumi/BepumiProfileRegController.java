package com.bepum.web.controller.bepumi;

import java.io.File;
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
		
		String saveDirectory = request.getSession().getServletContext().getRealPath("/upload/profilePic");
		System.out.println(saveDirectory);
		int maxPostSize = 1024*1024*5;// 5MB 
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", new DefaultFileRenamePolicy());

		
		String pay = multi.getParameter("pay");
		
		String profileImg = multi.getFilesystemName("profile-img");
		int profileImgSize = (int)(new File(saveDirectory+"/"+profileImg).length());
		
		
		String homePhoto1 = multi.getFilesystemName("home-photo1");
		String homePhoto2 = multi.getFilesystemName("home-photo2");
		String homePhoto3 = multi.getFilesystemName("home-photo3");
		int homePhoto1Size = (int)(new File(saveDirectory+"/"+homePhoto1).length());
		int homePhoto2Size = (int)(new File(saveDirectory+"/"+homePhoto2).length());
		int homePhoto3Size = (int)(new File(saveDirectory+"/"+homePhoto3).length());
		

		String[] bepumDays = multi.getParameterValues("bepumi-day");

		String bepumDay = "";
		if (multi.getParameter("bepumi-day") != null) {
			for (int i = 0; i < bepumDays.length; i++) {
				if (bepumDays[i] != null)
					if (bepumDay=="")
						bepumDay += bepumDays[i];
					else
						bepumDay += ", " + bepumDays[i];
			}
		}

		String startTime = multi.getParameter("start-time");
		String endTime = multi.getParameter("end-time");

		String others = multi.getParameter("others");
		String selfIntro = multi.getParameter("self-intro");
		
		
		/*if (startTime != null && !(startTime.equals("")) && endTime != null && !(endTime.equals("")))*/
			
		ProfileDao dao = new JdbcProfileDao();
		
		int result = dao.insert(others, selfIntro, bepumDay, startTime, endTime,
				profileImg, homePhoto1, homePhoto2, homePhoto3, pay);

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
