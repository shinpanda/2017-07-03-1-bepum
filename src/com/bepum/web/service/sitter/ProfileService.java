package com.bepum.web.service.sitter;

import java.util.HashMap;

import com.bepum.web.entity.Member;
import com.bepum.web.entity.Sitter;

public class ProfileService {
	
	
	//화면이 로드 될 때
	public HashMap<Member, Sitter> getMemberProfile(String id) {
		return null;
	}
	
	//공개/비공개 수정
	public boolean Open(String id) {
		boolean open = true;
		return open;
	}
	
	//베푸미 정보 수정
	public int modify(String id) {
		return 0;
	}
}
