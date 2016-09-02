package me.kagami.mybatisread;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
/**
 * 这块的@Intercepts注解必须存在,里面的参数只可以填一下几种
 * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 * ParameterHandler (getParameterObject, setParameters)
 * ResultSetHandler (handleResultSets, handleOutputParameters)
 * StatementHandler (prepare, parameterize, batch, update, query)
 *
 * type只能选上面四种，后面的method是type填写的类中的方法，后面的args是方法字段
 */
@Intercepts({
	@Signature(type= Executor.class,method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
	@Signature(type= Executor.class,method = "update", args = {MappedStatement.class, Object.class})
})
public class ExamplePlugin implements Interceptor {
	
	/**
	 * 实现拦截逻辑的地方，内部要通过invocation.proceed()显式地推进责任链前进，也就是调用下一个拦截器拦截目标方法。
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
		System.out.println(statement.getSqlSource().getBoundSql(null).getSql());
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		//就是用当前这个拦截器生成对目标target的代理，实际是通过Plugin.wrap(target,this) 来完成的，把目标target和拦截器this传给了包装函数。
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		//用于设置额外的参数，参数配置在拦截器的Properties节点里。
	}

}
