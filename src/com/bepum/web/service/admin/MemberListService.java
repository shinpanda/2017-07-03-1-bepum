package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Member;

public class MemberListService {

	// 화면이 로드될 때
	public List<Member> getMemberList() {
		return getMemberList(1, "");
	}

	// 검색했을 때(아이디로)
	public List<Member> getMemberList(String id) {
		return getMemberList(1, id);
	}

	// 검색후 페이징
	public List<Member> getMemberList(int page, String id) {
		return getMemberList(page, id);
	}

	// 상세내용 보기
	public int MemberGet(int id) {
		return 0;
	}


}
