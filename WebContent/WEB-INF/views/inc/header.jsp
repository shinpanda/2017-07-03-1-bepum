<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<c:set var = "p" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var str=$(location).attr('pathname');
		var index = str.indexOf('/', 3);
		var res = str.substr(index+1);
		if(str.indexOf('-') > 0){
			res = str.substring((index+1), str.indexOf('-'));
		}
		$("a[href*='"+res+"']").parents(".sub-menu").removeClass('hidden');
		$("a[href*='"+res+"']").addClass("on");
	});
</script>
</head>
<body>
	<header id="header">
	<div class="content-container clearfix">
		<a href="${p}/index.html"><img src="${p}/images/1616.png" id="logo"
			alt="베품" /></a>
		<section id="menu-container"> 
		<nav class="menu-wrapper">

			<ul class="main-menu">
				<li><a href="">소개</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/index.html">서비스 소개</a></li>
						<li><a href="${p}/index.html">이용방법</a></li>
					</ul></li>
				<li><a href="">베푸미 활동 관리</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/bepumi/profile">프로필 관리</a></li>
						<li><a href="${p}/bepumi/matching-list">매칭 내역</a></li>
					</ul></li>	
				<li><a href="">베푸미 찾기</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/searching/bepumi-list">조건별 베푸미 찾기</a></li>
						<li><a href="${p}/searching/matching-list">매칭 내역</a></li>
					</ul></li>
				<li><a href="">커뮤니티</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/board/free">자유게시판</a></li>
						<li><a href="${p}/board/review">후기게시판</a></li>
					</ul></li>
				<li><a href="">문의/FAQ</a>
					<ul class="sub-menu hidden">
						<li><a href="${p}/board/question">문의게시판</a></li>
						<li><a href="${p}/board/report">신고게시판</a></li>
					</ul>
					</li>
			</ul>
		</nav> 
		<nav class="menu-wrapper">
		<ul id="login">
			<li><a href="" class="btn-border">Sign in</a></li>
		</ul>
		</nav>
		<div id="sub-bg"></div>
		</section>
	</div>
	</header>
</body>
</html>