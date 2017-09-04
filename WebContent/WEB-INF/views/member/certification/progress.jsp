<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><head>
<meta charset="UTF-8">
<link href="../css/common_style.css" type="text/css" rel="stylesheet">
<link href="../css/style2.css" type="text/css" rel="stylesheet">
<link href="../css/certification.css" type="text/css" rel="stylesheet">
<title>베:품</title>
</head>

<body>

<!-- header 집중화 -->
	





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		var str=$(location).attr('pathname');
		var index = str.indexOf('/', 3);
		var res = str.substr(index+1);

		$("a[href*='"+res+"']").parents(".sub-menu").removeClass('hidden');
		$("a[href*='"+res+"']").addClass("on");
	});
</script>

<!-- LOGIN팝업  -->
 <script language="javascript">
	function showPopup() {
		window.open("/bepum/member/sign", "로그인/회원가입",
				"resizable=no width=562, height=800, left=600, top=50");
		
	}
</script>




	<header id="header">
	<div class="content-container clearfix">
		<a href="/bepum/index"><img src="/bepum/images/1616.png" id="logo" alt="베품"></a>
		<section id="menu-container"> 
		<nav class="menu-wrapper">

			<ul class="main-menu">
				<li><a href="">소개</a>
					<ul class="sub-menu hidden">
						<li><a href="/bepum/index">서비스 소개</a></li>
						<li><a href="/bepum/index">이용방법</a></li>
					</ul></li>
				<li><a href="/bepum/member/certification-progress" class="on">베푸미 되기</a><!-- 임시 -->
					<ul class="sub-menu">
						<li><a href="/bepum/member/certification-progress" class="on">진행 상황</a></li>
						<li><a href="/bepum/member/certification-request">서류 인증</a></li>
					</ul></li>	
				<li><a href="/bepum/bepumi/profile">베푸미 활동 관리</a>
					<ul class="sub-menu hidden">
						<li><a href="/bepum/bepumi/profile">프로필 관리</a></li>
						<li><a href="/bepum/bepumi/matching-list">매칭 내역</a></li>
					</ul></li>	
				<li><a href="/bepum/searching/matching-list">베푸미 찾기</a>
					<ul class="sub-menu hidden">
						<li><a href="/bepum/searching/bepumi-list">조건별 베푸미 찾기</a></li>
						<li><a href="/bepum/searching/matching-list">매칭 내역</a></li>
					</ul></li>
				<li><a href="/bepum/board/free">커뮤니티</a>
					<ul class="sub-menu hidden">
						<li><a href="/bepum/board/free">자유게시판</a></li>
						<li><a href="/bepum/board/review">후기게시판</a></li>
					</ul></li>
				<li><a href="/bepum/board/question">문의/FAQ</a>
					<ul class="sub-menu hidden">
						<li><a href="/bepum/board/question">문의게시판</a></li>
						<li><a href="/bepum/board/report">신고게시판</a></li>
					</ul>
					</li>
			</ul>
		</nav> 
		<nav class="menu-wrapper">
		<ul id="login">
			<li><a href="" onclick="javascript:showPopup();" class="btn-border">Sign in</a></li>
		</ul>
		</nav>
		<div id="sub-bg"></div>
		</section>
	</div>
	</header>


	
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
				<div class="document-certification1">재심사가 필요한 서류의 경우, [재심사 필요] 버튼을 눌러 다시 제출해주세요.</div>
				<div class="document-wrapper">
					<div class="application-form-wrapper clearfix">
						
						<div class="title-box dc-name">신청서</div>
						<div class="progress">
							<span>제출 전</span> 
							<span>제출 완료</span> 
							<span>심사 중</span> 
							<span>심사 완료</span> 
							<span class="progress-status">
								<a href="#layer2" class="btn-recheck">재심사 필요</a>
							
