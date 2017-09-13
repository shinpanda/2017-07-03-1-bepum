package com.bepum.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.el.fmt.ParseDateTag;

import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.entity.Member;

@WebServlet("/member/sign")
public class SignController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();

		request.setAttribute("uri", uri);
		request.getRequestDispatcher("/WEB-INF/views/member/sign.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int result =0;
		int grade = 000;
		int count = 0;
		String _id = request.getParameter("id");
		String _name = request.getParameter("name");
		String _pwd = request.getParameter("pw");
		String _gender = request.getParameter("gender");
		String _birth="";
		String birthday_year = request.getParameter("birthday_year");
		String birthday_month = request.getParameter("birthday_month");
		String birthday_day = request.getParameter("birthday_day");
		String _email = request.getParameter("email");
		
		
		if(birthday_year != null && !birthday_year.equals("") 
				&&birthday_month != null && !birthday_month.equals("") 
				&&birthday_day != null && !birthday_day.equals(""))
			_birth = birthday_year+"-"+birthday_month+"-"+birthday_day;

		String id="";
		String name="";
		String pwd="";
		String gender="";
		String birth="";
		String email="";

		if(_id != null && !_id.equals("")) {
			id =_id;
			count++;
			}
		if(_name != null && !_name.equals("")) {
			name =_name;
			count++;
		}
		if(_pwd != null && !_pwd.equals("")) {
			pwd =_pwd;
			count++;
		}
		if(_gender != null && !_gender.equals("")) {
			gender =_gender;
			count++;
		}
		if(_birth != null && !_birth.equals("")) {
			birth =_birth;
			count++;
		}
		if(_email != null && !_email.equals("")) {
			email =_email;
			count++;
		}
		//System.out.println(id+", "+name+", "+pwd+", "+Integer.parseInt(gender)+", "+birth+", "+email+", "+grade);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDao memberDao = new JdbcMemberDao();
		
		Member member = new Member(id, name, pwd, Integer.parseInt(gender), birth, email, grade, new Date());
		if(count >= 6)
			result = memberDao.insert(member);
		
		if(result>0) {
			out.println("<script>alert('베품에 회원가입이 완료되었습니다.로그인후 이용해주세요.');location.href='sign';</script>");
		}else {
			out.println("<script>alert('회원가입 실패하였습니다. 다시 시도해 주세요');history.go(-1);</script>");
		}
		
	}
}
