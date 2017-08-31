<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/matching.css" type="text/css" rel="stylesheet">
<title>베품</title>
<!-- 요청, 진행 중, 과거 매칭 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">
		<div class="content-container">
			<main id="main" class="main">			
			<h3>매칭 진행 현황</h3>

			<div class="matching-progress-container">
				<div class="matching-progress-wrapper">
					<div class="matching-progress step1-container">
						<div class="step-wrapper">
							<p class="step">매칭 신청</p>
							<p>매칭 접수 단계</p>
						</div>
					</div>
					<div class="matching-progress step2-container">
						<div class="step-wrapper">
							<p class="step">승인 중</p>
							<p>관리자 및 돌보미 승인 단계</p>
						</div>
					</div>
					<div class="matching-progress step3-container">
						<div class="step-wrapper">
							<p class="step">결제 확인</p>
							<p>결제 확인 단계</p>
						</div>
					</div>
					<div class="matching-progress step4-container">
						<div class="step-wrapper">
							<p class="step">매칭 진행</p>
							<p>승인 후 매칭 진행단계</p>
						</div>
					</div>
					<div class="matching-progress step5-container">
						<div class="step-wrapper">
							<p class="step">매칭 완료</p>
							<p>매칭 완료 단계</p>
						</div>
					</div>
				</div>
			</div>
			<script>
				$(".matching-progress").click(function(){
					$(this).siblings().removeClass("present");
					$(this).addClass("present");
				});
			</script>
			
			
			<div class="table-container">
				<div class="table-wrapper">
					<div class="board-table">
						<div class="table-header">
							<div class="cell no">no</div>
							<div class="cell request-id">아이디</div>
							<div class="cell request-name">돌보미 이름</div>
							<div class="cell grade">돌보미 등급</div>
							<div class="cell bepum-day">날짜</div>
							<div class="cell bepum-time">시간</div>
							<div class="cell req-date">신청일</div>
							<div class="cell status">매칭 상태</div>
						</div>

						<c:forEach begin="1" end="15" varStatus="status">
							<div class="row">
								<div class="cell no">${status.current}</div>
								<div class="cell request-id">
									<a href="matching-detail?no=${status.current}">testid</a>
								</div>
								<div class="cell request-name">권다영</div>
								<div class="cell grade">돌보미</div>
								<div class="cell bepum-day">2017.07.25</div>
								<div class="cell bepum-time">09:00 ~ 18:00</div>
								<div class="cell req-date">2017.07.08</div>
								<div class="cell status">신청 대기</div>
							</div>
						</c:forEach>
					</div>
					<div></div>
				</div>
			</div>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>