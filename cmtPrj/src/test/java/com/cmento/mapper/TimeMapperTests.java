package com.cmento.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cmento.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	@Autowired
	private TimeMapper timeMapper;
	
	// select sysdate();
	@Test
	public void testTime() {
		log.info("----------------------------");
		log.info("sysdate : " + timeMapper.getTime());
		log.info("----------------------------");
	}
	
	// select now();
		@Test
		public void testTime1() {
			log.info("----------------------------");
			log.info("systimestamp : " + timeMapper.getTime2());
			log.info("----------------------------");
		}
}
