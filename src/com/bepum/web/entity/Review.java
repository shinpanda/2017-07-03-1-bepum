package com.bepum.web.entity;

import java.util.Date;

public class Review {
	private String no;
	private String writerID;
	private String matchingNo;
	private Date regDate;
	private String grade;
	private String title;
	private String content;
	private int hit;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String no, String writerID, String matchingNo, Date regDate, String grade, String title,
			String content, int hit) {
		this.no = no;
		this.writerID = writerID;
		this.matchingNo = matchingNo;
		this.regDate = regDate;
		this.grade = grade;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
