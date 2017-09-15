<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="input-title">
	<div class="wrap">
		<h1>
			<span class="tooltiper" data-tooltip="조건에 맞는 베푸미를 찾아보세요 ">베푸미
				찾기<span class="tooltip" style="top: -35px; left: -20px;">조건에
					맞는 베푸미를 찾아보세요 </span>
			</span>
		</h1>
	</div>
	<div class="search-form-container">
		<form name ="search" class="search" method="get" onsubmit="return check()">

			<div class="search-input cd-wrapper">
				<div class="field flex cd-wrapper" id="searchform">
					<input type="text" id="searchterm" name="a" placeholder="베푸미를 찾고 싶은 지역을 입력해보세요." class="ui-btn-icon-location" >
				</div>
			</div>


			<div class="search-input">
				<div class="cd-wrapper">
					<div id="child-age" class="flex optional child-age">
						<div class="flex age-group">
							<span class="input-title">아이나이</span> <label class="age-label">
								<input name="ka" type="radio" id="kid_age1" value="1">
								<span class="inner-label">1~2세</span>
							</label> <label class="age-label"> <input name="ka" type="radio"
								id="kid_age2" value="3"> <span class="inner-label">3~4세</span>
							</label> <label class="age-label"> <input name="ka" type="radio"
								id="kid_age3" value="5"> <span class="inner-label">5~6세</span>
							</label> <label class="age-label"> <input name="ka" type="radio"
								id="kid_age4" value="7"> <span class="inner-label">7~8세</span>
							</label>
						</div>
					</div>
					<div id="day-of-week" class="day-of-week optional">

						<div class="flex checkbox-group">
							<span class="input-title">요일 </span> <input type="checkbox"
								id="_01" name="d" value="Mon"> <label for="_01">
								월 </label> <input type="checkbox" id="_02" name="d" value="Tue">
							<label for="_02"> 화 </label> <input type="checkbox" id="_03"
								name="d" value="Wed"> <label for="_03">
								수 </label> <input type="checkbox" id="_04" name="d" value="Thu">
							<label for="_04"> 목 </label> <input type="checkbox" id="_05"
								name="d" value="Fri"> <label for="_05"> 금 </label> <input
								type="checkbox" id="_06" name="d" value="Sat">
							<label for="_06"> 토 </label> <input type="checkbox" id="_07"
								name="d" value="Sun"> <label for="_07"> 일 </label>
						</div>
					</div>
				</div>
			</div>

			<div class="search-input flex">
				<div class="flex optional">
					<span class="input-title input-time">시작시간</span> <select
						aria-label="시작시간" id="start_time" name="s" class="search-time">
						<option value="">시간선택</option>
						<option value="00:00">00:00</option>
						<option value="01:00">01:00</option>
						<option value="02:00">02:00</option>
						<option value="03:00">03:00</option>
						<option value="04:00">04:00</option>
						<option value="05:00">05:00</option>
						<option value="06:00">06:00</option>
						<option value="07:00">07:00</option>
						<option value="08:00">08:00</option>
						<option value="09:00">09:00</option>
						<option value="10:00">10:00</option>
						<option value="11:00">11:00</option>
						<option value="12:00">12:00</option>
						<option value="13:00">13:00</option>
						<option value="14:00">14:00</option>
						<option value="15:00">15:00</option>
						<option value="16:00">16:00</option>
						<option value="17:00">17:00</option>
						<option value="18:00">18:00</option>
						<option value="19:00">19:00</option>
						<option value="20:00">20:00</option>
						<option value="21:00">21:00</option>
						<option value="22:00">22:00</option>
						<option value="23:00">23:00</option>
						<option value="24:00">24:00</option>
					</select>
				</div>
				<div class="flex optional">
					<span class="input-title input-time">끝나는시간 </span> <select
						aria-label="끝나는시간" id="end_time" name="e" class="search-time">
						<option value="">시간선택</option>
						<option value="00:00">00:00</option>
						<option value="01:00">01:00</option>
						<option value="02:00">02:00</option>
						<option value="03:00">03:00</option>
						<option value="04:00">04:00</option>
						<option value="05:00">05:00</option>
						<option value="06:00">06:00</option>
						<option value="07:00">07:00</option>
						<option value="08:00">08:00</option>
						<option value="09:00">09:00</option>
						<option value="10:00">10:00</option>
						<option value="11:00">11:00</option>
						<option value="12:00">12:00</option>
						<option value="13:00">13:00</option>
						<option value="14:00">14:00</option>
						<option value="15:00">15:00</option>
						<option value="16:00">16:00</option>
						<option value="17:00">17:00</option>
						<option value="18:00">18:00</option>
						<option value="19:00">19:00</option>
						<option value="20:00">20:00</option>
						<option value="21:00">21:00</option>
						<option value="22:00">22:00</option>
						<option value="23:00">23:00</option>
						<option value="24:00">24:00</option>
					</select>
				</div>
			</div>

			<div class="search-input flex">
				<div class="flex optional">
					<input type="submit" class="bttn col" value="검색">
				</div>
			</div>
		</form>
	</div>

</div>


<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/index.js"></script>
<script>
		function check() {
			 if(search.start_time.value=="" &&search.end_time.value==""){
				 return true;
			 }
			 else if (search.start_time.value >=search.end_time.value){
				 alert("시간 설정을 확인해주세요.");
			    search.start_time.value.focus();
			    return false;	
			}
			 else if (search.start_time.value=="" &&!search.end_time.value==""){
				 alert("시간 설정을 확인해주세요.");
			    search.start_time.value.focus();
			    return false;	
			}
		}

</script>