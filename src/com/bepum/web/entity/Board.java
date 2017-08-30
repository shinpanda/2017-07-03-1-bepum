package com.bepum.web.entity;

import java.util.Date;

public class Board {
/*
 * 모든 게시판
 * no, 게시물 종류, 
 * 제목, 글쓴이, 
 * 작성 날짜, 공개 여부
 */
	private String no;
	private String title;
	private String content;
	private String writerId;
	private int hit;
	private Date regDate;
	private int open;
	private String privateKey;
	
	public Board() {
		
	}

	public Board(String no, String title, String content, String writerId, int hit, Date regDate, int open, String privateKey) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.hit = hit;
		this.regDate = regDate;
		this.open = open;
		this.setPrivateKey(privateKey);
	}
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}




	
}
