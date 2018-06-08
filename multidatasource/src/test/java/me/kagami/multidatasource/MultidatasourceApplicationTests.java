package me.kagami.multidatasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.kagami.multidatasource.service.OtherDBService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultidatasourceApplicationTests {
	@Autowired
	OtherDBService service;

	@Test
	public void contextLoads() {
		System.out.println(service.count());
	}

}
