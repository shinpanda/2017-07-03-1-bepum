<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/board.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-container">
			<main id="main" class="main">

			<h3>문의게시판</h3>
			<div class="table-container">
				<div class="table-wrapper">
					<div class="board-table">
						<div class="row table-header">
							<div class="cell no">no</div>
							<div class="cell title">제목</div>
							<div class="cell writer-id">글쓴이</div>
							<div class="cell reg-date">작성날짜</div>
							<div class="cell hit">조회수</div>
						</div>
										
						<c:forEach var="n" items="${list}" begin="0" end="14">					
						<div class="row">
							<div class="cell no">${n.no}</div>
							<div class="cell title title-content"><a href="./question-detail?no=${n.no}">${n.title}</a></div>
							<div class="cell writer-id">${n.writerId}</div>
							<div class="cell reg-date">${n.regDate}</div>
							<div class="cell hit">${n.hit}</div>
						</div>
						</c:forEach>
					</div>
				</div>
				<div class="btn reg-btn">
				<a href="./question-reg">쓰기</a>
			</div>
			</div>
			</main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>