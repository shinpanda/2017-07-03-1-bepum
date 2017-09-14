<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="css/list-top.css" rel="stylesheet" >
<link href="css/list-bottom.css" type="text/css" rel="stylesheet" />



 <script src="//use.typekit.net/xyl8bgh.js"></script>
<script>try{Typekit.load();}catch(e){}</script>


  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
<link rel='stylesheet prefetch' href='css/codepen_io_andytran_pen.css'>

<title>베:품</title>
<!-- 요청, 진행 중, 과거 매칭 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body" class="clearfix">

		<main id="main" class="main">
		<div class="content-container">
			<jsp:include page="list-top.jsp" />
			<jsp:include page = "list-bottom.jsp" />
		</div>
		</main>

	</div>
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>