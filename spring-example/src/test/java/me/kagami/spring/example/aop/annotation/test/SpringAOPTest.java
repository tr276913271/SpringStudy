package me.kagami.spring.example.aop.annotation.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.kagami.spring.example.aop.annotation.AnnotationAopServer;
import me.kagami.spring.example.aop.annotation.TestInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class SpringAOPTest {
	@Autowired
	private AnnotationAopServer server;
	@Autowired
	private TestInterface testInterface;

	@Test
	public void test() {
		server.sayHello();
		// testInterface.sayHello("aa");
		server.sayHello();
		server.saySomeOne("t");
	}
}
