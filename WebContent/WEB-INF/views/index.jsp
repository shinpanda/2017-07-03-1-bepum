<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/common_style.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
<title>베:품</title>


</head>
<body>

<!-- 헤더집중화 -->
	<jsp:include page="inc/header.jsp"></jsp:include>

	<div id="visual">
		<div id="banner-mask">
			<div class="content-container">
				<div id="banner-test">
					<!-- <h1>엄마들의 육아 품앗이</h1> -->
						<img src="images/main_image_text1.PNG" /><br />
						<a class="btn btn-searchBepumi">베푸미 찾기</a>
				</div>
			</div>
		</div>

	</div>

	<div id="body">
		<div class="content-container">
			<main id="main">
			<div>
				<div class=intro0>
					<h3 class = "hidden">[소개]</h3>
					<div class="intro1">
						<img alt="소개" src="images/main_intro1.png"/>
					</div>
					<div class="intro2">
						단기간 아이를 돌봐줄 누군가가 필요할 때, 베품을 이용해보세요. <p></p>
						아이를 키우는 엄마들이 돌보미가 되어 드리기 때문에 안심하고 맡길 수 있답니다.
					</div>
					<div class="intro1">
						<img alt="소개" src="images/main_intro2.png"/>
					</div>
					<div class="intro2">
						서류 인증을 거쳐 육아 품앗이 서비스를 이용하는 엄마들을 의미해요. <p></p>
						베품을 통해 얻은 소중한 시간을 서로서로 베풀어보세요!
					</div>
				</div>
				
				<div class=intro0>
					<h3>Best 후기</h3>
					<p>베품 서비스를 통해 아이 엄마들과 소통도 하고 어린 아기라 걱정했는데 같은 아기 엄마라 더 세심히 신경 써
						주셔서 좋았어요</p>
					<p>- 아기 엄마</p>
				</div>
				<div class=intro0>
					<h3 class = "hidden">[베품 이용방법]</h3>
					<div class="intro1">
						<img alt="이용 방법" src="images/main_process.png"/>
					</div>
					<div class="intro2 main_process1">
						<img alt="이용 방법" src="images/main_process1.PNG"/>
					</div>
				</div>
			</main>
		</div>
	</div>

</body>
</html>

<!--  footer 집중화 -->
	<jsp:include page="inc/footer.jsp"></jsp:include>
	
</body>
</html>