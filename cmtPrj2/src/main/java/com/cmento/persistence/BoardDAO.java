package com.cmento.persistence;

import java.util.List;

import com.cmento.domain.BoardVO;

public interface BoardDAO {
	List<BoardVO> listAll();
	void create(BoardVO vo);
	BoardVO read(Integer bno);
	void delete(Integer bno);
	void update(BoardVO vo);
}
