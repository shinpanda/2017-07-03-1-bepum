<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/memprofile.css" type="text/css" rel="stylesheet">
<title>베:품</title>
</head>

<body>

	<jsp:include page="../inc/header.jsp"></jsp:include>


	<div id="body">

		<div class="content-container">
			<main class="main">
			<div class="mem-information"><h3>회원정보조회/수정</h3></div>
			
			<form method="post">
				<div class="self-certification-check">
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box">아이디</div>
						<label class="content-box dc-name mem-fixed" name="id">${member.id}</label>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box">이름</div>
						<input type="text" class="content-box dc-name" name="name" value="${member.name}">
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">비밀번호</div>
						<input type="password" class="content-box dc-name" name="pwd" value="${member.pwd}">
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">이메일</div>
						<input type="email" class="content-box dc-name" name="email" value="${member.email}">
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">성별</div>
						<c:set var="gender" value="남자" />
							<c:if test="${member.gender == 2}">
								<c:set var="gender" value="여자" />
							</c:if>
						<label class="content-box dc-name mem-fixed">${gender}</label>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">생년월일</div>
						<div class="content-box dc-name">
						<span>
						<input type="text" value="${fn:substring(member.birth,0,4)}" placeholder="0000" name="birth-year" />
							</span> 년 <span>
						<input type="text" value="${fn:substring(member.birth,5,7)}" placeholder="01" name="birth-month" />
						</span> 월 <span>
						<input type="text" value="${fn:substring(member.birth,8,10)}" placeholder="01" name="birth-day" />
						일
						</span>
						</div>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">등급</div>
						<c:set var="grade" value="베푸미" />
							<c:if test="${member.grade == 2}">
								<c:set var="grade" value="슈퍼베푸미" />
							</c:if>
						<label class="content-box dc-name mem-fixed">${grade}</label>
					</div>
					</div>
					<div class="self">
					<div class="clearfix">
					<div class="simform-actions">
						<input type="submit" class="submit" value="수정"/>
						</div>
					</div>
					</div>
				</div>

			</form>
			
			
			<div class="mem-cancel"><h3>회원정보탈퇴신청</h3>
			<div class="simform-actions">
					<input type="button" class="submit cancel" value="회원탈퇴"/>
			</div>
			</div>
			
			</main>
			
		</div>
	</div>

	<jsp:include page="../inc/footer.jsp"></jsp:include>
</body>
</html>