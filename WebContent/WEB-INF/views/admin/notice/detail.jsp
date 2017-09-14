<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../../css/style2.css" type="text/css" rel="stylesheet">
<link href="../../css/admin.css" type="text/css" rel="stylesheet">
<title>베:품</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<main id="main" class="main">

			<div class="detail-container">
				<div class="info-container">
					<div class="tr-info clearfix">
						<span class="title">${b.title}</span> <span class="reg-date">${b.regDate}</span>
					</div>
					<div class="wch-info clearfix">
						<span class="writer">${b.writerId}</span>
						<div class="ch-wrapper">
							<span class="comment-num">조회수</span> <span class="hit">${b.hit}</span>
						</div>
					</div>
				</div>
				<div class="detail-content">
					${fn:replace(b.content, cn, br)}
				</div>
				<div>
					<a href="list" class="btn">목록</a>
					<div class="ed-wrapper">
						<a href="edit?no=${b.no}" class="btn">수정</a>
						<a href="del?no=${b.no}" class="btn">삭제</a>
					</div>
				</div>
				
			</div>
			</main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>