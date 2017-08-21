package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Matching;

public class MatchingService {
	//화면이 로드될 때 
	
	
	public List<Matching> getMatchingList(){
		return getMatchingList(1,"", "");
	}	
	
	//검색했을 때
	public List<Matching> getMatchingList( int page, String searchTarget, String value) {
		// searchTarget 아이디, 베푸미 이름, 지역별 / value: 검색어
		return getMatchingList( page, searchTarget, value);
	}
	
	
	//진행 상태 별로 분류
	public List<Matching> getMatchingList(int page, int  progress){
		return null;
		//구현~~
	}
	
	//상세내용 보기
	public int MatchingGet(int no){
		return 0;
	}
}
