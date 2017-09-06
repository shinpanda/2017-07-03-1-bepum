package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;

public interface SecretBoardDao {

	List<BoardView> getList(int page,String c_name, String query, String tName);

	BoardView get(String no, String tName);

	int update(String no, String title, String content, String tName);

	int insert(String title, String content, String tName);

	int getCount();

}
