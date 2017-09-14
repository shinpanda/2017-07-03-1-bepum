<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../../css/admin.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<main id="main" class="main">

			<h3>신고게시판</h3>
			<div class="table-container">
				<div class="table-wrapper">
					<div class="board-table">
						<div class="row table-header">
							<div class="cell w60">no</div>
							<div class="cell">제목</div>
							<div class="cell w100">글쓴이</div>
							<div class="cell w120">작성날짜</div>
							<div class="cell w80">조회수</div>
						</div>

						<c:forEach var="n" items="${list}" begin="0" end="14">
							<div class="row">
								<div class="cell">${n.no}</div>
								<div class="cell title">
									<a href="detail?no=${n.no}">${n.title}
										(${n.countCmt})</a>
								</div>
								<div class="cell">${n.writerId}</div>
								<div class="cell"><jsp:useBean id="now"
										class="java.util.Date"></jsp:useBean>
									<fmt:parseNumber value="${now.time}" integerOnly="true"
										var="today" />
									<fmt:parseNumber value="${n.regDate.time}" integerOnly="true"
										var="regDateNum" />
										<c:if test="${((today - regDateNum)/(1000*60*60*24)) < 1}">
											<fmt:formatDate value="${n.regDate}" pattern="HH:MM"
												var="regDate" />
														${regDate}
													</c:if>
										<c:if test="${((today - regDateNum)/(1000*60*60*24)) >= 1}">
											<fmt:formatDate value="${n.regDate}" pattern="YY.MM.dd"
												var="regDate" />
														${regDate}
													</c:if>
								</div>
								<div class="cell">${n.hit}</div>
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
		</div>
		</main>
	</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>