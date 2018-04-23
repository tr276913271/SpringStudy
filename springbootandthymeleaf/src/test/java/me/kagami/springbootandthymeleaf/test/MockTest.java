package me.kagami.springbootandthymeleaf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import me.kagami.springbootandthymeleaf.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
@AutoConfigureMockMvc
public class MockTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() throws Exception {
		MvcResult returnR = MockUtil.mock200(this.mockMvc, "", "/simplejson");
		System.out.println(returnR.getResponse().getContentAsString());
	}
}
