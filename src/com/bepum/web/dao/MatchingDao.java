package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.MatchingView;

public interface MatchingDao {

	List<MatchingView>  getList(String id, int page, String query);
	
	MatchingView get(String no);
	
	int getCount(String id);

	int updateStatus(String no, String query);

	
	int insert0(String requestID, String bepumiID);
	int insert(String bepumDate, String requirement, String startTime, String endTime);
	
	
	
}
