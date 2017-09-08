<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>  
<%
	String uploadPath=request.getRealPath("/upload/certification");
	//getServletContextPath().getRealPath("upload");
	System.out.print("realPath:"+uploadPath);
	int size=10*1024*1024;
/* 	String name="";
	String subject=""; */
	
	String fileName1=""; //중복처리후 (가져올 땐 이 이름의 파일을 가져와야되고)
	String originalName1=""; //중복처리 전 원본 (사용자한테 파일이름 띄울 땐 이거 띄우기)
	
	String fileName2="";
	String originalName2="";
	
	String fileName3="";
	String originalName3="";
	
	String fileName4="";
	String originalName4="";
	
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
		fileName1 = multi.getFilesystemName(file1);		
		//multi에서 알고있는 (파일)원본이름을 file1을 통해서 알아낸다.
		originalName1 = multi.getOriginalFileName(file1);
		
		
		fileName2= multi.getFilesystemName(file3);
		originalName2=multi.getOriginalFileName(file3);		
		
		fileName3= multi.getFilesystemName(file3);
		originalName3=multi.getOriginalFileName(file3);	
		
		fileName4= multi.getFilesystemName(file4);
		originalName4=multi.getOriginalFileName(file4);	
		
		}catch(Exception e){
			out.print(e.getMessage());
			System.out.print("파일 업로드 문제 발생: "+e.getMessage()); //로그 기록
		
	}
 %>       



<!DOCTYPE html>
<html>
<!-- 약관동의	 -->
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/certification.css" type="text/css" rel="stylesheet" />
<title>베:품</title>
</head>

<body>
	<!-- 헤더집중화 -->
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-container">

			<main class="main">
			<h3>자격 심사 신청</h3>
			<div class="req-progress-container">
				<div class="req-progress-wrapper">
					<div class="req-progress">
						<p class="step">1단계</p>
						<p>약관동의</p>
					</div>
					<div class="req-progress">
						<p class="step">2단계</p>
						<p>본인 인증</p>
					</div>
					<div class="req-progress">
						<p class="step">3단계</p>
						<p>서류 제출</p>
					</div>
					<div class="req-progress present">
						<p class="step">4단계</p>
						<p>신청 완료</p>
					</div>
				</div>
			</div>
			<div class="complete-container">
				<h3>신청이 완료되었습니다</h3>
				
				<p>본 회원의 돌보미 자격 신청이 완료되었으며, 심사 완료 후 돌보미로 활동하실 수 있게 됩니다.</p>
				<p>심사 진행 상황을 확인해주세요.</p>
				
				<div class="agree-btn-container"><a href="certification-progress">심사 진행창으로 이동</a></div>
			</div>
			</main>
		</div>
	</div>

	<!--  footer 집중화 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>