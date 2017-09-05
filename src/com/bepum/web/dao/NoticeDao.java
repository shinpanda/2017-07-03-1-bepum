package com.bepum.web.dao;

import java.util.List;

import com.bepum.web.entity.Board;
import com.bepum.web.entity.BoardView;

public interface NoticeDao {

	List<BoardView> getList(int page,String c_name, String query);

	BoardView get(String no);

	int update(String no, String title, String content);

	int insert(String title, String content);

	int getCount();

	int delete(String no, String string);

	int updateHit(String no);


}
