<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 베푸미 [진행중] 매칭목록 세부페이지 상단 부분 -->

<h4 class="profile-title">${profile.id}님과의 매칭</h4>
<div class = "profile-container">
	<div class="imgMsg-container">
		<div class="profile-img">
			<img src="../upload/profilePic/${profile.profilePic}" id="profile-img" alt="프로필 사진">
		</div>
		<div class="profile-btn-wrapper">
			<div class="btn-msg-container">
				<input type="button" class="btn msg-btn"  alt="메세지 보내기" onclick=""/>
			</div>
			<div class="btn-profile-container">
				<a href="../searching/detail-profile?id=${profile.id}"  target="_blank"  alt="프로필 상세보기" ></a>
			</div>
		</div>
	</div>
	
	<div class="profile-detail">
		<div class="profile-detail-table">
			<div class="row">
				<div class="cell th"><b>매칭 상태</b></div>
				<div class="cell td"><b>${profile.status}</b></div>
			</div>
			<div class="row">
				<div class="cell th">　</div>
				<div class="cell ">　</div>
			</div>
			<div class="row">
				<div class="cell th">이름</div>
				<div class="cell td">${profile.name}</div>
			</div>
			<c:if test="${!profile.status.equals('신청대기') && !status.equals('신청실패')}">
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