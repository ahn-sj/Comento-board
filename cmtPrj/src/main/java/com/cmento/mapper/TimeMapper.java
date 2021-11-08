package com.cmento.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
	@Select("select sysdate()")
	String getTime();
	
	String getTime2();

}
