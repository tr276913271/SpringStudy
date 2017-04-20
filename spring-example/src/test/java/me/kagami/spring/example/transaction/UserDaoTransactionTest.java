package me.kagami.spring.example.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.kagami.spring.example.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class UserDaoTransactionTest {
	@Autowired
	private UserDao userDao;
	//CglibAopProxy
	@Test
	public void test() {
		System.out.println(userDao.findUserByUserName("tian"));
	}
}
