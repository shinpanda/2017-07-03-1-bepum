package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Profile;
import com.bepum.web.entity.SearchingBepumiView;

public interface SearchingBepumiDao {

	//List<SearchingBepumiView> getList(int page);

	int getCount(int babyAge, String bepumDay, String bepumDay2, String bepumDay3, String bepumDay4, String bepumDay5, String bepumDay6, String bepumDay7, String startTime, String endTime);

	List<SearchingBepumiView> getList(int page, int babyAge, String bepumDay1, String bepumDay2, String bepumDay3,
			String bepumDay4, String bepumDay5, String bepumDay6, String bepumDay7, String startTime, String endTime);



}
