package com.bepum.web.entity;

public class ProfileView extends Profile{

	Baby baby;
	
	public ProfileView() {
		baby = new Baby();
	}
	
	
	public String getBabyNo() {
		return baby.getNo();
	}

	public void setBabyNo(String no) {
		baby.setNo(no);
	}

	public String getBabyName() {
		return baby.getName();
	}

	public void setBabyName(String name) {
		baby.setName(name);
	}

	public int getBabyAge() {
		return baby.getAge();
	}

	public void setBabyAge(int age) {
		baby.setAge(age);
	}

	public String getBabyBepumiID() {
		return baby.getBepumiID();
	}
	
	public int getBabyGender() {
		return baby.getGender();
	}

	public void setBabyGender(int gender) {
		baby.setGender(gender);
	}
}
