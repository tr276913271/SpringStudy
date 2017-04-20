package me.kagami.springmybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.kagami.springmybatis.bean.User;
import me.kagami.springmybatis.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void test() {
		User user = userMapper.getUser(1);
		User useraa = userMapper.getUser(1);
		System.out.println(user);
	}
}
