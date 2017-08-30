<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- 신청자 결제요청 세부페이지 -->

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
				<form>
					<div class="member rb-container">
						<div class="member req-date">
							<span class="date-title">매칭 신청일</span>
							<span>2017월 7월 14일</span>
						</div>
						<div class="member bepum-date">
							<span class="date-title">돌보미 날짜</span>
							<div class="behpum-time">
							<span class="start-time">2017년 7월 15일 10시</span> > <span class="end-time">2017년 7월 15일 16일</span>
							</div>
						</div>
					</div>
					
					<div class="member ongoing-bottom">
						<div class="member pay-info-container">
							<h3>결제 요청</h3>
							<div class="pay-info-table">
								<div class="row">
									<div class="cell th">총 금액</div>
									<div class="cell td">\60,000</div>
								</div>
									<div class="row">
									<div class="cell th">결제 방법</div>
									<div class="cell td">무통장 입금</div>
								</div>
									<div class="row">
									<div class="cell th">계좌</div>
									<div class="cell td">국민은행 524901-01-456123</div>
								</div>
							</div>
						</div>
						<div class="member baby-info-container">
							<h3>아기정보</h3>
							<div class="member baby-info-table">
								<div class="row">
									<div class="cell th">이름</div>
									<div class="cell td">아이</div>
								</div>
								<div class="row">
									<div class="cell th">나이</div>
									<div class="cell td">26개월</div>
								</div>
								<div class="row">
									<div class="cell th">성별</div>
									<div class="cell td">남아</div>
								</div>
							</div>
						</div>
					</div>
				
				
					<input type="submit" class="btn pay-btn" value="결제하기"/>
				</form>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>