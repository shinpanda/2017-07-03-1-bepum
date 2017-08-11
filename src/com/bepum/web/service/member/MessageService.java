package com.bepum.web.service.member;

import java.util.List;

import com.bepum.web.entity.Message;

public class MessageService {

	//메세지목록 (전체메세지, 중요메세지, 읽은메세지, 읽지않은메세지)
	//화면이 로드될 때
	public List<Message> getMessageList(){
		return getMessageList(1,"");
	}
	//검색했을 때
	public List<Message> getMessagedList(String fromID /*, String title 도 넣어야되나?*/){
		return getMessageList(1, fromID);
	}

	//검색후 페이징
	public List<Message> getMessageList(int page, String fromID){
		return null;
	}
	//정렬
	public List<Message> getMessageList(int page, String fromID, String OrderCol, boolean asc){
		return null;
		//구현~~
	}
	
	//상세내용 보기
	public int MessageGet(int num){
		return 0;
	}
	
	
}
