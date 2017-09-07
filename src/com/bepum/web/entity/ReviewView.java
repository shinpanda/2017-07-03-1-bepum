package com.bepum.web.entity;

import java.util.Date;

public class ReviewView extends Review {
	Matching matching;
	
	public ReviewView() {
		matching = new Matching();
	}
	
	public String getBepumiID() {
		return matching.getBepumiID();
	}

	public void setBepumiID(String bepumiID) {
		matching.setBepumiID(bepumiID);
	}

	public Date getReqDate() {
		return matching.getReqDate();
	}

	public void setReqDate(Date reqDate) {
		matching.setReqDate(reqDate);
	}

	public Date getBepumDate() {
		return matching.getBepumDate();
	}

	public void setBepumDate(Date bepumDate) {
		matching.setBepumDate(bepumDate);
	}
	
	public String getRequirement() {
		return matching.getRequirement();
	}

	public void setRequirement(String requirement) {
		matching.setRequirement(requirement);
	}

}
