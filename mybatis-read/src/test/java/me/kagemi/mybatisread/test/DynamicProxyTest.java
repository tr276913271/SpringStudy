package me.kagemi.mybatisread.test;

//代理处理器：
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;

public class DynamicProxyTest {

	@Test
	public void test() {
		RealSubject rs = new RealSubject(); // 在这里指定被代理类
		InvocationHandler ds = new DynamicSubject(rs);
		Class cls = rs.getClass();
		// 以下是一次性生成代理,cls.getInterfaces，这样写方便生成代理，如果这样写 new Class[]{Subject.class} ,麻烦
		Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
		subject.request();
	}
}

interface Subject {
	abstract public void request();
}

// 具体角色RealSubject：
class RealSubject implements Subject {
	public RealSubject() {
	}

	public void request() {
		System.out.println(" From real subject. ");
	}
}

class DynamicSubject implements InvocationHandler {
	private Object sub;

	public DynamicSubject() {
	}

	public DynamicSubject(Object obj) {
		sub = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(" before calling " + method);
		method.invoke(sub, args);
		System.out.println(" after calling " + method);
		return null;
	}
}