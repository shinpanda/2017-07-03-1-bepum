<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  
<%-- 
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>  
 --%>

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