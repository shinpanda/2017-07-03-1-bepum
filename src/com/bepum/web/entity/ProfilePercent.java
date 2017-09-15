package com.bepum.web.entity;

public class ProfilePercent {
	int requestPercent;
	int completePercent;
	
	public ProfilePercent() {
		// TODO Auto-generated constructor stub
	}

	public ProfilePercent(int requestPercent, int completePercent) {
		super();
		this.requestPercent = requestPercent;
		this.completePercent = completePercent;
	}

	public int getRequestPercent() {
		return requestPercent;
	}

	public void setRequestPercent(int requestPercent) {
		this.requestPercent = requestPercent;
	}

	public int getCompletePercent() {
		return completePercent;
	}

	public void setCompletePercent(int completePercent) {
		this.completePercent = completePercent;
	}
	
	
}
