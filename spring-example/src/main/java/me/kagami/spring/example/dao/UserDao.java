package me.kagami.spring.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import me.kagami.spring.example.bean.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User findUserByUserName(final String username) {
		final User user = new User();
		String sql = "select * from user where username =?";
		jdbcTemplate.query(sql, new Object[]{username},new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setIduser(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUserpassword(rs.getString(3));
			}
		});
		return user;
	}
}
