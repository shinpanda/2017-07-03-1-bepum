package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.MatchingView;

public interface BepumiMatchingDao {

	List<MatchingView> getList(String id, int page, String query);

	int getCount();

}
