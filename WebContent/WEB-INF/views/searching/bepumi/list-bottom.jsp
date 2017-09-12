
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="result" class="result-container">
	<h3 class=hidden>검색 결과</h3>
	<div id="resultsetting" class="result-setting-container">

		<div id="resultinfo">
			<p id="resultaddress" class="resultaddress">검색지역 : 전국</p>
			<p id="resultcount" class="resultcount">${count}명의 베푸미가 검색되었습니다.</p>
		</div>
		<div id="resultsort" class="resultsort">
			<input id="time" type="radio" name="sort" checked="checked"
				value="time"> <label for="time"><span></span>시간순</label> <input
				id="grade" type="radio" name="sort" value="grade"> <label
				for="grade"><span></span>등급순</label>


		</div>

		<c:set var="page" value="${param.p}" />
		<c:if test="${empty param.p}">
			<c:set var="page" value="1" />
		</c:if>
		<div class="bepumi-list-container">
			<div class="wrap">
				<%-- 					<c:forEach var = "i" begin = "0" end = "5"  >			 --%>
				<c:forEach items="${list}" begin="0" end="8" step="3"
					varStatus="status">
					<c:set var="startrowNum" value="${(page-1)*9}" />
					<div class="floor">
					
						<c:forEach begin="${status.index}" end="${status.index+2}" var="i">
							<c:if test="${startrowNum + i < count}">
								<%-- 								<c:forEach var = "i" begin = "0" end = "2"  >			 --%>
								<div class="column">
									<!-- Post-->
									<div class="post-module">
										<!-- Thumbnail-->
										<div class="thumbnail">
											<a href="detail-profile?id=${list[i].id}"><img
												src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/photo-1429043794791-eb8f26f44081.jpeg" /></a>
										</div>
										<!-- Post Content-->
										<div class="post-content">

											<c:set var="grade" value="회원" />
											<c:if test="${list[i].grade == 1}">
												<c:set var="grade" value="베푸미" />
											</c:if>
											<c:if test="${list[i].grade == 2}">
												<c:set var="grade" value="슈퍼베푸미" />
											</c:if>


											<div class="category">${grade}</div>
											<h1 class="title">${list[i].intro}</h1>

											<h2 class="sub_title">${list[i].name} ${list[i].address}</h2>
											<p class="description">${list[i].etc}</p>
											<div class="post-meta">
											<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
											<fmt:parseNumber value="${now.time}" integerOnly="true" var = "today" />
											<fmt:parseNumber value="${list[i].regDate.time}" integerOnly="true" var = "regDateNum" />
												<span class="timestamp">
												<i class="fa fa-clock">
													<c:if test="${((today - regDateNum)/(1000*60*60*24)) < 1}">
														<fmt:formatDate value = "${list[i].regDate}" pattern="hh:mm" var="regDate" />
														${regDate}
													</c:if>
													<c:if test="${((today - regDateNum)/(1000*60*60*24)) >= 1}">
														<fmt:formatDate value = "${list[i].regDate}" pattern="YY-MM-dd" var="regDate" />
														${regDate}
													</c:if>
													</i>
													<!-- 6 mins ago --></span><span class="comments"><i
													class="fa fa-comments"></i><a href="#">후기
														${list[i].countReview}개 </a></span>
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>


					</div>
				</c:forEach>
				<%-- 					</c:forEach>			
 --%>
				
				<c:set var="startNum" value="${page-(page-1)%10}" />
				<c:set var="lastNum"
					value="${fn:substringBefore((count%9 == 0 ? (count/9) : (count/9)+1) , '.')}" />
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
</div>



<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/searching.js"></script>

