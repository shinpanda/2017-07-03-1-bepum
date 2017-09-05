package com.bepum.web.entity;

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
	private String email;
	private int grade;
	
	public Member() {
		
	}
	public Member(String id, String name, String pwd, int gender, String birth, String email, int grade) {
		this.name = name;
		this.id = id;
		this.pwd=pwd;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.grade = grade;
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
	
	
}
