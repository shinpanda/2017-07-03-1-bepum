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

@WebServlet("/bepumi/profile-edit")
public class BepumiProfileEditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String saveDirectory = request.getRealPath("/upload/profilePic");
		System.out.println(saveDirectory);
		int maxPostSize = 1024 * 1024 * 5;// 5MB
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String pay = multi.getParameter("pay");

		String profileImg = multi.getFilesystemName("profile-img");
		String originprofileImg = multi.getParameter("originpp");

		String originHomePhoto1 = multi.getParameter("originhome1");
		String originHomePhoto2 = multi.getParameter("originhome2");
		String originHomePhoto3 = multi.getParameter("originhome3");

		String homePhoto1 = multi.getFilesystemName("home-photo1");
		String homePhoto2 = multi.getFilesystemName("home-photo2");
		String homePhoto3 = multi.getFilesystemName("home-photo3");

		String[] bepumDays = multi.getParameterValues("bepumi-day");

		if(originprofileImg != null && profileImg == null) {
			profileImg = originprofileImg;
		}
		
		if(originHomePhoto1 != null && homePhoto1 == null) {
			homePhoto1 = originHomePhoto1;
		}
		
		if(originHomePhoto2 != null && homePhoto2 == null) {
			homePhoto2 = originHomePhoto2;
		}
		
		if(originHomePhoto3 != null && homePhoto3 == null) {
			homePhoto3 = originHomePhoto3;
		}
		
		
		String bepumDay = "";
		if (multi.getParameter("bepumi-day") != null) {
			for (int i = 0; i < bepumDays.length; i++) {
				if (bepumDays[i] != null)
					if (bepumDay == "")
						bepumDay += bepumDays[i];
					else
						bepumDay += ", " + bepumDays[i];
			}
		}

		String startTime = multi.getParameter("start-time");
		String endTime = multi.getParameter("end-time");

		String others = multi.getParameter("others");
		String selfIntro = multi.getParameter("self-intro");

		/*
		 * if (startTime != null && !(startTime.equals("")) && endTime != null &&
		 * !(endTime.equals("")))
		 */

		ProfileDao dao = new JdbcProfileDao();

		int result = dao.update(others, selfIntro, bepumDay, startTime, endTime, profileImg, homePhoto1, homePhoto2,
				homePhoto3, pay);

		response.sendRedirect("profile");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProfileDao dao = new JdbcProfileDao();
		String saveDirectory = request.getRealPath("/upload/profilePic");
		System.out.println(saveDirectory);
		request.setAttribute("profile", dao.get());
		request.setAttribute("br", "<br/>");
		request.setAttribute("cn", "\n");

		/* response.sendRedirect("notice.jsp"); */
		request.getRequestDispatcher("/WEB-INF/views/bepumi/profile/edit.jsp").forward(request, response);

	}
}
