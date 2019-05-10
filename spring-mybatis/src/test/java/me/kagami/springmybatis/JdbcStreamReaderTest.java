package me.kagami.springmybatis;

import me.kagami.springmybatis.bean.User;
import me.kagami.springmybatis.service.JdbcStreamReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JdbcStreamReaderTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        JdbcStreamReader<User> jdbcStreamReader = new JdbcStreamReader<>(dataSource);

        jdbcStreamReader.queryAndProcess("select * from user",null,new BeanPropertyRowMapper<>(User.class),x->{
            System.out.println(x);
        });
    }

}
