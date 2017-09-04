<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "p" value="${pageContext.request.contextPath}"/>	

<aside id="aside" class="aside">
	<h1>ADMIN PAGE</h1>

	<nav>
		<h1>베품</h1>
		<ul>
			<li><a href="${p}/admin/notice/list">공지관리</a></li>
			<li><a href="${p}/admin/question/list">문의글</a></li>
			<li><a href="${p}/admin/report/list">신고글</a></li>
			<li><a href="${p}/admin/matching/list">매칭 관리</a></li>
		</ul>
	</nav>

	<nav>
		<h1>회원관리</h1>
		<ul>
			<li><a href="${p}/admin/member/list">가입회원</a></li>
			<li><a href="${p}/admin/bepumi/list">베푸미</a></li>
			<li><a href="${p}/admin/bepumi/request/list">베푸미 신청내역</a></li>
		</ul>
	</nav>
</aside>
