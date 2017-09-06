package com.bepum.web.entity;

public class MatchingView extends Matching {
	
	Review review;
	
	public MatchingView() {
		review = new Review();
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


	public String getReviewRegDate() {
		return review.getRegDate();
	}


	public String getReviewGrade() {
		return review.getGrade();
	}

	public String getReviewTitle() {
		return review.getTitle();
	}

	public String getReviewContent() {
		return review.getContent();
	}


	public void setNo(String no) {
		review.setNo(no);
	}


	public void setWriterID(String writerID) {
		review.setWriterID(writerID);
	}


	public void setMatchingNo(String matchingNo) {
		review.setMatchingNo(matchingNo);
	}


	public void setRegDate(String regDate) {
		review.setRegDate(regDate);
	}

/*
	public void setGrade(String grade) {
		this.grade = grade;
	}
*/
	public void setTitle(String title) {
		review.setTitle(title);
	}

/*	public void setContent(String content) {
		this.content = content;
	}*/
	
}
