package me.kagami.spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kagami.spring.example.bean.User;
import me.kagami.spring.example.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User findUser(String username) {
		return userDao.findUserByUserName(username);
	}
}
