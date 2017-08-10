package com.bepum.web.entity;

import java.util.Date;

public class Message {
	/*
	 * 아이디 보낸 메시지, 누구에게 수신 메시지, 누가
	 */
	private String num;
	private String text;
	private Date date;
	private String from_id;
	private String to_id;

	public Message() {
		
	}
	public Message(String num, String text, Date date, String from_id, String to_id) {
		this.num = num;
		this.text = text;
		this.date = date;
		this.from_id = from_id;
		this.to_id = to_id;
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

	public String getFrom_id() {
		return from_id;
	}

	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}

	public String getTo_id() {
		return to_id;
	}

	public void setTo_id(String to_id) {
		this.to_id = to_id;
	}

}
