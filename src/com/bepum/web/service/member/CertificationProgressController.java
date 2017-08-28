package com.bepum.web.service.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/certification/progress")
public class CertificationProgressController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri  = request.getRequestURI();
		
		request.setAttribute("uri", uri);
		
		/*response.sendRedirect("notice.jsp");*/
		request.getRequestDispatcher("/WEB-INF/views/bepumi/profile/detail.jsp").forward(request, response);
		
	}
}





/*package com.bepum.web.service.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bepum.web.entity.Certification;

public class CertificationProgressController {

	// 화면이 로드될 때
	public List<Certification> getCertificationList() {
		return getCertificationList("");
	}
	
	public List<Certification> getCertificationList(String memId) {
		return getCertificationList(memId);
	}
	//상세정보
	public int getCertification(String type, String memId) {
		return getCertification(type, memId);
	}
	//신청서 제출&수정
	public int setApplication(String memId) {
		return 0;
	}
	// 건강진단서제출&수정
	public int setHc(String memId) {
		return 0;
	}
	//가족관계증명서제출&수정
	public int setFrc(String memId) {
		return 0;
	}

}*/


