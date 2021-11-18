package com.cmento.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cmento.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testListAll() {
		log.info("------------------------");
		log.info("listAll() >> " + boardMapper.listAll());
		log.info("------------------------");
	}
	
	@Test
	public void testCreate() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("Title Test DBMS");
		vo.setContent("Content Test DBMS");
		vo.setWriter("Writer Test DBMS");
		vo.setViewcnt(0);
		
		boardMapper.create(vo);
	}
	
	@Test
	public void testRead() {
		BoardVO vo = new BoardVO(); 
		vo = boardMapper.read(6);
		
		log.info("------------------------");
		log.info("read() >> " + boardMapper.read(6));
		log.info("------------------------");
	}
	
	@Test
	public void testDelete() {
		log.info("------------------------");
		log.info("delete() >> count = " + boardMapper.delete(2));
		log.info("------------------------");
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(3);
		vo.setTitle("Update Test Title");
		vo.setContent("Update Test Content");
		vo.setWriter("Update Test Writer");
		
		log.info("------------------------");
		log.info("update() >> count = " + boardMapper.update(vo));
		log.info("------------------------");
	}
}
 