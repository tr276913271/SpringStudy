package me.kagemi.mybatisread.test;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.reflection.ReflectionException;
import org.junit.Test;

import me.kagami.mybatisread.UserMapper;

public class ReflectorTest {
	@Test
	public void methodSignature() {
		// 注意getDeclaredMethods与getMethods区别
		Method[] methods = UserMapper.class.getMethods();
		for (Method method : methods) {
			System.out.println(getSignature(method));
		}
	}
	/**
	 * 这个方法主要是校验的功能，当一个类的定义如下的时候，可能报异常
	 *  private int id;
		public int isId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		一个属性即定义了get又定义了is，的时候。一般不会这么写
		
		同理还有resolveSetterConflicts方法，一般使用eclipse生成的get，set，方法的Bean类，都不会在这两个方法上抛出异常
	 * @param conflictingGetters
	 */
	private void resolveGetterConflicts(Map<String, List<Method>> conflictingGetters) {
		for (String propName : conflictingGetters.keySet()) {
			List<Method> getters = conflictingGetters.get(propName);
			Iterator<Method> iterator = getters.iterator();
			Method firstMethod = iterator.next();
			if (getters.size() == 1) {
				// addGetMethod(propName, firstMethod);
			} else {
				Method getter = firstMethod;
				Class<?> getterType = firstMethod.getReturnType();
				while (iterator.hasNext()) {
					Method method = iterator.next();
					Class<?> methodType = method.getReturnType();
					/**
					 * 注意这块的异常
					 */
					if (methodType.equals(getterType)) {
						throw new ReflectionException("Illegal overloaded getter method with ambiguous type for property " + propName + " in class " + firstMethod.getDeclaringClass()
								+ ".  This breaks the JavaBeans " + "specification and can cause unpredicatble results.");
					} else if (methodType.isAssignableFrom(getterType)) {
						// OK getter type is descendant
					} else if (getterType.isAssignableFrom(methodType)) {
						getter = method;
						getterType = methodType;
					} else {
						throw new ReflectionException("Illegal overloaded getter method with ambiguous type for property " + propName + " in class " + firstMethod.getDeclaringClass()
								+ ".  This breaks the JavaBeans " + "specification and can cause unpredicatble results.");
					}
				}
				// addGetMethod(propName, getter);
			}
		}
	}

	private String getSignature(Method method) {
		StringBuilder sb = new StringBuilder();
		Class<?> returnType = method.getReturnType();
		if (returnType != null) {
			sb.append(returnType.getName()).append('#');
		}
		sb.append(method.getName());
		Class<?>[] parameters = method.getParameterTypes();
		for (int i = 0; i < parameters.length; i++) {
			if (i == 0) {
				sb.append(':');
			} else {
				sb.append(',');
			}
			sb.append(parameters[i].getName());
		}
		return sb.toString();
	}
}
