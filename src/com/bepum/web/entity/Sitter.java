package com.bepum.web.entity;

import java.sql.Time;

public class Sitter {
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
	private String bepumi_day;
	private Time str_time;
	private Time end_time;
	private String profile_img;
	private String house_img;
	private boolean open;

	public Sitter() {
		
	}
	
	public Sitter(String id, String others, String intro, String bepumi_day, Time str_time, Time end_time, String profile_img,
			String house_img, boolean open) {
		this.id = id;
		this.others = others;
		this.intro = intro;
		this.bepumi_day = bepumi_day;
		this.str_time = str_time;
		this.end_time = end_time;
		this.profile_img = profile_img;
		this.house_img = house_img;
		this.open = open;
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
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public Time getStr_time() {
		return str_time;
	}

	public void setStr_time(Time str_time) {
		this.str_time = str_time;
	}

	public Time getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Time end_time) {
		this.end_time = end_time;
	}

	public String getProfile_img() {
		return profile_img;
	}

	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}

	public String getHouse_img() {
		return house_img;
	}

	public void setHouse_img(String house_img) {
		this.house_img = house_img;
	}

	public String getBepumi_day() {
		return bepumi_day;
	}

	public void setBepumi_day(String bepumi_day) {
		this.bepumi_day = bepumi_day;
	}
	
	
}
