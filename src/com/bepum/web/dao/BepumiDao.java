package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Bepumi;

public interface BepumiDao {

	List<Bepumi> getList(int page, String query, String cName);
	
	int getCount();
	
	int insert(Bepumi bepumi);

}
