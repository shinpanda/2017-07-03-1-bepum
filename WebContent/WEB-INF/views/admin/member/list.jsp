<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../../css/style2.css" type="text/css" rel="stylesheet">
<link href="../../css/admin.css" type="text/css" rel="stylesheet">
<title>베:품</title>
<!-- 요청, 진행 중, 과거 매칭 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<main id="main" class="main">
			<h3>전체 회원</h3>

			<div class="table-container">
				<div class="table-wrapper">
					<div class="board-table">
						<div class="row table-header">
							<div class="cell w100">아이디</div>
							<div class="cell w100">이름</div>
							<div class="cell w100">성별</div>
							<div class="cell w100">생년월일</div>
							<div class="cell w100">이메일</div>
							<div class="cell w100">등급</div>
						</div>

						<c:forEach var="n" items="${list}" begin="0" end="14">
							<c:set var="gender" value="남자" />
							<c:if test="${n.gender == 2}">
								<c:set var="gender" value="여자" />
							</c:if>

							<c:set var="grade" value="회원" />
							<c:if test="${n.grade == 999}">
								<c:set var="grade" value="관리자" />
							</c:if>
							<c:if test="${n.grade == 0}">
								<c:set var="grade" value="일반회원" />
							</c:if>
							<c:if test="${n.grade == 1}">
								<c:set var="grade" value="베푸미" />
							</c:if>
							<c:if test="${n.grade == 2}">
								<c:set var="grade" value="슈퍼베푸미" />
							</c:if>
							<div class="row">
								<div class="cell">${n.id}</div>
								<div class="cell">
									<a href="detail?id=${n.id}" >${n.name}</a>
									
								</div>
								<div class="cell">${gender}</div>
								<div class="cell">${n.birth}</div>
								<div class="cell email">${n.email}</div>
								<div class="cell">${grade}</div>
							</div>
						</c:forEach>
					</div>
					<c:set var="page" value="${param.p}" />
					<c:set var="startNum" value="${page-(page-1)%10}" />
					<c:set var="lastNum"
						value="${fn:substringBefore((count%15 == 0 ? (count/15) : (count/15)+1) , '.')}" />
					<div class="paging-container clearfix">
						<div>
							<c:if test="${startNum<=10 || startNum == null}">
								<a href="?p=1">◀</a>
							</c:if>
							<c:if test="${startNum>10}">
								<a href="?p=${startNum-10}">◀</a>
							</c:if>
						</div>

						<ul>
							<%-- <c:forEach varStatus="page" begin="1" end="5">
						<li><a href="?p=${page.current}">${page.current}</a></li>
					</c:forEach> --%>
							<c:forEach var="i" begin="0" end="9">
								<c:set var="present" value="" />
								<c:if test="${(startNum+i) == page || (page == null && i == 0)}">
									<c:set var="present" value="page-present" />
								</c:if>
								<c:if test="${startNum + i <= lastNum}">
									<li><a class="${present}" href="?p=${startNum+i}">${startNum+i}</a></li>
								</c:if>
							</c:forEach>
						</ul>
						<div>
							<%-- <c:if test="${startNum < lastNum < startNum+5}"> --%>
							<c:if test="${lastNum >= startNum+10}">
								<a href="?p=${startNum+10}">▶</a>
							</c:if>
							<c:if test="${lastNum < startNum+10}">
								<a href="?p=${lastNum}">▶</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>