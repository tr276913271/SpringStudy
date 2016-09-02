package me.kagami.mybatisread.returnlistmap;


import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public interface SQLMapper {
	List<Map<String, Object>>  runSqlAndReturnListMap(String sql);
}
