package com.cmento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmento.domain.BoardVO;
import com.cmento.mapper.BoardMapper;

import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@ToString
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	@Override
	public void regist(BoardVO board) {
		mapper.create(board);
	}

	@Override
	public BoardVO read(Integer bno) {
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.update(board);
	}

	@Override
	public int remove(Integer bno) {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() {
		return mapper.listAll();
	}
}
