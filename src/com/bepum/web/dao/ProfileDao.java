package com.bepum.web.dao;


import com.bepum.web.entity.Profile;
import com.bepum.web.entity.ProfilePercent;
import com.bepum.web.entity.ProfileView;

public interface ProfileDao {

	ProfileView get(String id);

	int getIsProfile(String id);

	int insert(String id, String others, String selfIntro, String bepumDay, String startTime, String endTime, String profileImg,
			String homePhoto1, String homePhoto2, String homePhoto3, String pay);

	int update(String id, String others, String selfIntro, String bepumDay, String startTime, String endTime, String profileImg,
			String homePhoto1, String homePhoto2, String homePhoto3, String pay);

	int updateSecret(String id, int sec);

	ProfilePercent getPercent(String id);

}
