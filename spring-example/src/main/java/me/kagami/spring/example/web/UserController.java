package me.kagami.spring.example.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import me.kagami.spring.example.bean.User;
import me.kagami.spring.example.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/user.do")
	public ModelAndView  getUser(HttpServletRequest request,User user) {
		User findUser = userService.findUser(user.getUsername());
		return new ModelAndView("main","user",findUser);  
	}
	@RequestMapping(value="/socketpage.do")
	public ModelAndView  socketPage(HttpServletRequest request) {
		return new ModelAndView("websocket");  
	}
}
