package com.bepum.web.entity;

import java.util.Date;

public class SecretBoardView extends Board {
	private int isPrivate;
	private String privateKey;
	private int countCmt;
	
	public SecretBoardView() {
		// TODO Auto-generated constructor stub
	}
	
	

	public SecretBoardView(String no, String title, String content, String writerId, int hit, Date regDate, int isPrivate, String privateKey, int countCmt) {
		super();
		this.isPrivate = isPrivate;
		this.privateKey = privateKey;
		this.countCmt = countCmt;
	}



	public int getCountCmt() {
		return countCmt;
	}

	public void setCountCmt(int countCmt) {
		this.countCmt = countCmt;
	}



	public int getIsPrivate() {
		return isPrivate;
	}



	public void setIsPrivate(int isPrivate) {
		this.isPrivate = isPrivate;
	}



	public String getPrivateKey() {
		return privateKey;
	}



	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
	
	
}
