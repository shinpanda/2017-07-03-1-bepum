package com.bepum.web.service.sitter;

import java.util.HashMap;
import java.util.List;

import com.bepum.web.entity.Matching;
import com.bepum.web.entity.Member;
import com.bepum.web.entity.Sitter;

public class MatchingService {
	// 신청자 베푸미 구분해줘야 함

	public List<Matching> getMatchingList(String role) { // 신청자인지 베푸미인지 확인
		return getMatchingList(role, 1);
	}

	public List<Matching> getMatchingList(String role, int page) {// 페이지 넘김
		return getMatchingList(role, page);
	}

	// 신청자일 경우 아이디, 베푸미 이름, 지역별로 과거 매칭 내역 검색
	public List<Matching> getMatchingList(String role, String searchTarget, String value) {
		// searchTarget 아이디, 베푸미 이름, 지역별 / value: 검색어
		return getMatchingList(role, 1, searchTarget, value);

	}

	public List<Matching> getMatchingList(String role, int page, String searchTarget, String value) {
		// searchTarget 아이디, 베푸미 이름, 지역별 / value: 검색어
		return getMatchingList(role, page, searchTarget, value);

	}

	// 정렬 -> 매칭 상태 별로 과거/진행/신청 으로 정렬
	public List<Matching> getMatchingList(String role, int page, String searchTarget, String value, String OrderCol) {
		return null;
	}

	// 클릭하면 해당 멤버 정보 보여주고
	public HashMap<Member, Sitter> get(String id) {
		return null;
	}

	// 진행사항이 신청일 경우
	// 매칭 승인/거절
	public int accept(boolean acc) {
		return 0;
	}
}
