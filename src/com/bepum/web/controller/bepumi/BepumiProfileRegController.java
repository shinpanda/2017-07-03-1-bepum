package com.bepum.web.controller.bepumi;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.ProfileDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcProfileDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/bepumi/profile-reg")
public class BepumiProfileRegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _id = session.getAttribute("id");

		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String id = _id.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(id);

			if (role < 1)
				out.write("<script> alert('잘못된 요청입니다.'); history.back(); </script>");
			else {
				request.setCharacterEncoding("UTF-8");

				String saveDirectory = request.getSession().getServletContext().getRealPath("/upload/profilePic");
				System.out.println(saveDirectory);
				int maxPostSize = 1024 * 1024 * 5;// 5MB
				MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8",
						new DefaultFileRenamePolicy());

				String pay = multi.getParameter("pay");

				String profileImg = multi.getFilesystemName("profile-img");
				int profileImgSize = (int) (new File(saveDirectory + "/" + profileImg).length());

				String homePhoto1 = multi.getFilesystemName("home-photo1");
				String homePhoto2 = multi.getFilesystemName("home-photo2");
				String homePhoto3 = multi.getFilesystemName("home-photo3");
				int homePhoto1Size = (int) (new File(saveDirectory + "/" + homePhoto1).length());
				int homePhoto2Size = (int) (new File(saveDirectory + "/" + homePhoto2).length());
				int homePhoto3Size = (int) (new File(saveDirectory + "/" + homePhoto3).length());

				String[] bepumDays = multi.getParameterValues("bepumi-day");

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

				int result = dao.insert(id, others, selfIntro, bepumDay, startTime, endTime, profileImg, homePhoto1,
						homePhoto2, homePhoto3, pay);

				response.sendRedirect("profile");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _id = session.getAttribute("id");

		if (_id == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String id = _id.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(id);

			if (role < 1)
				out.write("<script> alert('잘못된 요청입니다.'); history.back(); </script>");
			else {
				/* response.sendRedirect("notice.jsp"); */
				ProfileDao dao = new JdbcProfileDao();

				request.setAttribute("profile", dao.get(id));

				request.getRequestDispatcher("/WEB-INF/views/bepumi/profile/reg.jsp").forward(request, response);
			}
		}
	}
}
