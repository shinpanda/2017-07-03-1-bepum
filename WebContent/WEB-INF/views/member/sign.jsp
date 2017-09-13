<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login/Sign-In</title>
<link href="../css/loginstyle.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="logmod">
		<div class="logmod__wrapper">
			<!-- <span class="logmod__close" onclick="javascript:window.close();">Close</span> -->
			<div class="logmod__container">
				<ul class="logmod__tabs">
					<li data-tabtar="lgm-2"><a href="">로그인</a></li>
					<li data-tabtar="lgm-1"><a href="">회원가입</a></li>
				</ul>

				<div class="logmod__tab-wrapper">
					<div class="logmod__tab lgm-1">
						<!-- 회원가입 -->
						<div class="logmod__heading">
							<span class="logmod__heading-subtitle"> <strong>베:품
									회원가입</strong>
							</span>
						</div>
						<div class="logmod__form">
							<form method="post" name="loginInfo" accept-charset="utf-8" action="#" class="simform" onsubmit="return checkValue()">
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">이름 *</div>
										<input class="string optional" maxlength="10" id="user-name" name="name"
											placeholder="이름" type="text" size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">아이디 *</div>
										<input class="string optional" maxlength="255" id="user-id" name="id"
											placeholder="아이디" type="text" size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input string optional">
										<div class="string optional" for="user-pw">비밀번호 *</div>
										<input class="string optional" maxlength="255" id="user-pw" name="pw"
											placeholder="비밀번호" type="password" size="50" />
									</div>
									<div class="input string optional">
										<div class="string optional" for="user-pw-repeat">비밀번호확인
											*</div>
										<input class="string optional" maxlength="255"
											id="user-pw-repeat" placeholder="비밀번호확인" type="password" name="pw-re"
											size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">이메일 *</div>
										<input class="string optional" maxlength="250" id="user-email" name="email"
											placeholder="이메일" type="email" size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input string optional" id="user-gender">
										<div class="string optional" for="user-gender">성별 *</div>
										<label>남자<input class="option-input radio"
											name="gender" type="radio" value="1"></label>
									</div>
									<div class="input string optional">
										<div class="string optional" for="user-gender">
											<br />
										</div>
										<label>여자<input class="option-input radio"
											name="gender" type="radio" value="2" checked></label>
									</div>
								</div>

								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-birth">생년월일 *</div>
										<select aria-label="년" id="user_birthday_year"
											name="birthday_year">
											<option value="">년</option>
											<c:forEach var="i" begin="1900" end="2017">
												<option value="${i}">${i}년</option>
											</c:forEach>
										</select> 
										<select aria-label="월" id="user_birthday_month" name="birthday_month">
											<option value="">월</option>
											<c:forEach var="i" begin="1" end="12">
												<option value="${i}">${i}월</option>
											</c:forEach>
										</select> 
										<select aria-label="일" id="user_birthday_day" name="birthday_day">
											<option value="">일</option>
											<c:forEach var="i" begin="1" end="31">
												<option value="${i}">${i}일</option>
											</c:forEach>
										</select> 
										

									</div>
								</div>
								<div class="sminputs" style="text-align: right; font-size: 11px; border-bottom: none;">
									*표시 항목은 필수항목입니다.
								</div>
								

								<div class="simform__actions">
									<input type="submit" class="sumbit" name="commit" value="가입신청" />
								</div>
							</form>
						</div>
					</div>
					<div class="logmod__tab lgm-2">
						<!-- 로그인 -->
						<div class="logmod__heading">
							<a href=""><image src="../images/1616.png" id="logo" alt="베품" /></a>
							<span class="logmod__heading-subtitle"> <strong>아이디와
									비밀번호를 입력해주세요.</strong>
							</span>
						</div>
						<div class="logmod__form">
							<form accept-charset="utf-8" action="login" class="simform">
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">아이디*</div>
										<input class="string optional" maxlength="255" id="user-email"
											placeholder="아이디" type="text" size="50" name="id" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-pw">비밀번호*</div>
										<input class="string optional" id="user-pw" placeholder="비밀번호"
											type="password" name="pwd"/>
										<!-- <span class="hide-password">Show</span> -->
									</div>
								</div>
								<div class="simform__actions">
									<input class="sumbit" name="commit" type="submit"
										value="Log In" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="../js/index.js"></script>
</body>
</html>



