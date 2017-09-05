package com.bepum.web.entity;

import java.sql.Time;

public class Profile extends Bepumi {
/* 베푸미 활동관리
 * 아이디
 * 기타사항, 자기소개서
 * 베품 가능 시간
 * 공개 여부
 * 
 * + 사진 파일, 집 사진....
 */
	private String id;
	private String others;
	private String intro;
	private String bepumiDay;
	private String strTime;
	private String endTime;
	private String profileImg;
	private String houseImg;
	private int secret;

	public Profile() {
		
	}
	
	public Profile(String id, String others, String intro, String bepumiDay, String strTime, String endTime,
			String profileImg, String houseImg, int secret) {
		this.id = id;
		this.others = others;
		this.intro = intro;
		this.bepumiDay = bepumiDay;
		this.strTime = strTime;
		this.endTime = endTime;
		this.profileImg = profileImg;
		this.houseImg = houseImg;
		this.secret = secret;
	}






	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}

	
	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}






	public String getBepumiDay() {
		return bepumiDay;
	}






	public void setBepumiDay(String bepumiDay) {
		this.bepumiDay = bepumiDay;
	}






	public String getStrTime() {
		return strTime;
	}






	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}






	public String getEndTime() {
		return endTime;
	}






	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}






	public String getProfileImg() {
		return profileImg;
	}






	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}






	public String getHouseImg() {
		return houseImg;
	}






	public void setHouseImg(String houseImg) {
		this.houseImg = houseImg;
	}
	
	
}
