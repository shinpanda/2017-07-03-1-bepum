<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/matching.css" type="text/css" rel="stylesheet">
<title>베:품</title>
<!-- 신청자 매칭목록 세부페이지 (1. 결제요청 직전) -->
<!--  신청자 매칭목록 세부페이지 (3. 매칭완료된거에 후기작성)  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">
		<div class="content-container">
			<main id="main" class="main">
				<jsp:include page = "detail-top.jsp" />
				
				<c:if test="${profile.status.equals('결제대기') || status.equals('결제완료')}">
					<jsp:include page = "detail-bottom-pay.jsp" />
				</c:if>
				<c:if test="${profile.status.equals('매칭완료')}">
					<jsp:include page = "detail-bottom.jsp" />
				</c:if>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>