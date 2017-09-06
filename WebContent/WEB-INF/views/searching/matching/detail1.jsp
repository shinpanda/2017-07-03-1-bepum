<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- 신청자 매칭목록 세부페이지 (1. 결제요청 직전) -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/matching.css" type="text/css" rel="stylesheet">
<title>베품</title>
</head>
<body>
<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">
		<div class="content-container">
			<main id="main" class="main">
				<jsp:include page = "detail-top.jsp" />
				<jsp:include page = "detail-bottom-pay.jsp" />
			</main>
		</div>
	</div>
<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>