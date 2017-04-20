package me.kagami.spring.example.aop.annotation;

import org.springframework.stereotype.Repository;

//@Repository
public class TestInterfaceImpl implements TestInterface {

	public void sayHello(String name) {
		System.out.println(name);
	}

}
