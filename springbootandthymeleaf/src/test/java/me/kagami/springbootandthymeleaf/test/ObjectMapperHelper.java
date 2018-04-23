package me.kagami.springbootandthymeleaf.test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ObjectMapper辅助类
 */
public class ObjectMapperHelper {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	static {
		// 反序列化时忽略unknown值
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 序列化过程中忽略null值
		MAPPER.setSerializationInclusion(Include.NON_NULL);
	}

	public static ObjectMapper getObjectMapper() {
		return MAPPER;
	}
}
