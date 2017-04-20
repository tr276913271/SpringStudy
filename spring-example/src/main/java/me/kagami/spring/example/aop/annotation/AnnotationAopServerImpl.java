package me.kagami.spring.example.aop.annotation;

public class AnnotationAopServerImpl implements AnnotationAopServer {

	public void sayHello() {
		System.out.println("你好");
	}
	
	public void saySomeOne(String name) {
		System.out.println(name);
	}
}
