<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/board.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-container">
			<main id="main" class="main">

			<h3>자유게시판</h3>
			<div class="table-container">
				<div class="table-wrapper">
					<div class="board-table">
						<div class="row table-header">
							<div class="cell no">no</div>
							<div class="cell title">제목</div>
							<div class="cell writer-id">글쓴이</div>
							<div class="cell reg-date">작성날짜</div>
							<div class="cell hit">조회수</div>
						</div>

						<c:forEach var="n" items="${list}" begin="0" end="14">
							<div class="row">
								<div class="cell no">${n.no}</div>
								<div class="cell title title-content">
									<a href="./free-detail?no=${n.no}">${n.title}</a>
								</div>
								<div class="cell writer-id">${n.writerId}</div>
								<div class="cell reg-date">${n.regDate}</div>
								<div class="cell hit">${n.hit}</div>
							</div>
						</c:forEach>
					</div>
					<div class="search-form-container">
						<form action="" method="get" class="search-form">
							<select name="search-sel">
								<option value="writerId">아이디</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
							</select> 
							<input type="search" name="search" /> 
							<input type="submit" />
						</form>
					</div>
					<c:set var="page" value="${param.p}" />
					<c:set var="startNum" value="${page-(page-1)%10}" />
					<c:set var="lastNum" value="${count/10}" />
					<div class="paging-container clearfix">
						<div>
							<a href="?p=1">◀</a>
						</div>
						<ul>
							<%-- <c:forEach varStatus="page" begin="1" end="5">
						<li><a href="?p=${page.current}">${page.current}</a></li>
					</c:forEach> --%>
							<c:forEach var="i" begin="0" end="9">
								<li><a href="?p=${startNum+i}">${startNum+i}</a></li>
							</c:forEach>
						</ul>
						<div>
							<a href="?p=${startNum+5}">▶</a>
						</div>
					</div>
				</div>
				<div class="btn reg-btn">
					<a href="./free-reg">쓰기</a>
				</div>
			</div>
			</main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>