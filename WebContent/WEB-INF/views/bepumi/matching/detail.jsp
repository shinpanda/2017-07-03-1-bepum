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
			<main id="main" class="main"> <jsp:include
				page="detail-top.jsp" /> <jsp:include page="detail-bottom.jsp" />
			<div class="bm btn-container">
				<c:if test="${profile.status.equals('신청대기')}">
					<form method="post">
						<input type="submit" name="ok-btn" value="승인" class="btn" /> <input
							type="submit" name="ok-btn" value="거절" class="btn" />
					</form>
				</c:if>
			</div>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>