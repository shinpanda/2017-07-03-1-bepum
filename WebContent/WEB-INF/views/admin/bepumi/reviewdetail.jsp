<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../../css/admin.css" type="text/css" rel="stylesheet" />
<link href="../css/board.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<main id="main" class="main">
				
				<div class="content-container" style="width: inherit;">
			<main id="main"  style="width: 95%;">

			<div class="detail-container">
				<div class="info-container">
					<div class="tr-info clearfix">
						<span class="title">[ ${b.bepumiID} 님과의 매칭 ] - ${b.title}</span> 
						<div class="reg-date date-wrapper">
							<span>배품 날짜 ${b.bepumDate}</span>
							<span><fmt:formatDate value="${b.regDate}" pattern="YY-MM-dd HH:MM"
												var="regDate" />작성일 ${regDate}</span>
						</div>
					</div>
					<div class="wch-info clearfix">
						<span class="writer">${b.writerID}</span>
						<div class="ch-wrapper">
								
							<%-- <span class="comment-num">댓글 수 ${b.countCmt} </span>  --%><span
								class="hit">조회수 ${b.hit}</span>
						</div>
					</div>
					<div class="detail-content">${fn:replace(b.content, cn, br)}
					</div>
					<div>
						<a href="review" class="btn">목록</a>
					</div>
				</div>
			</div>
			</main>
		</div>
				
				
				
				
				
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>