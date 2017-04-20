package me.kagami.springmybatis;

import java.util.concurrent.CountDownLatch;

import me.kagami.springmybatis.service.UserService;
import me.kagami.springmybatis.util.ApplicationContextUtil;

public class TestRunnable implements Runnable {
	private UserService userService = (UserService) ApplicationContextUtil.getApplicationContext().getBean("userServiceImpl");
	private CountDownLatch latch;

	public TestRunnable(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		userService.doService();
	}
}
