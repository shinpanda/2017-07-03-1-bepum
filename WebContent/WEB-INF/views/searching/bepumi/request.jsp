<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/matching.css" type="text/css" rel="stylesheet">
<title>베품</title>
</head>

<body>
	<jsp:include page="../../inc/header.jsp"></jsp:include>
	<div id="body">

		<main id="main">
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
			        <td><input type="date"/></td>
			    </tr>
			    <tr>
			        <th scope="row">시작시간</th>
			        <td><input type="text"/></td>
			    </tr>
			    <tr>
			        <th scope="row">마침시간</th>
			        <td><input type="text"/></td>
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
			        <td>010-1234-1234</td>
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
			        <td>이아영</td>
			    </tr>
			    <tr>
			        <th scope="row">나이</th>
			        <td >20개월</td>
			    </tr>
			    <tr>
			        <th scope="row">성별</th>
			        <td><input type="radio" name="gender" value="남" checked="checked"/>남<input type="radio" name="gender" value="여"/>여</td>
			    </tr>
			    </tbody>
				</table>	
		
		
			

				<ul>
				<li >
				<label for="name">전달 메시지</label>
				<textarea id="message" name="name" rows="8" cols="50"></textarea>
		
			    </li>
			    </ul>
			</form>
			
			
				<input type="submit" value="신청" class="agree-btn-container"/>
			</form>
	
		</main>
</div>
<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>