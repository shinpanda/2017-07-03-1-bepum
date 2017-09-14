package com.bepum.web.entity;

import java.util.Date;

public class Member {
/* 이름, 아이디
 * 패스워드
 * 성별, 주소
 * 생년월일, 전화번호
 * 이메일, 등급
 */	
	private String id;
	private String name;
	private String pwd;
	private int gender;
	private String birth;
	private String phone;
	private String address;
	
	private String email;
	private int grade;
	private Date regDate;
	
	public Member() {
		
	}
	public Member(String id, String name, String pwd, int gender, String birth, String email,String phone,String address, int grade, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
		this.regDate = regDate;
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
