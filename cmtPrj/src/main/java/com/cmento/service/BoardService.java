package com.cmento.service;

import java.util.List;

import com.cmento.domain.BoardVO;

public interface BoardService {
	void regist(BoardVO board);
	BoardVO read(Integer bno);
	int modify(BoardVO board);
	int remove(Integer bno);
	List<BoardVO> listAll();
}
