package com.bepum.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.dao.BoardDao;
import com.bepum.web.dao.MemberDao;
import com.bepum.web.dao.jdbc.JdbcBoardDao;
import com.bepum.web.dao.jdbc.JdbcMemberDao;
import com.bepum.web.entity.Member;
import com.bepum.web.entity.Profile;

@WebServlet("/admin/member/member-detail")
public class MemberDetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   
	      String _id= request.getParameter("id");        
	            
	      String id = "";
	     
	      if (_id != null && !_id.equals(""))
	         id = _id;
	      
	      
	   
	      MemberDao  dao = new JdbcMemberDao();
	      
	      
	     Member m = dao.get(id);
	      
	   /*   List<Notice> list = null;*/
	    
	      request.setAttribute("member", m);
		
		request.getRequestDispatcher("/WEB-INF/views/admin/member/detail.jsp").forward(request, response);
	}

}
