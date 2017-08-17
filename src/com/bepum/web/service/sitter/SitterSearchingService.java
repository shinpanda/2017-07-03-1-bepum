package com.bepum.web.service.sitter;

import java.util.HashMap;
import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.Matching;
import com.bepum.web.entity.Member;
import com.bepum.web.entity.Sitter;

public class SitterSearchingService {
	
		//화면이 로드될 때 
		public HashMap<Member, Sitter> getSearchingList(){
			return null;
		}
		
		//지역별, 날짜별, 시간별로 돌보미 검색
		public HashMap<Member, Sitter> getSearchingList(String searchTarget, String value) {
			// searchTarget 지역별, 날짜별, 시간별 / value: 검색어
			return getSearchingList(1, searchTarget, value);

		}

		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String value) {
			// searchTarget 지역별/날짜별/시간별 / value: 검색어
			return getSearchingList(page, searchTarget, "", "", value);

		}
		
		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String searchTarget2, String value) {
			// searchTarget 지역별,날짜별 / 날짜별,시간별 / 지역별,시간별 / value: 검색어
			return getSearchingList(page, searchTarget, searchTarget2, "", value);

		}
		
		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String searchTarget2, String searchTarget3, String value) {
			// searchTarget 지역별, 날짜별, 시간별 / value: 검색어
			return getSearchingList(page, searchTarget, searchTarget2, searchTarget3, value, "");

		}

		// 정렬 -> 등록일순, 등급순으로 정렬
		public HashMap<Member, Sitter> getSearchingList(int page, String searchTarget, String searchTarget2, String searchTarget3, String value, String OrderCol) {
			return null;
		}
		
		// 클릭하면 해당 멤버 정보 보여주고
		public HashMap<Member, Sitter> get(String id) {
			return null;
		}
		
}
