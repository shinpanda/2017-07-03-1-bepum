<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

			<h3>자유게시판</h3>
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
							<div class="cell no">${n.id} </div>
							<div class="cell title"><a href="./notice-detail?no=${n.id}">${n.title}</a></div>
							<div class="cell writer-id">권다영</div>
							<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
									<fmt:parseNumber value="${now.time}" integerOnly="true"
										var="today" />
									<fmt:parseNumber value="${n.regDate.time}"
										integerOnly="true" var="regDateNum" />
									<div class="cell reg-date">
										<c:if test="${((today - regDateNum)/(1000*60*60*24)) < 1}">
											<fmt:formatDate value="${n.regDate}" pattern="HH:MM"
												var="regDate" />
														${regDate}
													</c:if>
										<c:if test="${((today - regDateNum)/(1000*60*60*24)) >= 1}">
											<fmt:formatDate value="${n.regDate}" pattern="YY-MM-dd"
												var="regDate" />
														${regDate}
													</c:if>
									</div>
							<div class="cell hit">${n.hit}</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>
			</main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>