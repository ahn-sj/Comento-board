package com.cmento.service;

import java.util.List;

import com.cmento.domain.BoardVO;

public interface BoardService {
	void regist(BoardVO board);
	BoardVO read(Integer bno);
	void modify(BoardVO board);
	void remove(Integer bno);
	List<BoardVO> listAll();
}
