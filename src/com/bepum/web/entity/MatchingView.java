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


	public void setReviewNo(String no) {
		review.setNo(no);
	}


	public void setReviewWriterID(String writerID) {
		review.setWriterID(writerID);
	}


	public void setReviewMatchingNo(String matchingNo) {
		review.setMatchingNo(matchingNo);
	}


	public void setReviewRegDate(String regDate) {
		review.setRegDate(regDate);
	}


	public void setReviewGrade(String grade) {
		review.setGrade(grade);
	}

	public void setReviewTitle(String title) {
		review.setTitle(title);
	}

	public void setReviewContent(String content) {
		review.setContent(content);
	}
	
}
