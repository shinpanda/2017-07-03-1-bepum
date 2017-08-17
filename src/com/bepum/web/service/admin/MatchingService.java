package com.bepum.web.service.admin;

import java.util.List;

import com.bepum.web.entity.Matching;

public class MatchingService {
	//화면이 로드될 때 
	public List<Matching> getMatchingList(){
		return getMatchingList(1,"");
	}
	//검색했을 때
	public List<Matching> getMatchingList(String applicant){
		return getMatchingList(1,applicant);
	}
	//검색후 페이징
	public List<Matching> getMatchingList(int page, String applicant){
		return null;
	}
	//진행 상태 별로 분류
	public List<Matching> getMatchingList(int  progress){
		return null;
		//구현~~
	}
	
	//상세내용 보기
	public int MatchingGet(int no){
		return 0;
	}
}
