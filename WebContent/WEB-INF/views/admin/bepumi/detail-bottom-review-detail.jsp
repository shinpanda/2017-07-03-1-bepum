<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="board-table">
	<div class="row table-header">
		<div class="cell no">no</div>
		<div class="cell title">제목</div>
		<div class="cell writer-id">글쓴이</div>
		<div class="cell reg-date">작성날짜</div>
		<div class="cell hit">조회수</div>
	</div>
	<c:forEach var="n" items="${reviewList}" begin="0" end="4">
		<div class="row">
			<div class="cell no">${n.no}</div>
			<div class="cell title title-content">
				<a href="../bepumi/reviewdetail?no=${n.no}">${n.title}</a>
			</div>
			<div class="cell writer-id">${n.writerID}</div>
			<div class="cell reg-date">
				<c:if test="${((today - regDateNum)/(1000*60*60*24)) < 1}">
					<fmt:formatDate value="${n.regDate}" pattern="HH:MM" var="regDate" />
														${regDate}
													</c:if>
				<c:if test="${((today - regDateNum)/(1000*60*60*24)) >= 1}">
					<fmt:formatDate value="${n.regDate}" pattern="YY.MM.dd"
						var="regDate" />
														${regDate}
													</c:if>
			</div>
			<div class="cell hit">${n.hit}</div>
		</div>
	</c:forEach>
</div>



<p>평점 : ${bepumi.avgRating} </p>
<p>매칭 수 : ${bepumi.countStatus} </p> 
<p>매칭완료 수 : ${bepumi.countComplete} </p>

<form method="post">
	<input type="hidden" name="reqId" value="${member.id}" />
	<c:if test="${member.grade == 1}">
		<input type="submit" name="gradeSbt" value="Upgrade" />
	</c:if>
	<c:if test="${member.grade == 2}">
		<input type="submit" name="gradeSbt" value="Downgrade" />
	</c:if>
</form>
