package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Profile;
import com.bepum.web.entity.SearchingBepumiView;

public interface SearchingBepumiDao {

	List<SearchingBepumiView> getList(int page);

	int getCount();



}
