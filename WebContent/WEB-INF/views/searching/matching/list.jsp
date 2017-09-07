<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/matching.css" type="text/css" rel="stylesheet">
<title>베:품</title>
<!-- 신청자 매칭목록 (요청, 진행 중,  완료) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">
		<div class="content-container">
			<main id="main" class="main">			
			<h3>매칭 진행 현황</h3>

			<div class="matching-progress-container">
				<div class="matching-progress-wrapper">
					<div class="matching-progress step1-container">
						<div class="step-wrapper">
							<p class="step">매칭 신청</p>
							<p>매칭 접수 단계</p>
						</div>
					</div>
					<div class="matching-progress step2-container">
						<div class="step-wrapper">
							<p class="step">승인 중</p>
							<p>관리자 및 돌보미 승인 단계</p>
						</div>
					</div>
					<div class="matching-progress step3-container">
						<div class="step-wrapper">
							<p class="step">결제 확인</p>
							<p>결제 확인 단계</p>
						</div>
					</div>
					<div class="matching-progress step4-container">
						<div class="step-wrapper">
							<p class="step">매칭 진행</p>
							<p>승인 후 매칭 진행단계</p>
						</div>
					</div>
					<div class="matching-progress step5-container">
						<div class="step-wrapper">
							<p class="step">매칭 완료</p>
							<p>매칭 완료 단계</p>
						</div>
					</div>
				</div>
			</div>
			<script>
				$(".matching-progress").click(function(){
					$(this).siblings().removeClass("present");
					$(this).addClass("present");
				});
			</script>
			
			
			<div class="table-container">
				<div class="table-wrapper">
					<div class="board-table">
						<div class="table-header">
							<div class="cell no">no</div>
							<div class="cell request-id">돌보미 아이디</div>
							<div class="cell request-name">돌보미 이름</div>
							<div class="cell grade">회원 등급</div>
							<!-- <div class="cell bepum-day">날짜</div> -->							
							<div class="cell req-date">신청일</div>
							<div class="cell bepum-time">시간</div>
							<div class="cell status">매칭 상태</div>
						</div>

						<c:forEach var="n" items="${list}" begin="0" end="14">
							<c:set var="grade" value="베푸미" />
							<c:if test="${n.grade == 2}">
								<c:set var="grade" value="슈퍼베푸미" />
							</c:if>
							<div class="row">
								<div class="cell no">${n.no}</div>
								<div class="cell request-id"><a href="matching-list-detail?no=${n.no}">${n.id}</a></div>
								<div class="cell request-name">
									<a href="matching-list-detail?no=${n.no}">${n.name}</a>
								</div>
								<div class="cell grade">${grade}</div>
								<div class="cell req-date">${n.reqDate}</div>
								<div class="cell bepum-time">${n.startTime}~ ${n.endTime}</div>
								<div class="cell status">${n.status}</div>
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