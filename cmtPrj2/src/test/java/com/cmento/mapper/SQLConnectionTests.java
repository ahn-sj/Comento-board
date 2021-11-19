package com.cmento.mapper;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SQLConnectionTests {
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	// MySQL Connection Junit Test
	@Test
	public void testConnection() {
		Connection con;
		try {
			con = ds.getConnection();
			log.info("-------------------------------");
			log.info(con);
			log.info("-------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}
	
	// MyBatis Connection Junit Test
	@Test
	public void testConnection2() {
		SqlSession session = sessionFactory.openSession();
		Connection con = session.getConnection();
		log.info("-------------------------------");
		log.info("SqlSessionFactory >> " + sessionFactory); 
		log.info("Session >> " + session);
		log.info("Connection >> " + con);
		log.info("-------------------------------");
	}
}
