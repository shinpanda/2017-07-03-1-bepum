<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="result" class="result-container">
	<h3 class=hidden>검색 결과</h3>
	<div id="resultsetting" class="result-setting-container">

		<div id="resultinfo">
			<p id="resultaddress" class="resultaddress">검색지역 : 전국</p>
			<p id="resultcount" class="resultcount">20명의 베푸미가 검색되었습니다.</p>
		</div>
		<div id="resultsort" class="resultsort">
			<input id="time" type="radio" name="sort" checked="checked"
				value="time"> <label for="time"><span></span>시간순</label> <input
				id="grade" type="radio" name="sort" value="grade"> <label
				for="grade"><span></span>등급순</label>


		</div>




		<div class="bepumi-list-container">
			<div class="wrap">

				<c:forEach begin="0" end="2">
						<div class="floor">
		
							<c:forEach begin="0" end="3">
			 					<div class="bepumi">
									<img src="images/pic03.jpg" alt="" />
									<div id="bepumipicture" class="bepumi-pic">
										<img class="gradesuper" src="images/superbepumi.png" alt="슈퍼베푸미" />
										<p id="bepumireview" class="bepumi-review">후기 30개</p>
			
									</div>
									<div id="info1" class="bepumi-info info1">
										<p id="bepuminame" class="bepumi-name">구구구</p>
										<p id="bepumiage ">34세</p>
										<p id="bepumiaddress">서울시 마포구</p>
									</div>
									<div id="info2" class="bepumi-info info2">
										<p id="bepumimessage">"도움이 필요하시면 정성을 다해 돌보겠습니다."</p>
			
									</div>
								</div>
							</c:forEach>
							
							
						</div>
				</c:forEach>
			</div>

		</div>
	</div>
</div>
