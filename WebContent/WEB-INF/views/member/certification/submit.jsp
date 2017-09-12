<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<!-- 약관동의	 -->
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet" />
<link href="../css/style2.css" type="text/css" rel="stylesheet" />
<link href="../css/certification.css" type="text/css" rel="stylesheet" />
<title>베:품</title>
</head>

<body>
	<!-- 헤더집중화 -->
	<jsp:include page="../../inc/header.jsp"></jsp:include>

	<div id="body">
		<div class="content-container">

			<main class="main">
			<h3>자격 심사 신청</h3>
			<div class="req-progress-container">
				<div class="req-progress-wrapper">
					<div class="req-progress">
						<p class="step">1단계</p>
						<p>약관동의</p>
					</div>
					<div class="req-progress">
						<p class="step">2단계</p>
						<p>본인 인증</p>
					</div>
					<div class="req-progress present">
						<p class="step">3단계</p>
						<p>서류 제출</p>
					</div>
					<div class="req-progress">
						<p class="step">4단계</p>
						<p>신청 완료</p>
					</div>
				</div>
			</div>
			
			
			<!-- 파일 냈는지 폼 체크 -->
			
				<script>
				function check() {
				  if(fileSubmit.application.value == "") {
				    alert("신청서를 업로드해 주세요.");
				    fileSubmit.application.focus();
				    return false;
				  }
				  else if(fileSubmit.family.value == "") {
				    alert("가족관계증명서를 업로드해 주세요.");
				    fileSubmit.family.focus();
				    return false;
				  }
				  else if(fileSubmit.hc.value == "") {
					    alert("건강진단서를 업로드해 주세요.");
					    fileSubmit.hc.focus();
					    return false;
			      }
				  else if(fileSubmit.baby.value == "") {
					    alert("아이 예방접종 증명서를 업로드해 주세요.");
					    fileSubmit.baby.focus();
					    return false;
				  }
				  else return true;
				}
				</script>			

				<form  method="post" enctype="Multipart/form-data" name="fileSubmit" onsubmit="return check()">
					<div class="submit-table-container">
						<div class = "submit-table">
							<div class="row">
								<div class="cell th">신청서</div>
								<div class="cell td"><input type="text" class="file_route" readonly="readonly" id="file_route1"/></div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="application-form" name="application"
										onchange="javascript:document.getElementById('file_route1').value=this.value"/>
									<label for="application-form">파일찾기</label>
								</div>
							</div>
							<div class="row">
								<div class="cell th">가족관계증명서</div>
								<div class="cell td"><input type="text" class="file_route" readonly="readonly" id="file_route2"/></div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="family-rc-form" name="family" 
									onchange="javascript:document.getElementById('file_route2').value=this.value"/>
									<label for="family-rc-form">파일찾기</label>
								</div>
							</div>
							<div class="row">
								<div class="cell th">건강진단서</div>
								<div class="cell td"><input type="text" class="file_route" readonly="readonly" id="file_route3"/></div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="hc-form" name="hc"
									onchange="javascript:document.getElementById('file_route3').value=this.value"/>
									<label for="hc-form">파일찾기</label>
								</div>
							</div>
							<div class="row">
								<div class="cell th">아이 예방접종 증명서</div>
								<div class="cell td"><input type="text" class="file_route" readonly="readonly" id="file_route4"/></div>
								<div class="cell td">
									<input type="file" class="submitBtn" id="baby-form" name="baby"
									onchange="javascript:document.getElementById('file_route4').value=this.value"/>
									<label for="baby-form">파일찾기</label>
								</div>
							</div>
						</div>
					</div>
						
						<input type="submit" value="다음" class="agree-btn-container"/>
					</form>	
					</main>
				</div>
			</div>

	<!--  footer 집중화 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>

</body>
</html>