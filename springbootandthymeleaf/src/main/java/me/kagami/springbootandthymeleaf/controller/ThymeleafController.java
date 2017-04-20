package me.kagami.springbootandthymeleaf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.kagami.springbootandthymeleaf.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	@RequestMapping("hellothymeleaf")
	public String helloThymeleaf(Model model) {
		model.addAttribute("hellomessage", "Thymeleaf");
		model.addAttribute("user", new User());
		return "thymeleaf/hellothymeleaf";
	}

	@RequestMapping("fragment")
	public String fragment(Model model) {
		return "thymeleaf/fragment";
	}

	@RequestMapping("importjquery")
	public String importJquery(Model model) {
		return "thymeleaf/importjquery";
	}

	@RequestMapping("i118n")
	public String i118n(Model model) {
		return "i118n";
	}

	@RequestMapping("utilityobjects")
	public String utilityObjects(Model model) {
		model.addAttribute("date", new Date());
		model.addAttribute("num", 19900);
		model.addAttribute("name", "tian");
		return "thymeleaf/utilityobjects";
	}

	@RequestMapping("formsubmit")
	public String formsubmit(String email) {
		System.out.println(email);
		return "thymeleaf/form";
	}

	@RequestMapping("form")
	public String form() {
		return "thymeleaf/form";
	}

	@RequestMapping("each")
	public String each(Model model) {
		List<User> ulist = new ArrayList<User>();
		ulist.add(new User());
		ulist.add(new User());
		ulist.add(new User());
		ulist.add(new User());
		model.addAttribute("users", ulist);
		return "thymeleaf/each";
	}

	@RequestMapping("thswitch")
	public String thswitch() {
		return "thymeleaf/thswitch";
	}

	@RequestMapping("thwith")
	public String thwith(Model model) {
		List<User> ulist = new ArrayList<User>();
		ulist.add(new User());
		ulist.add(new User());
		ulist.add(new User());
		ulist.add(new User());
		model.addAttribute("users", ulist);
		return "thymeleaf/thwith";
	}

	@RequestMapping("thinline")
	public String thinline(Model model) {
		model.addAttribute("user", new User());
		return "thymeleaf/thinline";
	}

}
