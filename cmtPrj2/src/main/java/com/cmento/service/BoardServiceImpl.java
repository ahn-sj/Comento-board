package com.cmento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmento.domain.BoardVO;
import com.cmento.persistence.BoardDAO;

import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@ToString
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) {
		dao.create(board);
	}

	@Override
	public BoardVO read(Integer bno) {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() {
		return dao.listAll();
	}
}
