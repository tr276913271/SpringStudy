package me.kagami.springbootandthymeleaf.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

public class MockUtil {

	public static MvcResult mock200(MockMvc mockMvc, String json, String url) throws Exception {
		return mock(mockMvc, json, url, status().isOk());
	}

	public static MvcResult mock400(MockMvc mockMvc, String json, String url) throws Exception {
		return mock(mockMvc, json, url, status().isBadRequest());
	}

	public static MvcResult mock(MockMvc mockMvc, String json, String url, ResultMatcher result) throws Exception {
		MockHttpServletRequestBuilder request = post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(json);
		MvcResult andReturn = mockMvc.perform(request).andExpect(result).andReturn();
		System.out.println("MOCK TEST:" + andReturn.getResponse().getContentAsString());
		return andReturn;
	}

	public static MvcResult mock200(MockMvc mockMvc, Object dto, String url) throws Exception {
		return mock(mockMvc, ObjectMapperHelper.getObjectMapper().writeValueAsString(dto), url, status().isOk());
	}
}
