package com.bepum.web.entity;

import java.util.Date;

public class Board {
/*
 * 모든 게시판
 * no, 게시물 종류, 
 * 제목, 글쓴이, 
 * 작성 날짜, 공개 여부
 */
	private int no;
	private String title;
	private String writer;
	private Date reg_date;
	private boolean open;
	
	public Board() {
		
	}
	
	public Board(int no, String title, String writer, Date reg_date, boolean open) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.reg_date = reg_date;
		this.open = open;
	}



	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	
}
