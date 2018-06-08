package me.kagami.multidatasource.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OtherDBDao {
	
	@Select("select count(*) from user")
	int count();
}
