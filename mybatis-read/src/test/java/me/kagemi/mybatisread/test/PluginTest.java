package me.kagemi.mybatisread.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.junit.Test;
/**
 *  mybatis的plugin测试，尽然可以代理其他类 
 *  mybatis的拦截顺序大概是 executor Statement Result
 *  使用动态代理机制
 */
public class PluginTest {

	@Test
	public void mapPluginShouldInterceptGet() {
		Map map = new HashMap();
		map = (Map) new AlwaysMapPlugin().plugin(map);
		assertEquals("Always", map.get("Anything"));
	}

	@Test
	public void shouldNotInterceptToString() {
		Map map = new HashMap();
		map = (Map) new AlwaysMapPlugin().plugin(map);
		assertFalse("Always".equals(map.toString()));
	}

	@Intercepts({ @Signature(type = Map.class, method = "get", args = { Object.class }) })
	public static class AlwaysMapPlugin implements Interceptor {
		public Object intercept(Invocation invocation) throws Throwable {
			return "Always";
		}

		public Object plugin(Object target) {
			//必须返回一个object，这个object要么是代理过的，要么是原生的。
			return Plugin.wrap(target, this);
		}

		public void setProperties(Properties properties) {
		}
	}

}