package me.kagami.springmybatis.service;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class JdbcStreamReader<T> {
    final DataSource dataSource;


    public JdbcStreamReader(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void queryAndProcess(String jdbcSql, List params, RowMapper<T> rowMapper, Consumer<T> func) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (jdbcSql.equals("")) {
            throw new RuntimeException("sql不能为空");
        }
        try {

            conn = this.dataSource.getConnection();
            ps = conn.prepareStatement(jdbcSql, 1003, 1007);

            if (null != params) {
                for (int e = 0; e < params.size(); e++) {
                    ps.setObject(e + 1, params.get(e));
                }
            }

            ps.setFetchSize(-2147483648);
            rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                func.accept(rowMapper.mapRow(rs, 1));
            }
        } finally {
            this.close(conn, ps, rs);
        }

    }

    private void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
