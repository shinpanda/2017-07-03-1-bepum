package com.bepum.web.entity;

import java.sql.Time;

public class Baby extends Bepumi {

	
	private String no;
	private String name;
	private String age;
	private String bepumiID;

	public Baby() {
		
	}

	public Baby(String no, String name, String age, String bepumiID) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.bepumiID = bepumiID;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBepumiID() {
		return bepumiID;
	}

	public void setBepumiID(String bepumiID) {
		this.bepumiID = bepumiID;
	}
	
	
}
