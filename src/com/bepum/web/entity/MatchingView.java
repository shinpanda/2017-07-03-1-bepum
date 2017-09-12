package com.bepum.web.entity;

import java.util.Date;

public class MatchingView extends Matching {
	
	Baby baby;
	Review review;
	Payment payment;
	
	public MatchingView() {
		review = new Review();
		payment = new Payment();
		baby = new Baby();
	}
	
	public String getReviewNo() {
		return review.getNo();
	}

	public String getReviewWriterID() {
		return review.getWriterID();
	}

	public String getReviewMatchingNo() {
		return review.getMatchingNo();
	}


	public Date getReviewRegDate() {
		return review.getRegDate();
	}


	public int getReviewRating() {
		return review.getRating();
	}

	public String getReviewTitle() {
		return review.getTitle();
	}

	public String getReviewContent() {
		return review.getContent();
	}


	public void setReviewNo(String no) {
		review.setNo(no);
	}


	public void setReviewWriterID(String writerID) {
		review.setWriterID(writerID);
	}


	public void setReviewMatchingNo(String matchingNo) {
		review.setMatchingNo(matchingNo);
	}


	public void setReviewRegDate(Date regDate) {
		review.setRegDate(regDate);
	}


	public void setReviewRating(int rating) {
		review.setRating(rating);
	}

	public void setReviewTitle(String title) {
		review.setTitle(title);
	}

	public void setReviewContent(String content) {
		review.setContent(content);
	}
	
	
	public String getBabyNo() {
		return baby.getNo();
	}

	public void setBabyNo(String no) {
		baby.setNo(no);
	}

	public String getBabyName() {
		return baby.getName();
	}

	public void setBabyName(String name) {
		baby.setName(name);
	}

	public int getBabyAge() {
		return baby.getAge();
	}

	public void setBabyAge(int age) {
		baby.setAge(age);
	}
	
	public String getBabyBepumiID() {
		return baby.getBepumiID();
	}

	public void setBabyGender(int gender) {
		baby.setGender(gender);
	}
	
	public int getBabyGender()
	{
		return baby.getGender();
	}

	public String getPaymentNo() {
		return payment.getNo();
	}
	
	public void setPaymentNo(String no) {
		payment.setNo(no);
	}
	
	public int getPaymentOption() {
		return payment.getOption();
	}
	
	public void setPaymentOption(int option) {
		payment.setOption(option);
	}
	
	public Date getPaymentPayDate() {
		return payment.getPayDate();
	}
	
	public void setPaymentPayDate(Date payDate) {
		payment.setPayDate(payDate);
	}
}
