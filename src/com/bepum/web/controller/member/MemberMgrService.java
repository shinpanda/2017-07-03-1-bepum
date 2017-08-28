package com.bepum.web.controller.member;

import java.util.List;

import com.bepum.web.entity.Member;

public class MemberMgrService {
	
	//로그인 할 때 아이디,비번 일치하는지 확인
	public int check(){
		return 0;		
	}

	
	//회원가입 (회원목록에 insert)
	public List<Member> signUp(Member member){
		return null;		
	}
	//가입 시 ID중복확인
	public int checkID(){
		return 0;
	}
	
	//마이페이지
	//수정(이름,비번,주소,전화번호,이메일)
	public List<Member> editMypage(Member member){
		return null;	
	}
	
	
	//탈퇴
	public void withdraw(){
		
	}
}
