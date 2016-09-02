package me.kagami.mybatisread;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.javafx.collections.MappingChange.Map;

import me.kagami.mybatisread.returnlistmap.SQLMapper;

public class App {
	public static void main(String[] args) throws Exception {
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader("configuration.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
		SqlSession session = sessionFactory.openSession(true);//是否auto commit
		
		String statement = "me.kagami.mybatisread.UserMapper.getUser";// 映射sql的标识字符串
		User user = session.selectOne(statement, 1);
		System.out.println(user);

		BooksMapper mapper = session.getMapper(BooksMapper.class);
		System.out.println(mapper.getBooks(1));

//		UserMapper usermapper = session.getMapper(UserMapper.class);
//		usermapper.insert(new User());
//		user.setName("aaa");
//		mapper.insert(user);
//		user.setName("bbbx");
//		usermapper.update(user);
		
		SQLMapper sql = session.getMapper(SQLMapper.class);
		List<Map<String, Object>>  books = sql.runSqlAndReturnListMap("select * from Books where id =1");
		System.out.println(books);
//		session.commit();
		session.close();
	}
}
