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
<title>베품</title>
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
					<div class="req-progress present">
						<p class="step">1단계</p>
						<p>약관동의</p>
					</div>
					<div class="req-progress">
						<p class="step">2단계</p>
						<p>전화번호 인증</p>
					</div>
					<div class="req-progress">
						<p class="step">3단계</p>
						<p>서류 제출</p>
					</div>
					<div class="req-progress">
						<p class="step">4단계</p>
						<p>신청 완료</p>
					</div>
				</div>
			</div>
			<div class="agreement-container">
				<div class="bepumi-agreement">
					<div class="agree-title">
						<span>아이돌보미 신청약관(필수)</span>
						<div class="check-container">
							<input type="checkbox" name="agr-btn" id="agr-btn1">
						</div>
					</div>
					<div class="agreement-content"></div>
				</div>
				<div class="bepumi-agreement">
					<div class="agree-title">
						<span>개인정보 이용 동의(필수)</span>
						<div class="check-container">
							<input type="checkbox" name="agr-btn" id="agr-btn1">
						</div>
					</div>
					<div class="agreement-content"></div>
				</div>
				<div class="bepumi-agreement">
					<div class="agree-title">
						<span>개인정보 제 3자 제공 동의(필수)</span>
						<div class="check-container">
							<input type="checkbox" name="agr-btn" id="agr-btn1">
						</div>
					</div>
					<div class="agreement-content"></div>
				</div>
				<div class="agree-btn-container">
					<p>전체동의</p>
					<a href="">다음</a>
				</div>
			</div>
			</main>
		</div>
	</div>

	<!--  footer 집중화 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>