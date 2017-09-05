package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Member;

public interface MemberDao {

	List<Member> getList(int page, String query, String cName);

	int getCount();

}
