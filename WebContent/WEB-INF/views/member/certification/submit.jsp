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
			

				<form action="certification-complete" method="post" enctype="Multipart/form-data">
					<div class="submit-table-container">
						<div class = "submit-table">
					<!-- 		<div class="row throw">
								<div class="cell th">서류</div>
								<div class="cell th">파일명</div>
								<div class="cell th">제출</div>
								</div> -->
							<div class="row">
								<div class="cell th">신청서</div>
								<div class="cell td">신청서이름.jpg</div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="application-form" name="application"/>
									<label for="application-form">파일찾기</label>
								</div>
							</div>
							<div class="row">
								<div class="cell th">가족관계증명서</div>
								<div class="cell td">신청서이름.jpg</div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="family-rc-form" name="family"/>
									<label for="family-rc-form">파일찾기</label>
								</div>
							</div>
							<div class="row">
								<div class="cell th">건강진단서</div>
								<div class="cell td">신청서이름.jpg</div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="hc-form" name="hc"/>
									<label for="hc-form">파일찾기</label>
								</div>
							</div>
							<div class="row">
								<div class="cell th">아이 예방접종 증명서</div>
								<div class="cell td">신청서이름.jpg</div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="baby-form" name="baby"/>
									<label for="baby-form">파일찾기</label>
								</div>
							</div>
						</div>
					</div>
						
						<input type="submit" value="다음" class="agree-btn-container"/>
					</form>	
					</main>
				</div>
			</div>

	<!--  footer 집중화 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>