<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 베푸미 공개 설정 및 자기소개 변경 -->
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/board.css" type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-container">
			<main id="main" class="main">
			<div class="reg-container">
				<form action="" method="post" name="free-reg-form" class="reg-form">
					<input type="text" name="title" placeholder="제목" />
					<textarea rows="25" cols="65" name="content"></textarea>
					<div class="sec-container">
						<div class="sec-btn-container">
							<label class="sec-header">비밀글 설정</label> 
							<input type="radio" name="sec-btn" value="open"
								id="op-btn"> 
								<label for="op-btn">공개글</label>
								<input
								type="radio" name="sec-btn" value="sec" id="sec-btn" checked>
							<label for="sec-btn">비밀글</label>
						</div>
						<div class="sec-key-container">
							<label class="sec-header">비밀번호</label>
							<input type="password" name="sec-key" />
						</div>
					</div>
					<div class="reg-btn-container">
						<input type="submit" class="btn reg-btn" value="등록" />
						<button type="button" onclick="history.back()"
							class="btn reg-btn reg-cancel">취소</button>
					</div>
				</form>
			</div>
			</main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>