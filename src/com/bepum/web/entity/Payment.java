package com.bepum.web.entity;

import java.util.Date;

public class Payment {
	private String no;
	private int option;
	private Date payDate;
	
	public Payment() {
	}

	public Payment(String no, int option, Date payDate) {
		this.no = no;
		this.option = option;
		this.payDate = payDate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	
}
