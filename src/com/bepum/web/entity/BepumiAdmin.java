package com.bepum.web.entity;

public class BepumiAdmin {
	int avgRating;
	int countStatus;
	int countComplete;
	
	public BepumiAdmin() {
		// TODO Auto-generated constructor stub
	}

	public BepumiAdmin(int avgRating, int countStatus, int countComplete) {
		super();
		this.avgRating = avgRating;
		this.countStatus = countStatus;
		this.countComplete = countComplete;
	}

	public int getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}

	public int getCountStatus() {
		return countStatus;
	}

	public void setCountStatus(int countStatus) {
		this.countStatus = countStatus;
	}

	public int getCountComplete() {
		return countComplete;
	}

	public void setCountComplete(int countComplete) {
		this.countComplete = countComplete;
	}
	
	
}
