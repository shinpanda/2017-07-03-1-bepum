package com.bepum.web.entity;

import java.util.Date;

public class Review {
	private String no;
	private String writerID;
	private String matchingNo;
	private Date regDate;
	private int rating;
	private String title;
	private String content;
	private int hit;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Review(String no, String writerID, String matchingNo, Date regDate, int rating, String title,
			String content) {

		this.no = no;
		this.writerID = writerID;
		this.matchingNo = matchingNo;
		this.regDate = regDate;
		this.rating = rating;
		this.title = title;
		this.content = content;
		this.hit = hit;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getWriterID() {
		return writerID;
	}

	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}

	public String getMatchingNo() {
		return matchingNo;
	}

	public void setMatchingNo(String matchingNo) {
		this.matchingNo = matchingNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	
}
