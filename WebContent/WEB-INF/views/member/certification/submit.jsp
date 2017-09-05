<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<div class="req-progress present">
						<p class="step">3단계</p>
						<p>서류 제출</p>
					</div>
					<div class="req-progress">
						<p class="step">4단계</p>
						<p>신청 완료</p>
					</div>
				</div>
			</div>
			<div class="identify-container">
				
				서류제출 부분
				
				<div class="agree-btn-container">
					<a href="certification-complete">다음</a>
				</div>
				<script>
				
				</script>
			</div>
			</main>
		</div>
	</div>

	<!--  footer 집중화 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>