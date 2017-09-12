package com.bepum.web.entity;

import java.sql.Time;

public class Baby extends Bepumi {

	
	private String no;
	private String name;
	private int age;
	private String bepumiID;
	private int gender;

	public Baby() {
		
	}

	public Baby(String no, String name, int age, String bepumiID, int gender) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.bepumiID = bepumiID;
		this.gender=gender;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBepumiID() {
		return bepumiID;
	}

	public void setBepumiID(String bepumiID) {
		this.bepumiID = bepumiID;
	}
	

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	
}
