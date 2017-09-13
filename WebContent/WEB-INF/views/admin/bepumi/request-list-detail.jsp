<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../../../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../../../css/style2.css" type="text/css" rel="stylesheet">
<link href="../../../css/admin.css" type="text/css" rel="stylesheet">
<title>베:품</title>
<!-- 자격심사 요청한 회원들 목록 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body" class="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp"></jsp:include>
			<main id="main" class="main">
			<h3>신청 회원</h3>
				<div class="profile-detail">
				<div class="profile-detail-table request">
					<div class="row">
						<div class="cell th1">아이디</div>
						<div class="cell td">${profile.reqId}</div>
					</div>
					<div class="row">
						<div class="cell th1">이름</div>
						<div class="cell td">${profile.name}</div>
					</div>
					<div class="row">
						<div class="cell th1">성별</div>
						<div class="cell td">${profile.gender}</div>
					</div>
		
					<div class="row">
						<div class="cell th1">등급</div>
						<div class="cell td">${profile.grade}</div>
					</div>
					<div class="row">
						<div class="cell th1">생년월일</div>
						<div class="cell td">${profile.birth}</div>
					</div>
					<div class="row">
						<div class="cell th1">이메일</div>
						<div class="cell td">${profile.email}</div>
					</div>
			
				</div>
				<form  method="post" enctype="Multipart/form-data" name="fileCheck" onsubmit="">	
						<!-- 서류부분 -->
					<div class="document-detail-table request">
						<div class="row">
							<div class="cell th1"><input type="checkbox" name="acheckBox"/>  신청서</div>
							<div class="cell td">${profile.applicationForm}</div>
							
						</div>
						<div class="row">
							<div class="cell th1"><input type="checkbox" name="hcheckBox"/>  건강진단서</div>
							<div class="cell td">${profile.HC}</div>
						</div>
						<div class="row">
							<div class="cell th1"><input type="checkbox" name="fcheckBox"/>  가족관계증명서</div>
							<div class="cell td">${profile.FRC}</div>
						</div>
						<div class="row">
							<div class="cell th1"><input type="checkbox" name="vcheckBox"/>  아이 예방접종 증명서</div>
							<div class="cell td">${profile.VC}</div>
						</div>
					</div>
				
				</div>

			
			<!-- 네 개 다 체크하면 grade 1로 변경하고 파일 제출상태도 모두 1로 변경(심사완료 on), 
				하나라도 통과 안되면 파일 제출상태에 0을 db에 저장하고 0인거에 대해서는 재심사필요 on 하고 사용자가 다시 제출하게 
				사용자가 다시 제출하는거는 update 함수로 하기 -->
					<div>
						<input type="submit" class="" value="저장"/>
					</div>
				</form>
			</main>
		</div>
	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>