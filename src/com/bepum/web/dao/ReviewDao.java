package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.ReviewView;

public interface ReviewDao {

	List<ReviewView> getList(int page, String cName, String query);

	int getCount();

	int updateHit(String no);

	Object get(String no);

	int insert(String id, String no, int rating, String reviewTitle, String reviewContent);

	int update(String id, String no, int rating, String reviewTitle, String reviewContent);

	List<ReviewView> getListByBepumi(String id);
}
