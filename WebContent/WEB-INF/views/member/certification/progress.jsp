<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/certification.css" type="text/css" rel="stylesheet">
<title>베:품</title>
</head>

<body>

	<jsp:include page="../../inc/header.jsp"></jsp:include>


	<div id="body">

		<div class="content-container">
			<main class="main">
			<h3>심사 진행 상황</h3>

			<div class="certfi-container">
				<div class="self-certification">본인 인증</div>
				<div class="self-certification-check">인증이 완료되었습니다.</div>
			</div>
			<br>
			<br>
			<br>

			<div class="certfi-container document-container">
				<div class="document-certification">필수서류 인증</div>
				<div class="document-certification1">
					재심사가 필요한 서류의 경우, [재심사 필요]버튼을 눌러 다시 제출해주세요.</div>
					
					
			<div class="document-wrapper">
				<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">신청서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 중</span> <span>심사
								완료</span>
								<span class="progress-status">
								<a href="#layer2" class="btn-recheck">재심사 필요</a>
							</span>
						</div>
				</div>
				
				<div class="family-rc-wrapper clearfix">
					<div class="title-box dc-name">가족관계증명서</div>
					<div class="progress">
						<span>제출 전</span> <span>제출 완료</span> <span>심사 중</span> <span>심사완료</span>
						<span class="progress-status">
						<a href="#layer3" class="btn-recheck">재심사 필요</a>
						</span>
					</div>
				</div>
					
					
				<div class="hc-wrapper clearfix">
					<div class="title-box dc-name">건강진단서</div>
					<div class="progress">
						<span>제출 전</span>
						<span>제출 완료</span>
						<span>심사 중</span> 
						<span>심사완료</span>
						<span class="progress-status">
						<a href="#layer4" class="btn-recheck">재심사 필요</a>
						</span>
					</div>
				</div>


				<div class="baby-wrapper clearfix">
					<div class="title-box dc-name">아이 예방접종 증명서</div>
					<div class="progress">
						<span>제출 전</span>
						<span>제출 완료</span>
						<span>심사 중</span>
						<span>심사완료</span>
						<span class="progress-status">
						<a href="#layer5" class="btn-recheck">재심사 필요</a>
						</span>
					</div>
				</div>
			</div>
			</div>
			</main>
			
		</div>
	</div>
				</div>
			</div>





	<!-- 재심사필요 팝업 -->
	<form method="post">
		<div class="dim-layer" style="display: none;">
			<div class="dimBg"></div>
			<div id="layer2" class="pop-layer"
				style="margin-top: -150px; margin-left: -260px;">
				<div class="pop-container">
					<div class="pop-conts">
						<!--content //-->
						<p class="ctxt mb20">
							<b>***재심사 요청 사유***111</b><br> <br> 본인 인증에 사용된 성함과 서류상의 성함이
							일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
						</p>

						<div class="btn-r">
							<div class="edit-box-container">
								<div class="edit-box-wrapper">
									<input type="file" class="editBtn" id="application-form-edit"
										name="edit"> <label for="application-form-edit">파일
										찾기</label> <input type="submit" class="editBtn"
										id="application-form-submit" name="filesubmit"> <label
										for="application-form-submit">제출</label>
								</div>
							</div>
							<a href="#" class="btn-layerClose">Close</a>
						</div>
						<!--// content-->
					</div>
				</div>
			</div></div>
			<div class="dim-layer" style="display: none;">
				<div class="dimBg"></div>
				<div id="layer3" class="pop-layer"
					style="margin-top: -150px; margin-left: -260px;">
					<div class="pop-container">
						<div class="pop-conts">
							<!--content //-->
							<p class="ctxt mb20">
								<b>***재심사 요청 사유***222</b><br> <br> 본인 인증에 사용된 성함과 서류상의
								성함이 일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
							</p>

							<div class="btn-r">
								<div class="edit-box-container">
									<div class="edit-box-wrapper">
										<input type="file" class="editBtn" id="family-rc-edit"
											name="edit"> <label for="family-rc-edit">파일
											찾기</label> <input type="submit" class="editBtn"
											id="family-rc-submit" name="filesubmit"> <label
											for="family-rc-submit">제출</label>
									</div>
								</div>
								<a href="#" class="btn-layerClose">Close</a>
							</div>
							<!--// content-->
						</div>
					</div>
				</div></div>
				<div class="dim-layer" style="display: none;">
					<div class="dimBg"></div>
					<div id="layer4" class="pop-layer"
						style="margin-top: -150px; margin-left: -260px;">
						<div class="pop-container">
							<div class="pop-conts">
								<!--content //-->
								<p class="ctxt mb20">
									<b>***재심사 요청 사유***333</b><br> <br> 본인 인증에 사용된 성함과 서류상의
									성함이 일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
								</p>

								<div class="btn-r">
									<div class="edit-box-container">
										<div class="edit-box-wrapper">
											<input type="file" class="editBtn" id="hc-edit"
												name="edit"> <label for="hc-edit">파일
												찾기</label> <input type="submit" class="editBtn"
												id="hc-submit" name="filesubmit"> <label
												for="hc-submit">제출</label>
										</div>
									</div>
									<a href="#" class="btn-layerClose">Close</a>
								</div>
								<!--// content-->
							</div>
						</div>
					</div>
				</div>
				<div class="dim-layer" style="display: none;">
				<div class="dimBg"></div>
				<div id="layer5" class="pop-layer"
					style="margin-top: -150px; margin-left: -260px;">
					<div class="pop-container">
						<div class="pop-conts">
							<!--content //-->
							<p class="ctxt mb20">
								<b>***재심사 요청 사유***444</b><br> <br> 본인 인증에 사용된 성함과 서류상의 성함이
								일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
							</p>
	
							<div class="btn-r">
								<div class="edit-box-container">
									<div class="edit-box-wrapper">
										<input type="file" class="editBtn" id="baby-edit"
											name="edit"> <label for="baby-edit">파일
											찾기</label> <input type="submit" class="editBtn"
											id="baby-submit" name="filesubmit"> <label
											for="baby-submit">제출</label>
									</div>
								</div>
								<a href="#" class="btn-layerClose">Close</a>
							</div>
							<!--// content-->
						</div>
					</div>
				</div></div>
	</form>


	<script type="text/javascript">
		$('.btn-recheck').click(function() {
			var $href = $(this).attr('href');
			layer_popup($href);
		});
		function layer_popup(el) {

			var $el = $(el); //레이어의 id를 $el 변수에 저장
			var isDim = $el.prev().hasClass('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수

			isDim ? $el.parent(".dim-layer").fadeIn() : $el.fadeIn();

			var $elWidth = ~~($el.outerWidth()), $elHeight = ~~($el
					.outerHeight()), docWidth = $(document).width(), docHeight = $(
					document).height();

			// 화면의 중앙에 레이어를 띄운다.
			if ($elHeight < docHeight || $elWidth < docWidth) {
				$el.css({
					marginTop : -$elHeight / 2,
					marginLeft : -$elWidth / 2
				})
			} else {
				$el.css({
					top : 0,
					left : 0
				});
			}

			$el.find('a.btn-layerClose').click(function() {
				isDim ? $el.parent(".dim-layer").fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
				return false;
			});

			$('.layer .dimBg').click(function() {
				$el.parent(".dim-layer").fadeOut();
				return false;
			});

		}
	</script>
	</div>
	</div>
	<!-- 팝업 여기까지 -->


	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>