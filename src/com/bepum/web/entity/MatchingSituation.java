package com.bepum.web.entity;

import java.util.Date;

public class MatchingSituation {

	private String no;
	private String status;
	private String requestID;
	private String bepumiID;
	
	public MatchingSituation() {
	}

	public MatchingSituation(String no, String status, String requestID, String bepumiID) {
		this.no = no;
		this.status = status;
		this.requestID = requestID;
		this.bepumiID = bepumiID;
	}

	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getBepumiID() {
		return bepumiID;
	}

	public void setBepumiID(String bepumiID) {
		this.bepumiID = bepumiID;
	}
	
	
	
}
