package com.bepum.web.dao;

public interface MatchingDao {


	int insert0(String requestID, String bepumiID);
	int insert(String bepumDate, String requirement, String startTime, String endTime);
	
}
