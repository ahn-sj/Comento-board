package com.cmento.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cmento.domain.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> listAll();
	void create(BoardVO vo);
	BoardVO read(Integer bno);
	int delete(Integer bno);
	int update(BoardVO vo);
}
