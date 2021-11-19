package com.cmento.service;

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
public class BoardServiceTests {
	@Autowired
	private BoardService service;
	
	@Test
	public void testServiceImplToString() {
		log.info("------------------------");
		log.info(service);
		log.info("------------------------");
	}
	
	@Test
	public void testServiceImplGetList() {
		log.info("------------------------");
		log.info(service.listAll());
		log.info("------------------------");
	}
	
	@Test
	public void testServiceImplRegist() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("ServiceImpl Title9 Test");
		vo.setContent("ServiceImpl Content9 Test");
		vo.setWriter("ServiceImpl Writer9 Test");
		vo.setViewcnt(0);
		
		service.regist(vo);
	}
	
	@Test
	public void testServiceImplRead() {
		BoardVO vo = new BoardVO();
		vo = service.read(7);
		
		log.info("------------------------");
		log.info("read() >> " + service.read(7));
		log.info("------------------------");
	}
	
	@Test
	public void testServiceImplRemove() {
		log.info("------------------------");
		log.info("delete() complete!!");
		log.info("------------------------");
	}
	
	@Test
	public void testServiceImplModify() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(9);
		vo.setTitle("ServiceImplModify Title");
		vo.setContent("ServiceImplModify Content");
		vo.setWriter("ServiceImplModify Writer");
		
		log.info("------------------------");
		log.info("update() complete!!");
		log.info("------------------------");
	}
	
	
}
