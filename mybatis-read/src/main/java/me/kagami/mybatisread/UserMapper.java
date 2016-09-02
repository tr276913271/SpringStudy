package me.kagami.mybatisread;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import me.kagami.mybatisread.page.Page;

public interface UserMapper {
	User getUser(int id);

	@Insert("insert into user(id,name) values(#{id},#{name})")
	void insert(User user);

	@Delete("delete from user where id = #{id}")
	void deleteById(int id);

	@Update("update user set name = #{name} where id = #{id}")
	int update(User user);

	List<User> selectSameNameByPage(String name, Page page);
}
