package com.bepum.web.entity;

import java.util.Date;

public class Matching {
/*
 * no, 신청자, 베푸미, 베푸미 등급
 * 베품 날짜, 베품 시간, 베품을 신청한 날짜, 아기 이름, 아기 나이, 요구사항 , 
 * 진행 상황
 */
	private String applicant;
	private String bepumi;
	private int bp_grade;
	private Date mat_date;
	private Date req_date;
	private String babyname;
	private int babyage;
	private String req_msg;
	private int progress;
	
	public Matching() {
		
	}

	public Matching(String applicant, String bepumi, int bp_grade, Date mat_date, Date req_date, String babyname,
			int babyage, String req_msg, int progress) {
		super();
		this.applicant = applicant;
		this.bepumi = bepumi;
		this.bp_grade = bp_grade;
		this.mat_date = mat_date;
		this.req_date = req_date;
		this.babyname = babyname;
		this.babyage = babyage;
		this.req_msg = req_msg;
		this.progress = progress;
	}

	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getBepumi() {
		return bepumi;
	}
	public void setBepumi(String bepumi) {
		this.bepumi = bepumi;
	}
	public int getBp_grade() {
		return bp_grade;
	}
	public void setBp_grade(int bp_grade) {
		this.bp_grade = bp_grade;
	}
	public Date getMat_date() {
		return mat_date;
	}
	public void setMat_date(Date mat_date) {
		this.mat_date = mat_date;
	}
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(Date req_date) {
		this.req_date = req_date;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getBabyname() {
		return babyname;
	}

	public void setBabyname(String babyname) {
		this.babyname = babyname;
	}

	public int getBabyage() {
		return babyage;
	}

	public void setBabyage(int babyage) {
		this.babyage = babyage;
	}

	public String getReq_msg() {
		return req_msg;
	}

	public void setReq_msg(String req_msg) {
		this.req_msg = req_msg;
	}
	
	
	
}
