package com.bepum.web.entity;

import java.util.Date;

public class BoardView extends Board {
	private int countCmt;
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}
	

	public BoardView(String no, String title, String content, String writerId, int hit, Date regDate, int countCmt) {
		super();
		this.countCmt = countCmt;
	}


	public int getCountCmt() {
		return countCmt;
	}

	public void setCountCmt(int countCmt) {
		this.countCmt = countCmt;
	}
	
}
