package com.bepum.web.entity;

import java.util.Date;

public class BoardView extends Board {
	private int countCmt;
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public BoardView(String no, String title, String content, String writerId, int hit, Date regDate, int open,
			String privateKey) {
		super(no, title, content, writerId, hit, regDate, open, privateKey);

	}


	public int getCountCmt() {
		return countCmt;
	}

	public void setCountCmt(int countCmt) {
		this.countCmt = countCmt;
	}
	
}
