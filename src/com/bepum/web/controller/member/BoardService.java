package com.bepum.web.controller.member;

import java.util.List;

import com.bepum.web.entity.Board;

public class BoardService {

	// 화면이 로드될 때
	public List<Board> getBoardList() {
		return getBoardList(1, "");
	}

	// 검색했을 때
	public List<Board> getBoardList(String title) {
		return getBoardList(1, title);
	}

	// 검색후 페이징
	public List<Board> getBoardList(int page, String title) {
		return null;
	}

	// 정렬
	public List<Board> getBoardList(int page, String title, String OrderCol, boolean asc) {
		return null;
		// 구현~~
	}

	// 상세내용 보기
	public int BoardGet(int no) {
		return 0;
	}

}
