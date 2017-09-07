package com.bepum.web.entity;

import java.sql.Time;

public class Bepumi extends Member {
/* 베푸미 활동관리
 * 아이디
 * 기타사항, 자기소개서
 * 베품 가능 시간
 * 공개 여부
 * 
 * + 사진 파일, 집 사진....
 */
	
	private String id;
	private String address;
	private String phoneNum;
	private Baby baby; //음.. 베이비는 하나만 있는 것도 아닌데.. 이렇게 둬도 되는 건가.....

	public Bepumi() {
	}
	
	public Bepumi(String id, String address, String phoneNum) {
		this.id = id;
		this.address = address;
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Baby getBaby() {
		return baby;
	}

	
}
