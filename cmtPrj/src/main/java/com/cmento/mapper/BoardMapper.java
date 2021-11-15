package com.cmento.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cmento.domain.BoardVO;

@Mapper
public interface BoardMapper {
	void create(BoardVO board);
	BoardVO read();
	void update();
	void delete();
	List<BoardVO> listAll();

}
