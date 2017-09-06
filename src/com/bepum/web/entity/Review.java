package com.bepum.web.entity;

public class Review {
	private String no;
	private String writerID;
	private String matchingNo;
	private String regDate;
	private String grade;
	private String title;
	private String content;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String no, String writerID, String matchingNo, String regDate, String grade, String title,
			String content) {
		this.no = no;
		this.writerID = writerID;
		this.matchingNo = matchingNo;
		this.regDate = regDate;
		this.grade = grade;
		this.title = title;
		this.content = content;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
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
	
	
	
}
