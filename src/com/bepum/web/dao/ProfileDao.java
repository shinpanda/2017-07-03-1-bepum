package com.bepum.web.dao;


import com.bepum.web.entity.Profile;

public interface ProfileDao {

	Profile get();

	int getIsProfile();

	int insert(String others, String selfIntro, String bepumDay, String startTime, String endTime, String profileImg,
			String homePhoto1, String homePhoto2, String homePhoto3, String pay);

}
