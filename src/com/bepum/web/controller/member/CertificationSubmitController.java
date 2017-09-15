package com.bepum.web.controller.member;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bepum.web.dao.BepumiRequestDao;
import com.bepum.web.dao.MemberRoleDao;
import com.bepum.web.dao.jdbc.JdbcBepumiRequestDao;
import com.bepum.web.dao.jdbc.JdbcMemberRoleDao;
import com.bepum.web.entity.BepumiRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/certification-submit")
public class CertificationSubmitController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object _id = session.getAttribute("id");
		
		if(_id == null) {
			
		}else {
			String id = _id.toString();
			
			MemberRoleDao roleDao = new JdbcMemberRoleDao();
			int grade = roleDao.getRole(id);
				
			request.setAttribute("grade", grade);
			
			if (grade > 0)
			{
				BepumiRequestDao dao = new JdbcBepumiRequestDao();
				request.setAttribute("brDoc", dao.get(id));
			}
			
			//String uri  = request.getRequestURI();
			request.getRequestDispatcher("/WEB-INF/views/member/certification/submit.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uploadPath=request.getSession().getServletContext().getRealPath("/upload/certification");
		//getServletContextPath().getRealPath("upload");
		System.out.print("realPath:"+uploadPath);
		int size=50*1024*1024;
	/* 	String name="";
		String subject=""; */
		
		String applicationFormCopy=""; //중복처리후 (가져올 땐 이 이름의 파일을 가져와야되고)
		String applicationForm=""; //중복처리 전 원본 (사용자한테 파일이름 띄울 땐 이거 띄우기)
		
		String HCCopy="";
		String HC="";
		
		String FRCCopy="";
		String FRC="";
		
		String VCCopy="";
		String VC="";

		
		MultipartRequest multi = null;
		
		try{
			multi=new MultipartRequest(
					request,
					uploadPath,
					size,
					"utf-8",
					new DefaultFileRenamePolicy()
					);
			
	/* 		name=multi.getParameter("name");
			subject=multi.getParameter("subject"); */
			
			//첨부파일 여러개 가져온다.
			Enumeration files= multi.getFileNames();
			
			//파일의 이름만 가져온다.->전송받은 이름
			String file1 = (String)files.nextElement();
			String file2=(String)files.nextElement();
			String file3=(String)files.nextElement();
			String file4=(String)files.nextElement();
			
			//multi에서 해당 이름을 알려주고 실제 시스템상의 이름을 알아낸다.
			applicationFormCopy = multi.getFilesystemName(file1);		
			//multi에서 알고있는 (파일)원본이름을 file1을 통해서 알아낸다.
			applicationForm = multi.getOriginalFileName(file1);

			FRCCopy= multi.getFilesystemName(file2);
			FRC=multi.getOriginalFileName(file2);	
			
			HCCopy= multi.getFilesystemName(file3);
			HC=multi.getOriginalFileName(file3);		
			
			
			
			VCCopy= multi.getFilesystemName(file4);
			VC=multi.getOriginalFileName(file4);
			
			if(applicationFormCopy == null)
			{
				applicationForm = "";
				applicationFormCopy = "";
			}
			
			if(HCCopy == null)
			{
				HC = "";
				HCCopy = "";
			}
			
			if(FRCCopy == null)
			{
				FRC = "";
				FRCCopy = "";
			}
			if(VCCopy == null)
			{
				VC = "";
				VCCopy = "";
			}
			
			BepumiRequestDao dao = new JdbcBepumiRequestDao();
			
			HttpSession session = request.getSession();
			Object _id = session.getAttribute("id");
			String reqID = _id.toString();
			
			String _grade = multi.getParameter("grade");
			int grade = 0;
			if(_grade != null && !_grade.equals("")) {
				grade = Integer.parseInt(_grade);
				
				if(grade > 0) {
					String applicationFormStatus = "제출 완료";
					String HCStatus = "제출 완료"; 
					String FRCStatus = "제출 완료"; 
					String VCStatus = "제출 완료"; 
					
					if(applicationFormCopy.equals("")) {
						applicationForm = multi.getParameter("application-orgin");
						applicationFormCopy = multi.getParameter("application-orgin-after");
						applicationFormStatus = multi.getParameter("application-orgin-status");
					}
					if(FRCCopy.equals("")) {
						FRC = multi.getParameter("frc-orgin");
						FRCCopy = multi.getParameter("frc-orgin-after");
						FRCStatus = multi.getParameter("frc-orgin-status");
					}
					if(HCCopy.equals("")) {
						HC = multi.getParameter("hc-orgin");
						HCCopy = multi.getParameter("hc-orgin-after");
						HCStatus = multi.getParameter("hc-orgin-status");
					}
					if(VCCopy.equals("")) {
						VC = multi.getParameter("vc-orgin");
						VCCopy = multi.getParameter("vc-orgin-after");
						VCStatus = multi.getParameter("vc-orgin-status");
					}
					
					int result = dao.updateDoc(reqID, applicationFormCopy,applicationForm,HCCopy,HC,FRCCopy,FRC,VCCopy,VC, applicationFormStatus, HCStatus, FRCStatus, VCStatus);
				}
			} else {
				int result = dao.insert(reqID, applicationFormCopy,applicationForm,HCCopy,HC,FRCCopy,FRC,VCCopy,VC);
			}
			}catch(Exception e){
				System.out.print(e.getMessage());
				System.out.print("파일 업로드 문제 발생: "+e.getMessage()); //로그 기록			
		}
		response.sendRedirect("certification-complete");
	}
	
}
