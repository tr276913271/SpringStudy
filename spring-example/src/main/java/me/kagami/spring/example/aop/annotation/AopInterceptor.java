package me.kagami.spring.example.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopInterceptor {
	// 定义一个切入点,完全精准目标
	@Pointcut("execution(* me.kagami.spring.example.aop.annotation.AnnotationAopServerImpl.sayHello())")
	public void anyMethod() {

	}

	// 有参数的
	@Pointcut("execution(* me.kagami.spring.example.aop.annotation.AnnotationAopServerImpl.saySomeOne(String))")
	public void saySomeOneMethod() {

	}
/**
 * */
	// 这里除了写切点方法外，还要写通知方法，spring才会生成代理。只写切点方法不会生成代理
	// 有参数的
	@Pointcut("execution(* me.kagami.spring.example.aop.annotation.TestInterfaceImpl.sayHello(String))")
	public void saySomeOneMethodTest() {

	}
	//通知方法
	@Before("saySomeOneMethodTest() && args(name)")
	public void saySomeOneMethodBeforeTest(String name) {
		System.out.println("前置通知" + name);
	}
 
	@Before("saySomeOneMethod() && args(name)")
	public void saySomeOneMethodBefore(String name) {
		System.out.println("前置通知" + name);
	}

	@Before("anyMethod()")
	public void doAccessCheck() {
		System.out.println("前置通知");
	}

	@AfterReturning("anyMethod()")
	public void doAfter() {
		System.out.println("后置通知");
	}

	@After("anyMethod()")
	public void after() {
		System.out.println("最终通知");
	}

	@AfterThrowing("anyMethod()")
	public void doAfterThrow() {
		System.out.println("例外通知");
	}

	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入环绕通知");
		Object object = pjp.proceed();// 执行该方法
		System.out.println("退出方法");
		return object;
	}
}
