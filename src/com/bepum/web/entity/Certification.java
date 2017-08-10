package com.bepum.web.entity;

import java.util.Date;

public class Certification {
	/*
	 * 자격증명서류들 아이디, 베푸미 여부(등급) 신청서, 주민등록등본, 가족관계 증명서, 건강진단서 신청일
	 */
	private String memId;
	private String application;
	private String hc; // 건강진단서
	private String frc; // 가족관계증명서
	private Date reqDate;

	public Certification() {
	}

	public Certification(String memId, String application, String hc, String frc, Date reqDate) {
		this.memId = memId;
		this.application = application;
		this.hc = hc;
		this.frc = frc;
		this.reqDate = reqDate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getHc() {
		return hc;
	}

	public void setHc(String hc) {
		this.hc = hc;
	}

	public String getFrc() {
		return frc;
	}

	public void setFrc(String frc) {
		this.frc = frc;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

}
