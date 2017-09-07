package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.ReviewView;

public interface ReviewDao {

	List<ReviewView> getList(int page, String cName, String query);

	int getCount();

	int updateHit(String no);

	Object get(String no);
}
