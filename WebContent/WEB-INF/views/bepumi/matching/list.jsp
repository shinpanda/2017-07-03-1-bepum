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
			<h3>매칭 내역</h3>
			<div class="table-container">
				<div class="list-arr">
					<nav>
						<ul>
							<li>매칭 진행</li>
							<li>매칭 신청</li>
							<li>과거 매칭</li>
						</ul>
					</nav>
				</div>
				<div class="table-wrapper">
					<div class="board-table">
						<div class="table-header">
							<div class="cell no">no</div>
							<div class="cell request-id">아이디</div>
							<div class="cell request-name">이름</div>
							<div class="cell grade">돌보미 등급</div>
							<div class="cell req-date">신청일</div>
							<div class="cell bepum-time">시간</div>
							<div class="cell status">매칭 상태</div>
						</div>

						<c:forEach begin="0" end="14" varStatus="status">
							<div class="row">
								<div class="cell no">${status.current}</div>
								<div class="cell request-id">testid</div>
								<div class="cell request-name">권다영</div>
								<div class="cell grade">돌보미</div>
								<div class="cell req-date">2017.07.08</div>
								<div class="cell bepum-time">09:00 ~ 18:00</div>
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