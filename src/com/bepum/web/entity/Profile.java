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
	private String etc;
	private String intro;
	private String bepumDay;
	private String strTime;
	private String endTime;
	private String profilePic;
	private String houseImg1;
	private String houseImg2;
	private String houseImg3;
	private String pay;
	private int secret;

	public Profile() {
		
	}

	public Profile(String id, String etc, String intro, String bepumDay, String strTime, String endTime,
			String profilePic, String houseImg1, String houseImg2, String houseImg3, String pay, int secret) {
		this.id = id;
		this.etc = etc;
		this.intro = intro;
		this.bepumDay = bepumDay;
		this.strTime = strTime;
		this.endTime = endTime;
		this.profilePic = profilePic;
		this.houseImg1 = houseImg1;
		this.houseImg2 = houseImg2;
		this.houseImg3 = houseImg3;
		this.pay = pay;
		this.secret = secret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getBepumDay() {
		return bepumDay;
	}

	public void setBepumDay(String bepumDay) {
		this.bepumDay = bepumDay;
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

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getHouseImg1() {
		return houseImg1;
	}

	public void setHouseImg1(String houseImg1) {
		this.houseImg1 = houseImg1;
	}

	public String getHouseImg2() {
		return houseImg2;
	}

	public void setHouseImg2(String houseImg2) {
		this.houseImg2 = houseImg2;
	}

	public String getHouseImg3() {
		return houseImg3;
	}

	public void setHouseImg3(String houseImg3) {
		this.houseImg3 = houseImg3;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public int getSecret() {
		return secret;
	}

	public void setSecret(int secret) {
		this.secret = secret;
	}
	
	
	
}
