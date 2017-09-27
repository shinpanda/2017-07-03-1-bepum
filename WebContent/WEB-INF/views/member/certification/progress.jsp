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
				<div class="document-certification1">재심사가 필요한 서류의 경우, [재심사
					필요]버튼을 눌러 다시 제출해주세요.</div>


				<div class="document-wrapper">
					<div class="application-form-wrapper clearfix">
						<div class="title-box dc-name">신청서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 완료</span> <span>
								<a href="#layer2" class="btn-recheck">재심사 필요</a>
							</span>
						</div>
					</div>
					<script>
						var spans = document.querySelector('.application-form-wrapper').querySelectorAll('span');
						for(var i in spans){
							var spanText = spans[i].innerHTML;
							if(typeof spanText != "undefined"){
								if(spanText.indexOf('${profile.applicationFormStatus}')>=0){
									spans[i].classList.add('progress-status');
								}
							}
						}
						/* for (var i = 0; i < 4; i++) {
							if ($('.application-form-wrapper').find('span').eq(
									i).html().indexOf('${profile.applicationFormStatus}') >= 0) {
								$('.application-form-wrapper').find('span').eq(
										i).addClass('progress-status');
							}
						} */
					</script>
					<div class="family-rc-wrapper clearfix">
						<div class="title-box dc-name">가족관계증명서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 완료</span> <span>
								<a href="#layer3" class="btn-recheck">재심사 필요</a>
							</span>
						</div>
					</div>
					<script>
						var spans = document.querySelector('.family-rc-wrapper').querySelectorAll('span');
						for(var i in spans){
							var spanText = spans[i].innerHTML;
							if(typeof spanText != "undefined"){
								if(spanText.indexOf('${profile.FRCStatus}')>=0){
									spans[i].classList.add('progress-status');
								}
							}
						}
						/* for (var i = 0; i < 4; i++) {
							if ($('.family-rc-wrapper').find('span').eq(i)
									.html().indexOf('${profile.FRCStatus}') >= 0) {
								$('.family-rc-wrapper').find('span').eq(i)
										.addClass('progress-status');
							}
						} */
					</script>
					<div class="hc-wrapper clearfix">
						<div class="title-box dc-name">건강진단서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 완료</span> <span>
								<a href="#layer4" class="btn-recheck">재심사 필요</a>
							</span>
						</div>
					</div>
					<script>
					var spans = document.querySelector('.hc-wrapper').querySelectorAll('span');
					for(var i in spans){
						var spanText = spans[i].innerHTML;
						if(typeof spanText != "undefined"){
							if(spanText.indexOf('${profile.HCStatus}')>=0){
								spans[i].classList.add('progress-status');
							}
						}
					}
						/* for (var i = 0; i < 4; i++) {
							if ($('.hc-wrapper').find('span').eq(i).html()
									.indexOf('${profile.HCStatus}') >= 0) {
								$('.hc-wrapper').find('span').eq(i).addClass(
										'progress-status');
							}
						} */
					</script>

					<div class="baby-wrapper clearfix">
						<div class="title-box dc-name">아이 예방접종 증명서</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 완료</span> <span>
								<a href="#layer5" class="btn-recheck">재심사 필요</a>
							</span>
						</div>
					</div>
					<script>
					var spans = document.querySelector('.baby-wrapper').querySelectorAll('span');
					for(var i in spans){
						var spanText = spans[i].innerHTML;
						if(typeof spanText != "undefined"){
							if(spanText.indexOf('${profile.VCStatus}')>=0){
								spans[i].classList.add('progress-status');
							}
						}
					}
						/* for (var i = 0; i < 4; i++) {
							if ($('.baby-wrapper').find('span').eq(i).html()
									.indexOf('${profile.VCStatus}') >= 0) {
								$('.baby-wrapper').find('span').eq(i).addClass(
										'progress-status');
							}
						} */
					</script>
				</div>
			</div>
			</main>

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
							<b>***재심사 요청 사유***</b><br> <br> 본인 인증에 사용된 성함과 서류상의
							성함이 일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
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
			</div>
		</div>
		<div class="dim-layer" style="display: none;">
			<div class="dimBg"></div>
			<div id="layer3" class="pop-layer"
				style="margin-top: -150px; margin-left: -260px;">
				<div class="pop-container">
					<div class="pop-conts">
						<!--content //-->
						<p class="ctxt mb20">
							<b>***재심사 요청 사유***</b><br> <br> 본인 인증에 사용된 성함과 서류상의
							성함이 일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
						</p>

						<div class="btn-r">
							<div class="edit-box-container">
								<div class="edit-box-wrapper">
									<input type="file" class="editBtn" id="family-rc-edit"
										name="edit"> <label for="family-rc-edit">파일 찾기</label>
									<input type="submit" class="editBtn" id="family-rc-submit"
										name="filesubmit"> <label for="family-rc-submit">제출</label>
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
			<div id="layer4" class="pop-layer"
				style="margin-top: -150px; margin-left: -260px;">
				<div class="pop-container">
					<div class="pop-conts">
						<!--content //-->
						<p class="ctxt mb20">
							<b>***재심사 요청 사유***</b><br> <br> 본인 인증에 사용된 성함과 서류상의
							성함이 일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
						</p>

						<div class="btn-r">
							<div class="edit-box-container">
								<div class="edit-box-wrapper">
									<input type="file" class="editBtn" id="hc-edit" name="edit">
									<label for="hc-edit">파일 찾기</label> <input type="submit"
										class="editBtn" id="hc-submit" name="filesubmit"> <label
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
							<b>***재심사 요청 사유***</b><br> <br> 본인 인증에 사용된 성함과 서류상의
							성함이 일치하지 않습니다.<br> 적합한 서류를 다시 제출해주세요!<br> <br>
						</p>

						<div class="btn-r">
							<div class="edit-box-container">
								<div class="edit-box-wrapper">
									<input type="file" class="editBtn" id="baby-edit" name="edit">
									<label for="baby-edit">파일 찾기</label> <input type="submit"
										class="editBtn" id="baby-submit" name="filesubmit"> <label
										for="baby-submit">제출</label>
								</div>
							</div>
							<a href="#" class="btn-layerClose">Close</a>
						</div>
						<!--// content-->
					</div>
				</div>
			</div>
		</div>
	</form>


	<script type="text/javascript">
		var btnRecheck = document.querySelectorAll('.btn-recheck')
		for(var a in btnRecheck){
			btnRecheck[a].onclick = function() {
				var href = this.getAttribute('href');// 이렇게 하면 전체 href를 가져옴
				
				//alert(typeof href);
				layer_popup(href);
			};
		}
		
		
 		function layer_popup(el) {
 			var el = document.querySelector(el);
			/* var el = $(el); //레이어의 id를 $el 변수에 저장
			var isDim = el.prev().hasClass('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수 */
			//alert(el.previousElementSibling);
			var isDim = el.previousElementSibling.classList.contains('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수
			
			function fadeIn(element){
				var timeId = null;
				element.style.opacity = 0;
				
				element.style.display="block";
				
				if(timeId == null){
					timeId = setInterval(function(){
						var opacity = parseFloat(element.style.opacity);
						if((opacity + 0.2) >= 1.0){
							clearInterval(timeId);
							timeId = null;
						}
						element.style.opacity = opacity + 0.2;
					}, 50);
				}

			};
			
			function fadeOut(element){
				var timeId = null;
				var opacity = parseInt(element.style.opacity);				
				if(timeId == null){
					timeId = setInterval(function(){
						var opacity = parseFloat(element.style.opacity);	
						if((opacity - 0.2) <= 0){
							clearInterval(timeId);
							timeId = null;
							element.style.display="none";
						}
						element.style.opacity = (opacity - 0.2);
					}, 30);
				}
			};
			isDim ? fadeIn(el.parentNode) : fadeIn(el);
			//isDim ? el.parentNode.style.display="block" : el.display="block";
			
			/*  if(isDim == true){
				el.parentNode.style.opacity = 0;
				el.parentNode.style.display="block";
				var timeId = null;
				if(timeId == null){
					 timerId = setInterval(function() {
						var opacity = el.parentNode.style.opacity;
						if(timeId == null){
							timeId = setInterval(function(){
								el.parentNode.style.opacity += 1;
								if(opacity == 1)
									timeId = null;
							}, 1000);
						}
					});
				}
				
			}else{
				el.style.opacity = 0;
				el.style.display="block";
				var timeId = null;
				if(timeId == null){
					timerId = setInterval(function() {
						el.style.opacity = 0;
						if(timeId == null){
							timeId = setInterval(function(){
								el.style.opacity += 0.1;
								if(el.style.opacity == 1)
									timeId = null;
							}, 50);
						}
					});
				}
			} */

			/* var elWidth = ~~(el.outerWidth), elHeight = ~~(el.outerHeight), docWidth = document.width, docHeight = document.height;

			// 화면의 중앙에 레이어를 띄운다.
			if (elHeight < docHeight || elWidth < docWidth) {
				el.style.marginTop = -elHeight / 2;
				el.style.marginLeft = -elWidth / 2;
			} else {
				el.style.top = 0;
				el.style.left = 0;
			}  */
			
			el.querySelector('a.btn-layerClose').onclick = function() {
				isDim ? fadeOut(el.parentNode) : fadeOut(el);
				//isDim ? el.parentNode.style.display="none" : el.style.display="none"; // 닫기 버튼을 클릭하면 레이어가 닫힌다.
				return false;
			};

			/* el.querySelector('.layer .dimBg').onclick = function() {
				fadeOut(el.parentNode);
				//el.parentNode.style.display="none";
				return false;
			}; */
			
		}
		/* $('.btn-recheck').click(function() {
			var $href = $(this).attr('href');
			layer_popup($href);
		});
		function layer_popup(el) {
			//var $el = $(el);
			var $el = $("a[href*='"+el+"']");
			var el = new jQuery(el); //레이어의 id를 $el 변수에 저장
			if(el.previousElementSibling != "undefined")
				var isDim = el.previousElementSibling.classList.contains('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수
		
			//isDim ? $el.parentNode.fadeIn() : $el.fadeIn();

			 /*var $elWidth = ~~($el.outerWidth()), $elHeight = ~~($el.outerHeight()), docWidth = $(document).width(), docHeight = $(document).height();

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

		} */
		
		/* function layer_popup(el) {
			//var $el = $(el);
			var $el = new jQuery(el); //레이어의 id를 $el 변수에 저장
			var isDim = $el.prev().hasClass('dimBg'); //dimmed 레이어를 감지하기 위한 boolean 변수

			isDim ? $el.parent(".dim-layer").fadeIn() : $el.fadeIn();

			var $elWidth = ~~($el.outerWidth()), $elHeight = ~~($el.outerHeight()), docWidth = $(document).width(), docHeight = $(document).height();

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

		} */
	</script>

	<!-- 팝업 여기까지 -->


	<jsp:include page="../../inc/footer.jsp"></jsp:include>
</body>
</html>