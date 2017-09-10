<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 돌보미 상세정보 -->

<h4 class="profile-title">돌보미 상세정보</h4>
<div class = "profile-container">
	<div class="imgMsg-container">
		<div class="profile-img">
			<img src="../images/profile1.png" id="profile-img" alt="프로필 사진">
		</div>
		<div class="profile-btn-wrapper">
			<div class="btn-msg-container">
				<input type="button" class="btn msg-btn"  alt="메세지 보내기" onclick=""/>
			</div>
			<div class="btn-profile-container">
				<a href="../bepumi/profile"  target="_blank"  alt="프로필 상세보기" ></a>
			</div>
		</div>
	</div>
	
	<div class="profile-detail">
		<div class="profile-detail-table">
			<div class="row">
				<div class="cell th">아이디</div>
				<div class="cell td">${list[0].id}</div>
			</div>
			<div class="row">
				<div class="cell th">이름</div>
				<div class="cell td">${list[0].name}</div>
			</div>
			<div class="row">
				<div class="cell th">나이</div>
				<div class="cell td">${list[0].age}</div>
			</div>
			<div class="row">
				<div class="cell th">거주지</div>
				<div class="cell td">${list[0].address}</div>
			</div>
			<div class="row">
				<div class="cell th">등급</div>
				<div class="cell td">${list[0].grade}</div>
			</div>
			<div class="row">
				<div class="cell th">주민번호</div>
				<div class="cell td">${list[0].grade}</div>
			</div>
			<div class="row">
				<div class="cell th">연락처</div>
				<div class="cell td">${list[0].phoneNum}</div>
			</div>
		</div>
	</div>
</div>