package me.kagami.springbootandthymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import me.kagami.springbootandthymeleaf.bean.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * 加上ResponseBody后相当于返回的全是json了
 */
@RestController
public class RestStyleController {
	
	@RequestMapping("/simplejson")
	public String simpleJson() {
		return "simpleJson!!!";
	}

	@RequestMapping("/userjson")
	public User userJson() {
		User user = new User();
		user.setId(1);
		user.setName("tian");
		user.setPassword("123456");
		return user;
	}
	
	@RequestMapping("/listjson")
	public List<User> listJson() {
		List<User> list = new ArrayList<User>();
		
		User user = new User();
		user.setId(1);
		user.setName("tian");
		user.setPassword("123456");
		
		list.add(user);
		list.add(user);
		list.add(user);
		return list;
	}
}
