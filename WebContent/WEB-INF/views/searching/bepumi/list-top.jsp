<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="input-title">
	<div class="wrap">
		<h1>
			조건별 <span class="tooltiper" data-tooltip="조건에 맞는 돌보미를 검색해보세요 ">돌보미
				검색<span class="tooltip" style="top: -35px; left: -20px;">조건에
					맞는 돌보미를 검색해보세요 </span>
			</span>
		</h1>
	</div>
	<div class="search-form-container">
		<form class="search" method="get">

			<div class="search-input cd-wrapper">
				<div class="field flex cd-wrapper" id="searchform">
					<input type="text" id="searchterm" placeholder="지역 검색">
					<!--  <button type="button" id="search">Find!</button> -->
				</div>
			</div>


			<div class="search-input">
				<div class="cd-wrapper">
					<div id="child-age" class="flex optional child-age">
						<div class="flex age-group">
							<span class="input-title">아이나이</span> <label class="age-label">
								<input name="kid-ages" type="radio"  id="kid_age1"  value = "1" >
								<span class="inner-label">1~2세</span>
							</label> <label class="age-label"> <input name="kid-ages"
								type="radio" id="kid_age2" value = "3" > <span
								class="inner-label">3~4세</span>
							</label> <label class="age-label"> <input name="kid-ages"
								type="radio" id="kid_age3" value = "5"  > <span
								class="inner-label">5~6세</span>
							</label> <label class="age-label"> <input name="kid-ages"
								type="radio" id="kid_age4" value = "7"  > <span
								class="inner-label">7~8세</span>
							</label>
						</div>
					</div>
					<div id="day-of-week" class="day-of-week optional">

						<div class="flex checkbox-group">
							<span class="input-title">요일 </span> <input type="checkbox"
								id="_01" name="select" value="Mon" > <label
								for="_01"> 월 </label> <input type="checkbox" id="_02"
								name="select" value="Tue" > <label for="_02">
								화 </label> <input type="checkbox" id="_03" name="select" value="Wed"
								> <label for="_03"> 수 </label> <input
								type="checkbox" id="_04" name="select" value="Thu" >
							<label for="_04"> 목 </label> <input type="checkbox" id="_05"
								name="select" value="Fri" > <label for="_05">
								금 </label> <input type="checkbox" id="_06" name="select" value="Sat"
								> <label for="_06"> 토 </label> <input
								type="checkbox" id="_07" name="select" value="Sun" >
							<label for="_07"> 일 </label>
						</div>
					</div>
				</div>
			</div>

			<div class="search-input flex">
				<div class="flex optional">
					<span class="input-title input-time">시작시간 </span> <input
						type="time" min="07:00" max="22:00" name = "start-time">
				</div>
				<div class="flex optional">
					<span class="input-title input-time">끝나는시간 </span> <input
						type="time" min="07:00" max="22:00" name = "end-time">
				</div>
			</div>

			<div class="search-input flex">
				<div class="flex optional">
					<input type="submit" class="bttn col" value = "검색">
				</div>
				<div class="flex optional">
					<a href="" class="bttn-dark dark">취소</a>
				</div>
			</div>
		</form>
	</div>

</div>


<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/index.js"></script>
