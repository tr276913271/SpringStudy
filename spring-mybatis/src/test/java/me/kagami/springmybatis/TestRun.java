package me.kagami.springmybatis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-collection-test.xml")
public class TestRun {
	
	@Test
	public void test() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);
		try {
			ExecutorService service = Executors.newFixedThreadPool(10);
			for (int i = 0; i < 10; i++) {
				service.submit(new TestRunnable(latch));
			}
			latch.countDown();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
