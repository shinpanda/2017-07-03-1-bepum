package com.bepum.web.entity;

import java.util.Date;

public class Message {
	/*
	 * 아이디 보낸 메시지, 누구에게 수신 메시지, 누가
	 */
	private String num;
	private String text;
	private Date date;
	private String fromID;
	private String toID;

	public Message() {
		
	}
	public Message(String num, String text, Date date, String fromID, String toID) {
		this.num = num;
		this.text = text;
		this.date = date;
		this.fromID = fromID;
		this.toID = toID;;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFromID() {
		return fromID;
	}

	public void setFromID(String fromID) {
		this.fromID = fromID;
	}

	public String getToID() {
		return toID;
	}

	public void setToID(String toID) {
		this.toID = toID;
	}

}
