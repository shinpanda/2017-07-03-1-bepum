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
			<h4 class="profile-title">${profile.id} 과 ${profile.bepumiID} 님과의 매칭</h4>
			<div class="profile-container">
				<div class="imgMsg-container">
					<div class="profile-img">
						<img src="../upload/profilePic/${profile.profilePic}"
							id="profile-img" alt="프로필 사진">
					</div>
					<div class="profile-btn-wrapper">
						<div class="btn-msg-container">
							<input type="button" class="btn msg-btn" alt="메세지 보내기" onclick="" />
						</div>
						<div class="btn-profile-container">
							<a href="../searching/detail-profile?id=${profile.id}"
								target="_blank" alt="프로필 상세보기"></a>
						</div>
					</div>
				</div>

				<div class="profile-detail">
					<div class="profile-detail-table">
						<div class="row">
							<div class="cell th">
								<b>매칭 상태</b>
							</div>
							<div class="cell td">
								<b>${profile.status}</b>
							</div>
						</div>
						<div class="row">
							<div class="cell th"></div>
							<div class="cell "></div>
						</div>
						<div class="row">
							<div class="cell th">이름</div>
							<div class="cell td">${profile.name}</div>
						</div>
						<c:if
							test="${!profile.status.equals('신청대기') && !status.equals('신청실패')}">
							<div class="row">
								<div class="cell th">연락처</div>
								<div class="cell td">${profile.phoneNum}</div>
							</div>
						</c:if>
						<div class="row">
							<div class="cell th">거주지</div>
							<div class="cell td">${profile.address}</div>
						</div>

						<c:set var="grade" value="베푸미" />
						<c:if test="${profile.grade == 2}">
							<c:set var="grade" value="슈퍼베푸미" />
						</c:if>

						<div class="row">
							<div class="cell th">등급</div>
							<div class="cell td">${grade}</div>
						</div>
					</div>
				</div>
			</div>

			<div class="member rb-wrapper">
				<div class="rb-container">
					<div class="req-date">
						<span class="date-title">매칭 신청일</span> <span>${profile.reqDate}</span>
					</div>
					<div class="bepum-date">
						<span class="date-title">돌보미 날짜</span>
						<div class="bepum-time">
							<span class="start-time">${profile.bepumDate}
								${profile.startTime} </span> > <span class="end-time">${profile.bepumDate}
								${profile.endTime}</span>
						</div>
					</div>
				</div>
			</div>
			<div class="req-info-container">
				<h3>요구사항</h3>
				<div class="req-container">${profile.requirement}</div>
			</div>

			<c:if
				test="${profile.status.equals('매칭완료')||profile.status.equals('결제완료')}">
				<div class="bepumi pay-info-container">
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
			</c:if>
			<div class="bepumi baby-info-container">
				<h3>아기정보</h3>
				<div class="baby-info-table">
					<div class="row">
						<div class="cell th">이름</div>
						<div class="cell td">${profile.babyName}</div>
					</div>
					<div class="row">
						<div class="cell th">나이</div>
						<div class="cell td">${profile.babyAge}세</div>
					</div>
					<div class="row">
						<div class="cell th">성별</div>
						<div class="cell td">
							<c:if test="${profile.babyGender==1}">남</c:if>
							<c:if test="${profile.babyGender==2}">여</c:if>
						</div>
					</div>
				</div>
			</div>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>
