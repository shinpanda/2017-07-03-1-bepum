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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<main id="main" class="main">
				<jsp:include page = "detail-top.jsp" />
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>