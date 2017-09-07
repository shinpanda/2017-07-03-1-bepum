<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

	<div id="body" class="del-body">
		<div class="content-container">
			<main id="main" class="main">
			<form method="post" action="" name="del-form">
				<div class="simple-container">
					<div>제목 : ${b.title}</div>
					<div>글쓴이 : ${b.writerId}</div>

					<input type="hidden" name="no" value="${b.no}" />
					<div>
						<span>삭제하시겠습니까?</span> <input type="submit" class="btn" value="삭제">
					</div>
				</div>

			</form>
			</main>
		</div>
	</div>

	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>