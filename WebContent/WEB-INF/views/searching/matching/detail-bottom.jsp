<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 신청자 매칭완료 후에 후기 작성하는 페이지 -->
<div class="past-container">
	<div class="table-container">
		<h3>매칭 상세정보</h3>
		<div class="past-table">
			<div class="row">
				<div class="cell1">매칭신청일</div>
				<div class="cell2" style="">${profile.reqDate}</div>
			</div>
			<div class="row">
				<div class="cell1">돌보미 날짜</div>
				<div class="cell2" style="">${profile.bepumDate}
					${profile.startTime} >> ${profile.bepumDate} ${profile.endTime}</div>
			</div>

			<c:set var="paymentOption" value="무통장입금" />
			<c:if test="${profile.paymentOption == 0}">
				<c:set var="paymentOption" value="카드" />
			</c:if>

			<div class="row">
				<div class="cell1">결제 정보</div>
				<div class="cell2">
					결제 일자 > ${profile.paymentPayDate} <br /> 결제 방법 > ${paymentOption} <br />
					총 금액 > 70,000원

				</div>
			</div>
		</div>
	</div>
</div>

<div class="review-detail-container">
	<h3>후기</h3>
	<div class="review-container">
		<div class="review-title">
			<span>${profile.reviewTitle}</span>
			<div class="review-rating">
				<span>만족도</span> <span> 
				<c:forEach begin="1"
						end="${profile.reviewRating}" var="i"><img src="../images/smile-on.png" /></c:forEach><c:forEach begin="1" end="${5 - profile.reviewRating}" var="i"><img src="../images/smile.png" /></c:forEach>
				</span>
			</div>
		</div>
		<div class="review-content"><c:if test="${not empty profile.reviewContent}">${profile.reviewContent}</c:if><c:if test="${empty profile.reviewContent}">이 곳을 눌러 후기를 작성해주세요</c:if></div>
	</div>
</div>


<div class="review-popup hidden">
	<div class="review-reg-containter">
		<form method="post" class="review-form">

			<div class="review">
				<input type="text" name="review-title" placeholder="제목을 입력해주세요"
					value="${profile.reviewTitle}" />
				<textarea name="review-content" placeholder="내용을 입력해주세요">${profile.reviewContent}</textarea>
			</div>
			<div class="rating-container">
				<span>만족도 평가</span> <input type="radio" name="rating" value="1"
					id="r1" /> <label for="r1" class="rating"></label> <input
					type="radio" name="rating" value="2" id="r2" /> <label for="r2"
					class="rating"></label> <input type="radio" name="rating" value="3"
					id="r3" /> <label for="r3" class="rating"></label> <input
					type="radio" name="rating" value="4" id="r4" /> <label for="r4"
					class="rating"></label> <input type="radio" name="rating" value="5"
					id="r5" /> <label for="r5" class="rating"></label>
			</div>
			<c:if test="${not empty profile.reviewRating}">
				<script>
				
					var rating = '${profile.reviewRating}';
					document.querySelector('input:radio[name="rating"]:input[value=' + rating + ']').checked = true;
					/* $('input:radio[name="rating"]:input[value=' + rating + ']')
							.attr("checked", true);
					$(
							'input:radio[name="rating"]:input[value=' + rating
									+ '] + label').addClass("active").prevAll(
							".rating").addClass("active"); */
				</script>
			</c:if>
			<script>
				$(".rating").hover(
						function() {
							$(this).parent().children(".rating").removeClass(
									"active");
							$(this).addClass("active").prevAll(".rating")
									.addClass("active");
						});
				$(".rating-container")
						.mouseleave(
								function() {
									if (!$(
											".rating-container input[type='radio']")
											.is(':checked')) {
										$(this).children(".rating")
												.removeClass("active");
									} else if ($(
											".rating-container input[type='radio']")
											.is(':checked')) {
										$(this).children(".rating")
												.removeClass("active");
										$(
												".rating-container input[type='radio']:checked + label")
												.addClass("active").prevAll(
														".rating").addClass(
														"active");
									}
								});

				$(".rating").click(
						function() {
							$(this).parent().children(".rating").removeClass(
									"active");
							$(this).addClass("active").prevAll(".rating")
									.addClass("active");
						});
			</script>
			<div class="btn-container">
				<c:if test="${empty profile.reviewTitle}">
					<input type="submit" name="rv-submit" value="등록"
						class="btn review-btn">
				</c:if>
				<c:if test="${not empty profile.reviewTitle}">
					<input type="submit" name="rv-submit" value="수정"
						class="btn review-btn">
				</c:if>
				<button type="button" class="btn review-btn" id="review-cancel">취소</button>
			</div>

		</form>
	</div>
</div>

<script>
	$(".review-detail-container").click(function() {
		$(".review-popup").removeClass("hidden");
	});
	$("#review-cancel").click(function() {
		$(".review-popup").addClass("hidden");
	});

	$(document).mouseup(function(e) {
		// 팝업 아이디
		var container = $(".review-reg-containter");
		if (!container.is(e.target) && container.has(e.target).length === 0) {
			container.parent(".review-popup").addClass("hidden");
		}
	});
</script>
</div>
