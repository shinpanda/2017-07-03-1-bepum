package com.bepum.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiAdminDao;
import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.ReviewDao;
import com.bepum.web.dao.jdbc.JdbcBepumiAdminDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcReviewDao;
import com.bepum.web.entity.BepumiAdmin;
import com.bepum.web.entity.Member;
import com.bepum.web.entity.ReviewView;

@WebServlet("/admin/bepumi/detail")
public class BepumiDetailController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String _btnOtn = request.getParameter("gradeSbt");

		String btnOtn = "";
		if (_btnOtn != null && !_btnOtn.equals(""))
			btnOtn = _btnOtn;

		String _id = request.getParameter("reqId");

		String id = "";
		if (_id != null && !_id.equals(""))
			id = _id;

		MemberDao dao = new JdbcMemberDao();

		int result = 0;
		if (btnOtn.equals("Upgrade")) {
			result = dao.updateGrade(2, id);
		} else if (btnOtn.equals("Downgrade")) {
			result = dao.updateGrade(1, id);
		} else {

		}

		response.sendRedirect(request.getHeader("Referer"));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		Object _adminId = session.getAttribute("id");

		if (_adminId == null)
			out.write("<script> alert('로그인이 필요한 요청입니다.'); history.back(); </script>");
		else {
			String adminId = _adminId.toString();
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int role = roleDao.getRole(adminId);

			if (role == 999) {
				String _id = request.getParameter("id");

				String id = "";
				if (_id != null && !_id.equals(""))
					id = _id;

				MemberDao memberDao = new JdbcMemberDao();
				BepumiAdminDao bepumiDao = new JdbcBepumiAdminDao();

				BepumiAdmin b = bepumiDao.getRatingStatus(id);

				ReviewDao reviewDao = new JdbcReviewDao();
				List<ReviewView> list = reviewDao.getListByBepumi(id);

				Member m = memberDao.get(id);

				request.setAttribute("member", m);
				request.setAttribute("bepumi", b);
				request.setAttribute("reviewList", list);

				request.getRequestDispatcher("/WEB-INF/views/admin/bepumi/detail.jsp").forward(request, response);
			}
			else {
				out.write("<script> alert('잘못된 접근입니다.'); history.back(); </script>");
			}
		}
	}

}
