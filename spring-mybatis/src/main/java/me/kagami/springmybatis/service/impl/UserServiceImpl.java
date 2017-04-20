package me.kagami.springmybatis.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.kagami.springmybatis.bean.User;
import me.kagami.springmybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SqlSession sqlSession;

	@Transactional
	public void doService() {
		
//		User user = sqlSession.selectOne("me.kagami.springmybatis.mapper.UserMapper.getUser",1);
//		if(user.getScore() == 1){
//			user.setScore(user.getScore()+1);
//			sqlSession.update("me.kagami.springmybatis.mapper.UserMapper.updateUser",user);
//			System.out.println(Thread.currentThread()+":运行成功");
//		} else {
//			System.out.println(Thread.currentThread()+":停止运行");
//		}
		try {
			sqlSession.insert("me.kagami.springmybatis.mapper.UserMapper.insert");
			System.out.println("执行");
		} catch (Exception e) {
			System.out.println("退出");
		}
	}

}
