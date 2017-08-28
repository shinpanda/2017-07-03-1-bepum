<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/profile.css" type="text/css" rel="stylesheet">
<title>베품</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
</head>

<body>
	<jsp:include page="../inc/header.jsp"></jsp:include>
	<div id="body">
		
		<main id="main">
		<div class="bg-profile-header">
			<div class="content-container">
				<div class="btn-header">
					<button type="submit" onclick="">비공개</button>
					<a href="./profile-edit" id="edit">수정</a>
				</div>
				<div class="bepum-definite-wrapper">
					<p>
						희망 시급 : <span>8000</span> 원
					</p>

				</div>
			</div>
		</div>
		<div class="content-container">
			<div class="profile-member-container">
				<div class="profile-member-wrapper">
					<img src="../images/profile.jpg" id="profile-photo" alt="프로필 사진">
					<p id="name">홍길동</p>
					<p id="address">서울 강서구</p>
					<p id="grade">일반 베푸미</p>
					<p id="contact">010-2222-2222</p>
				</div>
			</div>
			<div class="home-photo-container">
				<h3>집 사진</h3>
				<div class="home-photo-wrapper">
					<!--집사진 3개-->
					<div class="home-photo"></div>
					<div class="home-photo"></div>
					<div class="home-photo"></div>
				</div>
			</div>

			<div class="time-table">
				<h3>가능 시간</h3>
				<div class="bepumi-day">
					<span class="Mon">월</span>
					<span class="Tue">화</span> 
					<span class="Wed">수</span> 
					<span class="Thu">목</span> 
					<span class="Fri">금</span>
					<span class="Sat">토</span> 
					<span class="Sun">일</span>
				</div>
				<p class="bepumi-time">
					<span>9:00</span> ~ <span>18:00</span>
				</p>
			</div>
			<div class="table-contatiner">
				<h3>소개</h3>
				<div class="table-wrapper">
					<div class="intro-table">
						<div class="row">
							<div class="cell1">기타사항</div>
							<div class="cell2" style="">
								운전 가능<br> 요리 능숙<br> 시간 협의 가능
							</div>
						</div>
						<div class="row">
							<div class="cell1">자기소개서</div>
							<div class="cell2">
								유치원 및 초등학교 급식 조리사로 오랫동안 근무했으며<br> 근래까지 예쁜 아가들을 돌봐왔답니다.<br>
								도움이 필요하시면 정성을 다해서 돌보겠습니다.

							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="chart-container">
				<h3>매칭</h3>
				<div class="chart-wrapper">
					<!-- 매칭 요청률 -->
					<div class="chart-wrapper-default request-chart-wrapper">
						<div class="chart-default bepumi-request-chart">
							<div class="chart1"></div>
							<div class="chart2"></div>
							<div class="chart-center">
								<span>50%</span>
							</div>
						</div>
						<p class="chart-name">매칭 요청률</p>
					</div>
					<div class="chart-wrapper-default success-chart-wrapper">
						<!-- 매칭 성공률 -->
						<div class="chart-default bepumi-success-chart">
							<div class="chart1"></div>
							<div class="chart2"></div>
							<div class="chart-center">
								<span>75%</span>
							</div>
						</div>
						<p class="chart-name2">매칭 성공률</p>
					</div>
				</div>
			</div>
			<script>
				var setChart = function(c, per, color) {
					var c_name = '.' + c;
					if (per >= 50) {
						var d = (per / 100 * 360) - 90;
						$(c_name).find(".chart1").css({
							"background" : color
						});
						$(c_name).find(".chart2").css({
							"transform" : "rotate(" + d + "deg)",
							"background" : color
						});
					} else {
						var d = ((per + 50) / 100 * 360) - 90;
						$(c_name).find(".chart1").css({
							"background" : color
						});
						$(c_name).find(".chart2").css({
							"transform" : "rotate(" + d + "deg)",
							"background" : "#a2a2a2"
						});
					}
					$(c_name).find(".chart-center").children("span").text(
							per + "%");

				};
				setChart("bepumi-request-chart", 50, "#85DDC8");
				setChart("bepumi-success-chart", 75, "#cba9e2");
			</script>
		</div>
		
		</main>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>