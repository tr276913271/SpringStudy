package me.kagami.mybatisread.page;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import me.kagami.mybatisread.User;
import me.kagami.mybatisread.UserMapper;

public class PageTest {
	public static void main(String[] args) throws IOException {
		// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader("configuration.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader,"produce");
		SqlSession session = sessionFactory.openSession();//是否auto commit
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		Page page = new Page();
		page.setPageNumber(1);
		page.setCurrentPage(3);
		List<User> users = mapper.selectSameNameByPage("tian",page);
		
		for (User user : users) {
			System.out.println(user);
		}
	}
}
