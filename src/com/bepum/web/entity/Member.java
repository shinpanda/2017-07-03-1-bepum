package com.bepum.web.entity;

public class Member {
/* 이름, 아이디
 * 성별, 주소
 * 생년월일, 전화번호
 * 이메일, 등급
 */	
	private String name;
	private String id;
	private int gender;
	private String addr;
	private String birth;
	private String e_addr;
	private String p_num;
	private int grade;
	
	public Member() {
		
	}
	public Member(String name, String id, int gender, String addr, String birth, String e_addr, String p_num,
			int grade) {
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.addr = addr;
		this.birth = birth;
		this.e_addr = e_addr;
		this.p_num = p_num;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getE_addr() {
		return e_addr;
	}
	public void setE_addr(String e_addr) {
		this.e_addr = e_addr;
	}
	public String getP_num() {
		return p_num;
	}
	public void setP_num(String p_num) {
		this.p_num = p_num;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}	
}
