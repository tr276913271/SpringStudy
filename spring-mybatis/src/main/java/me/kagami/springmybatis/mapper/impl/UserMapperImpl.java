package me.kagami.springmybatis.mapper.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.kagami.springmybatis.bean.User;
import me.kagami.springmybatis.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {
	@Autowired
	private SqlSession sqlSession;

	public User getUser(int id) {
		return sqlSession.selectOne("me.kagami.springmybatis.mapper.UserMapper.getUser", id);
	}

}