<!-- 재심사필요 팝업 -->							
							<form method="post">
								<div class="dim-layer" style="display: none;">
								    <div class="dimBg"></div>
								    <div id="layer2" class="pop-layer" style="margin-top: -150px; margin-left: -260px;">
								        <div class="pop-container">
								            <div class="pop-conts">
								                <!--content //-->
								                <p class="ctxt mb20">
								                	<b>***재심사 요청 사유***</b><br><br>
								                    본인 인증에 사용된 성함과 서류상의 성함이 일치하지 않습니다.<br>
								                    적합한 서류를 다시 제출해주세요!<br><br>
								                </p>
								
								                <div class="btn-r">
								                <div class="edit-box-container">
													<div class="edit-box-wrapper">
														<input type="file" class="editBtn" id="application-form-edit" name="edit">
														<label for="application-form-edit">파일 찾기</label>
														<input type="submit" class="editBtn" id="application-form-submit" name="filesubmit">
														<label for="application-form-submit">제출</label>
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
							</span>
							
							<script type="text/javascript">
							$('.btn-recheck').click(function(){
						        var $href = $(this).attr('href');
						        layer_popup($href);
						    });
						    function layer_popup(el){

						        var $el = $(el);        //레이어의 id를 $el 변수에 저장
						        var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

						        isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

						        var $elWidth = ~~($el.outerWidth()),
						            $elHeight = ~~($el.outerHeight()),
						            docWidth = $(document).width(),
						            docHeight = $(document).height();

						        // 화면의 중앙에 레이어를 띄운다.
						        if ($elHeight < docHeight || $elWidth < docWidth) {
						            $el.css({
						                marginTop: -$elHeight /2,
						                marginLeft: -$elWidth/2
						            })
						        } else {
						            $el.css({top: 0, left: 0});
						        }

						        $el.find('a.btn-layerClose').click(function(){
						            isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
						            return false;
						        });

						        $('.layer .dimBg').click(function(){
						            $('.dim-layer').fadeOut();
						            return false;
						        });

						    }</script>
						</div>
					</div>				
<!-- 팝업 여기까지 -->			

		
					<div class="family-rc-wrapper clearfix">
						<div class="title-box dc-name">가족관계증명서</div>
						<div class="progress">
							<span>제출 전</span>
							<span>제출 완료</span>
							<span>심사 중</span>
							<span>심사완료</span>
							<span class="progress-status">
								<a href="#layer3" class="btn-recheck">재심사 필요</a>
							</span>
							<!-- 재심사필요 팝업 -->							
							<form method="post">
								<div class="dim-layer" style="display: none;">
								    <div class="dimBg"></div>
								    <div id="layer3" class="pop-layer" style="margin-top: -150px; margin-left: -260px;">
								        <div class="pop-container">
								            <div class="pop-conts">
								                <!--content //-->
								                <p class="ctxt mb20">
								                	<b>***재심사 요청 사유***</b><br><br>
								                    본인 인증에 사용된 성함과 서류상의 성함이 일치하지 않습니다.<br>
								                    적합한 서류를 다시 제출해주세요!<br><br>
								                </p>
								
								                <div class="btn-r">
								                <div class="edit-box-container">
													<div class="edit-box-wrapper">
														<input type="file" class="editBtn" id="application-form-edit" name="edit">
														<label for="application-form-edit">파일 찾기</label>
														<input type="submit" class="editBtn" id="application-form-submit" name="filesubmit">
														<label for="application-form-submit">제출</label>
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
							$('.btn-recheck').click(function(){
						        var $href = $(this).attr('href');
						        layer_popup($href);
						    });
						    function layer_popup(el){

						        var $el = $(el);        //레이어의 id를 $el 변수에 저장
						        var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

						        isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

						        var $elWidth = ~~($el.outerWidth()),
						            $elHeight = ~~($el.outerHeight()),
						            docWidth = $(document).width(),
						            docHeight = $(document).height();

						        // 화면의 중앙에 레이어를 띄운다.
						        if ($elHeight < docHeight || $elWidth < docWidth) {
						            $el.css({
						                marginTop: -$elHeight /2,
						                marginLeft: -$elWidth/2
						            })
						        } else {
						            $el.css({top: 0, left: 0});
						        }

						        $el.find('a.btn-layerClose').click(function(){
						            isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
						            return false;
						        });

						        $('.layer .dimBg').click(function(){
						            $('.dim-layer').fadeOut();
						            return false;
						        });

						    }</script>
						</div>
					</div>				
<!-- 팝업 여기까지 -->	
						</div>
					</div>
					
					
					<div class="hc-wrapper clearfix">
						<div class="title-box dc-name">건강진단서</div>
						<div class="progress">
							<span>제출 전</span>
							<span>제출 완료</span>
							<span>심사 중</span>
							<span>심사완료</span>
							<span class="progress-status">재심사 필요</span>
						</div>
					</div>
					
					
					<div class="baby-wrapper clearfix">
						<div class="title-box dc-name">아가</div>
						<div class="progress">
							<span>제출 전</span> <span>제출 완료</span> <span>심사 중</span> <span>심사
								완료</span> <span class="progress-status">재심사 필요</span>
						</div>
					</div>
				</main></div>
			</div>
		
	
	
	
<!--  footer 집중화 -->
	

<footer id="footer">
		<div class="content-container">
			<h2>베품</h2>
			<br>
			<div>
				<p>상호:베품</p>
				<p>전화번호:010-000-000</p>
				<p>관리자 이메일:admin@bepum.com</p>
			</div>
			<p>Copyright ⓒ bepum.com 2017-2017 All Right Reserved. Contact
				admin@bepum.com for more information</p>
		</div>
</footer>


</body></html>