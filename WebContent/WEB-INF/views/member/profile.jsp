<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/memprofile.css" type="text/css" rel="stylesheet">
<title>베:품</title>

<script>

window.onload = function(){
  $("select").each(function(){
	  var rel = $(this).attr("rel");
	  $(this).find("option[value="+rel+"]").attr("selected","selected");
  });
}
 
</script>
</head>

<body>

	<jsp:include page="../inc/header.jsp"></jsp:include>


	<div id="body">

		<div class="content-container">
			<main class="main">
			<div class="mem-information"><h3>회원정보조회/수정</h3></div>
			
			<form method="post">
				<div class="self-certification-check">
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box">아이디</div>
						<label class="content-box dc-name mem-fixed" name="id">${member.id}</label>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box">이름</div>
						<input type="text" class="content-box dc-name" name="name" value="${member.name}">
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">비밀번호</div>
						<input type="password" class="content-box dc-name" name="pwd" value="${member.pwd}">
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">이메일</div>
						<input type="email" class="content-box dc-name" name="email" value="${member.email}">
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">성별</div>
						<c:set var="gender" value="남자" />
							<c:if test="${member.gender == 2}">
								<c:set var="gender" value="여자" />
							</c:if>
						<label class="content-box dc-name mem-fixed">${gender}</label>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">생년월일</div>
						<div class="content-box dc-name">
						<c:set var="year" value="${fn:substringBefore(member.birth,'-')}"/>
						<c:set var="month" value="${fn:substringBefore(fn:substringAfter(member.birth,'-'),'-')}"/>
						<c:set var="day" value="${fn:substringAfter(fn:substringAfter(member.birth,'-'),'-')}"/>
						
						<input type="text" value="${year}" name="birth-year" class="text-right"/>
						년
						<%-- <input type="text" value="${fn:substring(member.birth,5,7)}"  name="birth-month" class="text-right"/>
						 --%>
						<%-- <input type="text" value="${fn:substring(member.birth,8,10)}"  name="birth-month" class="text-right"/>
						 --%>
								<select aria-label="월" class="text-right" name="birth-month" rel="${month}">
									<option value="">월</option>
									<c:forEach var="i" begin="1" end="12">
											<option value="${i}">${i}월</option>
									</c:forEach>
								</select> 
								<select aria-label="일" class="text-right" name="birth-day" rel="${day}">
									<option value="">일</option>
									<c:forEach var="i" begin="1" end="31">
										<option value="${i}">${i}일</option>
									</c:forEach>
								</select>
							</div>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">주소</div>
						<div class="content-box dc-name" style="border: none;">
							<c:set var="address1" value="${fn:substringBefore(member.address,' ')}"/>
							<c:set var="address2" value="${fn:substringAfter(member.address,' ')}"/>
							<span style="font-size: 13px;">시/도: * </span><input type="text" id="address1" name="address1" value="${address1}" class="address text-center" />
							<span style="font-size: 13px;">시/군/구: *</span> <input type="text" id="address2" name="address2" value="${address2}" class="address text-center" />
							</div>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">전화번호</div>
						<div class="content-box dc-name" style="border: none;">
							<c:set var="phone1" value="${fn:substringBefore(member.phone,'-')}"/>
							<c:set var="phone2" value="${fn:substringBefore(fn:substringAfter(member.phone,'-'),'-')}"/>
							<c:set var="phone3" value="${fn:substringAfter(fn:substringAfter(member.phone,'-'),'-')}"/>
							<input type="text" id="phone1" name="phone1" value="${phone1}" class="text-center" />-
							<input type="text" id="phone2" name="phone2" value="${phone2}" class="text-center"/>-
							<input type="text" id="phone3" name="phone3" value="${phone3}" class="text-center"/>
						
						</div>
					</div>
					</div>
					<div class="self">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">등급</div>
						<c:set var="grade" value=" " />
							<c:if test="${member.grade == 0}">
								<c:set var="grade" value="일반회원" />
							</c:if>
							<c:if test="${member.grade == 1}">
								<c:set var="grade" value="베푸미" />
							</c:if>
							<c:if test="${member.grade == 2}">
								<c:set var="grade" value="슈퍼베푸미" />
							</c:if>
							<c:if test="${member.grade == 999}">
								<c:set var="grade" value="관리자" />
							</c:if>
							
						<label class="content-box dc-name mem-fixed">${grade}</label>
					</div>
					</div>
					<div class="self">
					<div class="clearfix">
					<div class="simform-actions">
						<input type="submit" class="submit" value="수정"/>
						</div>
					</div>
					</div>
				</div>

			</form>
			
			
			<div class="mem-cancel"><h3>회원정보탈퇴신청</h3>
			<!-- <div class="simform-actions">
					<a href="" class="submit cancel">회원탈퇴</a>
			</div> -->
			
			<br>
			  <a href="#" class="modal-trigger" data-modal="modal-name">회원탈퇴</a> <!-- Trigger Modal. --></div>
		<!-- Modal -->
		<div class="modal" id="modal-name">
		  <div class="modal-sandbox"></div>
		  <div class="modal-box">
		    <div class="modal-header">
		      <div class="close-modal">&#10006;</div>
		      <h1>회원탈퇴</h1>
		    </div>
		    <form action="delete" method="post">
		    <div class="modal-body center">
		     
		      <p>회원탈퇴를 하시면 베품의 모든 자격이 상실됩니다.</p>
		      <p>회원탈퇴를 원하시면 비밀번호를 입력 후 아래의 탈퇴하기 버튼을 클릭해주세요.</p>
		      <p>회원탈퇴를 하셔도 등록한 글이나 매칭정보는 삭제되지 않을 수 있습니다.</p>
		      
		      <p>${member.id} 님 정말 탈퇴 하시겠습니까?</p>
		      
		     <div class="dc-name mem-fixed"> <span>비밀번호 입력 :</span> <input type="password" class="content-box dc-name" name="pwd" style="float: none;"/></div>
		      <br/><br/>
		      <input class="btn-modal" type="submit" value="탈퇴하기" >
		    </div>
		    </form>
		  </div>
		</div>
		
		
		</main>
			
		</div>
	</div>

	<jsp:include page="../inc/footer.jsp"></jsp:include>
	
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>
    <script>
    $(".modal-trigger").click(function(e){
    	  e.preventDefault();
    	  dataModal = $(this).attr("data-modal");
    	  $("#" + dataModal).css({"display":"block"});
    	});

    	$(".close-modal, .modal-sandbox").click(function(){
    	  $(".modal").css({"display":"none"});
    	});
    
    </script>
</body>
</html>