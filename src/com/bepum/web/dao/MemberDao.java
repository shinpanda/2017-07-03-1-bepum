package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Member;

public interface MemberDao {

	List<Member> getList(int page, String query, String cName);
	
	int getCount();

	int insert(Member member);

	Member get(String id);

	int update(String id, String name, String pwd, String birth, String address, String phone, String email);

	int delete(String id, String pwd);

	int checkId(String id);
	
	int updateGrade(String reqID);
	int updateGrade(int grade, String id);

}
