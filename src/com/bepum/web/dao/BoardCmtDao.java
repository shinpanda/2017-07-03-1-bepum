package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.BoardComment;

public interface BoardCmtDao {

	List<BoardComment> getList(String no, String tName);

	int insert(String no, String id, String cmt, String tName);

	int delete(String no, String tName);

	int update(String no, String content, String tName);

	Object get(String no, String tName);

}
