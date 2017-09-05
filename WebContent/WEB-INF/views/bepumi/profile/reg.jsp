<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="p" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/profile.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						var opt = {
							img : $('#profile-photo'),
							inputFile : $('#profile-img-edit-btn')
						};

						// onchange
						$('#profile-img-edit-btn')
								.change(
										function() {
											var inputFile = opt.inputFile
													.get(0);
											var img = opt.img.get(0);

											// FileReader
											if (window.FileReader) {
												// image 파일만
												if (!inputFile.files[0].type
														.match(/image\//))
													return;

												// preview
												try {
													var reader = new FileReader();
													reader.onload = function(e) {
														img.src = e.target.result;

													}
													reader
															.readAsDataURL(inputFile.files[0]);
												} catch (e) {
													// exception...
												}
												// img.filters (MSIE)
											} else if (img.filters) {
												inputFile.select();
												inputFile.blur();
												var imgSrc = document.selection
														.createRange().text;

												img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""
														+ imgSrc + "\")";
												// no support
											} else {
												// Safari5, ...
											}
										});

					});
</script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">

		<main id="main">
		<form method="post" enctype="multipart/form-data"
			name="bepumi-profile-form">
			<div class="bg-profile-header">
				<div class="content-container">
					<div class="btn-header">
						<input id="submit-btn" type="submit" value="변경사항 저장" />
					</div>
					<div class="bepum-definite-wrapper">
						<p>
							희망 시급 : <span><input type="text" placeholder="8000"
								class="profile-num" name="pay" /></span> 원
						</p>

					</div>
				</div>
			</div>
			<div class="content-container">
				<div class="profile-member-container">
					<div class="profile-member-wrapper">
						<img src="${p}/images/profile.jpg" id="profile-photo" alt="프로필 사진">
						<div class="profile-box">
							<label for="profile-img-edit-btn">사진 수정</label> <input
								type="file" accept=".bmp, .jpg, .png" id="profile-img-edit-btn"
								name="profile-img">
						</div>

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
						<div class="home-photo">
							<label for="home-img-edit1"><img
								src="${p}/images/add_icon.png" /></label> <input type="file"
								onchange="previewFile(1)" accept=".bmp, .jpg, .png"
								id="home-img-edit1" name="home-photo1">
						</div>

						<div class="home-photo">
							<label for="home-img-edit2"><img
								src="${p}/images/add_icon.png" /></label> <input type="file"
								onchange="previewFile(2)" accept=".bmp, .jpg, .png"
								id="home-img-edit2" name="home-photo2">
						</div>

						<div class="home-photo">
							<label for="home-img-edit3"><img
								src="${p}/images/add_icon.png" /></label> <input type="file"
								onchange="previewFile(3)" accept=".bmp, .jpg, .png"
								id="home-img-edit3" name="home-photo3">
						</div>
						<script>
							function previewFile(num) {
								var file = document
										.querySelector('#home-img-edit' + num).files[0];
								var reader = new FileReader();
								reader.addEventListener("load", function() {
									$("#home-img-edit" + num).parent().css(
											{
												"background" : "url("
														+ reader.result
														+ ") no-repeat",
												"background-size" : "cover"
											});
								}, false);
								if (file) {
									reader.readAsDataURL(file);
								}
							}
						</script>
					</div>
				</div>
				<div class="time-table">
					<h3>가능 시간</h3>
					<div class="bepumi-day">
						<input type="checkbox" id="bepumi-day1" name="bepumi-day"
							value="월" /> <label for="bepumi-day1">월</label> <input
							type="checkbox" id="bepumi-day2" name="bepumi-day" value="환" />
						<label for="bepumi-day2">화</label> <input type="checkbox"
							id="bepumi-day3" name="bepumi-day" value="수" /> <label
							for="bepumi-day3">수</label> <input type="checkbox"
							id="bepumi-day4" name="bepumi-day" value="목" /> <label
							for="bepumi-day4">목</label> <input type="checkbox"
							id="bepumi-day5" name="bepumi-day" value="금" /> <label
							for="bepumi-day5">금</label> <input type="checkbox"
							id="bepumi-day6" name="bepumi-day" value="토" /> <label
							for="bepumi-day6">토</label> <input type="checkbox"
							id="bepumi-day7" name="bepumi-day" value="일" /> <label
							for="bepumi-day7">일</label>
					</div>
					<p>
						<span><input type="text" placeholder="9:00"
							class="profile-num" pattern="[0-2]\d:[0-5]\d"
							title="08:00 형식으로 넣어주세요" name="start-time" /></span> ~ <span><input
							type="text" placeholder="18:00" class="profile-num"
							pattern="[0-2]\d:[0-5]\d" title="08:00 형식으로 넣어주세요"
							name="end-time" /></span>
					</p>
				</div>

				<div class="table-container">
					<h3>소개</h3>
					<div class="table-wrapper">

						<div class="intro-table">
							<div class="row">
								<div class="cell1">기타사항</div>
								<div class="cell2">
									<textarea name="others" class="table-input" rows="3" cols="65"
										placeholder="예)운전 가능"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="cell1">자기소개</div>
								<div class="cell2">
									<textarea name="self-intro" class="table-input" rows="4"
										cols="65"></textarea>
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
		</form>
		</main>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>