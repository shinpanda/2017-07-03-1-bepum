package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.MatchingView;

public interface SearchingMatchingDao {

	List<MatchingView> getList(String id, int page, String query);
	
	MatchingView get(String no);

	
	int getCount(String id);

}
