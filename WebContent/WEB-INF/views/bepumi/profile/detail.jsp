<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/profile.css" type="text/css" rel="stylesheet">
<title>베품</title>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->

</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">

		<main id="main">
		<div class="bg-profile-header">
			<div class="content-container">
				<div class="btn-header">
					<form method = "post">
						<c:if test="${profile.secret == 0}">
							<button type="submit" name="sec-btn" value="secret" class="sec-btn">비공개</button>
						</c:if>
						<c:if test="${profile.secret == 1}">
							<button type="submit" name="sec-btn" value="open" class="sec-btn">공개</button>
						</c:if>
					</form>
					<c:if test="${isProfile == 0}">
						<div class="sec-btn"><a href="./profile-reg" class="edit">등록</a></div>
					</c:if>
					<c:if test="${isProfile != 0}">
						<div class="sec-btn"><a href="./profile-edit" class="edit">수정</a></div>
					</c:if>
				</div>
				<div class="bepum-definite-wrapper">
					<p>
						희망 시급 : <span>${profile.pay}</span> 원
					</p>

				</div>
			</div>
		</div>
		<div class="content-container">
			<div class="profile-member-container">
				<div class="profile-member-wrapper">
					<c:if test="${not empty profile.profilePic}">
					<img src="../upload/profilePic/${profile.profilePic}" id="profile-photo" alt="프로필 사진">
					</c:if>
					<c:if test="${empty profile.profilePic}">
					<img src="../images/profile1.png" id="profile-photo" alt="프로필 사진">
					</c:if>
					<p id="name">${profile.name}</p>
					<p id="address">${profile.address}</p>
					<c:set var="grade" value="회원" />
					<c:if test="${profile.grade == 1}">
						<c:set var="grade" value="베푸미" />
					</c:if>
					<c:if test="${profile.grade == 2}">
						<c:set var="grade" value="슈퍼베푸미" />
					</c:if>
					<p id="grade">${grade}</p>
					<p id="contact">${profile.phoneNum}</p>
				</div>
			</div>
			<div class="home-photo-container">
				<h3>집 사진</h3>
				<div class="home-photo-wrapper">
					<!--집사진 3개-->
					<div class="home-photo">
					<c:if test="${not empty profile.houseImg1}">
					<img src="../upload/profilePic/${profile.houseImg1}" alt ="집 사진 1" />
					</c:if>
					</div>
					<div class="home-photo">
					<c:if test="${not empty profile.houseImg2}">
					<img src="../upload/profilePic/${profile.houseImg2}" alt ="집 사진 2" />
					</c:if></div>
					<div class="home-photo">
					<c:if test="${not empty profile.houseImg3}"><img src="../upload/profilePic/${profile.houseImg3}" alt ="집 사진 3" /></c:if></div>
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
					
					<script>
						var str = '${profile.bepumDay}';
						var arr = [];
						var i = 0;
						while(str.indexOf(',') > 0){
							var index = str.indexOf(',');
							arr[i++] = str.substr(0, index);
							str = str.substr(index+2);
						}
						arr[i] = str;

						for(var index in arr){
							/* $('.'+arr[index]).addClass('on'); */
							document.querySelector('.'+arr[index]).classList.add('on');
						}
						
					</script>
				</div>
				<p class="bepumi-time">
					<span>${profile.strTime}</span> ~ <span>${profile.endTime}</span>
				</p>
			</div>
			<div class="table-container">
				<h3>소개</h3>
				<div class="table-wrapper">
					<div class="intro-table">
						<div class="row">
							<div class="cell1">기타사항</div>
							<div class="cell2">${fn:replace(profile.etc, cn, br)}
							</div>
						</div>
						<div class="row">
							<div class="cell1">자기소개</div>
							<div class="cell2">${fn:replace(profile.intro, cn, br)}</div>
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
								<span></span>
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
								<span></span>
							</div>
						</div>
						<p class="chart-name2">매칭 성공률</p>
					</div>
				</div>
			</div>
			<script>

				var setChart = function(c, per, color) {
					var c_name = '.' + c;
					var chartName = document.querySelector(c_name); 
					
					if (per >= 50) {
						var d = (per / 100 * 360) - 90;
						chartName.querySelector('.chart1').style.background = color;
						chartName.querySelector('.chart2').style.transform = "rotate(" + d + "deg)";
						chartName.querySelector('.chart2').style.background = color;
						/* $(c_name).find(".chart1").css({
							"background" : color
						}); */
						/* $(c_name).find(".chart2").css({
							"transform" : "rotate(" + d + "deg)",
							"background" : color
						}); */
					} else {
						var d = ((per + 50) / 100 * 360) - 90;
						chartName.querySelector('.chart1').style.background = color;
						chartName.querySelector('.chart2').style.transform = "rotate(" + d + "deg)";
						chartName.querySelector('.chart2').style.background = "#a2a2a2";
						/* $(c_name).find(".chart1").css({
							"background" : color
						});
						$(c_name).find(".chart2").css({
							"transform" : "rotate(" + d + "deg)",
							"background" : "#a2a2a2"
						}); */
					}
					chartName.querySelector('.chart-center').querySelector("span").innerHTML = per + "%";
					/* $(c_name).find(".chart-center").children("span").text(
							per + "%"); */

				};
				setChart("bepumi-request-chart", ${percent.requestPercent}, "#85DDC8");
				setChart("bepumi-success-chart", ${percent.completePercent}, "#cba9e2");
			</script>
		</div>

		</main>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>