<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<c:if test="${profile.status.equals('매칭완료')||profile.status.equals('결제완료')}">
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