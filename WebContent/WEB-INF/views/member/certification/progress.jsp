<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/certification.css" type="text/css" rel="stylesheet" />
<title>베품</title>
</head>

<body>

<!-- header 집중화 -->
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
	
	<main class="main">
	<h3>심사 진행 상황</h3>
		<div class="content-container">			
			<div class="certfi-container">
				<div class="title-box title">전화번호 인증</div>
				<div></div>
			</div>
			<br />
			<br />
			<br />

			<div class="certfi-container document-container">
				<div class="title-box title">심사 서류 인증</div>
				<div class="document-wrapper">
					<div class="application-form-wrapper clearfix">
						<div class="edit-box-container">
						<div class="edit-box-wrapper">
								<label for="application-form-edit">수정</label> 
								<input type="file"  class="editBtn" id="application-form-edit" name="edit">
							</div>
						</div>
						<div class="title-box dc-name">신청서</div>
						<div class="progress">
							<span>제출 전</span> 
							<span>제출 완료</span> 
							<span class="progress-status">심사 중</span> 
							<span>심사 완료</span> 
							<span>재심사 필요</span>
						</div>
					</div>
					<div class="family-rc-wrapper clearfix">
						<div class="edit-box-container">
							<div class="edit-box-wrapper">
								<label for="family-rc-edit">수정</label> 
								<input type="file"  class="editBtn" id="family-rc-edit" name="edit">
							</div>
						</div>
						<div class="title-box dc-name">가족관계증명서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 중</span> <span>심사
								완료</span> <span class="progress-status">재심사 필요</span>
						</div>
					</div>
					<div class="hc-wrapper clearfix">
						<div class="edit-box-container">
							<div class="edit-box-wrapper">
								<label for="hc-edit">수정</label> 
								<input type="file"  class="editBtn" id="hc-edit" name="edit">
							</div>
						</div>
						<div class="title-box dc-name">건강진단서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 중</span> <span>심사
								완료</span> <span class="progress-status">재심사 필요</span>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</main>
	</div>
	
<!--  footer 집중화 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>