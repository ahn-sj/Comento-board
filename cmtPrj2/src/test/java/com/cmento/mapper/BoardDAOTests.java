package com.cmento.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cmento.domain.BoardVO;
import com.cmento.persistence.BoardDAO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTests {
	@Autowired
	private BoardDAO boardDao;
	
	@Test
	public void testDAOListAll() {
		log.info("------------------------");
		log.info("listAll() >> " + boardDao.listAll());
		log.info("------------------------");
	}
	
	@Test
	public void testDAOCreate() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("DAO Title");
		vo.setContent("DAO Content");
		vo.setWriter("DAO Writer");
		
		boardDao.create(vo);
	}
	
	@Test
	public void testDAORead() {
		boardDao.read(2);
	}
	
	@Test
	public void testDAODelete() {
		boardDao.delete(2);
	}
	
	@Test
	public void testDAOUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("sts - DAO Update Title");
		vo.setContent("sts - DAO Update Content");
		vo.setWriter("sts - DAO Update Writer");
		
		vo.setBno(5);
		
		boardDao.update(vo);
	}
	
}
