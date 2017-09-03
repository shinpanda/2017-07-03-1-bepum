package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;

public interface BoardDao {

	List<BoardView> getList(int page,String c_name, String query, String bName);

	BoardView get(String no, String bName);

	int update(String no, String title, String content, String bName);

	int insert(String title, String content, String bName);

	int getCount();

	int delete(String no, String string);

	int updateHit(String no);


}
