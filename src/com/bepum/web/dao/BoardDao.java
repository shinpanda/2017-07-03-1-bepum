package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;
import com.bepum.web.entity.Profile;

public interface BoardDao {

	List<BoardView> getList(int page,String c_name, String query, String tName);

	BoardView get(String no, String tName);

	int update(String no, String title, String content, String tName);

	int insert(String title, String content, String id, String tName);

	int getCount();

	int delete(String no, String string);

	int updateHit(String no);



}
