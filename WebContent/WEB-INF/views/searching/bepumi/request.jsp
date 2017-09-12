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
<title>베품</title>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">

		<main id="main" class="main">
			<div class="matching-request-container">
				<div class="matching-request">매칭 신청</div>
			</div>
		
			<form method="post"  class="form-style-7">
		
				<table class="type10">
				
				<thead>
			    <tr colspan="2">
			        <th scope="cols" class="even">날짜/시간</th>
			    </tr>
			    </thead>
			    <tbody>
			    <tr>
			        <th scope="row" >돌봄날짜</th>
			        <td><input type="date" name="bepumDate"/></td>
			    </tr>
			    <tr>
			        <th scope="row">시작시간</th>
			        <td>			
			        <div class="search-input flex">
					<div class="flex optional">
					<select aria-label="" id="start_time" name="start-time">
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
											</div></div>
				</td>
			    </tr>
			    <tr>
			        <th scope="row">마침시간</th>
			        <td>
			        <div class="search-input flex">
					<div class="flex optional">
					<select aria-label="" id="start_time" name="end-time">
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
											</div></div>
				</td>
			    </tr>
			    </tbody>
			    
			    <thead>
			    <tr colspan="2">
			        <th scope="cols" class="even">돌보미</th>
			    </tr>
			    </thead>
			    <tbody>
			    <tr>
			        <th scope="row">이름</th>
			        <td>${profile.name}</td>
			    </tr>
			    <tr>
			        <th scope="row" >아이디</th>
			        <td >${profile.id}</td>
			    </tr>
			    
			    		<c:set var="grade" value="베푸미" />
						<c:if test="${profile.grade == 2}">
							<c:set var="grade" value="슈퍼베푸미" />
						</c:if>
			    <tr>
			        <th scope="row" >회원 등급</th>
			        <td >${grade}</td>
			    </tr>
			    <tr>
			        <th scope="row">지역</th>
			        <td>${profile.address}</td>
			    </tr>
			    <tr><td></td>
			    </tr>
			    </tbody>
			    
			    
			    <thead>
			    <tr colspan="2">
			        <th scope="cols" class="even">신청자</th>
			    </tr>
			    </thead>
			    <tbody>
			    <tr>
			        <th scope="row" >이름</th>
			        <td>${reqprofile.name}</td>
			    </tr>
			    <tr>
			        <th scope="row">전화번호</th>
			        <td>${reqprofile.phoneNum}</td>
			    </tr>
			    </tbody>
			   
			    
			    
			    <thead>
			    <tr colspan="2">
			        <th scope="cols" class="even">아기 정보</th>
			    </tr>
			    </thead>
			    <tbody>
			    <tr>
			        <th scope="row">이름</th>
			        <td>${reqprofile.babyName}</td>
			    </tr>
			    <tr>
			        <th scope="row">나이</th>
			        <td >${reqprofile.babyAge}세</td>
			    </tr>
			    
			    		<c:set var="babyGender" value="남" />
						<c:if test="${profile.grade == 2}">
							<c:set var="babyGender" value="여" />
						</c:if>
			    <tr>
			        <th scope="row">성별</th>
			        <td>${babyGender}</td>
			    </tr>
			    </tbody>
				</table>	
		
		
			

				<ul>
				<li >
				<label for="name">전달 메시지</label>
				<textarea id="message" name="requirement" rows="8" cols="50"></textarea>
		
			    </li>
			    </ul>
				<input type="hidden" name="bepum-id" value="${profile.id}"/>
				<input type="submit" value="신청" id="request-submit" class="agree-btn-container"/>
				
					<script>
						window.onload = function(){
							var requestSubmit=document.getElementById("request-submit");
							
							requestSubmit.onclick= function(){
									
									alert("신청이 완료되었습니다. \n돌보미가 신청을 승인한 뒤 결제요청을 하면 꼭 '결제'를 '완료'해주세요!");
				
								};	};
							
					</script>
			</form>
	
		</main>
</div>
<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>